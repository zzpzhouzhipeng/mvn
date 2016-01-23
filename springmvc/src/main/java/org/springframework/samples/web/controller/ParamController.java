package org.springframework.samples.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.samples.web.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/param")	// 访问路径
public class ParamController {
	
	/**
	 * 注意: 自己controller的方法与方法访问时，只需要添加方法的requestMapping即可，不要添加类级别的了
	 * @return
	 */
	
	// 传递非对象做为参数
	@RequestMapping("/singleparam")
	public String singleparam() {
			return "/param/singleparam";
	}
	
	@RequestMapping("/singleparam01")
	// 注意: 1. 如果前段表单中的参数名和此处的参数名一致，则可以省略@RequstParam注解，否者要用次注解来绑定参数
	//		 2. 通过Model返回单个参数。
	public String singleparam01(@RequestParam("name") String names, Model model) {
		System.out.println("name:" + names);
		model.addAttribute("message", names + ", singleparam01处理方法，Model返回参数");
		return "/param/singleparamresult";
	}
	
	@RequestMapping(value="/singleparam02", method = RequestMethod.POST)
	public ModelAndView singleparam02(HttpServletRequest request) {
		String names = request.getParameter("name");
		System.out.println("name2:" + names);
		ModelAndView mav = new ModelAndView();
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", names + ", singleparam02处理方法，ModelAndView返回参数");
		map.put("message01", "message01");
		mav.addObject(map);
		/**
		 * 不指定键名称时，会自动生成一个
		 * 1. An x.y.User instance added will have the name user generated
		 * 2. An java.util.HashMap instance added will have the name hashMap generated
		 * 3. Adding null will result in an IllegalArgumentException being thrown
		 * 4. An x.y.User[] array with zero or more x.y.User elements added will have the name userList generated
		 * 5. A java.util.ArrayList with one or more x.y.User elements added will have the name userList generated
		 * 6. A java.util.HashSet with one or more x.y.Foo elements added will have the name fooList generated
		 */
//		mav.addObject("map", map);
		mav.setViewName("/param/singleparamresult02");
		return mav;
	}
	
	@RequestMapping("/paramobjvc")
	public String paramobjvc() {
			return "/param/paramobjvc";
	}
	
	@RequestMapping(value="/paramobjvc02", method=RequestMethod.POST)
	public User paramobjvc02(User user) {
		System.out.println("username:" + user.getUsername());
		System.out.println("pawword:" + user.getPassword());
		user.setUsername("ok");
		return user;
	}
	
	@RequestMapping("/paramobjvc03")
	public ModelAndView paramobjvc03(User user) {
		System.out.println("username:" + user.getUsername());
		System.out.println("pawword:" + user.getPassword());
		ModelAndView mav = new ModelAndView();
		user.setUsername("ok");
		mav.addObject("user", user);
		
//		mav.addObject(user); 	// 复合对象默认以变量名为键值
		mav.setViewName("/param/paramobjvc02");
		return mav;
	}
	
	@RequestMapping("/paramobjvc04")
	public String paramobjvc04(User user, Model model) {
		System.out.println("username:" + user.getUsername());
		System.out.println("pawword:" + user.getPassword());
		user.setUsername("ok");
		model.addAttribute("user", user);
		return "/param/paramobjvc02";
	}
	
	/**
	 * 文件上传
	 * @return
	 */
	@RequestMapping("/fileUploadIndex")
	public String fileUploadIndex() { //接收商品图片
		return "/param/uploadIndex";
	}
	
	/**
	 * 文件上传
	 * @return
	 */
	@RequestMapping("/upload")
	public String upload(Model model, MultipartFile pic) { //接收商品图片
		
		//原始名称
		String originalFilename = pic.getOriginalFilename();
		
		if(pic!=null && originalFilename  != null && originalFilename.length() > 0){
		
			//存储图片的物理路径
			String pic_path = "F:\\temp\\";
			
			//新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			
			model.addAttribute("itempic", newFileName);
			
			//新图片
			File newFile = new File(pic_path+newFileName);
			
			//将内存中的数据写入磁盘
			try {
				pic.transferTo(newFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return "/param/uploadIndex";
	}
}
