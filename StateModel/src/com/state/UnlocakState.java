package com.state;

public class UnlocakState implements StateIF {

	//通过方法，在门未锁的状态下，我可以推门进去
	@Override
	public void pass(Door door, String key) {
		
		if(key != null && key.equals(StateIF.key)) {
			door.setState(new LocakState());
			System.out.println("把门锁了");
			return ;
		}
		
		System.out.println("推开门，我看见了妈妈给我准备好了热腾腾的饭，妈妈慈祥地对我笑");

	}

}
