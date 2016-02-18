package com.synnex.wms.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.synnex.wms.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService{
	
	@PostConstruct
	public void printName() {
		System.out.println("调用成功了!");
	}

}
