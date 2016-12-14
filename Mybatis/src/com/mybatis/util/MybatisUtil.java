package com.mybatis.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	
	private static SqlSessionFactory factory = null;
	
	static {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		factory = new SqlSessionFactoryBuilder().build(reader);
		
		
		
	}
	
	public static SqlSession getSession() {
		
		return factory.openSession();
	}
	
	public static void close(SqlSession session) {
		if(session != null) {
			session.close();
			
		}
	}
	
	
	

}
