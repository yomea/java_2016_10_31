package com.tomcatContext.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tomcatContext.util.JdbcUtil;

/**
 * 
 * @author may
 *
 */
public class JNDITestServlet extends HttpServlet {

	private static final long serialVersionUID = -4221534764133676917L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Oracle数据库连接
        Connection oracleConnection = null;
        //MySql数据库连接
        Connection mySqlConnection = null;
        //SQLServer数据库连接
        Connection sqlServerConnection = null;
        
        //负责执行SQL的PreparedStatement对象
        PreparedStatement pstmtOracle = null;
        PreparedStatement pstmtMySQL = null;
        PreparedStatement pstmtSqlServer = null;
        
        //查询出来的结果集
        ResultSet rsOracle = null;
        ResultSet rsMySQL = null;
        ResultSet rsSqlServer = null;
        
        //存储查询出来的数据，每一行数据映射成一个Map，字段名作为key，字段的值作为value
        List<Map<String, String>> oracleDataList = new ArrayList<Map<String, String>>();
        List<Map<String, String>> mySqlDataList = new ArrayList<Map<String, String>>();
        List<Map<String, String>> sqlServerDataList = new ArrayList<Map<String, String>>();
        
        try {
            
            //获取Oracle数据库连接
             oracleConnection = JdbcUtil.getOracleConnection();
            //获取MySql数据库连接
             mySqlConnection = JdbcUtil.getMySqlConnection();
            //获取SQLServer数据库连接
             sqlServerConnection =JdbcUtil.getSqlServerConnection();
            
             String oracleDb_Sql = "SELECT * FROM LEAD_OAMS_DBSOURCES";
             String mySqlDb_Sql = "SELECT * FROM LEAD_OAMS_APPLICATIONS";
             String sqlServerDb_Sql = "SELECT * FROM T_DEMO";
                
             pstmtOracle = oracleConnection.prepareStatement(oracleDb_Sql);
             pstmtMySQL = mySqlConnection.prepareStatement(mySqlDb_Sql);
             pstmtSqlServer = sqlServerConnection.prepareStatement(sqlServerDb_Sql);
            
             //执行查询，查询结果存储到ResultSet结果集中
             rsOracle = pstmtOracle.executeQuery();
             rsMySQL = pstmtMySQL.executeQuery();
             rsSqlServer = pstmtSqlServer.executeQuery();
            
            //循环结果集中的数据 
            while(rsOracle.next()){
                Map<String, String> oracleDataMap = new LinkedHashMap<String, String>();
                //取出结果集中的数据，每一行数据映射成一个map集合
                oracleDataMap.put("resourceid", rsOracle.getString("RESOURCEID"));
                oracleDataMap.put("dbsource_name", rsOracle.getString("DBSOURCE_NAME"));
                oracleDataMap.put("dbsource_type", rsOracle.getString("DBSOURCE_TYPE"));
                //将代表每一行数据的Map集合添加到List集合中
                oracleDataList.add(oracleDataMap);
            }
            
            while(rsMySQL.next()){
                Map<String, String> mySqlDataMap = new LinkedHashMap<String, String>();
                mySqlDataMap.put("resourceid", rsMySQL.getString("resourceid"));
                mySqlDataMap.put("app_name", rsMySQL.getString("app_name"));
                mySqlDataList.add(mySqlDataMap);
            }
            
            while(rsSqlServer.next()){
                Map<String, String> sqlServerDataMap = new LinkedHashMap<String, String>();
                sqlServerDataMap.put("id", rsSqlServer.getString("id"));
                sqlServerDataMap.put("name", rsSqlServer.getString("name"));
                sqlServerDataList.add(sqlServerDataMap);
            }
            
            //将数据集合存储到request对象发送到页面进行显示
            request.setAttribute("oracleDataList", oracleDataList);
            request.setAttribute("mySqlDataList", mySqlDataList);
            request.setAttribute("sqlServerDataList", sqlServerDataList);
            //跳转到JNDITest.jsp页面显示数据
            request.getRequestDispatcher("/JNDITest.jsp").forward(request, response);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //释放资源
            JdbcUtil.release(oracleConnection, pstmtOracle, rsOracle);
            JdbcUtil.release(mySqlConnection, pstmtMySQL, rsMySQL);
            JdbcUtil.release(sqlServerConnection, pstmtSqlServer, rsSqlServer);
        }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}