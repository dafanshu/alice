/**
 * FileName: UserRole.java
 *
 * Description: select * from wm_role
 *
 * Created: python 2013-05-25
 * 
 * |--------------------------------------------------History---------------------------------------------------|
 * |                                                                                                            |
 * |-----Author-----|-----Date-----|----Version----|----------------------------Desc----------------------------| 
 * || 
 * |------------------------------------------------------------------------------------------------------------|
 */
package com.remind.bpf.role.model;

/**
 * UserRole
 * 
 * Create From SQL: select * from wm_role
 * 
 * @author python 2013-05-25
 * @version 0.0.1
 */
public class UserRole extends com.remind.bpf.common.bean.AbstractTableBean
{
	// ----------------------------------------------------- Properties
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String name;
	private java.lang.Integer type;
	private java.util.Date created;
	private java.lang.Long created_by;
	private java.lang.String status;
	private java.util.Date last_upd;
	private java.lang.Long last_upd_by;
	private java.lang.String remarks;
	
	// ----------------------------------------------------- Constructors

	// ----------------------------------------------------- Methods
	
	public java.lang.Long getId()
	{
		return id;
	}

	public void setId( java.lang.Long id )
	{
		this.id = id;
	}
	
	public java.lang.String getName()
	{
		return name;
	}

	public void setName( java.lang.String name )
	{
		this.name = name;
	}
	
	public java.lang.Integer getType()
	{
		return type;
	}

	public void setType( java.lang.Integer type )
	{
		this.type = type;
	}
	
	public java.util.Date getCreated()
	{
		return created;
	}

	public void setCreated( java.util.Date created )
	{
		this.created = created;
	}
	
	public java.lang.Long getCreated_by()
	{
		return created_by;
	}

	public void setCreated_by( java.lang.Long created_by )
	{
		this.created_by = created_by;
	}
	
	public java.lang.String getStatus()
	{
		return status;
	}

	public void setStatus( java.lang.String status )
	{
		this.status = status;
	}
	
	public java.util.Date getLast_upd()
	{
		return last_upd;
	}

	public void setLast_upd( java.util.Date last_upd )
	{
		this.last_upd = last_upd;
	}
	
	public java.lang.Long getLast_upd_by()
	{
		return last_upd_by;
	}

	public void setLast_upd_by( java.lang.Long last_upd_by )
	{
		this.last_upd_by = last_upd_by;
	}
	
	public java.lang.String getRemarks()
	{
		return remarks;
	}

	public void setRemarks( java.lang.String remarks )
	{
		this.remarks = remarks;
	}
	
	public String getTableName()
	{
		return "WM_ROLE";
	}
	
	public String getQueryId()
	{
		return "com.remind.bpf.role.model.UserRole.query";
	}
	
	public String getInsertId()
	{
		return "com.remind.bpf.role.model.UserRole.insert";
	}
	
	public String getUpdateAllId()
	{
		return "com.remind.bpf.role.model.UserRole.updateAll";
	}
	
	public String getUpdateNotAllId()
	{
		return "com.remind.bpf.role.model.UserRole.updateNotNull";
	}
}
