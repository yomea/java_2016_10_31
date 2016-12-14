package com.example.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
/**
 * 设置spring-boot启动监听器
 * @author may
 *
 */
public class MyapplictionListener implements ApplicationListener<ApplicationStartedEvent> {

	public void onApplicationEvent(ApplicationStartedEvent event) {
		System.out.println("spring-boot启动啦！");
		
	}

}
