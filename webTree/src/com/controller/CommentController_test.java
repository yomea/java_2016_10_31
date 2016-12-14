package com.controller;

import java.util.List;

import com.pojo.Comment;
import com.service.CommentService;
import com.service.impl.CommentServiceImpl;
import com.util.JsonUtil;
import com.util.Pager;

public class CommentController_test {
	
	public static void main(String[] args) {
		CommentService service = new CommentServiceImpl();
		
		Pager<Comment> comments = service.getComment(0, 0, 10);

		String jsonData = JsonUtil.objectToJson(comments);
		System.out.println(jsonData);
		print(comments.getComments(), 0);

	}

	private static void print(List<Comment> comments, int level) {
		String str = "";
	
		for(int i = 0; i < level; i++) {
			str += "***";
			
		}

		for (Comment comment : comments) {
			System.out.println(str + comment.getContent());
			if(1 == comment.getIsLeaf()) {
				print(comment.getComments(), level + 1);
				
			}
		}

	}

}
