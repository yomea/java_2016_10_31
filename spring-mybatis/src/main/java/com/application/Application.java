package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Configuration : 表示Application作为spring配置文件存在 
 * 
 * @EnableAutoConfiguration: 启动spring boot内置的自动配置  @ComponentScan :
 *                           扫描bean，路径为Application类所在package以及package下的子路径，这里为com.application，当然也可以传递一个参数指定在spring
 *                           boot中bean都放置在该路径已经子路径下。
 * @author may
 *
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
