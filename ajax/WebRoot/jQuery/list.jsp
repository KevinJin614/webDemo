<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.1.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$("li").mouseover(function(){
					$.getJSON("${pageContext.request.contextPath}/show",
							  {id:$(this).attr("id")},
							  function(user){
							  	$("#id").text(user.id);
							  	$("#username").text(user.username);
							  	$("#password").text(user.password);
							  	$("#name").text(user.name);
							  	$("#phone").text(user.phone);
							  });
				});
			});
		</script>
	</head>

	<body>
		
		<c:forEach items="${users}" var="user">
			<li id="${user.id }">${user.username }</li>
		</c:forEach>
		
		
		<hr/>
		编号：<div style="display: inline;" id="id"></div><br/>
		用户名：<div style="display: inline;" id="username"></div><br/>
		密码：<div style="display: inline;" id="password"></div><br/>
		姓名：<div style="display: inline;" id="name"></div><br/>
		电话：<div style="display: inline;" id="phone"></div><br/>
	</body>
</html>
