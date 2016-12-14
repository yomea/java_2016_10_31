package com.dao.impl;

import java.util.List;

import com.dao.CommentDao;
import com.pojo.Comment;
import com.util.DatabaseUtil;

public class CommentDaoImpl implements CommentDao {

	@Override
	public List<Comment> getComment(List<Comment> comments, String sql, int pid) {
		
		//获取评论list
		comments = DatabaseUtil.getComment(comments, sql, pid);
		//关闭connection对象
		DatabaseUtil.close();
		
		return comments;
	}

}
