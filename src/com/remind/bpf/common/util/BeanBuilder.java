package com.remind.bpf.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.remind.bpf.common.bean.AbstractTableBean;

import freemarker.template.Configuration;
import freemarker.template.Template;



public abstract class BeanBuilder
{
	// ----------------------------------------------------- Properties

	private static final Logger log = LoggerFactory.getLogger( BeanBuilder.class );

	private static final Map<String, String> FIELD_DESC = new HashMap<String, String>();

	// ----------------------------------------------------- Constructors

	static
	{
		FIELD_DESC.put( "ID", "ID" );
		FIELD_DESC.put( "REMARKS", "备注" );
		FIELD_DESC.put( "NAME", "名称" );
		FIELD_DESC.put( "STATUS", "状态" );
	}

	// ----------------------------------------------------- Methods

	public static void buildJavaBean( String sql, String src, String clazz, Class<?> parent, String name, boolean config ) throws Exception
	{
		// 1.1处理SQL查询结果

		PropertiesManager pm = PropertiesManagerUtil.getPropertiesManager();

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName( pm.getString( "jdbc.driverClassName" ) );
		dataSource.setUrl( pm.getString( "jdbc.url" ) );
		dataSource.setUsername( pm.getString( "jdbc.username" ) );
		dataSource.setPassword( pm.getString( "jdbc.password" ));
		Connection connection = dataSource.getConnection();
		Statement stmt = connection.createStatement();
		stmt.execute( sql );

		ResultSetMetaData meta = stmt.getResultSet().getMetaData();

		List<TableColumnBean> columns = new ArrayList<TableColumnBean>();

		for ( int i = 1; i <= meta.getColumnCount(); i++ )
		{
			TableColumnBean o = new TableColumnBean();
			o.setFields( meta.getColumnName( i ) );
			o.setType( meta.getColumnTypeName( i ) );
			o.setLength( meta.getPrecision( i ) );
			o.setScale( meta.getScale( i ) );
//			if ( parent != null )
//			{
//				try
//				{
//					Method method = ReflectUtils.getGetter( parent, o.getFields().toLowerCase() );
//					if ( method != null )
//					{
//						o.disable();
//					}
//				}
//				catch ( Exception e )
//				{
//				}
//			}
			log.debug( meta.getColumnName( i ) + "," + meta.getColumnTypeName( i ) + "," + meta.getScale( i ) + "," + meta.getPrecision( i ) );

			columns.add( o );
		}

		stmt.close();
		connection.close();

		// 1.2查询主键

		String queryPk = "select column_name " + "from (select table_name, constraint_name,owner " + "from user_constraints where constraint_type = 'P' "
				+ "and owner = ? and table_name = ?) uc, user_cons_columns ucc " + "	where uc.constraint_name = ucc.constraint_name"
				+ " and uc.table_name = ucc.table_name" + "	  and uc.owner = ucc.owner" + " and ucc.owner =? " + " and ucc.table_name = ?";

		connection = dataSource.getConnection();

		PreparedStatement prestmt = connection.prepareStatement( queryPk );
		prestmt.setString( 1, dataSource.getUsername().toUpperCase() );
		prestmt.setString( 2, clazz.substring( clazz.lastIndexOf( "." ) + 1 ).toUpperCase() );
		prestmt.setString( 3, dataSource.getUsername().toUpperCase() );
		prestmt.setString( 4, clazz.substring( clazz.lastIndexOf( "." ) + 1 ).toUpperCase() );

		List<String> pk = new ArrayList<String>();
		ResultSet rs = prestmt.executeQuery();

		while ( rs.next() )
		{
			log.debug( "========================:" + rs.getString( 1 ) );
			pk.add( rs.getString( 1 ) );
		}

		rs.close();
		prestmt.close();
		connection.close();

		// 2.处理文件地址

		String modelFilePath = src + "\\" + clazz.replace( '.', '\\' );
		
		String cfgFilePath = src + "\\" + clazz.replace( '.', '\\' ).replace("model", "mapper") + "Mapper";

		// 3.生成Java代码

		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading( BeanBuilder.class, "/com/remind/bpf/common/util" );
		cfg.setDefaultEncoding( "UTF-8" );

		Map<String,Object> root = new HashMap<String,Object>();
		root.put( "bean", clazz);
		root.put( "bean_pkg", clazz.substring( 0, clazz.lastIndexOf( "." ) ) );
		root.put( "mapper_pkg", clazz.substring( 0, clazz.lastIndexOf( "." ) ).replace("model", "mapper") );
		root.put( "bean_type", clazz.substring( clazz.lastIndexOf( "." ) + 1 ));
		root.put( "bean_created", new SimpleDateFormat( "yyyy-MM-dd" ).format( new Date() ) );
		root.put( "bean_author", System.getProperty( "user.name" ) );
		root.put( "bean_sql", sql );
		root.put( "bean_property", columns );
		root.put( "bean_parent", parent == null ? null : parent.getName() );
		root.put( "bean_pk", pk );
		root.put("mapper_parent", "CommonMapper");
		root.put( "table_name", sql.substring( sql.toLowerCase().lastIndexOf( "from" ) + 4 ).trim().toUpperCase());

		Template t = cfg.getTemplate( "javabean.ftl" );
		File modelFile = new File(modelFilePath+".java");
		modelFile.getParentFile().mkdirs();
		t.process( root, new OutputStreamWriter( new FileOutputStream( modelFile ) ) );

		// 4.生成MyBatis配置和mapper

		if ( config )
		{
			t = cfg.getTemplate( "mybatis.ftl" );
			File cfgXMLFile = new File(cfgFilePath+".xml");
			cfgXMLFile.getParentFile().mkdirs();
			t.process( root, new OutputStreamWriter( new FileOutputStream( cfgXMLFile) ) );
			
			t = cfg.getTemplate("mapper.ftl");
			File cfgJavaFile = new File(cfgFilePath+".java");
			cfgJavaFile.getParentFile().mkdirs();
			t.process( root, new OutputStreamWriter( new FileOutputStream( cfgJavaFile) ) );
		}

		// 5.入库，JavaBean统一管理

		connection = dataSource.getConnection();

		String deleteBean = "DELETE FROM BPF_BEAN WHERE clazz = :clazz";
		PreparedStatement deleteStmt = connection.prepareStatement( deleteBean );
		deleteStmt.setString( 1, clazz );
		deleteStmt.execute();
		deleteStmt.close();

		String insertBean = "INSERT INTO BPF_BEAN VALUES (FUNC_bpf_GETSEQ('BPF_BEAN'), :clazz, :name, :parent, :sql, :table_name, sysdate, -1, '0', null, null, null)";
		PreparedStatement insertStmt = connection.prepareStatement( insertBean );
		insertStmt.setString( 1, clazz );
		insertStmt.setString( 2, name );
		insertStmt.setString( 3, parent.getName() );
		insertStmt.setString( 4, sql );
		insertStmt.setString( 5, clazz.substring( clazz.lastIndexOf( "." ) + 1 ).toUpperCase() );
		insertStmt.execute();
		insertStmt.close();

		String deleteField = "DELETE FROM BPF_BEAN_FIELD WHERE clazz = :clazz";
		PreparedStatement deleteFieldStmt = connection.prepareStatement( deleteField );
		deleteFieldStmt.setString( 1, clazz );
		deleteFieldStmt.execute();
		deleteFieldStmt.close();

		String insertField = "INSERT INTO BPF_BEAN_FIELD VALUES (func_bpf_getseq('BPF_BEAN VALUES'), :clazz, :field, :fieldDesc, :seq, :type, sysdate, -1, '0', null, null, null)";
		PreparedStatement insertFieldStmt = connection.prepareStatement( insertField );

		int i = 1;
		for ( TableColumnBean column : columns )
		{
			insertFieldStmt.setString( 1, clazz );
			insertFieldStmt.setString( 2, column.getFields().toLowerCase() );

			if ( FIELD_DESC.containsKey( column.getFields() ) )
			{
				insertFieldStmt.setString( 3, FIELD_DESC.get( column.getFields() ) );
			}
			else
			{
				insertFieldStmt.setString( 3, column.getFields().toLowerCase() );
			}

			insertFieldStmt.setInt( 4, i );
			insertFieldStmt.setString( 5, column.getJavaTypeDesc() );
			insertFieldStmt.execute();

			i++;
		}
		insertFieldStmt.close();

		connection.close();
	}
	
	public static void main(String[] args) {
		final String bpfSrc = "F:\\workspace\\cms_proc\\src";
		final Class<AbstractTableBean> parent = AbstractTableBean.class;
		try {
			buildJavaBean("select * from cms_balance_sheet_info", bpfSrc,"com.cms.balance.model.CmsBalanceSheetInfo", parent, "订单表", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
