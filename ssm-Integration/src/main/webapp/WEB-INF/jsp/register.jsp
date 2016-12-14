<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
	#register {
		width:400px;
		height:400px;
		margin:0 auto;
		padding:10px;
		background-color: green;
	}
	
	#register form {
		margin-top:80px
	}
	
	#register div {
		padding:10px;

		text-align:center;
		
	}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="register">
		<form action="/user/register" method="post">
			<div>用户名:<input type="text" name="username" /></div>
			<div>年&nbsp;龄:<input type="text" name="age" /></div>
			<div>密&nbsp;码:<input type="password" name="password" /></div>
			<div>生&nbsp;日:<input type="text" name="date" /></div>
			<div><input type="submit" value="提交" /></div>
		</form>
	</div>
	

</body>
</html>