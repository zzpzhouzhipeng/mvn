package com.synnex.wms.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synnex.wms.dao.bean.Blog;
import com.synnex.wms.dao.bean.User;
import com.synnex.wms.service.IBlogService;
import com.synnex.wms.service.IUser;

@Controller
@RequestMapping("/mybatis")	// 访问路径
public class MybatisController {
	
	@Resource
	private IUser userImpl;
	
	@Resource
	private IBlogService blogServiceImpl;
	
	@RequestMapping("/index")
	public String singleparam() {
			return "/mybatis/index";
	}
	
	@RequestMapping("/requestMybatisTest")
	@ResponseBody
	public User requestMybatisTest(User user) throws Exception{
		if( user != null && !"".equals(user.getUsername())){
			List<User> userList = userImpl.queryUsers(user.getUsername());
			System.out.println("username:" + user.getUsername() + "; size:" + userList.size());
			user.setAge(userList.get(0).getAge());
		}
		return user;
	}
	
	@RequestMapping("/requestMybatisAssociation")
	@ResponseBody
	public List<Blog> requestMybatisAssociation() throws Exception{
		List<Blog> blogList = blogServiceImpl.selectBlogs();
		System.out.println("blogList:size:" + blogList.size());
		return blogList;
	}
}
