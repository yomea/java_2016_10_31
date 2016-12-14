<%@page import="org.apache.taglibs.standard.tag.common.sql.DataSourceWrapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 使用JDNI方式创建数据源 -->
<sql:setDataSource dataSource="mysqlDataSource" var="JDNIdateSource" scope="page"/>

<sql:query var="name" dataSource="${JDNIdateSource}" sql="select username from t_user">
	<c:out value="${name }"></c:out>
</sql:query>
<!-- 使用普通方式创建数据源 -->
<%-- <sql:setDataSource driver="" user="" password="" var="" scope="" url="" /> --%>
</body>
</html>