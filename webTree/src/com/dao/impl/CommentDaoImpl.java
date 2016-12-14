package com.dao.impl;

import java.util.List;

import com.dao.CommentDao;
import com.pojo.Comment;
import com.util.DatabaseUtil;

public class CommentDaoImpl implements CommentDao {

	@Override
	public List<Comment> getComment(List<Comment> comments, String sql, int pid, int pageNum, int pageSize) {
		
		
		comments = DatabaseUtil.getComment(comments, sql, pid, pageNum, pageSize);
		
		DatabaseUtil.close();
		
		
		return comments;
	}

}
