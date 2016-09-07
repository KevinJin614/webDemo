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
			<form action="modify.jsp" method="post">
				<table>
					<tr>
						<td>用户名：</td>
						<td><input type="text" name="username" readonly="readonly" value="abc"/></td>
					</tr>
					<tr>
						<td>注册时间：</td>
						<td><input type="text" readonly="readonly" value="2014-09-23"/></td>
					</tr>
					<tr>
						<td>姓&nbsp;&nbsp;名：</td>
						<td><input type="text" name="name" value="abc"/></td>
					</tr>
					<tr>
						<td>电&nbsp;&nbsp;话：</td>
						<td><input type="text" name="phone" value="12345678"/></td>
					</tr>
				</table>
				<input type="submit" value="修改"/> <a href="login.jsp">注销</a>
			</form>
		</center>
	</body>
</html>
