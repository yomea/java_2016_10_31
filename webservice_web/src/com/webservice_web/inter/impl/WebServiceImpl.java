package com.webservice_web.inter.impl;

import javax.jws.WebService;

import com.webservice_web.inter.IWebService;

@WebService
public class WebServiceImpl implements IWebService {

	@Override
	public void sayHello() {
		System.out.println("hello world");

	}

	@Override
	public void printName(String name) {
		System.out.println(name);

	}

}
