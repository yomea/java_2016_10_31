package com.interpret;

public class Or implements Expression {
	private Expression left, right;
	
	public Or(Expression left, Expression right) {
		this.left = left;
		
		this.right = right;		
	}

	@Override
	public boolean interpreter(Context context) {
		
		return left.interpreter(context) || right.interpreter(context);
	}

}
