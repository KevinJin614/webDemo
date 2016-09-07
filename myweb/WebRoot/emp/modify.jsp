<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="day04.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>modify</title>
	</head>

	<body>
		<%!
		private String getChecked(String value,String[] hobbies){
			for(String hobby:hobbies){
				if(value.equals(hobby)){
					return "checked";
				}
			}
			return "";
		}
		%>
		<%
			Emp emp = (Emp)request.getAttribute("emp");
		%>
	
		<h1>修改员工</h1>
		<hr/>
		<form action="<%=request.getContextPath() %>/modify.emp" method="post">
			<input type="hidden" name="id" value="<%=emp.getId() %>"/>
			姓名：<input type="text" name="name" value="<%=emp.getName() %>"/><br/>
			工资：<input type="text" name="salary" value="<%=emp.getSalary() %>"/><br/>
			性别：<input type="radio" name="sex" value="1" <%="1".equals(emp.getSex())?"checked":"" %>/>男
			<input type="radio" name="sex" value="0" <%="0".equals(emp.getSex())?"checked":"" %>/>女<br/>
			学历：<select name="edu">
					<option value="1" <%="1".equals(emp.getEdu())?"selected":"" %> >高中</option>
					<option value="2" <%="2".equals(emp.getEdu())?"selected":"" %>>专科</option>
					<option value="3" <%="3".equals(emp.getEdu())?"selected":"" %>>本科</option>
					<option value="4" <%="4".equals(emp.getEdu())?"selected":"" %>>研究生</option>
				 </select><br/>
			兴趣爱好：<input type="checkbox" name="hobbies" value="1" <%=getChecked("1",emp.getHobbies()) %>/>吃
			<input type="checkbox" name="hobbies" value="2" <%=getChecked("2",emp.getHobbies()) %>/>玩
			<input type="checkbox" name="hobbies" value="3" <%=getChecked("3",emp.getHobbies()) %>/>睡<br/>
			<input type="submit" value="修改"/>
		</form>
	</body>
</html>
