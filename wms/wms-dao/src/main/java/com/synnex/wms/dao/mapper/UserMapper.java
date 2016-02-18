package com.synnex.wms.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.synnex.wms.dao.bean.User;

public interface UserMapper {
	public List<User> queryUsers(@Param("username") String username);
}
