<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>

	<body>
	
		<form action="<%=request.getContextPath() %>/login" method="post">
			用户名：<input type="text" name="username"/><br/>
			密&nbsp;&nbsp;码：<input type="password" name="password"/><br/>
			<input type="submit" value="登陆"/>
		</form>
		
		<%
			String message=(String)request.getAttribute("message");
			if(message!=null){
			//out.write(message);
		%>
			<%=message %>
		<%
			}
		%>
		
	</body>
</html>
