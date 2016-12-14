package com.webservice_web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.xml.ws.Endpoint;

import com.webservice_web.inter.impl.WebServiceImpl;

@WebListener
public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		String address = "http://169.254.75.182:8787/WS_Server/Webservice";
		// 使用Endpoint类提供的publish方法发布WebService，发布时要保证使用的端口号没有被其他应用程序占用
		Endpoint.publish(address, new WebServiceImpl());
		System.out.println("发布webservice成功!");

	}

}
