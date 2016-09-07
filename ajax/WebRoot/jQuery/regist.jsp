<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.1.min.js"></script>
		<script type="text/javascript">
			$(function(){
<%--				$("#username").blur(function(){--%>
<%--					$.get("${pageContext.request.contextPath}/validateUsername",--%>
<%--						  {username:$("#username").val()},--%>
<%--						  function(message){--%>
<%--						  	$("#validateUsernameMessage").text(message);--%>
<%--						  });--%>
<%--				});--%>
				
<%--				$("#username").blur(function(){--%>
<%--					$.post("${pageContext.request.contextPath}/validateUsername",--%>
<%--						  {username:$("#username").val()},--%>
<%--						  function(message){--%>
<%--						  	$("#validateUsernameMessage").text(message);--%>
<%--						  });--%>
<%--				});	--%>

				$("#username").blur(function(){
					$.get("${pageContext.request.contextPath}/validateUsername?username="+$("#username").val(),
						  function(message){
						  	$("#validateUsernameMessage").text(message);
						  });
				});
				
				$("#validateUsernameMessage").ajaxStart(function(){
					$(this).html("<font color='red'>正在处理...</font>");
				});
			});
		</script>
	</head>

	<body>
		<form action="${pageContext.request.contextPath }/regist" method="post">
			用户名：<input id="username" type="text" name="username"/><span id="validateUsernameMessage"></span><br/>
			密码：<input type="password" name="password"/><br/>
			电话：<input type="text" name="phone"/><br/>
			<input type="submit" value="注册"/>
		</form>
		${message }
		
	</body>
</html>
