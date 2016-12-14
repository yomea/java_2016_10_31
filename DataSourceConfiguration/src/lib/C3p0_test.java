package lib;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0_test {

	private static ComboPooledDataSource dataSource = null;

	static {

		// 通过代码创建C3P0数据库连接池
		/*
		 * ds = new ComboPooledDataSource();
		 * ds.setDriverClass("com.mysql.jdbc.Driver");
		 * ds.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		 * ds.setUser("root"); ds.setPassword("root"); ds.setInitialPoolSize(10);
		 * ds.setMinPoolSize(5); ds.setMaxPoolSize(20);
		 */

		// 通过读取C3P0的xml配置文件创建数据源，C3P0的xml配置文件c3p0-config.xml必须放在src目录下
		// ds = new ComboPooledDataSource();//使用C3P0的默认配置来创建数据源
		// dataSource = new ComboPooledDataSource();//将使用c3p0.xml中配置的默认配置
		dataSource = new ComboPooledDataSource("oracle");// 使用oracle配置项

	}

	public static Connection getConnection() throws SQLException {

		return dataSource.getConnection();
	}

	public static void main(String[] args) throws SQLException {
		Connection connection = C3p0_test.getConnection();
		System.out.println(connection);

	}

}
