package com.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装的评论对象
 * @author may
 *
 */
public class Comment {
	//id
	private int id;
	//父ID
	private int pid;
	//评论的内容
	private String content;
	//是否为叶子节点
	private int isLeaf;
	//用来装它的回复评论
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
