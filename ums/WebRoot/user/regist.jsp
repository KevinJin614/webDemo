<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>用户注册</title>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.1.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#username").blur(function(){
					$.get("${pageContext.request.contextPath }/checkName",
						  {username:$("#username").val()},
						  function(message){
							  $("#span").text(message);
						  });
				});
			});
		</script>
	</head>

	<body>
		<center>
			<h1>用户注册</h1>
			<hr/>
			<form action="${pageContext.request.contextPath }/user/regist.action" method="post">
				<table>
					<tr>
						<td>用户名：</td>
						<td>
							<input type="text" name="username" id="username"/><span id="span"></span>
						</td>
					</tr>
					<tr>
						<td>密&nbsp;&nbsp;码：</td>
						<td><input type="password" name="password"/></td>
					</tr>
					<tr>
						<td>姓&nbsp;&nbsp;名：</td>
						<td><input type="text" name="name"/></td>
					</tr>
					<tr>
						<td>电&nbsp;&nbsp;话：</td>
						<td><input type="text" name="phone"/></td>
					</tr>
				</table>
				<input type="submit" value="注册"/> <a href="${pageContext.request.contextPath }/user/login.jsp">返回</a>
			</form>
		
		</center>
	</body>
</html>
