package com.databaseMetadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DatabaseMetadata {

	public static void main(String[] args) throws Exception {
		// DatabaseMetadata.DatabaseMetaDataTest();
		// DatabaseMetadata.ParameterMetaDataTest();
		DatabaseMetadata.ResultSetMetaDataTest();
	}

	public static void DatabaseMetaDataTest() throws Exception {

		Connection conn = JdbcUtil.getConnection();
		DatabaseMetaData metadata = conn.getMetaData();
		// getURL()：返回一个String类对象，代表数据库的URL
		System.out.println(metadata.getURL());
		// getUserName()：返回连接当前数据库管理系统的用户名
		System.out.println(metadata.getUserName());
		// getDatabaseProductName()：返回数据库的产品名称
		System.out.println(metadata.getDatabaseProductName());
		// getDatabaseProductVersion()：返回数据库的版本号
		System.out.println(metadata.getDatabaseProductVersion());
		// getDriverName()：返回驱动驱动程序的名称
		System.out.println(metadata.getDriverName());
		// getDriverVersion()：返回驱动程序的版本号
		System.out.println(metadata.getDriverVersion());
		// isReadOnly()：返回一个boolean值，指示数据库是否只允许读操作
		System.out.println(metadata.isReadOnly());
		JdbcUtil.release(conn, null, null);

	}

	public static void ParameterMetaDataTest() throws Exception {

		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from t_user where username=? and password=?");
		ParameterMetaData parameterMetaData = pst.getParameterMetaData();
		System.out.println(parameterMetaData.getParameterCount());
		System.out.println(parameterMetaData.getParameterTypeName(1));

		JdbcUtil.release(conn, null, null);

	}

	public static void ResultSetMetaDataTest() throws Exception {
		Connection conn = JdbcUtil.getConnection();
		String sql = "select * from t_user";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		// ResultSet.getMetaData()获得代表ResultSet对象元数据的ResultSetMetaData对象
		ResultSetMetaData metadata = rs.getMetaData();
		// getColumnCount() 返回resultset对象的列数
		System.out.println(metadata.getColumnCount());
		// getColumnName(int column) 获得指定列的名称
		System.out.println(metadata.getColumnName(1));
		// getColumnTypeName(int column)获得指定列的类型
		System.out.println(metadata.getColumnTypeName(1));
		JdbcUtil.release(conn, st, rs);
	}
	
}