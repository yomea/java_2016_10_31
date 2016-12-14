package httpServer;

import java.io.IOException;
import java.net.Socket;

/**
 * 在每个请求到来时，创建一个新的线程响应请求
 * @author may
 *
 */
public class Dispatcher implements Runnable {
	
	private Request request;
	private Response response;
	private int code = 200;
	
	public Dispatcher(Socket socket, Request request, Response response) {
		this.request = request;
		this.response = response;
		
	}
	

	@Override
	public void run() {
		
		try {
			//解析参数
			request.parseParam();
			String url = "/" + request.getUrl();
			//忽略/favicon.ico请求
			if("/favicon.ico".equals(url)) {
				return ;
				
			}
			//根据UR-pattern取得servlet的名称
			String servletName = Webapps.getMapping().get(url);
			//根据servletName来得到servlet
			Servlet servlet = Webapps.getServlet(servletName);
			//如果加载配置文件出了错误，得到状态码
			this.code = Webapps.getCode();
			if(servlet == null) {
				//如果为null，将404写入相应头
				response.createHeader(404);
				//如果为null，向客户端响应404错误
				response.pushToClient();
				return ;
			}
			//如果没有出错，调用servlet的服务方法，写出用户自定义的响应数据
			response.createHeader(code);
			servlet.initResource(request, response);
			
			servlet.server(request, response);
			
			response.pushToClient();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}

}
