<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>用户修改</title>
	</head>

	<body>
		<center>
			<h1>用户修改</h1>
			<hr/>
			<form action="${pageContext.request.contextPath }/user//modify.action" method="post">
				<table>
					<tr>
						<td>用户名：</td>
						<td><input type="text" name="username" readonly="readonly" value="${user.username }"/></td>
					</tr>
					<tr>
						<td>注册时间：</td>
						<td><input type="text" readonly="readonly" value="${user.registDate }"/></td>
					</tr>
					<tr>
						<td>姓&nbsp;&nbsp;名：</td>
						<td><input type="text" name="name" value="${user.name }"/></td>
					</tr>
					<tr>
						<td>电&nbsp;&nbsp;话：</td>
						<td><input type="text" name="phone" value="${user.phone }"/></td>
					</tr>
				</table>
				<input type="submit" value="修改"/> <a href="${pageContext.request.contextPath }/user/logout.action">注销</a>
			</form>
		</center>
	</body>
</html>
