package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.pojo.Comment;

public class DatabaseUtil {

	private static Connection connection;

	private static final String URL = "jdbc:mysql://localhost:3306/bbs";

	private static final String USER = "root";

	private static final String PASSWORD = "root";

	static {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConn() {
		try {
			if (connection == null) {

				connection = DriverManager.getConnection(URL, USER, PASSWORD);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static List<Comment> getComment(List<Comment> comments, String sql, int pid, int pageNum, int pageSize) {
		Connection connection = DatabaseUtil.getConn();

		try {
			PreparedStatement pstat = connection.prepareStatement(sql);
			pstat.setInt(1, pid);
			pstat.setInt(2, (pageNum - 1) * pageSize);
			pstat.setInt(3, pageSize);
			ResultSet rs = pstat.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();
			int count = meta.getColumnCount();
			while (rs.next()) {
				Comment comment = new Comment();
				for (int i = 0; i < count; i++) {
					String columnName = meta.getColumnName(i + 1);
					switch (columnName) {
					case "id":
						comment.setId(rs.getInt(columnName));
						break;
					case "pid":
						comment.setPid(rs.getInt(columnName));
						break;
					case "cont":
						comment.setContent(rs.getString(columnName));
						break;
					case "isleaf":
						comment.setIsLeaf(rs.getInt(columnName));
						break;

					}
				}
				pstat.clearParameters();
				if (comment.getIsLeaf() == 1) {
					getComment(comment.getComments(), sql, comment.getId(), pageNum, pageSize);

				}
				comments.add(comment);

			}
			close(rs);
			close(pstat);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return comments;
	}
	
	public static void close() {

		if (connection != null) {

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			connection = null;
		}

	}
	
	
	public static int getCount(String sql) {
		
		Connection connection = getConn();
		
		Statement stat;
		try {
			
			stat = connection.createStatement();
			
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getInt(1);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	public static void close(Statement stat) {

		if (stat != null) {

			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stat = null;
		}

	}

	public static void close(ResultSet rs) {

		if (rs != null) {

			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}

	}

}
