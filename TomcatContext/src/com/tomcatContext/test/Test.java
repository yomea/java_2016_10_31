package com.tomcatContext.test;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Test {
	
	public static void main(String[] args) throws Exception {
		
		Context context = new InitialContext();
		
		DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/MysqlDataSource");
		
		Connection connection = dataSource.getConnection();
		
		System.out.println(connection);
		
	}

}
