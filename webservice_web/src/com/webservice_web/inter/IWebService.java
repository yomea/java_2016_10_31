package com.webservice_web.inter;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IWebService {
	
	@WebMethod
	void sayHello();
	
	@WebMethod
	void printName(String name);
	

}
