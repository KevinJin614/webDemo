<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page import="bean.Cart"/>
<jsp:directive.page import="bean.Item"/>
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
				<form id="f" action="${pageContext.request.contextPath }/removeByIds.do" method="post">
				<c:forEach items="${cart.items }" var="item" varStatus="status">
				<tr>
					<td><input type="checkbox"  name="c" value="${item.product.id }"/></td>
					<td>${status.count }</td>
					<td>${item.product.name }</td>
					<td>${item.num }</td>
					<td>${item.price }</td>
					<td><a href="${pageContext.request.contextPath }/removeById.do?productId=${item.product.id }">删除</a></td>
				</tr>
				</c:forEach>
			</form>
		</table>
		----------------------------------------------<br/>
		总计：${cart.price }元<br/>
		<a href="javascript:;" onclick="submit();">删除选中</a>
		<a href="${pageContext.request.contextPath }/clear.do">清空购物车</a>
		<a href="${pageContext.request.contextPath }/findAll.do">继续购买</a>
		<a href="${pageContext.request.contextPath }/show/shop/order">结算</a>
	</body>
</html>
