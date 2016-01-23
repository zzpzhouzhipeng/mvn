package org.springframework.samples.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.samples.web.bean.User;

public interface UserMapper {
	public List<User> queryUsers(@Param("username") String username);
}
