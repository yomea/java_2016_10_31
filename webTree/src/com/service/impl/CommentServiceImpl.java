package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dao.CommentDao;
import com.dao.impl.CommentDaoImpl;
import com.pojo.Comment;
import com.service.CommentService;
import com.util.JsonUtil;
import com.util.Pager;

public class CommentServiceImpl implements CommentService {

	private CommentDao dao = new CommentDaoImpl();

	@Override
	public Pager<Comment> getComment(int id, int pageNum, int pageSize) {
		List<Comment> comments = this.gainComments(id, pageNum, pageSize);
		Pager<Comment> pager = new Pager<>(pageNum, comments);
		return pager;
	}

	private List<Comment> gainComments(int pid, int pageNum, int pageSize) {
		List<Comment> comments = new ArrayList<Comment>();
		
		String sql = "select id, pid, cont, isleaf from article where pid = ? limit ?,?";

		comments = dao.getComment(comments, sql, pid, pageNum, pageSize);

		return comments;

	}

	public static void main(String[] args) {
		Pager<Comment> pager = new CommentServiceImpl().getComment(0, 0, 1);
		
		System.out.println(JsonUtil.objectToJson(pager));
	}

}
