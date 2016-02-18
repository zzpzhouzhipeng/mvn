package com.synnex.wms.service;

import java.util.List;

import com.synnex.wms.dao.bean.User;

public interface IUser {
	public List<User> queryUsers(String username) throws Exception;
}
