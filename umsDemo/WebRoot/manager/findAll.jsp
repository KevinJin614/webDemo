<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>用户列表</title>
	</head>

	<body>
		<center>
			<h1>用户列表</h1>
			<hr/>
			<table border="1">
				<tr>
					<th>序号</th>
					<th>用户名</th>
					<th>操作</th>
				</tr>
				<tr>
					<td>1</td>
					<td><a href="find.jsp">aaa</a></td>
					<td><a href="#" onclick="return confirm('确认是否删除？')">删除</a></td>
				</tr>
			</table>
			<a href="login.jsp">注销</a>
		</center>
	</body>
</html>
