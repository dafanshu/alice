package com.remind.bpf.menu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.remind.bpf.menu.mapper.MenuMapper;
import com.remind.bpf.menu.model.Menu;

@Service("menuService")
public class MenuServiceImpl implements MenuService{

	@Resource(name="menuMapper")
	private MenuMapper mapper;
	
	
	public void insertMenu(){
		
	}


	@Override
	public List<Menu> queryMenuList(Integer type) {
		//1.左侧菜单,2导航菜单,3:树形菜单,4:单级菜单,5:Tab菜单,6 功能点
		Menu menu = new Menu();
		menu.setType(type);
		menu.setParent_id(0L);
		List<Menu> list = this.mapper.query(menu);
		return list;
	}
	
	@Override
	public List<Menu> queryMenuList(Menu menu) {
		List<Menu> list = this.mapper.query(menu);
		
		return list;
	}
	

	@Override
	public List<Menu> querySubMenuList(Long menuId,Integer type) {
		 Menu menu = new Menu();
		 menu.setParent_id(menuId);
		 menu.setType(type);
		return this.mapper.query(menu);
	}
	
	
}
