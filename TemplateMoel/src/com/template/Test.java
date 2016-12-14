package com.template;

public class Test {
	
	public static void main(String[] args) {
		
		HttpServlet httpServlet = new HttpServletSubClass();
		
		httpServlet.service("GET", "");
		
	}
	
}
