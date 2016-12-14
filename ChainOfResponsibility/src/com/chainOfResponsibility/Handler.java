package com.chainOfResponsibility;

public abstract class Handler {
	
	//下一个handler的引用
	private Handler successor;
	
	public void setSuccessor(Handler successor) {
		
		this.successor = successor;
	}
	
	public Handler getSuccessor() {
		
		return this.successor;
	}
	
	public abstract void handler();
	
	

}
