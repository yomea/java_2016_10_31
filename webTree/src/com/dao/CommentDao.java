package com.dao;

import java.util.List;

import com.pojo.Comment;

public interface CommentDao {
	/**
	 * 
	 * @param comments 用于存储comment的List容器
	 * @param sql SQL语句
	 * @param pid comment的父ID
	 * @param pageNum 页码
	 * @param pageSize 每页显示的记录数
	 * @return
	 */
	List<Comment> getComment(List<Comment> comments, String sql, int pid, int pageNum, int pageSize);

}
