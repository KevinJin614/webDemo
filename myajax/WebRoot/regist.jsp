<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
		
		
			function validateUsername(){
					
<%--			获得XMLHttpRequest对象	--%>
				var xmlHttpRequest=getXMLHttpRequest();
				var username=document.getElementById("username").value;
<%--			准备请求信息	--%>
				xmlHttpRequest.open("get","${pageContext.request.contextPath}/validateUsername?username="+username,true);
<%--				xmlHttpRequest.open("get","http://127.0.0.1:8081/myajax/validateUsername?username="+username,true);--%>
<%--			注册事件，当状态改变时，会自动调用注册的方法	--%>
				xmlHttpRequest.onreadystatechange=function(){
<%--				当服务器返回响应结果时处理	--%>
					if(xmlHttpRequest.readyState==4){
<%--				    响应结果的状态码是200（成功）时做处理	--%>
						if(xmlHttpRequest.status==200){
<%--					    获得响应的结果	--%>
							var result=xmlHttpRequest.responseText;
							document.getElementById("validateUsernameMessage").innerHTML=result;
						}else{
							document.getElementById("validateUsernameMessage").innerHTML="要访问的组件错误";
						}
					}else{
						document.getElementById("validateUsernameMessage").innerHTML="正在校验...";
					}
				};
<%--			发送请求	--%>
				xmlHttpRequest.send(null);
			}
			
			function validateUsername2(){
				var username=document.getElementById("username").value;
				var xmlHttpRequest=getXMLHttpRequest();
				xmlHttpRequest.open("post","${pageContext.request.contextPath}/validateUsername",true);
<%--				xmlHttpRequest.open("post","http://127.0.0.1:8081/myajax/validateUsername",true);--%>
<%--			设置一个请求头	--%>
				xmlHttpRequest.setRequestHeader("Context-Type","application/x-www-form-urlencoded");
				xmlHttpRequest.onreadystatechange=function(){
					if(xmlHttpRequest.readyState==4){
						if(xmlHttpRequest.status==200){
							var result=xmlHttpRequest.responseText;
							document.getElementById("validateUsernameMessage").innerHTML=result;
						}else{
							document.getElementById("validateUsernameMessage").innerHTML="要访问的组件错误";
						}
					}else{
						document.getElementById("validateUsernameMessage").innerHTML="正在校验...";
					}
				};
				xmlHttpRequest.send("username:"+username);
			}
			
		</script>
	</head>

	<body>
		<form action="${pageContext.request.contextPath }/regist" method="post">
			用户名：<input id="username" type="text" name="username" onblur="validateUsername2();"/><span id="validateUsernameMessage"></span><br/>
			密码：<input type="password" name="password"/><br/>
			电话：<input type="text" name="phone"/><br/>
			<input type="submit" value="注册"/>
		</form>
		${message }
		
	</body>
</html>
