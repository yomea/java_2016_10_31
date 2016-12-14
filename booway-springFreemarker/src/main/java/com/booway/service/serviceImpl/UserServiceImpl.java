package com.booway.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booway.mapper.UserMapper;
import com.booway.pojo.User;
import com.booway.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public UserServiceImpl() {
		
	}
	
	@Override
	public List<User> getAllUsers() {
		List<User> users = userMapper.getAllUsers();
		
		return users;
	}

}
