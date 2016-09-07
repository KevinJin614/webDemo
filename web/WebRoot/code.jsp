<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.1.min.js"></script>
		<script type="text/javascript">
			function changeImage(){
				document.getElementById("image").src="<%=request.getContextPath() %>/show.code?a="+new Date().getTime();
				return false;
			}
			function getXMLHttpRequest(){
				var xmlHttpRequest = null;
				if((typeof XMLHttpRequest) != 'undefined'){
					xmlHttpRequest = new XMLHttpRequest();
				}else {
					xmlHttpRequest = new ActionXObject('Microsoft.XMLHttp');
				}
				return xmlHttpRequest;
			}
			function validateCode(){
				var xmlHttpRequest = getXMLHttpRequest();
				var code = document.getElementById("code").value;
				xmlHttpRequest.open("get","${pageContext.request.contextPath }/validate.code?code="+code,true);
				xmlHttpRequest.onreadystatechange = function(){
					if(xmlHttpRequest.readyState == 4){
						if(xmlHttpRequest.status == 200){
							var result = xmlHttpRequest.responseText;
							document.getElementById("span").innerHTML=result;
						}
					}
				};
				xmlHttpRequest.send(null);
			}
			$(function(){
				$("#code").blur(function(){
				$.get("${pageContext.request.contextPath}/validate.code",
					  {code:$("#code").val()},
					  function(message){
						  $("#span").text(message);
					  });
				});
			});
		</script>

	</head>

	<body>
		<form action="${pageContext.request.contextPath }/submit.code" method="post">
			name:<input type="text" name="name"/><br/>
			<a href="javascript:;" onclick="return changeImage();"><img id="image" src="${pageContext.request.contextPath }/show.code"/></a>
			<a href="javascript:;" onclick="return changeImage();">换一张</a>
			<input type="text" name="code" id="code"  size="5" /><span id="span"></span><br/>
			<input type="submit" value="submit"/>
		</form>
		${message }
	</body>
</html>
