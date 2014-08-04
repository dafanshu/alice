package com.remind.bpf;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cms.balance.model.CmsBalanceSheetInfo;
import com.cms.balance.service.IBalanceService;
import com.remind.bpf.menu.service.MenuService;
import com.remind.bpf.user.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="menuService")
	private MenuService menuService;
	@Resource(name="balanceService")
	IBalanceService balanceService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		model.addAttribute("name", "yurui" );
		
		System.out.println("ttttt");
//		List<CmsBalanceSheetInfo>  list = balanceService.queryMenuList(null);
//		
//		model.addAttribute("animals",list);
		
		return "welcome";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView login() {
		logger.info("Welcome home!");
		
		return new ModelAndView("user/login", "user", new User());
	}
	
	/**
	 * 登录验证并初始化菜单
	 */
	@RequestMapping(value="/checkLogin")
	public ModelAndView checkLogin(@Valid @ModelAttribute("user") User user,
			BindingResult bindingResult){
		logger.info("user:"+user.getLogin_name());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		
//		List<Menu> leftMenu = this.menuService.queryMenuList(1);
//		mav.addObject("leftMenus", leftMenu);
//		
//		List<Menu> navMenu = this.menuService.queryMenuList(2);
//		mav.addObject("navMenus", navMenu);
		
		return mav;
	}
	
	@RequestMapping(value = "/bb", method = RequestMethod.GET)
	public String bb(Locale locale, Model model) {
		return "demo/bb";
	}
	
	@RequestMapping(value = "/downDoc", method = RequestMethod.GET)
	public String downDoc(Locale locale, Model model,HttpServletRequest request, HttpServletResponse response) {
		InputStream bis = null;
		try {
			bis = new java.io.FileInputStream("F:/俞瑞.doc");
			int bytesRead = 0;
			int bytesA = bis.available();
			byte[] attachByte = new byte[4096];//缓存，每次读取4k
			// MIME类型
			response.setContentType("application/octet-stream");
			response.setContentLength(bytesA);
			OutputStream opStream = null;
			opStream = response.getOutputStream();
			response.setHeader("Content-Disposition","attachment;filename=测试");
			while (true) {
				bytesRead = bis.read(attachByte, 0, attachByte.length);
				if (bytesRead <= 0) {
					break;
				}
				opStream.write(attachByte, 0, bytesRead);
			}
			opStream.flush();
			opStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	  
	
}
