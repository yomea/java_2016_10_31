package com.mediator;

public class Person {
	
	private Mediator meditor = null;
	
	public Person(Mediator meditor) {
		this.meditor = meditor;
		
	}
	
	public void jiaoshui() {
		
		System.out.println("缴税");
	}

}
