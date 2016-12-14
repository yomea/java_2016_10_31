package com.state;

public class Door {
	
	public StateIF state;
	
	public Door() {
		this.state = new UnlocakState();
		
	}
	
	public Door(StateIF state) {
		this.state = state;
		
	}

	
	public void pass(String key) {
		
		state.pass(this, key);
	}

	public StateIF getState() {
		return state;
	}

	public void setState(StateIF state) {
		this.state = state;
	}
	
	

}
