package com.visitor;

/**
 * 手机
 * @author may
 *
 */
public class Mobile implements Electronics {

	@Override
	public void accept(Visitor visitor) {
		visitor.visitMobile(this);

	}

}
