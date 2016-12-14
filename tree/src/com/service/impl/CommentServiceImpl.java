package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dao.CommentDao;
import com.dao.impl.CommentDaoImpl;
import com.pojo.Comment;
import com.service.CommentService;

public class CommentServiceImpl implements CommentService {

	private CommentDao dao = new CommentDaoImpl();

	@Override
	public List<Comment> getComment() {
		List<Comment> comments = this.gainComments(0);
		return comments;
	}
	/**
	 * 用来递归查找评论
	 * @param pid 父ID，顶层评论的pid为0
	 * @return
	 */
	private List<Comment> gainComments(int pid) {
		List<Comment> comments = new ArrayList<Comment>();

		String sql = "select id, pid, cont, isleaf from article where pid = ?";

		comments = dao.getComment(comments, sql, pid);

		return comments;

	}

	

}
