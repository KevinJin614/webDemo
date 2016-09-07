<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="day08.Product"/>
<jsp:directive.page import="day08.User"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>

	<body>
		<h1>商品列表</h1>
		<% 
			//User user=(User)session.getAttribute("user");
			
			//Integer count=(Integer)application.getAttribute("count");
			
			//if(user==null){
		%>
		
	<%--	test中是if的条件，EL表达式	--%>
		<c:if test="${empty user}">
		
<%--		<a href="<%=request.getContextPath() %>/shop/regist.jsp">注册</a>--%>
<%--		<a href="<%=request.getContextPath() %>/shop/login.jsp">登陆</a>--%>
			<a href="${pageContext.request.contextPath }/shop/regist.jsp">注册</a>
			<a href="${pageContext.request.contextPath }/shop/login.jsp">登陆</a>
		
		<%
			//}else{ 
		%>
		</c:if>
		<c:if test="${!empty user}">
<%--		<%=user.getUsername() %>用户--%>
		${user.username }用户
			<a href="${pageContext.request.contextPath }/logout.user">注销</a>
			<a href="${pageContext.request.contextPath }/findByUserId.order">我的订单</a>
		</c:if>
		<%
			//}
		%>
<%--		当前在线人数<%=count %>人--%>
		当前在线人数${applicationScope.count }人
		<hr/>
		<table border="1">
			<tr>
				<th>序号</th>
				<th>商品</th>
				<th>价格</th>
				<th>操作</th>
			</tr>
<%--			<%--%>
<%--				List<Product> products=(List<Product>)request.getAttribute("products");--%>
<%--				int i=1;--%>
<%--				for(Product product:products){--%>
<%--				--%>
<%--			%>--%>
<%--				--%>
<%--			<tr>--%>
<%--				<td><%=i++ %></td>--%>
<%--				<td><%=product.getName() %></td>--%>
<%--				<td><%=product.getPrice() %></td>--%>
<%--				<td><a href="<%=request.getContextPath() %>/add.cart?productId=<%=product.getId() %>">添加到购物车</a></td>--%>
<%--			</tr>--%>
<%--				--%>
<%--			<%--%>
<%--				}--%>
<%--			%>--%>

			<%--	items循环的集合，使用EL表达式	 var定义了一个临时的循环变量	--%>
			<c:forEach items="${products}" var="product" varStatus="status">
				<tr>
<%--					<td>${status.index }</td>--%>
					<td>${status.count }</td>
					<td>${product.name }</td>
					<td>${product.price }</td>
					<td><a href="${pageContext.request.contextPath }/add.cart?productId=${product.id }">添加到购物车</a></td>
				</tr>
			</c:forEach>
		
		</table>
<%--		<a href="<%=request.getContextPath() %>/shop/cart.jsp">查看购物车</a>--%>
		<a href="${pageContext.request.contextPath }/shop/cart.jsp">查看购物车</a>
	</body>
</html>
