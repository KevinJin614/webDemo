<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="bean.Product"/>
<jsp:directive.page import="bean.User"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>

	<body>
		<h1>商品列表</h1>

		
	<%--	test中是if的条件，EL表达式	--%>
		<c:if test="${empty user}">
		
			<a href="${pageContext.request.contextPath }/show/shop/regist">注册</a>
			<a href="${pageContext.request.contextPath }/show/shop/login">登陆</a>

		</c:if>
		<c:if test="${!empty user}">
		${user.username }用户
			<a href="${pageContext.request.contextPath }/logout.do">注销</a>
			<a href="${pageContext.request.contextPath }/findByUserId.do">我的订单</a>
		</c:if>
		当前在线人数${applicationScope.count }人
		<hr/>
		<table border="1">
			<tr>
				<th>序号</th>
				<th>商品</th>
				<th>价格</th>
				<th>操作</th>
			</tr>

			<%--	items循环的集合，使用EL表达式	 var定义了一个临时的循环变量	--%>
			<c:forEach items="${products}" var="product" varStatus="status">
				<tr>
					<td>${status.count }</td>
					<td>${product.name }</td>
					<td>${product.price }</td>
					<td><a href="${pageContext.request.contextPath }/add.do?productId=${product.id }">添加到购物车</a></td>
				</tr>
			</c:forEach>
		
		</table>
		<a href="${pageContext.request.contextPath }/show/shop/cart">查看购物车</a>
	</body>
</html>
