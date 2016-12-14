package com.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.bean.User;
import com.mybatis.mapper.UserMapper;
import com.mybatis.util.MybatisUtil;

public class MybatisTest {
	
	public static void main(String[] args) {
		
		SqlSession session = MybatisUtil.getSession();
		
		User user = session.selectOne("com.mybatis.mapper.UserMapper.get", 1);
		
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		List<User> users = userMapper.getAll();
		
		for (User user2 : users) {
			System.out.println(user2);
		}
		
		System.out.println(user);
		
		
	}

}
