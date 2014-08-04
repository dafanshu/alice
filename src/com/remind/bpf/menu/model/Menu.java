/**
 * FileName: Menu.java
 *
 * Description: select * from wm_menu
 *
 * Created: python 2013-05-25
 * 
 * |--------------------------------------------------History---------------------------------------------------|
 * |                                                                                                            |
 * |-----Author-----|-----Date-----|----Version----|----------------------------Desc----------------------------| 
 * || 
 * |------------------------------------------------------------------------------------------------------------|
 */
package com.remind.bpf.menu.model;

import java.util.List;

/**
 * Menu
 * 
 * Create From SQL: select * from wm_menu
 * 
 * @author python 2013-05-25
 * @version 0.0.1
 */
public class Menu extends com.remind.bpf.common.bean.AbstractTableBean
{
	// ----------------------------------------------------- Properties
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.Long parent_id;
	private java.lang.String name;
	private java.lang.Integer type;
	private java.lang.Integer seq;
	private java.lang.String event;
	private java.lang.String action;
	private java.util.Date created;
	private java.lang.Long created_by;
	private java.lang.String status;
	private java.util.Date last_upd;
	private java.lang.Long last_upd_by;
	private java.lang.String remarks;
	private List<Menu> subMenus;
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
	
	public java.lang.Long getParent_id()
	{
		return parent_id;
	}

	public void setParent_id( java.lang.Long parent_id )
	{
		this.parent_id = parent_id;
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
	
	public java.lang.Integer getSeq()
	{
		return seq;
	}

	public void setSeq( java.lang.Integer seq )
	{
		this.seq = seq;
	}
	
	public java.lang.String getEvent()
	{
		return event;
	}

	public void setEvent( java.lang.String event )
	{
		this.event = event;
	}
	
	public java.lang.String getAction()
	{
		return action;
	}

	public void setAction( java.lang.String action )
	{
		this.action = action;
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
	
	public List<Menu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<Menu> subMenus) {
		this.subMenus = subMenus;
	}

	public String getTableName()
	{
		return "WM_MENU";
	}
	
	public String getQueryId()
	{
		return "com.remind.bpf.menu.model.Menu.query";
	}
	
	public String getInsertId()
	{
		return "com.remind.bpf.menu.model.Menu.insert";
	}
	
	public String getUpdateAllId()
	{
		return "com.remind.bpf.menu.model.Menu.updateAll";
	}
	
	public String getUpdateNotAllId()
	{
		return "com.remind.bpf.menu.model.Menu.updateNotNull";
	}
}
