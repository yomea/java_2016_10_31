package com.dao;

import java.util.List;

import com.pojo.Comment;

/**
 * 获取评论信息的dao层
 * @author may
 *
 */
public interface CommentDao {
	
	/**
	 * 
	 * @param comments 用来装评论对象的容器
	 * @param sql SQL语句
	 * @param pid 每行记录的父ID
	 * @return
	 */
	List<Comment> getComment(List<Comment> comments, String sql, int pid);

}
