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
		
		
		<h1>员工列表</h1>
		<hr/>
		<table border="1">
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>工资</th>
				<th>性别</th>
				<th>学历</th>
				<th>爱好</th>
				<th>操作</th>
			</tr>
			<% 
			String[] sex={"女","男"};
			String[] edu={"","高中","专科","本科","研究生"};
			String[] hobbies={"","吃","玩","睡"};
			
			%>
			<%for(Emp emp:emps){%>
				<tr>
					<td><%=emp.getId() %></td>				
					<td><a href="<%=request.getContextPath() %>/showModify.emp?id=<%=emp.getId() %>"><%=emp.getName() %></a></td>	
					<td><%=emp.getSalary() %></td>
					<td><%=sex[Integer.parseInt(emp.getSex())] %></td>
					<td><%=edu[Integer.parseInt(emp.getEdu())] %></td>
					<td><%
						String hobby = "";
						for(int i = 0;i<emp.getHobbies().length;i++){
							hobby+=hobbies[Integer.parseInt(emp.getHobbies()[i])]+",";
						}
						hobby=hobby.substring(0,hobby.length()-1);
						out.write(hobby);
						%></td>	
					<td><a href="<%=request.getContextPath() %>/remove.emp?id=<%=emp.getId() %>" onclick="return confirm('确认是否删除？')">删除</a></td>
				</tr>
			<%} %>
		</table>
		
		
		
	</body>
</html>
