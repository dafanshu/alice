/**
 * FileName: ${bean_type}.java
 *
 * Description: ${bean_sql}
 *
 * Created: ${bean_author} ${bean_created}
 * 
 * |--------------------------------------------------History---------------------------------------------------|
 * |                                                                                                            |
 * |-----Author-----|-----Date-----|----Version----|----------------------------Desc----------------------------| 
 * || 
 * |------------------------------------------------------------------------------------------------------------|
 */
package ${bean_pkg};

/**
 * ${bean_type}
 * 
 * Create From SQL: ${bean_sql}
 * 
 * @author ${bean_author} ${bean_created}
 * @version 0.0.1
 */
public class ${bean_type} <#if bean_parent??>extends ${bean_parent}</#if>
{
	// ----------------------------------------------------- Properties
	private static final long serialVersionUID = 1L;
	
	<#list bean_property as p>
	<#if p.need>
	private ${p.javaTypeDesc} ${p.fields?lower_case};
	</#if>
	</#list>
	
	// ----------------------------------------------------- Constructors

	// ----------------------------------------------------- Methods
	
	<#list bean_property as p>
	<#if p.need>
	public ${p.javaTypeDesc} get${p.fields?lower_case?cap_first}()
	{
		return ${p.fields?lower_case};
	}

	public void set${p.fields?lower_case?cap_first}( ${p.javaTypeDesc} ${p.fields?lower_case} )
	{
		this.${p.fields?lower_case} = ${p.fields?lower_case};
	}
	
	</#if>
	</#list>
	public String getTableName()
	{
		return "${table_name}";
	}
	
	public String getQueryId()
	{
		return "${bean_pkg}.${bean_type}.query";
	}
	
	public String getInsertId()
	{
		return "${bean_pkg}.${bean_type}.insert";
	}
	
	public String getUpdateAllId()
	{
		return "${bean_pkg}.${bean_type}.updateAll";
	}
	
	public String getUpdateNotAllId()
	{
		return "${bean_pkg}.${bean_type}.updateNotNull";
	}
}
