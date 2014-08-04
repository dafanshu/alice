package com.remind.bpf.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.remind.bpf.common.page.Page;
import com.remind.bpf.user.mapper.UserMapper;
import com.remind.bpf.user.model.User;




@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	public void saveUser(User user) {
		System.out.println("uid:"+user.getId());
		System.out.println("save user successed!");
	}

	@Override
	public List<User> queryUserList(User user) {
		// TODO Auto-generated method stub
		return this.userMapper.query(user);
	}
	@Override
	public List<User> queryUserListPage(Page page) {
		// TODO Auto-generated method stub
		System.out.println("========="+this.userMapper.queryListPage(page));
		return this.userMapper.queryListPage(page);
	}
	
	public void insert(){
		User user = new User();
		user.setUser_name("事务回滚11133444");
		user.setLogin_diyname("hhaaw277e22221111");
		user.setLogin_name("aaa1226f3e33");
		user.setStatus("0");
		user.setPassword("aa1");
		user.setMsisdn("aa1");
		user.setTelphone("kk1");
		user.setEmail("test1");
		user.setDef_menu_id(1L);
		
		this.userMapper.insert(user);
		
		User user1 = new User();
		user1.setUser_name("事务回滚ddd");
		user1.setLogin_diyname("hhaa2211");
		user1.setLogin_name("aaa111122111111");
		user1.setStatus("0");
		user1.setPassword("aa");
		user1.setMsisdn("aa");
		user1.setTelphone("kk");
		user1.setEmail("test");
		throw new RuntimeException();
//		user1.setDef_menu_id(1L);
	//	this.userMapper.insert(user1);
	}
	
//	public List<User> getUserList(){
//	}

}
