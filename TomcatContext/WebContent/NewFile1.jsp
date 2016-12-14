<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--引入JSTL标签库 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>JNDI数据源连接测试</title>
  </head>
  
  <body>
          <%-- <h3>Oracle JNDI数据源测试</h3>
          使用sql:query标签发送SQL语句去数据库查询数据，查询的结果集保存到rs变量当中，dataSource属性指明使用的数据源
        <sql:query var="rs" dataSource="oracleDataSource">
            Oracle JNDI数据源测试 SQL
            SELECT * FROM LEAD_OAMS_DBSOURCES
        </sql:query>
        使用c:forEach标签遍历查询结果集rs中的每一行
        <c:forEach var="row" items="${rs.rows}">
            ${row.字段名}获取字段的值
            ${row.RESOURCEID}---${row.DBSOURCE_NAME}---${row.DBSOURCE_TYPE}<br/>
        </c:forEach>
        <hr/> --%>
        <h3>MySQL JNDI数据源测试</h3>
        <%--使用sql:query标签发送SQL语句去数据库查询数据，查询的结果集保存到rs变量当中，dataSource属性指明使用的数据源--%>
        <sql:query var="rs" dataSource="jdbc/MysqlDataSource">
            <%--MySQL JNDI数据源测试 SQL--%>
             select * from t_user
        </sql:query>
        <%--使用c:forEach标签遍历查询结果集rs中的每一行--%>
        <c:forEach var="row" items="${rs.rows}">
            <%--${row.字段名}获取字段的值--%>
            ${row.id}---${row.username}---${row.age}<br/>
        </c:forEach>
        <hr/>
        <%-- <h3>SQLServer JNDI数据源测试</h3>
        使用sql:query标签发送SQL语句去数据库查询数据，查询的结果集保存到rs变量当中，dataSource属性指明使用的数据源
        <sql:query var="rs" dataSource="sqlserverDataSource">
            SQLServer JNDI数据源测试 SQL
            select * from t_demo
        </sql:query>
        使用c:forEach标签遍历查询结果集rs中的每一行
        <c:forEach var="row" items="${rs.rows}">
            ${row.字段名}获取字段的值
            ${row.id}---${row.time}<br/>
        </c:forEach> --%>
  </body>
</html>