<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user list</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<style type="text/css">
	#main{
		width:400px;
		margin:0 auto;
	}
	

</style>

</head>
<body>
	
	<div id="main">
		<table class="table table-bordered table-hover table-condensed">
			<caption style="text-align:center; font-size:18px;">user list</caption>
			<tr>
				<th>姓名</th>
				<th>年龄</th>
				<th>生日</th>
			</tr>
			
			<c:forEach items="${users }" var="t_user">
				<tr>
					<td>${t_user.username }</td>
					<td>${t_user.age }</td>
					<td><fmt:formatDate value="${t_user.date }" pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
			
		
		</table>
	
	</div>

</body>
</html>