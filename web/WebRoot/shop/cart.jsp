<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="day08.Cart"/>
<jsp:directive.page import="day08.Item"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript">
			function selectAll(){
				var c=document.getElementsByName("c");
				var all=document.getElementById("all");
				if(all.checked==true){
					for(var i=0;i<c.length;i++){
						c[i].checked="checked";
					}
				}else{
					for(var i=0;i<c.length;i++){
						c[i].checked="";
					}
				}
			}
			
			function submit(){
				document.getElementById("f").submit();
			}
		</script>
	</head>

	<body>
		<h1>我的购物车</h1>
		<hr/>
		<table border="1">
			<tr>
				<th><input type="checkbox" id="all" onclick="selectAll();"/>全选</th>
				<th>序号</th>
				<th>商品</th>
				<th>数量</th>
				<th>价格</th>
				<th>操作</th>
			</tr>
<%--			<form id="f" action="<%=request.getContextPath() %>/removeByIds.cart" method="post">--%>
				<form id="f" action="${pageContext.request.contextPath }/removeByIds.cart" method="post">
				<%
					Cart cart=(Cart)session.getAttribute("cart");
					List<Item> items=cart.findAll();
					int i=1;
					for(Item item:items){
				%>
				
				<tr>
					<td><input type="checkbox"  name="c" value="<%=item.getProduct().getId() %>"/></td>
					<td><%=i++ %></td>
					<td><%=item.getProduct().getName() %></td>
					<td><%=item.getNum() %></td>
					<td><%=item.getPrice() %></td>
					<td><a href="<%=request.getContextPath() %>/removeById.cart?productId=<%=item.getProduct().getId() %>">删除</a></td>
				</tr>
				
				<%
					}
				%>
			</form>
		</table>
		----------------------------------------------<br/>
<%--		总计：<%=cart.getPrice() %>元<br/>--%>
		总计：${cart.price }元<br/>
		<a href="javascript:;" onclick="submit();">删除选中</a>
<%--		<a href="<%=request.getContextPath() %>/clear.cart">清空购物车</a>--%>
<%--		<a href="<%=request.getContextPath() %>/findAll.product">继续购买</a>--%>
<%--		<a href="<%=request.getContextPath() %>/shop/order.jsp">结算</a>--%>
		<a href="${pageContext.request.contextPath }/clear.cart">清空购物车</a>
		<a href="${pageContext.request.contextPath }/findAll.product">继续购买</a>
		<a href="${pageContext.request.contextPath }/shop/order.jsp">结算</a>
	</body>
</html>
