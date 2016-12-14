package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController//定义为Controller控制器
@EnableAutoConfiguration//根据依赖自动配置
public class Example implements EmbeddedServletContainerCustomizer { 
	//localhost:8080
	@RequestMapping("/")//映射访问地址
	String home() {
		return "您好 世界!";
	}
	//可以这样直接启动，也可以使用maven的指令mvn clean spring-boot:run
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Example.class, args);
	}
	//设置端口
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8888);
		
	}
}