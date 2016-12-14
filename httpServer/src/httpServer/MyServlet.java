package httpServer;

import java.io.IOException;
import java.io.Writer;

/**
 * 用户自定义的servlet
 * 类
 * @author may
 *
 */
public class MyServlet extends Servlet {
	
	/**
	 * 处理get请求
	 */
	@Override
	public void doGet(Request request, Response response) throws IOException {
		Writer writer = response.getWriter();

		writer.write("<html><head><title>HTTP响应示例</title><style type='text/css'>*{text-align:center;}ul{list-style-type:none;}</style></head><body><h1>Hello " + request.getParameter("username")
				+ "!</h1><h2>您的年龄是" + request.getParameter("age") + "</h2><h3>您喜欢的水果</h3><ul>");
		
		String[] favs = request.getParmeterValues("fav");
		for (String string : favs) {
			writer.write("<li>" + string + "</li>");
		}
		
		writer.write("</ul></body></html>");
	}
	
	

	/**
	 * 处理post请求
	 */
	@Override
	public void doPost(Request request, Response response) throws IOException {
		this.doGet(request, response);
	}
	
	

}
