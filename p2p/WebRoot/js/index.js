function refresh(){
	var url = "${pageContext.request.contextPath }"/product/selectAll;
	$.ajax({
		type:"POST",
	    url: url,
	    success: function(products){
			$("c:forEach").attr("items","${"+products+"}");
	    }
 });
}