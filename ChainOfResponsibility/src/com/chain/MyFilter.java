package com.chain;

//具体的过滤类
public class MyFilter extends Filter {
	
	private String name;
	
	public MyFilter(String name) {
		this.name = name;
	}

	@Override
	public String doFilter(Handler handler) {
		System.out.println("第一回：" + name);
		handler.doFilter(handler);
		System.out.println("第二回：" + name);
		return "hehe";
	}

}
