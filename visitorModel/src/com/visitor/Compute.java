package com.visitor;

/**
 * 电脑
 * @author may
 *
 */
public class Compute implements Electronics {

	@Override
	public void accept(Visitor visitor) {
		visitor.visitCompute(this);

	}

}
