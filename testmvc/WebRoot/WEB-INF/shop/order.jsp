<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page import="bean.User"/>
<jsp:directive.page import="bean.Cart"/>
<jsp:directive.page import="bean.Item"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	</head>

	<body>
		<h1>确认订单</h1>
		<hr/>
		用户：${user.username }<br/>
		电话：${user.phone }<br/>
		地址：${user.address }<br/>
		<table border="1">
			<tr>
				<th>序号</th>
				<th>商品</th>
				<th>数量</th>
				<th>价格</th>
			</tr>
			<c:forEach items="${cart.items }" var="item" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${item.product.name }</td>
				<td>${item.num }</td>
				<td>${item.price }</td>
			</tr>
			</c:forEach>
		</table>
		----------------------------------------------<br/>
		${cart.price }
		<a href="${pageContext.request.contextPath }/create.do">生成订单</a>
		<a href="${pageContext.request.contextPath }/show/shop/cart">返回</a>
	</body>
</html>
