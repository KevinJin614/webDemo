<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page import="bean.Order"/>
<jsp:directive.page import="bean.Item"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	</head>
	
	<body>
		<h1>订单</h1>
		<hr/>
		${order.user.username }用户${order.no }订单<br/>
		---------------------------------------------<br/>
		<table border="0">
			<tr>
				<th>序号</th>
				<th>商品</th>
				<th>数量</th>
				<th>价格</th>
			</tr>
			<c:forEach items="${order.items}" var="item" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${item.product.name }</td>
				<td>${item.num }</td>
				<td>${item.price }</td>
			</tr>
			</c:forEach>
		</table>
		---------------------------------------------<br/>
	共${order.count }条&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总计：${order.price }元
		
		
	</body>
</html>
