<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--引入JSTL标签库 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>JNDI测试</title>
  </head>
  
  <body>
        <h3>从Oracle数据库中取出来的数据</h3>
        <%--使用c:forEach标签遍历List集合--%>
        <c:forEach var="oracleDataMap" items="${oracleDataList}">
            ${oracleDataMap.resourceid}---${oracleDataMap.dbsource_name}---${oracleDataMap.dbsource_type}<br/>
        </c:forEach>
        <hr/>
        <h3>从mySql数据库中取出来的数据</h3>
        <%--使用c:forEach标签遍历List集合--%>
        <c:forEach var="mySqlDataMap" items="${mySqlDataList}">
            ${mySqlDataMap.resourceid}---${mySqlDataMap.app_name}<br/>
        </c:forEach>
        <hr/>
        <h3>从sqlServer数据库中取出来的数据</h3>
        <%--使用c:forEach标签遍历List集合--%>
        <c:forEach var="sqlServerDataMap" items="${sqlServerDataList}">
            ${sqlServerDataMap.id}---${sqlServerDataMap.name}<br/>
        </c:forEach>
  </body>
</html>