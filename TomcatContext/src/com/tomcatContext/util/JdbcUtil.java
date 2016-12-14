package com.tomcatContext.util;

/**
 * <p>ClassName: JdbcUtil<p>
 * <p>Description: 从JNDI容器中获取DataSource，再通过DataSource获取数据库连接<p>
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.alibaba.druid.pool.DruidDataSource;

/**
 * JNDI数据源获取助手
 * @author may
 *
 */
public class JdbcUtil {
    
/*
 web.xml文件中的JNDI数据源引用配置
 
  <!--Oracle数据库JNDI数据源引用 -->
  <resource-ref>
      <description>Oracle DB Connection</description>
      <res-ref-name>jdbc/OracleDataSource</res-ref-name>
      <res-type>javax.sql.DataSource</res-type>
      <res-auth>Container</res-auth>
 </resource-ref>
  
  <!--MySQL数据库JNDI数据 -->
  <resource-ref>
      <description>MySQL DB Connection</description>
      <res-ref-name>jdbc/MysqlDataSource</res-ref-name>
      <res-type>javax.sql.DataSource</res-type>
      <res-auth>Container</res-auth>
  </resource-ref>
  
   <!--SQLServer数据库JNDI数据源引用 -->
  <resource-ref>
      <description>SQLServer DB Connection</description>
      <res-ref-name>jdbc/SqlServerDataSource</res-ref-name>
      <res-type>javax.sql.DataSource</res-type>
      <res-auth>Container</res-auth>
  </resource-ref>
*/
    
    //Oracle数据库配置的JNDI数据源连接名,后面跟的是DataSource名，DataSource名在web.xml文件中的<res-ref-name></res-ref-name>进行了配置
    private static final String ORACLE_DB_JNDINAME = "java:comp/env/jdbc/OracleDataSource";
    //MySQL数据库配置的JNDI数据源连接名，java:comp/env是必须加的,后面跟的是DataSource名
    private static final String MYSQL_DB_JNDINAME = "java:comp/env/jdbc/MysqlDataSource";
    //SQLServer数据库配置的JNDI数据源连接名，java:comp/env是必须加的,后面跟的是DataSource名
    private static final String SQLSERVER_DB_JNDINAME = "java:comp/env/jdbc/SqlServerDataSource";
    
    private static DruidDataSource dsOracle = null;
    private static DruidDataSource dsMySql = null;
    private static DruidDataSource dsSqlServer = null;
    
    static{
        try {
            //1、初始化名称查找上下文
            Context ctx = new InitialContext();
            //2、通过JNDI名称找到DataSource
            dsOracle = (DruidDataSource) ctx.lookup(ORACLE_DB_JNDINAME);
            dsMySql = (DruidDataSource) ctx.lookup(MYSQL_DB_JNDINAME);
            dsSqlServer = (DruidDataSource) ctx.lookup(SQLSERVER_DB_JNDINAME);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    /**
     * MethodName: getOracleConnection
     * Description: 获取Oracle数据库连接
     * @author may        
     * @return
     * @throws SQLException
     */
    public static Connection getOracleConnection() throws SQLException {
        return dsOracle.getConnection();
    }
    
    /**
     * MethodName: getMySqlConnection
     * Description: 获取MySQL数据库连接
     * @author may        
     * @return
     * @throws SQLException
     */
    public static Connection getMySqlConnection() throws SQLException {
        return dsMySql.getConnection();
    }
    
    /**
     * 获取SQL server的链接
     * @return
     * @throws SQLException
     */
    public static Connection getSqlServerConnection() throws SQLException {
        return dsSqlServer.getConnection();
    }

   /**
    * 释放资源
    * @param conn
    * @param st
    * @param rs
    */
    public static void release(Connection conn,Statement st,ResultSet rs){
        if(rs!=null){
            try{
                //关闭存储查询结果的ResultSet对象
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(st!=null){
            try{
                //关闭负责执行SQL命令的Statement对象
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        if(conn!=null){
            try{
                //关闭Connection数据库连接对象
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}