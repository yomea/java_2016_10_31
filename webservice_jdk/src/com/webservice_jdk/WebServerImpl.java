package com.webservice_jdk;

import javax.jws.WebService;

@WebService
public class WebServerImpl implements WebServer {

	@Override
	public void sayHello() {
		
		System.out.println("hello world");

	}

	@Override
	public void printName(String name) {
		
		System.out.println(name);
	}

}
