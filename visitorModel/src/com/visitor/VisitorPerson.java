package com.visitor;

/**
 * 访问者
 * @author may
 *
 */
public class VisitorPerson implements Visitor {

	@Override
	public void visitCompute(Electronics electronic) {
		
		System.out.println("访问了电脑");
	}

	@Override
	public void visitMobile(Electronics electronic) {
		
		System.out.println("访问了手机");
		
	}

}
