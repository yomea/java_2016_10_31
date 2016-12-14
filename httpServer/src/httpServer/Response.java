package httpServer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Date;

public class Response {

	private StringBuilder context;

	private StringBuilder responseHeaderInfo;

	private static final String CRLF = "\r\n";

	private static final String BLANK = " ";

	private Socket socket;
	

	private BufferedWriter bufferedWriter;

	public Response() {
		context = new StringBuilder();
		responseHeaderInfo = new StringBuilder();

	}

	public Response(Socket socket) throws IOException {
		this();
		this.socket = socket;
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
	}


	/**
	 * 创建头信息
	 * 
	 * @param code
	 * @return
	 * @throws IOException 
	 */
	public void createHeader(int code) throws IOException {
		String info = "";
		// 状态码
		switch (code) {
		case 200:
			info = "OK";
			break;
		case 404:
			info = "NOT FOUND";
			context.delete(0, context.length());
			context.append("页面未找到！！！");
			break;
		case 505:
			info = "SERVER ERROR";
			context.delete(0, context.length());
			context.append("服务器错误！！！");
			break;

		}
		/**
		 * 封装类似的有信息 
		 * HTTP/1.1 200 OK Server:youth server/1.0 
		 * Date:Tue Nov 08
		 * 15:21:22 CST 2016 Content-Type:text/html;charset=utf-8
		 */
		responseHeaderInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK).append(info).append(CRLF);
		responseHeaderInfo.append("Server:youth server/1.0").append(CRLF);
		responseHeaderInfo.append("Date:" + new Date()).append(CRLF);
		responseHeaderInfo.append("Content-Type:text/html;charset=utf-8").append(CRLF).append(CRLF);
		//responseHeaderInfo.append("Content-Length:" + context.toString().getBytes().length).append(CRLF).append(CRLF);

		if(code == 404 || code == 505) {
			responseHeaderInfo.append(context);
			
		} 
		this.getWriter().write(responseHeaderInfo.toString());
	}
	
	/**
	 * 向客户端响应内容
	 * 
	 * @param code
	 * @throws IOException 
	 */
	public void pushToClient() throws IOException {
		Writer writer = this.getWriter();
		writer.flush();
		CloseUtil.close(writer, socket);
	}

	public Writer getWriter() throws IOException {
		
		return bufferedWriter;
	}

}
