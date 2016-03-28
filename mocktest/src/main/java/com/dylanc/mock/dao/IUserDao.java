package com.dylanc.mock.dao;

import com.dylanc.mock.bean.User;

public interface IUserDao {
	User getById(String id) throws Exception;
}
