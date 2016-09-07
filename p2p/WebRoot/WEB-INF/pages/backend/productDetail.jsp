<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.Product" %>
<%@ page import="entity.Company" %>
<%@ page import="entity.ProductType" %>
<%@ page import="entity.LendingPeriod" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>productDetail</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/bootstrap/css/bootstrap.min.css" type="text/css"></link>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/css/flat-ui.css" type="text/css"></link>
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/img/favicon.ico">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath }/plugins/bootstrap/js/bootstrap.min.js"></script>
	</head>

	<body style="padding: 5px 10px">

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">融资产品管理</h3>
			</div>
			
			<div class="panel-body">

				<div class="form-group">
					<label for="productID" class="col-lg-2 control-label">产品编号</label>
					<div class="col-lg-10">${product.productId }</div>
				</div>

				<div class="form-group">
					<label for="productName" class="col-lg-2 control-label">产品名称</label>
					<div class="col-lg-10">${product.productName }</div>
				</div>

				<div class="form-group">
					<label for="productRate" class="col-lg-2 control-label">贷款利率</label>
					<div class="col-lg-10">${product.primeLendingRateFrom }%-${product.primeLendingRateTo }%</div>
				</div>


				<div class="form-group">
					<label for="company" class="col-lg-2 control-label">发行单位</label>
					<div class="col-lg-10">${product.company.companyName }</div>
				</div>

				<div class="form-group">
					<label for="loansize" class="col-lg-2 control-label">贷款规模</label>
					<div class="col-lg-10">${product.financingAmountFrom }万-${product.financingAmountTo }万</div>
				</div>

				<div class="form-group">
					<label for="productType" class="col-lg-2 control-label">产品类型</label>
					<div class="col-lg-10">${product.productType.productTypeName }</div>
				</div>

				<div class="form-group">
					<label for="productDuration" class="col-lg-2 control-label">贷款周期</label>
					<div class="col-lg-10">${product.lendingPeriod.period }个月</div>
				</div>


				<div class="form-group">
					<label for="linkman" class="col-lg-2 control-label">联系人</label>
					<div class="col-lg-10">${product.linkMan }</div>
				</div>

				<div class="form-group">
					<label for="bank" class="col-lg-2 control-label">联系银行</label>
					<div class="col-lg-10">${product.ownedBank }</div>
				</div>

				<div class="form-group">
					<label for="content" class="col-lg-2 control-label">内容</label>
					<div class="col-lg-10">
						<div id="content" style="max-height: 300px; height: 200px;">
							${product.productDescription }
						</div>
					</div>
				</div>
			</div>
		</div>

	</body>
</html>
