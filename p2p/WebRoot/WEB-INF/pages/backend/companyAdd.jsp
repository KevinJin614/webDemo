<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="entity.Company" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
<%--	TODO:companyAdd页面添加的银行有乱码现象	--%>
		<title>companyAdd</title>
		
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/bootstrap/css/bootstrap.min.css"
			type="text/css"></link>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/css/flat-ui.css"
			type="text/css"></link>
		<link rel="shortcut icon" href="${pageContext.request.contextPath }/plugins/FlatUI/dist/img/favicon.ico">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script src="${pageContext.request.contextPath }/plugins/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/plugins/FlatUI/dist/js/flat-ui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/plugins/fwb/bootstrap-wysiwyg.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/plugins/fwb/external/jquery.hotkeys.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/productAdd.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/plugins/FlatUI/dist/js/application.js"></script>
		
		
		<script type="text/javascript">
			function inputSubmit(){
				$("#contentInput").val($("#content").wysiwyg('getContent').html());
			};
		</script>
	</head>

	<body style="padding: 5px 10px">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">企业添加</h3>
			</div>
			<div class="panel-body">
				<form class="form-horizontal" role="form"
					action="${pageContext.request.contextPath}/company/companyAdd.action">
					<div class="form-group">
						<label for="companyName" class="col-lg-2 control-label">企业名称</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" name="company.companyName" id="companyName" placeholder="产品名称">
						</div>
					</div>
					<div class="form-group">
						<label for="productRate" class="col-lg-2 control-label">融资佣金</label>
						<div class="col-lg-10">
							<div class="input-group col-lg-3" style="float: left;">
								<input type="text" class="form-control" name="company.financingInReturn" placeholder="佣金数">
								<span class="input-group-addon">%</span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="content" class="col-lg-2 control-label">内容</label>
						<div class="col-lg-10">
							<div class="btn-toolbar" data-role="editor-toolbar" data-target="#content">
								<div class="btn-group">
									<a class="btn" data-edit="indent" title="Indent (Tab)">Tab缩进</a>
								</div>
								<div class="btn-group">
									<a class="btn" data-edit="justifyleft" title="Align Left (Ctrl/Cmd+L)"> 左对齐 </a>
									<a class="btn" data-edit="justifycenter" title="Center (Ctrl/Cmd+E)"> 居中 </a>
									<a class="btn" data-edit="justifyright" title="Align Right (Ctrl/Cmd+R)"> 右对齐 </a>
									<a class="btn" data-edit="justifyfull" title="Justify (Ctrl/Cmd+J)"> 自动调整 </a>
								</div>
								<div class="btn-group">
									<a class="btn" data-edit="undo" title="Undo (Ctrl/Cmd+Z)">撤销</a>
									<a class="btn" data-edit="redo" title="Redo (Ctrl/Cmd+Y)">恢复</a>
								</div>
							</div>
							<div id="content" style="overflow: scroll; max-height: 300px; border: 1px solid; height: 200px;"></div>
							<input type="hidden" name="company.companyDetail" id="contentInput" />
							<br />
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<button type="submit" class="btn btn-lg btn-success" style="padding: 15px 60px; border-radius: 0px;" onclick="inputSubmit();">
								添加
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
