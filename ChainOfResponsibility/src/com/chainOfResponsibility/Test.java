package com.chainOfResponsibility;

public class Test {
	
	public static void main(String[] args) {
		
		Handler handler1 = new MyFilter("1");
		Handler handler2 = new MyFilter("2");
		Handler handler3 = new MyFilter("3");
		Handler handler4 = new MyFilter("4");
		Handler handler5 = new MyFilter("5");
		handler1.setSuccessor(handler2);
		handler2.setSuccessor(handler3);
		handler3.setSuccessor(handler4);
		handler4.setSuccessor(handler5);
		
		handler1.handler();
	}

}
