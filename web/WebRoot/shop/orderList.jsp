<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="day08.Order"/>
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
			<%
				List<Order> orders=(List<Order>)request.getAttribute("orders"); 
				
				int i=1;
				for(Order order:orders){
			%>
			<tr>
				<td><%=i++ %></td>
				<td><a href="<%=request.getContextPath() %>/findByOrderId.order?orderId=<%=order.getId() %>"><%=order.getNo() %></a></td>
			</tr>
			
			<% 
				}
			%>
		</table>
<%--		<a href="<%=request.getContextPath() %>/findAll.product">返回</a>--%>
		<a href="${pageContext.request.contextPath }/findAll.product">返回</a>
	</body>
</html>
