package com.state;

public class LocakState implements StateIF {

	@Override
	public void pass(Door door, String key) {
		if(key != null &&key.equals(StateIF.key)) {
			door.setState(new UnlocakState());
			door.pass(key);
			
		} else {
			
			System.out.println("门打不开");
		}
		
		
	}


}
