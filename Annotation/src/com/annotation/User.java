package com.annotation;

@Table("t_user")
public class User {
	
	@Field(column="username", type="varchar", length=20)
	private String username;
	
	@Field(column="age", type="int", length=20)
	private int age;
	
	@Id
	private int id;
	
	
	

}
