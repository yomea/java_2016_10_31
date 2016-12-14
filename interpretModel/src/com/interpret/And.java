package com.interpret;
/**
 * 包装and类
 * @author may
 *
 */
public class And implements Expression {
	//and左右两边的表达式
	private Expression left, right;
	
	public And(Expression left, Expression right) {
		
		this.left = left;
		
		this.right = right;
		
	}

	@Override
	public boolean interpreter(Context context) {
		
		
		
		return left.interpreter(context) && right.interpreter(context);
	}


}
