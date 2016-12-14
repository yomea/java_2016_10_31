package com.service;

import com.pojo.Comment;
import com.util.Pager;

public interface CommentService {
	Pager<Comment> getComment(int id, int pageNum, int pageSize);
}
