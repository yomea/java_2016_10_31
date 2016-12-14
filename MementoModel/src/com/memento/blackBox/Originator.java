package com.memento.blackBox;

import java.util.Vector;

/**
 * 发起人
 * @author may
 *
 */
public class Originator {
	//储存状态
	private Vector<String> states = null;
	
	public Originator() {
		states = new Vector<String>();
		
	}
	
	public Memento createMemento() {
		
		return new Memento(states);
		
	}
	
	public Vector<String> getStates() {
		
		return states;
	}
	
	public void setState(String state) {
		states.addElement(state);
	}
	
	public void restoreMemento(Memento memento) {
		this.states = memento.getStates();
		
	}
	
	public void print() {
		
		for (String string : states) {
			System.out.println(string);
		}
		
	}
	

}
