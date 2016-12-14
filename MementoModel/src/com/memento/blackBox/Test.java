package com.memento.blackBox;

public class Test {
	
	public static void main(String[] args) {
		
		Originator originator = new Originator();
		Caretaker caretaker = new Caretaker(originator);
		
		originator.setState("state1");
		
		caretaker.createMemento();
		
		originator.setState("state2");
		
		caretaker.createMemento();
		
		originator.setState("state3");
		
		caretaker.createMemento();
		
		caretaker.restoreMemento(1);
		
		originator.print();
		
		
		
	}

}
