package com.template;

public abstract class HttpServlet {

	//定义模板方法
	public void service(String request, String response) {
		
		if(request.equals("GET")) {
			
			doGet(request, response);
			
		} else if (request.equals("POST")) {
			
			doPost(request, response);
		}
		
		
	}
	//基本方法
	public abstract void doGet(String request, String response);
	//基本方法
	public abstract void doPost(String request, String response);
	
	
}
