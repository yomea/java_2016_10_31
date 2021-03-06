package com.ssm.service;

import java.util.List;

import com.ssm.pojo.User;

public interface UserService {
	
	int save(User user);
	
	int update(User user);
	
	List<User> getUsers();
	
	User validateUser(User user);
	
	int delete(int id);
	
	int register(User user);

}
