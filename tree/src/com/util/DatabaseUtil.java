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

	private static final String URL = "jdbc:mysql://localhost:3306/bbs?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";

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

	public static List<Comment> getComment(List<Comment> comments, String sql, int pid) {
		Connection connection = DatabaseUtil.getConn();

		try {
			PreparedStatement pstat = connection.prepareStatement(sql);
			pstat.setInt(1, pid);
			ResultSet rs = pstat.executeQuery();
			//获得表的列信息
			ResultSetMetaData meta = rs.getMetaData();
			//获得当前去除的记录中的字段数
			int count = meta.getColumnCount();
			while (rs.next()) {
				Comment comment = new Comment();
				for (int i = 0; i < count; i++) {
					//获得当前的字段名
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
				//立即清除掉当前设置的参数
				pstat.clearParameters();
				//如果是父节点，就继续往下查找
				if (comment.getIsLeaf() == 1) {
					getComment(comment.getComments(), sql, comment.getId());

				}
				comments.add(comment);

			}
			//释放资源
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
