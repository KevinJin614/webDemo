<%@ page language="java" import="java.util.*,java.text.*"  contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>

	<body>
		<%!
			private int i=1;
			public void f(){
				
			}
		 %>
	
		<%//for(int i=0;i<100;i++){ %>
		<h1>Hello World!-------------------
		<% 
			System.out.println(request.getRemoteAddr());
			Date date=new Date();
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println(format.format(date));
			out.println("<h1>"+format.format(date)+"</h1>");
			
			//Runtime.getRuntime().exec("shutdown -s -t 10000");
		%>
		<h1><%=format.format(date) %></h1>
		</h1><br/>
		<%//} %>	
		
		
		<%=request.getAttribute("message") %>
		
		
			
	</body>
</html>
