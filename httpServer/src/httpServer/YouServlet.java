package httpServer;

import java.io.IOException;
import java.io.Writer;

public class YouServlet extends Servlet {

	@Override
	public void doGet(Request request, Response response) throws IOException {
		Writer writer = response.getWriter();

		writer.write("<html><head><title>HTTP响应示例</title><style type='text/css'>*{text-align:center;}</style></head><body>Hello</body></html>");
		
		
		writer.write("");
	}
	
	

	@Override
	public void doPost(Request request, Response response) throws IOException {
		this.doGet(request, response);
	}
	
	

}
