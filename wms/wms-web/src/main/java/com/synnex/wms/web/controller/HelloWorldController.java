package com.synnex.wms.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.synnex.wms.service.ILoginService;

@Controller
@RequestMapping("/login")	// 访问路径
public class HelloWorldController {
	
	@Resource
	private ILoginService loginService;
	
	@RequestMapping("/index")
	public String springIndex(Model model) {
			model.addAttribute("message", "Hello index! Who are you ?");
			return "index";
	}
	
	// 页面跳转 1. 返回字符串：页面名字
	@RequestMapping(value="/helloWorld", method = RequestMethod.GET)
	public String helloWorld(Model model) {
		model.addAttribute("message", "Hello world 01! Who are you ?");
		return "front/helloWorld";
	}
	
	// 页面跳转 2. 返回ModeAndView对象 : 
	@RequestMapping(value="/helloWorld02", method = RequestMethod.GET)
	public ModelAndView helloWorld02(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		
		// 设置返回的页面路径及名字,和方式1中的字符串一样
        mav.setViewName("front/helloWorld");
        
        // 设置返回的参数及值
        mav.addObject("message02", "Hello World 02!");
        return mav;
	}
	
		// 页面跳转 2. 返回ModeAndView对象 : 
		@RequestMapping(value="front/{modul}/hello/{pathName}", method = RequestMethod.GET)
		public ModelAndView helloWorld03(//@PathVariable("pathName") String name, 
										@PathVariable String modul, 
										@PathVariable String pathName, 
										Model model
										) {
			System.out.println("modul :" + modul);
			System.out.println("pathName :" + pathName);
			ModelAndView mav = new ModelAndView();
			// 设置返回的页面路径及名字,和方式1中的字符串一样
	        mav.setViewName("front/helloWorld");
	        
	        // 设置返回的参数及值
	        mav.addObject("message", "Hello World 03!");
	        
	        //测试条用service层方法
	        //LoginServiceImpl login = new LoginServiceImpl();
	        loginService.printName();
	        
	        return mav;
		}
		
		// controller之间的跳转
		@RequestMapping(value="helloWorld04")
		public ModelAndView helloWorld04() {
			ModelAndView mav = new ModelAndView();
			mav.addObject("message", "Hello World 03!");
			mav.setViewName("redirect:helloWorld");
	        return mav;
		}
}
