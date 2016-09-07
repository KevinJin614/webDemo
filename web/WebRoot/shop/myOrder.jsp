<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="day08.Order"/>
<jsp:directive.page import="day08.Item"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	</head>
	
	<body>
		<h1>订单</h1>
		<hr/>
		<%
			Order order=(Order)request.getAttribute("order");
		%>
<%--		<%=order.getUser().getUsername() %>用户<%=order.getNo() %>订单<br/>--%>
		${order.user.username }用户${order.no }订单<br/>
		---------------------------------------------<br/>
		<table border="0">
			<tr>
				<th>序号</th>
				<th>商品</th>
				<th>数量</th>
				<th>价格</th>
			</tr>
			<% 
				Set<Item> items=order.getItems();
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
		---------------------------------------------<br/>
<%--		共<%=order.getCount() %>条&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总计：<%=order.getPrice() %>元--%>
	共${order.count }条&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总计：${order.price }元
		
		
	</body>
</html>
