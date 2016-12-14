package com.template;

public class HttpServletSubClass extends HttpServlet {

	@Override
	public void doGet(String request, String response) {
		System.out.println("调用get!!!");
		
	}

	@Override
	public void doPost(String request, String response) {
		System.out.println("调用post!!!");
		
	}

}
