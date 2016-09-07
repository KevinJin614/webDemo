<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>用户信息</title>
	</head>

	<body>
		<center>
			<h1>用户信息</h1>
			<hr/>
			<table>
				<tr>
					<td>用户名：</td>
					<td><input type="text" readonly="readonly" value="${user.username }"/></td>
				</tr>
				<tr>
					<td>姓&nbsp;&nbsp;名：</td>
					<td><input type="text" readonly="readonly" value="${user.name }"/></td>
				</tr>
				<tr>
					<td>电&nbsp;&nbsp;话：</td>
					<td><input type="text" readonly="readonly" value="${user.phone }"/></td>
				</tr>
				<tr>
					<td>注册时间：</td>
					<td><input type="text" readonly="readonly" value="${user.registDate }"/></td>
				</tr>
			</table>
			<a href="${pageContext.request.contextPath }/manager/findAll.action">返回</a>
		</center>
	</body>
</html>
