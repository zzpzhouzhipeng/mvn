package org.springframework.samples.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.samples.web.bean.User;
import org.springframework.samples.web.mapper.UserMapper;
import org.springframework.samples.web.service.IUser;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements IUser {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public List<User> queryUsers(String username) throws Exception {
		return userMapper.queryUsers(username);
	}

}
