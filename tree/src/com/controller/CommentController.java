package com.controller;

import java.util.List;

import com.pojo.Comment;
import com.service.CommentService;
import com.service.impl.CommentServiceImpl;
import com.util.JsonUtil;

public class CommentController {
	
	public static void main(String[] args) {
		CommentService service = new CommentServiceImpl();
		
		List<Comment> comments = service.getComment();
		//将list转化成json
		String jsonData = JsonUtil.objectToJson(comments);
		System.out.println(jsonData);
		print(comments, 0);

	}

	/**
	 * 
	 * @param comments 评论的list
	 * @param level 递归深度，即这棵树的字树所在的行
	 */
	private static void print(List<Comment> comments, int level) {
		//根据该评论的递归深度进行缩进
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
