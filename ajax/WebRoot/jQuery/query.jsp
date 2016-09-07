<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>	
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.1.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#key").keyup(function(){
					$("#rs").empty();
					$.getJSON("${pageContext.request.contextPath}/query",
							  {key:$("#key").val()},
							  function(results){
							  	$(results).each(function(index,result){
							  		var l="<li>"+result.message+"</li>"
							  		var $l=$(l);
							  		$l.click(function(){
							  			$("#key").val($(this).text());
							  		});
							  		$("#rs").append($l);
							  	});
							  });
				});
			});
		</script>
	</head>

	<body>
		<input id="key" type="text" name="key"/>
		<hr/>
		<div id="rs">
			<li>vvvv</li>
		</div>
	</body>
</html>
