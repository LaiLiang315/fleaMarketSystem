<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.1.8.2.min.js" ></script>
<script type="text/javascript" src="js/jquery.plugin.min.js"></script>
</head>
<body>
	<h1></h1>
	<ul>
	<c:forEach var="item" items="${ listGoodsManagerDTO }">
		<li>
			${item.type.type_name }
			<ul>
				<c:forEach var="item2" items="${ item.listGoodsPicsDTO }">
					<li>${item2.info.goods_name}</li>
				</c:forEach>
			</ul>
		</li>
	</c:forEach> 
	</ul>
	
	
	<!-- <ul id="selectTypes">
	</ul> -->
</body>
<script type="text/javascript">
//放入类型信息
(function getTypeInfo(){
	$.ajax({
	type:'POST',
    url:'/fleaMarketSystem/goodsInfoManager/goodsInfoManager_queryGoodsManagerDTO',
	cache: false,  
	processData: false,
	contentType: false,
	success:function(result){
	var listCarouselDTO = JSON.parse(result)
	putType(listCarouselDTO)
  }
})
})();
//查询分类下拉菜单
function putType(listCarouselDTO){
	var l = ''
	for(i=0;i<listCarouselDTO.length;i++){
		l = l + '<li>'+listCarouselDTO[i].type.type_name+'<ul>'
		for(j=0;j<listCarouselDTO[i].listGoodsPicsDTO.length;j++){
			l = l + '<li>'+listCarouselDTO[i].listGoodsPicsDTO[j].info.goods_name+'</li>'
		}
		l = l+'</ul>' + '</li>'
	}
	document.querySelector("#selectTypes").innerHTML = l;
}
</script>
</html>