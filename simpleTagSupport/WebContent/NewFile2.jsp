<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="com" uri="http://com.BodyTagSupport" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>
<com:JspFragment>
	<jsp:attribute name="jspFragment1">
		<jsp:getProperty name="date" property="year" ></jsp:getProperty>年<br />
	</jsp:attribute>
	<jsp:attribute name="jspFragment2">
		<jsp:getProperty name="date" property="month" ></jsp:getProperty>月<br />
	</jsp:attribute>
	
	<jsp:body>
		<jsp:getProperty name="date" property="day"></jsp:getProperty>日<br />
	</jsp:body>
	
</com:JspFragment>
</body>
</html>