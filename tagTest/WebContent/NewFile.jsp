<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 第一种 -->
<%-- <%@ taglib prefix="test"  tagdir="/WEB-INF/tags" %> --%>
<!-- 第二种方式 -->
<%@ taglib prefix="test"  uri="http://com.TagSupport" %>
<%
	request.setAttribute("test", "youth");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tag test</title>
</head>
<body>
	<test:test a="test">
		和哈斯地方哈是个扫地方
	</test:test>
	<%=test %>
</body>
</html>