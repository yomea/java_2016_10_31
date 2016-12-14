package com.interpret;

public class Constant implements Expression {
	
	private boolean flag;
	
	public Constant(boolean flag) {
		this.flag = flag;
		
	}

	@Override
	public boolean interpreter(Context context) {
		
		return flag;
	}
	
	

}
