package httpServer;

import java.io.IOException;

public abstract class Servlet {
	
	private String method;
	
	/**
	 * 不建议被重写
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public final  void initResource(Request request, Response response) throws IOException {
		
		this.method = request.getMethod();
	}
	/**
	 * 不建议被重写
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public final void server(Request request, Response response) throws IOException {
		
		if ("post".equalsIgnoreCase(method)) {
			this.doPost(request, response);

		} else if ("get".equalsIgnoreCase(method)) {

			this.doGet(request, response);
		}
	}

	public abstract void doGet(Request request, Response response) throws IOException;

	public abstract void doPost(Request request, Response response) throws IOException;
}
