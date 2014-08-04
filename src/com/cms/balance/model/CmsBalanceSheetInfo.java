/**
 * FileName: CmsBalanceSheetInfo.java
 *
 * Description: select * from cms_balance_sheet_info
 *
 * Created: Administrator 2014-07-24
 * 
 * |--------------------------------------------------History---------------------------------------------------|
 * |                                                                                                            |
 * |-----Author-----|-----Date-----|----Version----|----------------------------Desc----------------------------| 
 * || 
 * |------------------------------------------------------------------------------------------------------------|
 */
package com.cms.balance.model;

/**
 * CmsBalanceSheetInfo
 * 
 * Create From SQL: select * from cms_balance_sheet_info
 * 
 * @author Administrator 2014-07-24
 * @version 0.0.1
 */
public class CmsBalanceSheetInfo extends com.remind.bpf.common.bean.AbstractTableBean
{
	// ----------------------------------------------------- Properties
	private static final long serialVersionUID = 1L;
	
	private java.lang.String resourceid;
	private java.lang.String bs_number;
	private java.lang.String bs_date;
	private java.lang.Double bs_amount;
	private java.lang.String creator;
	private java.lang.String creator_id;
	private java.lang.String create_org_info;
	private java.lang.String create_company;
	private java.lang.String create_company_id;
	private java.lang.String create_departmet;
	private java.lang.String create_departmet_id;
	private java.util.Date create_date;
	private java.util.Date modify_date;
	private java.lang.String modifyor;
	private java.lang.String contract_id;
	private java.lang.String contract_num;
	private java.lang.String contract_name;
	private java.lang.String mark;
	private java.lang.String data_type;
	private java.lang.String isupload;
	private java.lang.String flgdelete;
	
	// ----------------------------------------------------- Constructors

	// ----------------------------------------------------- Methods
	
	public java.lang.String getResourceid()
	{
		return resourceid;
	}

	public void setResourceid( java.lang.String resourceid )
	{
		this.resourceid = resourceid;
	}
	
	public java.lang.String getBs_number()
	{
		return bs_number;
	}

	public void setBs_number( java.lang.String bs_number )
	{
		this.bs_number = bs_number;
	}
	
	public java.lang.String getBs_date()
	{
		return bs_date;
	}

	public void setBs_date( java.lang.String bs_date )
	{
		this.bs_date = bs_date;
	}
	
	public java.lang.Double getBs_amount()
	{
		return bs_amount;
	}

	public void setBs_amount( java.lang.Double bs_amount )
	{
		this.bs_amount = bs_amount;
	}
	
	public java.lang.String getCreator()
	{
		return creator;
	}

	public void setCreator( java.lang.String creator )
	{
		this.creator = creator;
	}
	
	public java.lang.String getCreator_id()
	{
		return creator_id;
	}

	public void setCreator_id( java.lang.String creator_id )
	{
		this.creator_id = creator_id;
	}
	
	public java.lang.String getCreate_org_info()
	{
		return create_org_info;
	}

	public void setCreate_org_info( java.lang.String create_org_info )
	{
		this.create_org_info = create_org_info;
	}
	
	public java.lang.String getCreate_company()
	{
		return create_company;
	}

	public void setCreate_company( java.lang.String create_company )
	{
		this.create_company = create_company;
	}
	
	public java.lang.String getCreate_company_id()
	{
		return create_company_id;
	}

	public void setCreate_company_id( java.lang.String create_company_id )
	{
		this.create_company_id = create_company_id;
	}
	
	public java.lang.String getCreate_departmet()
	{
		return create_departmet;
	}

	public void setCreate_departmet( java.lang.String create_departmet )
	{
		this.create_departmet = create_departmet;
	}
	
	public java.lang.String getCreate_departmet_id()
	{
		return create_departmet_id;
	}

	public void setCreate_departmet_id( java.lang.String create_departmet_id )
	{
		this.create_departmet_id = create_departmet_id;
	}
	
	public java.util.Date getCreate_date()
	{
		return create_date;
	}

	public void setCreate_date( java.util.Date create_date )
	{
		this.create_date = create_date;
	}
	
	public java.util.Date getModify_date()
	{
		return modify_date;
	}

	public void setModify_date( java.util.Date modify_date )
	{
		this.modify_date = modify_date;
	}
	
	public java.lang.String getModifyor()
	{
		return modifyor;
	}

	public void setModifyor( java.lang.String modifyor )
	{
		this.modifyor = modifyor;
	}
	
	public java.lang.String getContract_id()
	{
		return contract_id;
	}

	public void setContract_id( java.lang.String contract_id )
	{
		this.contract_id = contract_id;
	}
	
	public java.lang.String getContract_num()
	{
		return contract_num;
	}

	public void setContract_num( java.lang.String contract_num )
	{
		this.contract_num = contract_num;
	}
	
	public java.lang.String getContract_name()
	{
		return contract_name;
	}

	public void setContract_name( java.lang.String contract_name )
	{
		this.contract_name = contract_name;
	}
	
	public java.lang.String getMark()
	{
		return mark;
	}

	public void setMark( java.lang.String mark )
	{
		this.mark = mark;
	}
	
	public java.lang.String getData_type()
	{
		return data_type;
	}

	public void setData_type( java.lang.String data_type )
	{
		this.data_type = data_type;
	}
	
	public java.lang.String getIsupload()
	{
		return isupload;
	}

	public void setIsupload( java.lang.String isupload )
	{
		this.isupload = isupload;
	}
	
	public java.lang.String getFlgdelete()
	{
		return flgdelete;
	}

	public void setFlgdelete( java.lang.String flgdelete )
	{
		this.flgdelete = flgdelete;
	}
	
	public String getTableName()
	{
		return "CMS_BALANCE_SHEET_INFO";
	}
	
	public String getQueryId()
	{
		return "com.cms.balance.model.CmsBalanceSheetInfo.query";
	}
	
	public String getInsertId()
	{
		return "com.cms.balance.model.CmsBalanceSheetInfo.insert";
	}
	
	public String getUpdateAllId()
	{
		return "com.cms.balance.model.CmsBalanceSheetInfo.updateAll";
	}
	
	public String getUpdateNotAllId()
	{
		return "com.cms.balance.model.CmsBalanceSheetInfo.updateNotNull";
	}
}
