package com.flyweight;

public class Test {
	
	public static void main(String[] args) {
		SingletonFactory singletonFactory = SingletonFactory.newInstance();
		
		Flyweight flyweight = singletonFactory.getFlyweight('a');
		Flyweight flyweight2 = singletonFactory.getFlyweight('a');
		
		
		System.out.println(flyweight == flyweight2);
		flyweight.operation("这只是一个享元模式的简单的测试！！！");
		
	}

}
