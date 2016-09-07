<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>用户登陆</title>
	</head>

	<body>
		<center>
			<h1>用户登陆</h1>
			<hr/>
			<form action="${pageContext.request.contextPath }/user/login.action" method="post">
				<table>
					<tr>
						<td>用户名：</td>
						<td><input type="text" name="username"/></td>
					</tr>
					<tr>
						<td>密&nbsp;&nbsp;码：</td>
						<td><input type="password" name="password"/></td>
					</tr>
				</table>
				<input type="submit" value="登陆"/> <a href="${pageContext.request.contextPath }/user/regist.jsp">注册</a>
			</form>
		</center>
	</body>
</html>
