package com.ssm.pojo;

import java.util.Date;

public class User {
	
	private int id;
	
	private String username;
	
	private int age;
	
	private String password;
	
	private Date date;
	
	public User(String username, int age, String password, Date date) {
		this.username = username;
		this.age = age;
		this.password = password;
		this.date = date;
		
	}
	
	public User() {
		
		
	}
	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
