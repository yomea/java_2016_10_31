package com.mybatis.mapper;

import java.util.List;

import com.mybatis.bean.User;

public interface UserMapper {
	
	List<User> getAll();
	
	User get(int id);
	
	int update();
	
	int insert();

}
