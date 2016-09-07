<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="day04.*" %>
<%@ taglib uri="http://itany.com/functions" prefix="fun" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>modify</title>
	</head>

	<body>
	
		<div>
<%--			<%@include file="/emp/tools.jsp" %>--%>
			<jsp:include page="/emp/tools.jsp"></jsp:include>
		</div>
		<h1>修改员工</h1>
		<hr/>
		<form action="${pageContext.request.contextPath }/modify" method="post">
			<input type="hidden" name="id" value="${emp.id }"/>
			姓名：<input type="text" name="name" value="${emp.name }"/><br/>
			工资：<input type="text" name="salary" value="${emp.salary }"/><br/>
			性别：<input type="radio" name="sex" value="1" ${"1" eq emp.sex?"checked":"" }/>男
			<input type="radio" name="sex" value="0" ${"0" eq emp.sex?"checked":"" }/>女<br/>
			学历：<select name="edu">
					<option value="1" ${"1" eq emp.edu?"selected":"" }>高中</option>
					<option value="2" ${"2" eq emp.edu?"selected":"" }>专科</option>
					<option value="3" ${"3" eq emp.edu?"selected":"" }>本科</option>
					<option value="4" ${"4" eq emp.edu?"selected":"" }>研究生</option>
				 </select><br/>
			兴趣爱好：<input type="checkbox" name="hobbies" value="1" ${fun:getChecked("1",emp.hobbies) }/>吃
			<input type="checkbox" name="hobbies" value="2" ${fun:getChecked("2",emp.hobbies) }/>玩
			<input type="checkbox" name="hobbies" value="3" ${fun:getChecked("3",emp.hobbies) }/>睡<br/>
			<input type="submit" value="修改"/>
		</form>
	</body>
</html>
