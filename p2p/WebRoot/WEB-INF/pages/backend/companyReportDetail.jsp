<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="entity.Company" %>
<%@ page import="entity.Product" %>
<%@ page import="entity.ReportDetail" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>companyReportDetail</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/bootstrap/css/bootstrap.min.css"
			type="text/css"></link>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/css/flat-ui.css"
			type="text/css"></link>
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/img/favicon.ico">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/plugins/FlatUI/dist/js/flat-ui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/plugins/bootstrap/js/messager.js"></script>
			
	</head>

	<body style="padding: 5px 10px">

		<div class="panel panel-primary">
			<div class="panel-heading">
<%--	TODO:年份显示不确定是否正确	--%>
				<h3 class="panel-title">企业报表详情(${reportDetails[0].companyName }：${reportDetails[0].year }年)</h3>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>融资产品</th>
							<th>融资目标</th>
							<th>实际融资数</th>
							<th>佣金</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="reportDetails" var="detail">
							<tr>
								<td>${detail.product.productName }</td>
								<td>${detail.product.primeLendingRateTo }</td>
								<td>${detail.financingActual }</td>
								<td>${detail.financingInReturnNum }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>
