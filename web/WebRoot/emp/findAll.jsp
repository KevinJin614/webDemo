<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="day04.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>find all</title>
	</head>

	<body>
		<%
			List<Emp> emps=(List<Emp>)request.getAttribute("emps");
			
		%>
		<div>
<%--			<%@include file="/emp/tools.jsp" %>--%>
			<jsp:include page="/emp/tools.jsp"></jsp:include>
		</div>
		
		<h1>员工列表</h1>
		<hr/>
		<table border="1">
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>工资</th>
				<th>操作</th>
			</tr>
			<%for(Emp emp:emps){ %>
				<tr>
					<td><%=emp.getId() %></td>				
					<td><a href="<%=request.getContextPath() %>/modify.emp?id=<%=emp.getId() %>"><%=emp.getName() %></a></td>	
					<td><%=emp.getSalary() %></td>	
					<td><a href="<%=request.getContextPath() %>/remove?id=<%=emp.getId() %>" onclick="return confirm('确认是否删除？')">删除</a></td>
				</tr>
			<%} %>
		</table>
		
		
		
	</body>
</html>
