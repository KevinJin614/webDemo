<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="day08.User"/>
<jsp:directive.page import="day08.Cart"/>
<jsp:directive.page import="day08.Item"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	</head>

	<body>
		<h1>确认订单</h1>
		<hr/>
		<%
			User user=(User)session.getAttribute("user");
			Cart cart=(Cart)session.getAttribute("cart");
		%>
<%--		用户：<%=user.getUsername() %><br/>--%>
<%--		电话：<%=user.getPhone() %><br/>--%>
<%--		地址：<%=user.getAddress() %><br/>--%>
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
			<% 
				List<Item> items=cart.findAll();
				int i=1;
				for(Item item:items){
			%>
			<tr>
				<td><%=i++ %></td>
				<td><%=item.getProduct().getName() %></td>
				<td><%=item.getNum() %></td>
				<td><%=item.getPrice() %></td>
			</tr>
			
			<% 
				}
			%>
		</table>
		----------------------------------------------<br/>
<%--		总计：<%=cart.getPrice() %>元<br/>--%>
		${cart.price }
<%--		<a href="<%=request.getContextPath() %>/create.order">生成订单</a>--%>
<%--		<a href="<%=request.getContextPath() %>/shop/cart.jsp">返回</a>--%>
		<a href="${pageContext.request.contextPath }/create.order">生成订单</a>
		<a href="${pageContext.request.contextPath }/shop/cart.jsp">返回</a>
	</body>
</html>
