<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://itany.com/tag" prefix="my" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	</head>

	<body>
		<c:choose>
			<c:when test="${param.a>0}">
				aaaaaaa
			</c:when>
			<c:when test="${param.a<0}">
				bbbbbbb
			</c:when>
			<c:otherwise>
				ccccccc
			</c:otherwise>
		</c:choose>
		
		
		<c:catch var="e">
			<%
				int i=1/0;
			
			 %>
		</c:catch>
		
		${e }<br/>
		${e.message }<br/>
		
		<c:url value="/AAA"/><br/>
		${pageContext.request.contextPath }/AAA
		
		<c:import url="/index.jsp"></c:import>
		
		
		<my:msg info="abc" num="10"/>
<%--		 <c:redirect url="/hello.jsp"></c:redirect>--%>
		
	</body>
</html>
