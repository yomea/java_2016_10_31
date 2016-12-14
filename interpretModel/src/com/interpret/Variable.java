package com.interpret;

public class Variable implements Expression {
	
	private String key;
	
	public Variable(String key) {
		this.key = key;
		
	}

	@Override
	public boolean interpreter(Context context) {
		
		boolean flag = context.getValue(key);
		
		return flag;
	}


}
