package org.springframework.samples.web.mapper;

import java.util.List;

import org.springframework.samples.web.bean.Blog;

public interface BlogMapper {
	public List<Blog> selectBlogs();
}
