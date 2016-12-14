package com.interpret;

/**
 * 解释器模式
 * 表达式接口类
 * @author may
 *
 */
public abstract interface Expression {
	
	public boolean interpreter(Context context);

}
