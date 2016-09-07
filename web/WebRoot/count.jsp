<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>

	<body>
		<%
			//String username=(String)session.getAttribute("user");
			//if(username==null){
			//	response.sendRedirect(request.getContextPath()+"/login.jsp");
			//	return;
			//}
		%>
<%--		<h1><%=username %>访问了<%=session.getAttribute("count") %>次</h1>--%>
		<%=session.getAttribute("count") %>
		<hr/>
		<h1><%=request.getAttribute("count") %></h1>
		
		<a href="<%=request.getContextPath() %>/count">+</a>
		<a href="<%=response.encodeURL(request.getContextPath()+"/count") %>">+</a>
	</body>
</html>
