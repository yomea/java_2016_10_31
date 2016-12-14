package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.listener.MyapplictionListener;


@RestController//定义为Controller控制器
@EnableAutoConfiguration//根据依赖自动配置
public class Example {
	
	@Value("${test.username}")
	private String username;
	
	//localhost:8080
	@RequestMapping("/")//映射访问地址
	String home() {
		return username;
	}
	//可以这样直接启动，也可以使用maven的指令mvn clean spring-boot:run
	public static void main(String[] args) throws Exception {
		SpringApplication appliction = new SpringApplication(Example.class);
		appliction.addListeners(new MyapplictionListener());
		appliction.run(args);
	}
}