package org.springframework.samples.web.service;

import java.util.List;

import org.springframework.samples.web.bean.User;

public interface IUser {
	public List<User> queryUsers(String username) throws Exception;
}
