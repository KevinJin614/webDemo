<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript">
			function getXMLHttpRequest(){
				var xmlHttpRequest=null;
				if((typeof XMLHttpRequest)!='undefined'){
					xmlHttpRequest=new XMLHttpRequest();
				}else{
					xmlHttpRequest=new ActiveXObject('Microsoft.XMLHttp');
				}
				return xmlHttpRequest;
			}
			function show(id){
				var xmlHttpRequest=getXMLHttpRequest();
				xmlHttpRequest.open("get","${pageContext.request.contextPath}/show?id="+id,true);
				xmlHttpRequest.onreadystatechange=function(){
					if(xmlHttpRequest.readyState==4){
						var result=xmlHttpRequest.responseText;
						var user=eval("("+result+")");
						document.getElementById("id").innerHTML=user.id;
						document.getElementById("username").innerHTML=user.username;
						document.getElementById("password").innerHTML=user.password;
						document.getElementById("name").innerHTML=user.name;
						document.getElementById("phone").innerHTML=user.phone;
					}
				}
				xmlHttpRequest.send(null);
			}
		</script>
	</head>

	<body>
		
		<c:forEach items="${users}" var="user">
			<li onmouseover="show(${user.id });">${user.username }</li>
		</c:forEach>
		
		
		<hr/>
		编号：<div style="display: inline;" id="id"></div><br/>
		用户名：<div style="display: inline;" id="username"></div><br/>
		密码：<div style="display: inline;" id="password"></div><br/>
		姓名：<div style="display: inline;" id="name"></div><br/>
		电话：<div style="display: inline;" id="phone"></div><br/>
	</body>
</html>
