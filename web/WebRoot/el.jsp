<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<jsp:directive.page import="day08.User"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	</head>

	<body>
		<%
			pageContext.setAttribute("msg","PageContext Hello");
			request.setAttribute("msg","Request Hello");
			session.setAttribute("msg","Session Hello");
			
			User user=new User();
			user.setUsername("abc");
			
			request.setAttribute("user",user);
			
			List list=new ArrayList();
			
			list.add("aaa");
			list.add("bbb");
			list.add("ccc");
			request.setAttribute("list",list);
		%>
	
		<% 
			String msg=(String)request.getAttribute("msg");
			if(msg!=null){
				out.write(msg);
			}
		%>
		
		<br/>
		
		${msg }
		<br/>
		${sessionScope.msg }
		<br/>
		${pageScope.msg }
		<br/>
		${user.username }
		<br/>
		${pageContext.request }
		<br/>
		${pageContext.request.contextPath }
		<br/>
		${user["username"] }
		<br/>
		${list[1] }
		<br/>
		${1+1 }
		<br/>
		${1==1 }
		<br/>
		${1>5 }
		<br/>
		${1>5?"aaa":"bbb" }
		<br/>
		${"aaa" eq "aaa" }
		<br/>
<%--		${"aaa".equals("bbb") }--%>
		<br/>
		${param.a }
		<br/>
		----------------
		${empty user }
		
		
	</body>
</html>
