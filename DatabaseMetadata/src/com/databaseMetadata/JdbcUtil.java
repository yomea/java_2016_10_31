package com.databaseMetadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
	}

	public static void release(Connection conn, Statement statm, ResultSet resultSet) {
		try {
			if(conn != null) {
				conn.close();
				
			}
			if(statm != null) {
				statm.close();
				
			}
			
			if(resultSet != null) {
				resultSet.close();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
