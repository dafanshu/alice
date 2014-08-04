package com.remind.bpf.menu.service;

import java.util.List;

import com.remind.bpf.menu.model.Menu;

public interface MenuService {
	
	public List<Menu> queryMenuList(Integer type);
	
	public List<Menu> queryMenuList(Menu menu);
	
	public List<Menu> querySubMenuList(Long menuId,Integer type);

}
