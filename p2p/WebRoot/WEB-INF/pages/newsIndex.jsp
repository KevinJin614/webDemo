<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="entity.News" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--	TODO:newsIndex图片显示不出来	--%>
<html>
	<head>
		<title>ITing金融-每日新闻</title>
		<link href="${pageContext.request.contextPath }/css/css.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.2.min.js"></script>
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
	</head>

	<body>
		<div class="wrap header oauto clear">
		    <div id="clock" class="fr"></div>
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
		        <li><a href="${pageContext.request.contextPath }/product/index.action">融资产品</a></li>
		        <li><a href="${pageContext.request.contextPath }/news/newsIndex.action" target="_blank"  class="cur">每日新闻</a></li>
		    </ul>
		</div>
		
		
		<div class="wrap font16">首页 >> 每日新闻</div>
		<div class="wrap">
		<div class="title clear"><h1 class="fl">今日头条</h1></div>
			<div class="salon_top clear">
		    	<div class="fl">
		        	<ul id="foo1">
		            	<li><img src="${pageContext.request.contextPath }/images/news/${allNews[0].image }" width="613" height="459" /></li>
		            </ul>
		            <div id="pager1" class="pager"></div>
		        </div>
		        <div class="fr">
		        	<div class="bt"><h1><a href="" title="${allNews[0].newsTitle }">${allNews[0].newsTitle }</a></h1>
		            	<div class="hudongsalon_success">
		            		<span class="fe4800">(成功举办)</span>
		                </div>
		            </div>
		            <div class="in clear">
		                <div class="time">时间：${allNews[0].createAt }</div>
		            </div>
		            <div class="txt">
		            	${allNews[0].content }
		            </div>
		        </div>
		    </div>
		</div>
		<div class="wrap">
			<div class="title clear"><h1 class="fl">其他新闻</h1></div>
		    <div class="salon">
		    	<ul>
		    	
		    		<c:forEach items="${allNews}" var="news">
		    			<li class="clear">
			            	<div class="fl"><img src="${pageContext.request.contextPath }/images/news/${news.image }" /></div>
			                <div class="fl">
			                	<div class="salon_title clear">
			                		<div class="fl">
			                			<a href="" title="${news.newsTitle }">${news.newsTitle }</a>
			                			<span class="fe4800">
			                				<c:if test="${news.status}=='C'">(成功举办)</c:if>
			                				<c:if test="${news.status}=='F'">(已结束)</c:if>
			                			</span>
			                		</div>
			                		<div class="fr">日期：${news.createAt }</div>
			                	</div>
			                    <div class="salon_in">${news.content }</div>
			                </div>
			            </li>
		    		</c:forEach>
		    		
		        </ul>
<%--		TODO:newsIndex的分页        --%>
		        <div class="newslist_text"><a href="#">上一页</a><a href="#" class="cur">1</a><a href="#">2</a><a href="#">3</a><a href="#">4</a><a href="#">5</a><a href="#">6</a><a href="#">7</a><a href="#">...</a><a href="#">下一页</a></div>
		    </div>
		</div>
		<div class="footer">Copyright &copy; 2014 南京网博  版权所有   <a href="mailto:cuiyi@itany.com">cuiyi@itany.com</a></div>
	</body>
</html>
