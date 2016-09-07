<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.1.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#d1").load("${pageContext.request.contextPath}/jQuery/regist.jsp");
				
				$("#d2").load("${pageContext.request.contextPath}/list");
			});
		</script>
  </head>
  
  <body>
  	<div id="d1"></div>
  	
  	<div id="d2" style="position: absolute;top: 300px"></div>
  </body>
</html>
