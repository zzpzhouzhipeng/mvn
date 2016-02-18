package com.synnex.wms.service;

import java.util.List;

import com.synnex.wms.dao.bean.Blog;

public interface IBlogService {
	public List<Blog> selectBlogs() throws Exception;
}
