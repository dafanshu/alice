package com.remind.bpf.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.remind.bpf.common.page.Page;
import com.remind.bpf.user.model.User;
import com.remind.bpf.user.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	/**
	 * @return
	 */
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value="/test")
	public String checkLogin(@Valid @ModelAttribute("user") User user,
			BindingResult bindingResult){
		logger.info("user:"+user.getLogin_name());
		this.userService.insert();
		return "home";
	}
	
	@RequestMapping(value="/list")
	public ModelAndView queryUserList(User user){
		List<User> userList = this.userService.queryUserList(user);
		
//		List<User> userList = userService.listPageUser(user);
//		List<Role> roleList = roleService.listAllRoles();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/list");
		mv.addObject("userList", userList);
//		mv.addObject("roleList", roleList);
//		mv.addObject("user", user);
		return mv;
		
		
	}
	
//	@RequestMapping(value="/list",produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody List<User> queryUserList(User user){
//		List<User> list = this.userService.queryUserList(user);
//		
////		List<User> userList = userService.listPageUser(user);
////		List<Role> roleList = roleService.listAllRoles();
////		ModelAndView mv = new ModelAndView();
////		mv.setViewName("users");
////		mv.addObject("userList", userList);
////		mv.addObject("roleList", roleList);
////		mv.addObject("user", user);
////		return mv;
//		
//		
//		return list;
//	}
	
	@RequestMapping(value="/listPage")
	public String queryUserListPage(Page page){
		List<User> list = this.userService.queryUserListPage(page);
		
//		model.addAttribute("infoList", infoList);
//		model.addAttribute("page", page);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		return "test";
	}
	
//	@RequestMapping(value="/default")
//	public ModelAndView index(User user){
//		List<User> list = this.userService.queryUserList(user);
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("userList", list);
//		mav.setViewName("test");
//		return mav;
//	}
	
	@RequestMapping(value="/default")
	public String info(Model model,Page page){
		List<User> list = this.userService.queryUserListPage(page);
		model.addAttribute("userList", list);
		model.addAttribute("page", page);
		return "test";
	}
	
}
