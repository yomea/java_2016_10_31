package com.visitor;

/**
 * 访问者接口类
 * @author may
 *
 */
public interface Visitor {
	
	
	void visitCompute(Electronics electronic);
	
	void visitMobile(Electronics electronic);

}
