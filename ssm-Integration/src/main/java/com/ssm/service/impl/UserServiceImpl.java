package com.ssm.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.UserDao;
import com.ssm.pojo.User;
import com.ssm.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public int save(User user) {
		return userDao.save(user);
	}

	@Override
	public int update(User user) {
		return userDao.update(user);
	}

	@Override
	public User validateUser(User user) {
		return userDao.validateUser(user);
	}

	@Override
	public int delete(int id) {
		return userDao.delete(id);
	}

	@Override
	public int register(User user) {
		return userDao.register(user);
	}

	@Override
	public List<User> getUsers() {
		List<User> users = userDao.getUsers();
		if(null == users) {
			users = Collections.emptyList();
			
		}
		
		return users;
	}

	

}
