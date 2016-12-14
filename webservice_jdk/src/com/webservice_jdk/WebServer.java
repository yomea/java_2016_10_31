package com.webservice_jdk;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WebServer {

	@WebMethod
	void sayHello();
	
	@WebMethod
	void printName(String name);
	
}
