package com.interpret;

public class Test {
	
	public static void main(String[] args) {
		
		Context context = new Context();
		
		Constant constant = new Constant(true);
		
		Variable variableX = new Variable("x");
		
		Variable variableY = new Variable("y");
		
		context.addValue("x", false);
		
		context.addValue("y", true);
		
		And and1 = new And(constant, variableY);
		
		And and2 = new And(variableY, variableX);
		
		Or or = new Or(and1, and2);
		
		
		System.out.println(or.interpreter(context));
		
		
	}

}
