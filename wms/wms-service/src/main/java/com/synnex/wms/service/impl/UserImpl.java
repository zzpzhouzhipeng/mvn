package com.synnex.wms.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.synnex.wms.dao.bean.User;
import com.synnex.wms.dao.mapper.UserMapper;
import com.synnex.wms.service.IUser;

@Service
public class UserImpl implements IUser {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public List<User> queryUsers(String username) throws Exception {
		return userMapper.queryUsers(username);
	}

}
