package com.classloader;

class A {
	
	public static String a = "hello";
	
	public static final String B = "world";
	
	{
		System.out.println("动态块A");
		
	}
	
	
	static {
		System.out.println("静态初始化A");
		
	}
	
	public A() {
		System.out.println("create A");
		
	}
	
	
} 

class B extends A {
	public static String c = "c";
	
	public static final String D = "" ;
	
	{
		System.out.println("动态块B");
		
	}
	
	static {
		//D = ""; //如果final的常量没有设置初值，那么在这里赋初值就会发生类加载
		System.out.println("静态初始化B");
	}
	
	public B() {
		
		System.out.println("create B");
	}
	
}

public class Test {
	
	public static void main(String[] args) {
		//System.out.println(B.D);//这里的D在声明时赋给了初值，就是被动引用，类名.常量，B与A都不会发生静态初始化
		
		//System.out.println(B.c);//会初始化A与B
		
		//new B();//一定会初始化A和B
		
		//System.out.println(B.a);//只初始化A
		
		
		
	}
}


