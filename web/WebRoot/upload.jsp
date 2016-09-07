<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript">
			function add(){
				var f=document.getElementById("f");
				var a=document.getElementById("a");
				
				var textObj=document.createTextNode("文件：");
				
				f.insertBefore(textObj,a);
				
				var inputObj=document.createElement("input");
				inputObj.type="file";
				inputObj.name="file";
				
				f.insertBefore(inputObj,a);
				
				var brObj=document.createElement("br");
				
				f.insertBefore(brObj,a);
			}
		</script>
	</head>

	<body>
		<form id="f" action="<%=request.getContextPath() %>/upload" method="post" enctype="multipart/form-data">
<%--		<form id="f" action="http://127.0.0.1:8088/web/upload" method="post" enctype="multipart/form-data">--%>
			名字：<input type="text" name="name"/><br/>
			文件：<input type="file" name="file"/><br/>
			<input id="a" type="button" value="add" onclick="add();"/>
			<input type="submit" value="提交"/>
		</form>
		<% 
			String message=(String)request.getAttribute("message");
			if(message!=null){
				out.write(message);
			}
		%>
	</body>
</html>
