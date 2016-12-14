<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户列表</title>
	</head>
	<body>
		<table align='center' border='1'>
			<caption>用户列表</caption>
			<tbody>
				<tr>
					<th>ID</th>
					<th>name</th>
					<th>age</th>
					<th>birthday</th>
				</tr>
				<#list users as user>
					<tr>
					<td>${user.id}</td>
					<td>${user.username}</td>
					<td>${user.age}</td>
					<td>${user.birthday?string("yyyy-MM-dd HH:mm:ss")}</td>
				</tr>
				
				</#list>
			<tbody>
		</table>
	</body>
</html>