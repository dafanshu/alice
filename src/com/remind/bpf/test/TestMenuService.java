package com.remind.bpf.test;

import javax.annotation.Resource;

import org.junit.Test;

import com.cms.balance.service.IBalanceService;
import com.remind.bpf.common.util.AbstractTestCase;
import com.remind.bpf.menu.mapper.MenuMapper;
import com.remind.bpf.menu.model.Menu;
import com.remind.bpf.user.mapper.UserMapper;

public class TestMenuService extends AbstractTestCase {

	

	@Resource(name="menuMapper")
	private MenuMapper mapper;
	@Resource(name="userMapper")
	private UserMapper userMapper;
	@Resource(name="balanceService")
	IBalanceService balanceService;
	
	@Test
	public void saveMenu() throws Exception{
		
	    Menu menu = new Menu();
		menu.setParent_id(18L);
		menu.setName("用户管理1");
		menu.setType(1);
		menu.setStatus("0");
		menu.setSeq(1);
		menu.setEvent("test");
		menu.setAction("test");
//		menu.setCreated(new Date());
		menu.setCreated_by(1L);
//		menu.setLast_upd(new Date());
//		menu.setLast_upd_by(1L);
		//menu.setRemarks("test");
		this.mapper.insert(menu);
//		WM_USER user = new WM_USER();
//		user.setUser_name("haha");
//		user.setLogin_diyname("hhaa");
//		user.setLogin_name("aaa");
//		user.setStatus("0");
//		user.setPassword("aa");
//		user.setMsisdn("aa");
//		user.setTelphone("kk");
//		user.setEmail("test");
//		user.setDef_menu_id(1L);
//		this.userMapper.insert(user);
	}
	
	@Test
	public void listBalance() throws Exception{
		balanceService.queryMenuList(null);
	}
	
	
}
