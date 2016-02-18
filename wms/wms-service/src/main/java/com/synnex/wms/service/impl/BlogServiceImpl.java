package com.synnex.wms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.synnex.wms.dao.bean.Blog;
import com.synnex.wms.dao.mapper.BlogMapper;
import com.synnex.wms.service.IBlogService;

@Service
public class BlogServiceImpl implements IBlogService {

	@Resource
	private BlogMapper blogMapper;
	
	@Override
	public List<Blog> selectBlogs() throws Exception {
		return blogMapper.selectBlogs();
	}

}
