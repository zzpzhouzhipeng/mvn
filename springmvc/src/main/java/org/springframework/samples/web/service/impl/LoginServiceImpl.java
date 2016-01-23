package org.springframework.samples.web.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.samples.web.service.ILoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService{
	
	@PostConstruct
	public void printName() {
		System.out.println("调用成功了!");
	}

}
