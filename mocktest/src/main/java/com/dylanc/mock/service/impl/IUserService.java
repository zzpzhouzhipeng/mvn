package com.dylanc.mock.service.impl;

import com.dylanc.mock.bean.User;

public interface IUserService {
	 User query(String id) throws Exception;
}
