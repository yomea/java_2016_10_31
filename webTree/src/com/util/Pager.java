package com.util;

import java.util.ArrayList;
import java.util.List;

public class Pager<T> {
	
	private int currentPage;
	
	private List<T> comments = new ArrayList<>();

	public Pager(int currentPage, List<T> comments) {
		super();
		this.currentPage = currentPage;
		this.comments = comments;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<T> getComments() {
		return comments;
	}

	public void setComments(List<T> comments) {
		this.comments = comments;
	}
	
}
