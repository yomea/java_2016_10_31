package com.concurrent;

public class User {

	private String username;
	
	private int age;
	
	public User(String username, int age) {
		this.username = username;
		this.age = age;
	}

	public void setUser(String username, int age) {
		
		this.username = username;
		
		this.age = age;
	}

	
	public void print() {
		System.out.println("User [username=" + username + ", age=" + age + "]");
	}
	
	
}
