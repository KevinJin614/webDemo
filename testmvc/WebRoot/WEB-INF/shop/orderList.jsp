<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page import="bean.Order"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	</head>

	<body>
		<h1>我的订单</h1>
		<hr/>
		<table border="1">
			<tr>
				<th>序号</th>
				<th>订单号</th>
			</tr>
			<c:forEach items="${orders  }" var="order" varStatus="status">
			
			<tr>
				<td>${status.count }</td>
				<td><a href="${pageContext.request.contextPath }/findByOrderId.do?orderId=${order.id }">${order.no }</a></td>
			</tr>
			</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath }/findAll.do">返回</a>
	</body>
</html>
