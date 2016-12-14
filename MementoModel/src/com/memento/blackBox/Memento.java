package com.memento.blackBox;

import java.util.Vector;
/**
 * 备忘录
 * @author may
 *
 */
public class Memento {
	
	private Vector<String> states = null;
	
	
	@SuppressWarnings("unchecked")
	public Memento(Vector<String> states) {
		this.states = (Vector<String>) states.clone();
		
	}

	public Vector<String> getStates() {
		return states;
	}

	public void setStates(Vector<String> states) {
		this.states = states;
	}


	

}
