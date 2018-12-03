//筛选类型
var typeId = null
$(document).ready(function() {
	// 获取六条分类信息
	getTypeInfo();
	
	getuser();
	
	registerPage()
	// 小轮播自动进行
	$('#featured').carousel({
		interval : 4000
	})
	
	$(function() {
		$('#gallery a').lightBox();
	});
	
});
// 获取分类信息
function getTypeInfo() {
	$.ajax({
		async : false,
		type : 'POST',
		url : '/fleaMarketSystem/goodsType/goodsType_getListGoodsTypeDTO',
		cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
		processData : false, // 不序列化data
		contentType : false,
		success : function(result) {
			var listGoodsTypeDTO = JSON.parse(result)
			putType(listGoodsTypeDTO)
		}
	})
};
// 查询一级分类
function putType(listGoodsTypeDTO) {
	var length = listGoodsTypeDTO.length;
	var strStart = '';
	for (i = 0; i < length; i++) {
		strStart = strStart + '<li id="'
				+ listGoodsTypeDTO[i].typeOne.typeOne_id
				+ '" class="subMenu" onClick="getSubMenu(this)">' + '<a id="'
				+ listGoodsTypeDTO[i].typeOne.typeOne_id + '">'
				+ listGoodsTypeDTO[i].typeOne.typeOne_name + '</a>'
		strStart = strStart + '</li>' + '</ul>'
	}
	strStart = strStart + '</ul>'
	$("#sideManu").html(strStart);
//	document.querySelector("#sideManu").innerHTML = strStart;
}
// 获得二级分类信息
function getTypeTwo(typeOne) {
//	console.log("KKK" + typeOne)
	$.ajax({
		type : 'POST',
		url : '/fleaMarketSystem/goodsType/goodsType_getListType',
		data : {
			'typeOne.typeOne_id' : typeOne
		},
		cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
		// processData : false, // 不序列化data
		// contentType : false,
		success : function(result) {
			var types = JSON.parse(result)
			putTypeTwo(types) // 获取二级分类
		}
	})
};
// 查询分类下拉菜单
function putTypeTwo(types) {
//	console.log("HHHHGGG" + types)
	var length = types.length;
	var str = '<ul class="sub" style="display:block" >'
	// 获取二级菜单
	for (j = 0; j < types.length; j++) {
		str = str + '<li  id="' + types[j].type_id
				+ '" class="small" onClick="event.cancelBubble=true;getList(this)">'
				+ '<a>' + types[j].type_name + '</a>' + '</li>'
	}
	str = str + '</ul>'
	$("#" + types[0].type_belong + "").append(str)
}
function getSubMenu(str) {
	$("#" + str.id).children('ul').remove();
	var otherSubMenuChild = $("#" + str.id).siblings().children('ul')
	otherSubMenuChild.slideUp(500);
	$("#" + str.id).siblings().removeClass('open');
	var subMenuChild = $("#" + str.id).children('ul');// 点击的

	if ($("#" + str.id).hasClass('open')) {
		$("#" + str.id).removeClass('open');
	} else {
		$("#" + str.id).addClass('open');
		var typeOne = str.id;
		getTypeTwo(typeOne); // 调用得到二级菜单
	}
}
// 获取每个分类所有商品的图片
function getList(str){
	$("#"+str.id).siblings().removeClass('act');
	if ($("#"+str.id).hasClass('act')) {
		$("#"+str.id).removeClass('act');
    	} else {
		$("#"+str.id+"").addClass('act');
	}
	$
			.ajax({
				type : 'POST',
				url : '/fleaMarketSystem/goodsInfoManager/goodsInfoManager_findAllGoodsByTypeVO',
				data : {
					'typeId.type_id' : str.id,
					'page' : 1
				},
				cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
				// processData : false, // 不序列化data
				// contentType : false,
				success : function(result) {
//					console.log("啦啦啦啦啦all了" + result)
					var typeInfoPicVO = JSON.parse(result)
					Page(typeInfoPicVO);
					var strStart = '';
//					console.log("zzzzzzzzzzzzzzzzzzzzzzzzz"+typeInfoPicVO.listGoodsPicDTO)
					if (typeof(typeInfoPicVO.listGoodsPicDTO) === "undefined") {
						
						strStart = strStart+'<li>'+'</li>'
					}else{
					var length = typeInfoPicVO.listGoodsPicDTO.length;
					
					for (i = 0; i < length; i++) {
						strStart = strStart
								+ '<li>'
								+ '<div class="thumbnail">'
								+ '<a>'
								+ '<img style="width:160px;height:160px" src="/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName='
								+ typeInfoPicVO.listGoodsPicDTO[i].pic.picture_name
								+ '" />'
								+ '</a>'
								+ '<div class="caption">'
								+ '<h5>'
								+ typeInfoPicVO.listGoodsPicDTO[i].info.goods_name
								+ '</h5>'
								+ '<p>'
								+ typeInfoPicVO.listGoodsPicDTO[i].info.goods_name
								+ '</p>'
								+ '<h4 style="text-align:center">'
								+ '<a href="javascript:void(0)" class ="btn" onClick="getDetal(this)" >'
								+ '<i class="icon-zoom-in">'
								+ '</i>'
								+ '</a>'
								+ '<a href="javascript:void(0)" class="btn">'+'购买'
								+ '<i class="icon-shopping-cart">'
								+ '</i>'
								+ '</a>'
								+ '<a class="btn btn-primary">'
								+ '￥'
								+ typeInfoPicVO.listGoodsPicDTO[i].info.goods_price
								+ '</a>' + '</h4>' + '</div>'
						strStart = strStart + '</li>'
					   }
					}
					strStart = strStart + '</ul>'
					$("#latestGoods").html(strStart);
				}
			})
}
//分页获取商品信息
function getListGoodsInfo(str,pageNew) {
//$("#"+str.id+"").children('a').addClass("act");
//	console.log("VCXZ" + str)
//	console.log("vxczz"+pageNew)
	
	console.log(typeof (str))
	$
			.ajax({
				type : 'POST',
				url : '/fleaMarketSystem/goodsInfoManager/goodsInfoManager_findAllGoodsByTypeVO',
				data : {
					'typeId.type_id' : str,
					'page' : pageNew
				},
				cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
				// processData : false, // 不序列化data
				// contentType : false,
				success : function(result) {
//					console.log("啦啦啦啦啦all了" + result)
					var typeInfoPicVO = JSON.parse(result)
					var length = typeInfoPicVO.listGoodsPicDTO.length;
					var strStart = '';
					for (i = 0; i < length; i++) {
						strStart = strStart
								+ '<li>'
								+ '<div class="thumbnail">'
								+ '<a>'
								+ '<img style="width:160px;height:160px" src="/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName='
								+ typeInfoPicVO.listGoodsPicDTO[i].pic.picture_name
								+ '" />'
								+ '</a>'
								+ '<div class="caption">'
								+ '<h5>'
								+ typeInfoPicVO.listGoodsPicDTO[i].info.goods_name
								+ '</h5>'
								+ '<p>'
								+ typeInfoPicVO.listGoodsPicDTO[i].info.goods_name
								+ '</p>'
								+ '<h4 style="text-align:center">'
								+ '<a href="javascript:void(0)" class ="btn" onClick="getDetal(this)" >'
								+ '<i class="icon-zoom-in">'
								+ '</i>'
								+ '</a>'
								+ '<a href="javascript:void(0)" class="btn">'+'购买'
								+ '<i class="icon-shopping-cart">'
								+ '</i>'
								+ '</a>'
								+ '<a class="btn btn-primary">'
								+ '￥'
								+ typeInfoPicVO.listGoodsPicDTO[i].info.goods_price
								+ '</a>' + '</h4>' + '</div>'
						strStart = strStart + '</li>'
					}
					strStart = strStart + '</ul>'
					document.querySelector("#latestGoods").innerHTML = strStart;
				}
			})
}
// 获取分页
function Page(typeInfoPicVO) {
	console.log("0" + typeInfoPicVO)
	var totalRecords = typeInfoPicVO.totalRecords;
	console.log("1?" + totalRecords)
	var pageIndex = typeInfoPicVO.pageIndex;
	console.log("2?" + pageIndex)
	var pageSize = typeInfoPicVO.pageSize;
	console.log("3?" + pageSize)
	var totalPages = typeInfoPicVO.totalPages;
	console.log("4?" + totalPages)
	var havePrePage = typeInfoPicVO.havePrePage;
	console.log("5?" + havePrePage)
	var haveNextPage = typeInfoPicVO.haveNextPage;
	console.log("6?" + haveNextPage)
	var str = '<ul >' + '<li class="prev">' + "上一页" + '</li>'
	var strStart = '';
	console.log(totalPages)
	for (i = 0; i < totalPages; i++) {
		if (i === 0) {
			str = str + '<li id="' + (i + 1)
					+ '" class="nav active" onClick="getCurPage(this)">' + (i + 1)
					+ '</li>'

		} else {
			str = str + '<li id="' + (i + 1) + '" class="nav" onClick="getCurPage(this)">'
					+ (i + 1) + '</li>'
		}

	}
	str = str + '<li class="next">' + "下一页" + '</li>' + '</ul>'
	document.querySelector(".pagination").innerHTML = str;
	// 点击上一页
	$(".prev").on("click", function() {
		if (havePrePage = true) {
			var num = $(".pagination ul .active").html();
			console.log("KKKBBVVVDD"+num)
			$(".pagination li").removeClass("active");
			if (num > 1) {
				$("#" + (parseInt(num) - 1) + "").addClass("active");
			} else {
				$("#" + (parseInt(num)) + "").addClass("active");
				alert("第一页")
			}
			var str= $(".sub:visible").children("li.small.act").attr("id");
			if(num>1){
				
				var pageNew = parseInt(num)-1
				getListGoodsInfo(str,pageNew)
			}
		}
	})
	// 点击下一页
	$(".next").on("click", function() {
		if (haveNextPage = true) {
			// 获取当前active的li
			var num = $(".pagination ul .active").html();
			console.log(num)
			console.log("GGGGG" + num)
			// 移除之前的active
			$(".pagination li").removeClass("active");
			if (num < totalPages) {
				$("#" + (parseInt(num) + 1) + "").addClass("active");
			} else {
				// alert("已经是最后一页了")
				$("#" + (parseInt(num)) + "").addClass("active");
				alert("已经是最后一页了")
			}
			var str= $(".sub:visible").children("li.small.act").attr("id");
			if(num<totalPages){
				
				var pageNew = parseInt(num)+1
				getListGoodsInfo(str,pageNew)
			}
			
		}
	})
}
// 点击当前页
function getCurPage(num) {
//	console.log("dangqian" + num.id)
	$("#pagination li").removeClass("active");
	$("#" + (parseInt(num.id)) + "").addClass("active");
//	console.log("BMNB"+$(".pagination").children("li").html())
	//获取可见的ul的li的class为active的 id
	var str= $(".sub:visible").children("li.small.act").attr("id");
	var pageNew = parseInt(num.id) 
	getListGoodsInfo(str,pageNew)
}

//点击注册
function registerPage(){
	$(".register").on("click",function(){
		location.href = "/fleaMarketSystem/skip/skip_intoRegister"
	})
	
}


//得到当前登陆的用户
function getuser(){
	$.ajax({
		async : false,
		type : 'POST',
		url : '/fleaMarketSystem/loginRegister/loginRegister_getSes',
		cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
		processData : false, // 不序列化data
		contentType : false,
		success : function(result) {
//			alert("SESSION")
			console.log("SESSION"+result)
			var sessin = JSON.parse(result)
		}
	})
	
}
//跳转到详情页
