package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class Comment {
	
	private int id;
	
	private int pid;
	
	private String content;
	
	private int isLeaf;
	
	private List<Comment> comments = new ArrayList<Comment>();
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(int isLeaf) {
		this.isLeaf = isLeaf;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", pid=" + pid + ", content=" + content + ", isLeaf=" + isLeaf + ", comments="
				+ comments + "]";
	}
	
	
}
