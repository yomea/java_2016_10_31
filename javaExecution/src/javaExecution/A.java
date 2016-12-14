package javaExecution;

public class A {
	
	public A() {
		System.out.println("create A");
		
	}
	
	{
		System.out.println("A dynamic execute");
		
	}
	
	static {
		
		System.out.println("A static execute");
		
	}

}
