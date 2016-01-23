package org.springframework.samples.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.samples.web.bean.Student;
import org.springframework.samples.web.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ajax")	// 访问路径
public class AjaxController {
	
	/*
	 * 时间转换
	 */
//	@InitBinder  
//	public void initBinder(WebDataBinder binder) {
//		System.out.println("... first ...");
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//		dateFormat.setLenient(false);  
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
//	}
	
	/** 
	 * @desc 显示ajax参数传递主界面
	 * @return view
	 */
	@RequestMapping("/index")
	public String singleparam() {
			return "/ajax/index";
	}
	
	/*
	 **************************************************************BEGIN - springmvc ajax json 请求 - BEGIN***********************************************************************************
	 */
	
	/*
	 * 请求json字符串 返回json，一般适合批量操作
	 * @RequestBody 将接收到的json字符串转成对应的json对象类型
	 * @ResponseBody 讲java对象类型转换成json字符串传递到页面，供js解析
	 * @note 接收形参: 如果json字符串是对应的javabean的数据类型，那么springmvc中可以通过List<T>来接收
	 * @note 返回类型: 可以是java对象，或者对象的集合
	 * @param users
	 * @return
	 */
	@RequestMapping(value = "/requestJsonToJson", method = {RequestMethod.POST })
	@ResponseBody
	public List<User> requestJsonToJson(@RequestBody List<User> users){
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user = iterator.next();
			System.out.println("username:" + user.getUsername());
			System.out.println("password:" + user.getPassword());
			System.out.println("currentDate:" + user.getCurrentDate());
		}
		
		return users;
	}
	
	@RequestMapping(value = "/requestJsonObjToJson", method = {RequestMethod.POST })
	@ResponseBody
	public Student requestJsonObjToJson(@RequestBody Student student){
		System.out.println("username:" + student.getUsername());
		return student;
	}
	
//	/**
//	 * 请求key/value 返回json，请求参数是js对象
//	 * @note json字符串如果是单个bean对象，那么springmvc中只能使用bean对象来接受，而不能使用List<T>，否则会包转货实例化错误
//	 * @param users
//	 * @return
//	 */
//	@RequestMapping(value = "/requestKeyvalueToJson", method = {RequestMethod.POST })
//	@ResponseBody
//	public User requestKeyvalueToJson(User user){
//			System.out.println("username:" + user.getUsername());
//			System.out.println("password:" + user.getPassword());
//		
//			return user;
//	}
	
	/**
	 * 请求key/value 返回json，请求参数是js对象
	 * @param users
	 * @return
	 */
	@RequestMapping(value = "/requestKeyvalueToJson", method = {RequestMethod.POST })
	@ResponseBody
	public List<User> requestKeyvalueToJson(User user){
			List<User> users =  new ArrayList<User>();
			users.add(user);
			
			System.out.println("username:" + user.getUsername());
			System.out.println("password:" + user.getPassword());
		
			return users;
	}
	
	/*
	 **************************************************************END - springmvc ajax json 请求 - END***********************************************************************************
	 */
		/**
		 * 请求key/value 返回json，请求参数是js对象
		 * @param users
		 * @return
		 * @throws Exception 
		 */
		@RequestMapping(value = "/requestDateConvert", method = {RequestMethod.POST })
		@ResponseBody
//		public Date requestDateConvert(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date currentDate){
			public Date requestDateConvert(Date currentDate) throws Exception{
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateStr = sdf.format(currentDate);
				
				System.out.println("currentDate:" + dateStr);
				
				return currentDate;
		}
	/*
	 **********************BEGIN - 时间格式转换 - BEGIN***********************************************************************************
	 */
}
