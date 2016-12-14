<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="com" uri="http://com.user_defined_tag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<com:useBean name="date" scope="request" type="java.util.Date"></com:useBean>
<p>使用tld定义的JSP脚本变量</p>
&lt;%=date %&gt;=<%=date %>
</body>
</html>