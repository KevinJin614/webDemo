<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.1.min.js"></script>
		<script type="text/javascript">
			$(function(){
<%--				$("#a").data("a",1);--%>
<%--				$("#a").data("b",2);--%>
<%--				$("#d").data("a",3);--%>
<%--				alert($("#a").data("b"));--%>
<%--				--%>
<%--				alert($("#d").data("a"));--%>
				
				$("#d").data("count",0);
				
				$("#d").click(function(){
					$("#d").data("count",$("#d").data("count")+1);
					
					alert($("#d").data("count"));
				});
				
				
			});
		</script>
	</head>

	<body>
		<a id="a" href="#"></a>
		
		<div id="d">
			aaa
		</div>
		
		<input type="text" id="t"/>
	</body>
</html>
