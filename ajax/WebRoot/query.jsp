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
			function query(){
				
			
				var rs=document.getElementById("rs");
				
				rs.innerHTML="";
				
			
				
				
				
				
				
				var xmlHttpRequest=getXMLHttpRequest();
				var keyElement=document.getElementById("key");
				var key=keyElement.value;
				xmlHttpRequest.open("get","${pageContext.request.contextPath}/query?key="+key,true);
				xmlHttpRequest.onreadystatechange=function(){
					if(xmlHttpRequest.readyState==4){
						var result=xmlHttpRequest.responseText;
						var results=eval("("+result+")");
						for(var i=0;i<results.length;i++){
<%--							var liObj=document.createElement("li");--%>
<%--							liObj.innerHTML=results[i].message;--%>
<%--							rs.appendChild(liObj);--%>
<%--							liObj.onclick=function(){--%>
<%--								keyElement.value=this.innerHTML;--%>
<%--							}--%>



							rs.innerHTML=rs.innerHTML+"<li onclick='get(this)'>"+results[i].message+"</li>";
						}
					}
				};
				xmlHttpRequest.send(null);
			}
			
			function get(li){
				document.getElementById("key").value=li.innerHTML;
			}
			
		</script>
	</head>

	<body>
		<input id="key" type="text" name="key" onkeyup="query();"/>
		<hr/>
		<div id="rs">
			<li>vvvv</li>
		</div>
	</body>
</html>
