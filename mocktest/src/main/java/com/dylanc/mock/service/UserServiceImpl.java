package com.dylanc.mock.service;

import com.dylanc.mock.bean.User;
import com.dylanc.mock.dao.IUserDao;
import com.dylanc.mock.service.impl.IUserService;

public class UserServiceImpl implements IUserService{
	
    private IUserDao userDao;
    
    public User query(String id) throws Exception{  
    	User user;
        try{  
        	user = userDao.getById(id);
        	user.setName("liang");
        }catch(Exception e){  
        	throw e;  
        }
        return user;
    }

    public void editUser(User user) throws Exception{  
        try{  
        	userDao.editUser(user);
        }catch(Exception e){  
        	throw e;  
        }
    }
    
    
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	} 
}
