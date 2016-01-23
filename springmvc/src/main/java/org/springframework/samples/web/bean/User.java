package org.springframework.samples.web.bean;

import java.util.Date;

public class User {
	private String username;
	private String password;
	private int age;
	
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")	// 将页面的时间字符串转换成Date类型
	private Date currentDate;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
}
