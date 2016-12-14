package com.observer;

public class Watcher {
	
	private String name;
	
	public Watcher(String name) {
		this.name = name;
		
	}
	
	
	
	public void printer() {
		
		System.out.println("watcher:" + name);
	}

}
