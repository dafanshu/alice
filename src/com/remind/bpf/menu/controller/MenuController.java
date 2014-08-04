package com.remind.bpf.menu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.remind.bpf.menu.service.MenuService;



@Controller
@RequestMapping("/menu")
public class MenuController {

	@Resource(name="menuService")
	private MenuService menuService;
	
	@RequestMapping("/querySubMenus")
	public String querySubMenus(Long menuId,Integer type){
		this.menuService.querySubMenuList(menuId, type);
		return null;
	}
}
