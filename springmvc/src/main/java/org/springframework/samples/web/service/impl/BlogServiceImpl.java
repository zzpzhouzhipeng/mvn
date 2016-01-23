package org.springframework.samples.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.samples.web.bean.Blog;
import org.springframework.samples.web.mapper.BlogMapper;
import org.springframework.samples.web.service.IBlogService;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements IBlogService {

	@Resource
	private BlogMapper blogMapper;
	
	@Override
	public List<Blog> selectBlogs() throws Exception {
		return blogMapper.selectBlogs();
	}

}
