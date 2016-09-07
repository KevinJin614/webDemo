<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<style type="text/css">
			.c{
				background-color: #444444;
			}
		</style>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.1.min.js"></script>
		<script type="text/javascript">
<%--		
			$(document)将整个dom（html）转换成jQuery对象
			.ready();当整个html加载完以后自动执行ready()里面的代码
--%>
<%--			$(document).ready(function(){--%>
<%--			--%>
<%--			});--%>

<%--		上面代码的缩写形式	--%>
			$(function(){
				$("#h").click(function(){
<%--					alert(this.innerHTML);--%>
					alert($(this).html());
				});
				
				
				$("div:first").addClass("c");
				
				$("div p:even").css("background","#fff222");
				$("div p:odd").css("background","#222fff");
				
				
				
				$("#bigger").click(function(){
					var fontSize=$("div").css("font-size");
					$("div").css("font-size",parseInt(fontSize)+5+"px");
				});
				
				$("#smaller").click(function(){
					var fontSize=$("div").css("font-size");
					$("div").css("font-size",parseInt(fontSize)-5+"px");
				});
				
				
				$("#show").click(function(){
					$("div").fadeIn(3000);
				});
				
				$("#hidden").click(function(){
					$("div").fadeOut(3000);
				});
				
				$("#move").click(function(){
					$("#photo").animate({left:"600px"},3000)
							   .animate({left:"0px"},3000);
					setTimeout('javascript:$("#move").click();',6000);
				});
				
				$("#load").click(function(){
					$("#i").val("aaa");
					$("#img").attr("src","${pageContext.request.contextPath}/img/img.JPG");
					$("#d1").html("<h1>hello</h1>");
					$("#d2").text("<h1>hello</h1>");
				});
				
				$("#add").click(function(){
<%--					var s="<li>"+$("#t").val()+"</li>"--%>
<%--					$(s).appendTo($("#ul"));--%>

					var l=$("#ul li:first").clone();
					l.text($("#t").val());
					$("#ul").append(l);
				});
				
				$("#ul li").click(function(){
					var l=$(this).clone(true);
					$("#ul").append(l);
				});
				
				var i=1;
				
				$("#more").click(function(){
					var d=$("#fileDiv").clone(true);
					d.attr("id",d.attr("id")+i);
					$("#more").before(d);
				});
				
				$("div a").click(function(){
					$(this).parent().remove();
				});
			});
		</script>
	</head>

	<body>
		<h1 id="h" class="c">Hello World!</h1>
		
		<hr/>
		
		<div>
			<p>adfsadfsadfsda</p>
			<p>sdfsdfsadfsdfs</p>
			<p>adfsadfsadfsda</p>
			<p>sdfsdfsadfsdfs</p>
			<p>adfsadfsadfsda</p>
			<p>sdfsdfsadfsdfs</p>
			<p>adfsadfsadfsda</p>
			<p>sdfsdfsadfsdfs</p>
		</div>
		<hr/>
		<%--		font-size    每次放大5px --%>
		<input type="button" id="bigger" value="放大"/>
		<%--		font-size    每次缩小5px --%>
		<input type="button" id="smaller" value="缩小"/>
		
		<input type="button" id="show" value="显示"/>
		<input type="button" id="hidden" value="隐藏"/>
		
<%--		<input type="button" value="动起来" id="move"/>--%>
<%--		<div id="photo" style="position: absolute;">--%>
<%--			<img src="${pageContext.request.contextPath }/img/img.JPG"/>--%>
<%--		</div>--%>
		
		<hr/>
		
		<input type="button" id="load" value="加载"/>
		<hr/>
		<input type="text" id="i"/>
		<hr/>
		<img id="img"/>		
		<hr/>
		<div id="d1">
		</div>
		<hr/>
		<div id="d2">
		</div>
		<hr/>
		<input type="text" id="t"/><input type="button" id="add" value="追加"/>
		<ul id="ul">
			<li>aaa</li>
		</ul>
		<hr/>
		<div id="fileDiv">
			文件：<input type="file"/><a href="javascript:;">删除</a>
		</div>
		<input type="button" id="more" value="上传更多"/>
		
		
		
		
		
		
		
		
		
	</body>
</html>
