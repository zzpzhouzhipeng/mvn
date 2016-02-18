package com.synnex.wms.dao.bean;

import java.util.List;

public class Blog {
	private long id;
	private String title;
	private int categroy;
	private List<Author> authors;
	
	public int getCategroy() {
		return categroy;
	}
	public void setCategroy(int categroy) {
		this.categroy = categroy;
	}
	public long getId() {
		return id;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
