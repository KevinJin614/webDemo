<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>

	<body>
<%--		<h1>订单生成成功，订单号：<%=session.getAttribute("orderNo") %></h1>--%>
<%--		--%>
<%--		--%>
<%--		<%--%>
<%--			session.removeAttribute("orderNo");--%>
<%--		 %>--%>
<%--		<h1>订单生成成功，订单号：<%=request.getParameter("orderNo") %></h1>--%>
			<h1>订单生成成功，订单号：${param.orderNo }</h1>
		
	</body>
</html>
