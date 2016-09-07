<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript">
		
			function f(){
<%--				var p=new person("abc",24);--%>
				
<%--				alert(p.name);--%>
<%--				alert(p.age);--%>
<%--				p.play();--%>



<%--				var p=new Object();--%>
<%--				p.name="aaa";--%>
<%--				p.age=22;--%>
<%--				p.play=function(){--%>
<%--					alert("play");--%>
<%--				};--%>
<%--				--%>
<%--				alert(p.name);--%>
<%--				p.play();--%>

<%--			json	--%>
<%--				var p={"name":"abc","age":26,"address":{"city":"南京"}};--%>
<%--				--%>
<%--				alert(p.name);--%>
<%--				alert(p.address.city)--%>
<%--				--%>
<%--				var persons=[{"name":"aaa","age":"23"},{"name":"bbb","age":"24"}];--%>
<%--				--%>
<%--				for(var i=0;i<persons.length;i++){--%>
<%--					var p=persons[i];--%>
<%--					alert(p.name+" "+p.age);--%>
<%--				}--%>
				
				
				var s="{'name':'aaa','age':27}";
				
<%--				alert(s);--%>
				
				var p=eval("("+s+")");
				
<%--				alert(p);--%>
				
				alert(p.name);
				
			}
			
			function person(name,age){
				this.name=name;
				this.age=age;
				
				this.play=function(){
					alert(this.name+"在玩");
				}
			}
		</script>
	</head>

	<body>
		<a href="javascript:;" onclick="f();">click</a>
	</body>
</html>
