package com.chainOfResponsibility;

/**
 * handler的子类
 * @author may
 *
 */
public class MyFilter extends Handler {
	
	private String name;
	
	public MyFilter(Handler successor) {
		
		this.setSuccessor(successor);
	}
	
	public MyFilter(String name) {
		this.name = name;
		
	}

	@Override
	public void handler() {
		System.out.println("第一回" + name);
		if(this.getSuccessor() == null) {
			
			return ;
		}
		//类似servlet里的filter的doFilter()，表示放行
		this.getSuccessor().handler();
		System.out.println("第二回" + name);
	}

}
