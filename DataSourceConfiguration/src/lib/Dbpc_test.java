package lib;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class Dbpc_test {
	
	public static DataSource dataSource = null;
	
	static {
		
		Properties properties = new Properties();
		
		
		try {
			properties.load(Dbpc_test.class.getResourceAsStream("/dbpc.properties"));
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void main(String[] args) {
		
		Connection connection = Dbpc_test.getConnection();
		System.out.println(connection);
		
		
		
		try {
			System.out.println(connection.createStatement());
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
