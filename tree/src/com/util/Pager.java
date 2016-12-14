package com.util;

import java.util.ArrayList;
import java.util.List;

public class Pager<T> {
	
	private int currentPage;//但前页码
	
	private int totalPage;//总页码
	
	private int totalRow;//总行数
	
	private List<T> comments = new ArrayList<T>();

	public Pager(int currentPage, int totalPage, int totalRow, List<T> comments) {
		super();
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.totalRow = totalRow;
		this.comments = comments;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public List<T> getComments() {
		return comments;
	}

	public void setComments(List<T> comments) {
		this.comments = comments;
	}
	
}
