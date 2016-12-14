package com.chain;

public class Test {
	
	public static void main(String[] args) {
		
		Handler handler = new MyHandler();
		
		Filter filter1 = new MyFilter("1");
		Filter filter2 = new MyFilter("2");
		Filter filter3 = new MyFilter("3");
		Filter filter4 = new MyFilter("4");
		Filter filter5 = new MyFilter("5");
		
		handler.addFilter(filter1);
		handler.addFilter(filter2);
		handler.addFilter(filter3);
		handler.addFilter(filter4);
		handler.addFilter(filter5);
		
		handler.doFilter(handler);
		
	}

}
