<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="entity.Product" %>
<%@ page import="entity.Company" %>
<%@ page import="entity.ProductType" %>
<%@ page import="entity.LendingPeriod" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--	TODO:index点击选项后刷新页面	--%>
<html>
	<head>
		<title>网络在线货币借贷及审核系统</title>
		<link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/css/jPaginate.css" rel="stylesheet" type="text/css" media="screen"/>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.paginate.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
			
				$("#choices tr").each(function()
					{
						$(this).find('a').click(function(){
								$(this).parent().parent().find('a').removeClass('cur');
								$(this).addClass('cur');
								//TODO: 异步加载数据
						});
					}
				);
			});

		</script>
		
		<script language="javascript"> 
			function realSysTime(clock){ 
			var now=new Date(); //创建Date对象 
			var year=now.getFullYear(); //获取年份 
			var month=now.getMonth(); //获取月份 
			var date=now.getDate(); //获取日期 
			var day=now.getDay(); //获取星期 
			var hour=now.getHours(); //获取小时 
			var minu=now.getMinutes(); //获取分钟 
			var sec=now.getSeconds(); //获取秒钟 
			month=month+1; 
			var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六"); 
			var week=arr_week[day]; //获取中文的星期 
			var time="<a href='#'>"+year+"年"+month+"月"+date+"日 "+week+" "+hour+":"+minu+":"+sec+"</a>"; //组合系统时间 
			clock.innerHTML=time; //显示系统时间 
			} 
			window.onload=function(){ 
			window.setInterval("realSysTime(clock)",1000); //实时获取并显示系统时间 
			} 
		</script> 
		
		<script type="text/javascript">
			$(function() {
				$("#demo4").paginate({
				count 		: 50,
				start 		: 1,
				display     : 12,
				border					: false,
				text_color  			: '#79B5E3',
				background_color    	: 'none',	
				text_hover_color  		: '#2573AF',
				background_hover_color	: 'none', 
				images		: false,
				mouse		: 'press',
				onChange     			: function(page){
												
										  }
				
				});
			});
		</script>
	</head>

	<body>
		
		<div class="wrap header oauto clear">
			<div class="clear" style="float: left"><a href="${pageContext.request.contextPath }/index.jsp?method=login.jsp">管理员登录</a></div>
			<div id="clock"  style="float: right;"></div>
		</div>
		<div class="logo-nav">
		    <div class="wrap oauto">
		        <div class="clear">
		            <div class="fl"><img src="${pageContext.request.contextPath }/images/logo.png" /></div>
		        </div>
		    </div>
		</div>
		<div class="menu">
		    <ul class="clear">
		        <li><a href="${pageContext.request.contextPath }/product/index.action" class="cur">融资产品</a></li>
		        <li><a href="${pageContext.request.contextPath }/news/newsIndex.action" target="_blank">每日新闻</a></li>
		    </ul>
		</div>


		<div class="wrap bank_list">
			<div class="title clear">
				<h1 class="fl">产品分类</h1>
			</div>
			<div class="bank_list_tp">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" id="choices">
					<tr class="bank_list_tp1">
						<td width="10%" align="right">产品类型：</td>

						<td width="12%" align="center" valign="top" class="qb">
							<a href="javascript:;" class="cur">全部</a>
						</td>

						<td width="78%" class="txt clear">
							<a href="javascript:;">信用贷</a>
							<a href="javascript:;">抵押贷</a>
							<a href="javascript:;">质押贷</a>
							<a href="javascript:;">担保贷</a>
							<a href="javascript:;">票据贴现</a>
							<a href="javascript:;">其他</a>
						</td>
					</tr>
					<tr class="bank_list_tp2">
						<td align="right">贷款周期：</td>
						<td align="center" valign="top" class="qb">
							<a href="javascript:;" class="cur">全部</a>
						</td>
						<td class="txt clear">
							<a href="javascript:;">1个月</a>
							<a href="javascript:;">3个月</a>
							<a href="javascript:;">6个月</a>
							<a href="javascript:;">12个月</a>
							<a href="javascript:;">其他</a>
						</td>
					</tr>
					<tr class="bank_list_tp3">
						<td align="right">贷款利率：</td>
						<td align="center" valign="top" class="qb">
							<a href="javascript:;" class="cur">全部</a>
						</td>
						<td class="txt clear">
							<a href="javascript:;">6%以下</a>
							<a href="javascript:;">6%-8%</a>
							<a href="javascript:;">8%-10%</a>
							<a href="javascript:;">10%-12%</a>
							<a href="javascript:;">12%-14%</a>
							<a href="javascript:;">14%以上</a>
						</td>
					</tr>
					<tr class="bank_list_tp4">
						<td align="right">贷款规模：</td>
						<td align="center" valign="top" class="qb">
							<a href="javascript:;" class="cur">全部</a>
						</td>
						<td class="txt clear">
							<a href="javascript:;">100万以下</a>
							<a href="javascript:;">100万-200万</a>
							<a href="javascript:;">200万-300万</a>
							<a href="javascript:;">300万-500万</a>
							<a href="javascript:;">500万-1000万</a>
							<a href="javascript:;">1000万以上</a>
						</td>
					</tr>
				</table>
			</div>
		</div>


		<div class="wrap project_release">
			<div class="project_release_tp">融资产品</div>
		    <div class="project_release_bt">
		    	<ul>
		    		<c:forEach items="${products }" var="product">
		    			<c:if test="${product.status != 'D'}">
			    			<li class="clear">
	<%--		  TODO:index银行的介绍图片获取位置没定义 			--%>
				            	<div class="fl"><img src="${pageContext.request.contextPath }/images/jsyh.png"  width="75px" height="40px" class="pr_logo" /></div>
				                <div class="fl">
				                	<dl>
				                    	<dt>产品名称：<span class="king">${product.productName }</span></dt>
				                    	<dt>所属银行：${product.company.companyName }</dt>
				                      	<dt>产品类别：${product.productType.productTypeName }</dt>
				                    	<dt>放贷利率：${product.primeLendingRateFrom }%-${product.primeLendingRateTo }%（年化利率）</dt>
				                    	<dt>放贷金额：${product.financingAmountFrom }-${product.financingAmountTo }万</dt>
				                      	<dt>放贷期限：${product.lendingPeriod.period }个月</dt>
				                    </dl>
				                </div>
				                <div class="view_details"><a href="${pageContext.request.contextPath }/product/productIndex.action?productId=${product.productId }">查看详细</a></div>
				            </li>
		    			</c:if>
		    		</c:forEach>
		    	</ul>
		    </div>
<%--	TODO:index分页还没做	--%>
<!--		    <div class="newslist_text"><a href="#">上一页</a><a href="#" class="cur">1</a><a href="#">2</a><a href="#">3</a><a href="#">4</a><a href="#">5</a><a href="#">6</a><a href="#">7</a><a href="#">...</a><a href="#">下一页</a></div>-->
			<div class="demo">
				<div id="demo4"></div>
			</div>
		</div>
		
		<div class="footer">Copyright &copy; 2014 南京网博  版权所有   <a href="mailto:cuiyi@itany.com">cuiyi@itany.com</a></div>
		
	</body>
</html>
