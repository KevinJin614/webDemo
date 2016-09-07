<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="entity.Product" %>
<%@ page import="entity.Apply" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--	TODO:onlineApplyDetail中时间format	--%>
<html>
	<head>
		<title>onlineApplyDetail</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/bootstrap/css/bootstrap.min.css"
			type="text/css"></link>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/css/flat-ui.css"
			type="text/css"></link>
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/img/favicon.ico">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/plugins/FlatUI/dist/js/flat-ui.js"></script>
	</head>

	<body style="padding: 5px 10px">

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">在线申请详情</h3>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>产品名称</th>
							<th>申请人</th>
							<th>申请数额</th>
							<th>申请日期</th>
							<th>身份证号</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${applies }" var="apply">
							<tr>
								<td>${apply.product.productName }</td>
								<td>${apply.applyPerson }</td>
								<td>${apply.applyNum }</td>
								<td>${apply.applyDate }</td>
								<td>${apply.applyPersonIdcard }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</body>
</html>
