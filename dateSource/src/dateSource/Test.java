package dateSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
	
	public static void main(String[] args) {
		
		MyDataSource dateSource = new MyDataSource();
		Connection connection = null;
		
		try {
			connection = dateSource.getConnection();
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
