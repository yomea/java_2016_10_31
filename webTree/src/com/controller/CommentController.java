package com.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Comment;
import com.service.CommentService;
import com.service.impl.CommentServiceImpl;
import com.util.DigitUtil;
import com.util.JsonUtil;
import com.util.Pager;

@WebServlet("/tree")
public class CommentController extends HttpServlet {

	private static final long serialVersionUID = -6415932890784087449L;

	private CommentService service = new CommentServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		int pageNum = 1;

		int pageSize = 10;
		
		int id = 0;

		String pageNumStr = req.getParameter("pageNum");

		String pageSizeStr = req.getParameter("pageSize");
		
		String idStr = req.getParameter("id");

		resp.setContentType("application/json;charset=utf-8");
		//禁止流浪器缓存
		resp.setDateHeader("Expires", 0);
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Prama", "no-cache");

		Writer writer = resp.getWriter();

		//检验当前的取得的数据是否为数字字符串
		if (!DigitUtil.isIntegerDigit(pageNumStr) || !DigitUtil.isIntegerDigit(pageSizeStr) || !DigitUtil.isIntegerDigit(idStr)) {
			pageNumStr = "1";
			pageSizeStr = "1";
			idStr = "0";
		}
		
		pageNum = Integer.parseInt(pageNumStr);
		
		pageSize = Integer.parseInt(pageSizeStr);
		
		id = Integer.parseInt(idStr);
		
		Pager<Comment> comments = service.getComment(id, pageNum, pageSize);
		
		String jsonData = JsonUtil.objectToJson(comments);
		
		writer.write(jsonData);
		
		writer.flush();
		if(writer != null) {
			
			writer.close();
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
