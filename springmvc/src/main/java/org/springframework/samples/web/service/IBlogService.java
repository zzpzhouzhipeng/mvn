package org.springframework.samples.web.service;

import java.util.List;

import org.springframework.samples.web.bean.Blog;

public interface IBlogService {
	public List<Blog> selectBlogs() throws Exception;
}
