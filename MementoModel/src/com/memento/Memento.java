package com.memento;
/**
 * 备忘录，用来记录发起人的信息
 * @author may
 *
 */
public class Memento {
	
	private String state;

	public Memento(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

}
