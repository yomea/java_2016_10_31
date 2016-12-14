package javaExecution;

public class B extends A {

	public B() {
		System.out.println("create B");
		
	}
	
	{
		System.out.println("B dynamic execute");
		
	}
	
	static {
		
		System.out.println("B static execute");
		
	}
	
}
