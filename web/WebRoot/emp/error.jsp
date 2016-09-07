<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true"%>
<html>
	<head>
		<title>error</title>
	</head>

	<body>
		<h1>系统忙，稍后再试</h1>
		<%=exception%>
		<%
			pageContext.setAttribute("a","abc");
			String a="abc";
			
			pageContext.getRequest();
			pageContext.getResponse();
		%>
		
		
		<%=pageContext.getAttributesScope("a") %>
		<%=a %>
	</body>
</html>
