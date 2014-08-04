/**
 * FileName: User.java
 *
 * Description: select * from WM_USER
 *
 * Created: python 2013-05-25
 * 
 * |--------------------------------------------------History---------------------------------------------------|
 * |                                                                                                            |
 * |-----Author-----|-----Date-----|----Version----|----------------------------Desc----------------------------| 
 * || 
 * |------------------------------------------------------------------------------------------------------------|
 */
package com.remind.bpf.user.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.remind.bpf.common.page.Page;

/**
 * User
 * 
 * Create From SQL: select * from WM_USER
 * 
 * @author python 2013-05-25
 * @version 0.0.1
 */
@XmlRootElement
public class User extends com.remind.bpf.common.bean.AbstractTableBean
{
	// ----------------------------------------------------- Properties
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String user_name;
	private java.lang.String login_name;
	private java.lang.String login_diyname;
	private java.lang.String password;
	private java.lang.String email;
	private java.lang.String msisdn;
	private java.lang.String telphone;
	private java.lang.Long def_menu_id;
	private java.lang.String company_name;
	private java.lang.Integer prov_code;
	private java.lang.Integer city_code;
	private java.lang.Integer type;
	private java.lang.Integer grade;
	private java.lang.String locked;
	private java.lang.Integer error_count;
	private java.util.Date login_date;
	private java.util.Date created;
	private java.lang.Long created_by;
	private java.lang.String status;
	private java.util.Date last_upd;
	private java.lang.Long last_upd_by;
	private java.lang.String remarks;
	private Page page;
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
	
	public java.lang.String getUser_name()
	{
		return user_name;
	}

	public void setUser_name( java.lang.String user_name )
	{
		this.user_name = user_name;
	}
	
	public java.lang.String getLogin_name()
	{
		return login_name;
	}

	public void setLogin_name( java.lang.String login_name )
	{
		this.login_name = login_name;
	}
	
	public java.lang.String getLogin_diyname()
	{
		return login_diyname;
	}

	public void setLogin_diyname( java.lang.String login_diyname )
	{
		this.login_diyname = login_diyname;
	}
	
	public java.lang.String getPassword()
	{
		return password;
	}

	public void setPassword( java.lang.String password )
	{
		this.password = password;
	}
	
	public java.lang.String getEmail()
	{
		return email;
	}

	public void setEmail( java.lang.String email )
	{
		this.email = email;
	}
	
	public java.lang.String getMsisdn()
	{
		return msisdn;
	}

	public void setMsisdn( java.lang.String msisdn )
	{
		this.msisdn = msisdn;
	}
	
	public java.lang.String getTelphone()
	{
		return telphone;
	}

	public void setTelphone( java.lang.String telphone )
	{
		this.telphone = telphone;
	}
	
	public java.lang.Long getDef_menu_id()
	{
		return def_menu_id;
	}

	public void setDef_menu_id( java.lang.Long def_menu_id )
	{
		this.def_menu_id = def_menu_id;
	}
	
	public java.lang.String getCompany_name()
	{
		return company_name;
	}

	public void setCompany_name( java.lang.String company_name )
	{
		this.company_name = company_name;
	}
	
	public java.lang.Integer getProv_code()
	{
		return prov_code;
	}

	public void setProv_code( java.lang.Integer prov_code )
	{
		this.prov_code = prov_code;
	}
	
	public java.lang.Integer getCity_code()
	{
		return city_code;
	}

	public void setCity_code( java.lang.Integer city_code )
	{
		this.city_code = city_code;
	}
	
	public java.lang.Integer getType()
	{
		return type;
	}

	public void setType( java.lang.Integer type )
	{
		this.type = type;
	}
	
	public java.lang.Integer getGrade()
	{
		return grade;
	}

	public void setGrade( java.lang.Integer grade )
	{
		this.grade = grade;
	}
	
	public java.lang.String getLocked()
	{
		return locked;
	}

	public void setLocked( java.lang.String locked )
	{
		this.locked = locked;
	}
	
	public java.lang.Integer getError_count()
	{
		return error_count;
	}

	public void setError_count( java.lang.Integer error_count )
	{
		this.error_count = error_count;
	}
	
	public java.util.Date getLogin_date()
	{
		return login_date;
	}

	public void setLogin_date( java.util.Date login_date )
	{
		this.login_date = login_date;
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
	
	public Page getPage() {
		if(page==null)
			page = new Page();
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	public String getTableName()
	{
		return "WM_USER";
	}
	
	public String getQueryId()
	{
		return "com.remind.bpf.user.model.User.query";
	}
	
	public String getInsertId()
	{
		return "com.remind.bpf.user.model.User.insert";
	}
	
	public String getUpdateAllId()
	{
		return "com.remind.bpf.user.model.User.updateAll";
	}
	
	public String getUpdateNotAllId()
	{
		return "com.remind.bpf.user.model.User.updateNotNull";
	}
}
