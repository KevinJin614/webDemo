<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>add</title>
	</head>

	<body>
		<h1>添加员工</h1>
		<hr/>
		<form action="<%=request.getContextPath() %>/add.emp" method="post">
			姓名:<input type="text" name="name"/><br/>
			工资:<input type="text" name="salary"/><br/>
			性别：<input type="radio" name="sex" value="1"/>男
			<input type="radio" name="sex" value="0"/>女<br/>
			学历：<select name="edu">
					<option value="1">高中</option>
					<option value="2">专科</option>
					<option value="3">本科</option>
					<option value="4">研究生</option>
				 </select><br/>
			兴趣爱好：<input type="checkbox" name="hobbies" value="1"/>吃
			<input type="checkbox" name="hobbies" value="2"/>玩
			<input type="checkbox" name="hobbies" value="3"/>睡<br/>
			<input type="submit" value="添加"/>
		</form>
	</body>
</html>
