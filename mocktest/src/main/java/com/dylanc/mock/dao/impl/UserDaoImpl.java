package com.dylanc.mock.dao.impl;

import com.dylanc.mock.bean.User;
import com.dylanc.mock.dao.IUserDao;

public class UserDaoImpl implements IUserDao{
	public User getById(String id) throws Exception{ 
		User user = new User();
		try{
        	user.setId(id);
        }catch(Exception e){
        	throw e;
        }
        return user;  
	}
}
