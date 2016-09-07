<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<c:forEach items="${users}" var="user" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td><a href="${pageContext.request.contextPath}/manager/findById.action?id=${user.id}">${user.username}</a></td>
						<td><a href="${pageContext.request.contextPath}/manager/removeById.action?id=${user.id}" onclick="return confirm('确认是否删除？')">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<a href="${pageContext.request.contextPath }/manager/private/logout.action">注销</a>
		</center>
	</body>
</html>
