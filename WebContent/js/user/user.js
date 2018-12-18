var username = "";
var newUser = "";
// var userId="";
$(document).ready(function() {

	// 获取当前登陆的用户
	getuser()
	if (!user || typeof (user) == "undefined" || user == null) {
		toastr.error("非法登陆，正在退出");
		setTimeout(function() {
			window.location.href = "/fleaMarketSystem/skip/skip_intoIndex";
		}, 1000);
	}

	// $(".user-info").childen("img").attr("src",)
});
// 更新session
function getNewUser() {
	$.ajax({
		async : false,
		type : 'POST',
		url : '/fleaMarketSystem/loginRegister/loginRegister_getNewSes',
		data : {
			'newUser.username' : username
		},
		cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
		dataType : "text",
		success : function(result) {
			var jsonData = JSON.parse(result);
			newUser = jsonData.session.attributes.user_session
			// userId = jsonData.session.attributes.user_session.user_id;
			// console.log("qa:"+result)
			getheadPic()
		}
	})
}
// 得到头像
function getheadPic() {
	var dd = newUser.headportrait;
	if (dd == undefined) {
	} else {
		$("#headPic").attr(
				"src",
				"/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName="
						+ dd);
		$(".user-info").children("img").attr(
				"src",
				"/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName="
						+ dd);
		$("#ss").children("img").attr(
				"src",
				"/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName="
						+ dd);
	}

}

// 得到当前登陆的用户
function getuser() {
	$
			.ajax({
				async : false,
				type : 'POST',
				url : '/fleaMarketSystem/loginRegister/loginRegister_getSes',
				cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
				dataType : "text",
				success : function(result) {
					var jsonData = JSON.parse(result);
					var sess = jsonData.session.attributes.user_session
					if (typeof (sess) == "undefined") {
						toastr.error("非法登陆，正在退出");
						setTimeout(
								function() {
									window.location.href = "/fleaMarketSystem/skip/skip_intoIndex";
								}, 1000);
					} else {
						user = jsonData.session.attributes.user_session
						var userId = jsonData.session.attributes.user_session.user_id;
						username = jsonData.session.attributes.user_session.username
						getNewUser()
						getMyPublish(userId)
					}
				}
			})
}

// 获取我所发布的商品信息
function getMyPublish(userId) {
	console.log("KKKK" + userId)
	$
			.ajax({
				async : false,
				type : 'POST',
				url : '/fleaMarketSystem/goodsInfoManager/goodsInfoManager_getPublishedGoodsVO',
				data : {
					"newUser.user_id" : userId
				},
				cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
				success : function(result) {
					console.log("result:" + result)
					var goodsPicVO = JSON.parse(result);
					var str = "<ul>"
					if (typeof(goodsPicVO.listGoodsPicDTO) === "undefined" ) {
						 str = str + '<div class="no-data">'+'<p>'+'您没有发布任何二货哦~'+'</p>'+'</div>'+'</ul>'
						 $(".fr").html(str)

					} else {
						var length = goodsPicVO.listGoodsPicDTO.length
						console.log("HH" + length)
						for (i = 0; i < length; i++) {
							str = str
									+ '<li>'
									+ '<div class="list-header">'
									+ '<span>'
									+ goodsPicVO.listGoodsPicDTO[i].info.goods_creationtime
									+ '</span>'
									+ '</div>'
									+ '<div class="list-main clearfix">'
									+ '<a href="" class="goods-images fl">'
									+ '<img src="/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName='
									+ goodsPicVO.listGoodsPicDTO[i].pic.picture_name
									+ '" >'
									+ '</a>'
									+ '<div class="good-info fl">'
									+ '<a href="" class="goods-title">'
									+ '</a>'
									+ '<p class="goods-price">'
									+ '￥'
									+ '<span>'
									+ goodsPicVO.listGoodsPicDTO[i].info.goods_price
									+ '</span>'
									+ '</p>'
									+ '</div>'
									+ '<div class="operation fr">'
									/*
									 * + '<a href="javaScript:;" class="edit">' +
									 * '编辑' + '</a>'
									 */+ '<a id="'
									+ goodsPicVO.listGoodsPicDTO[i].info.goods_id
									+ '" href="javaScript:;" class="delete" onClick="deleteGoods(this)">'
									+ '删除' + '</a>' + '</div>' + '</div>'
									+ '</li>'
						}
						str = str + '</ul>'+'<div id="pagination" class="pagination">'+'</div>'
						$(".fr").html(str);
						//得到我发布的商品分页
						getMyPublishPage(goodsPicVO)
					}
				}
			})
}
//删除我发布的商品
function deleteGoods(e){
	var goodsId = e.id 
	$
			.ajax({
				async : false,
				type : 'POST',
				url : '/fleaMarketSystem/goodsInfoManager/goodsInfoManager_deleteGoods',
				data : {
					"data_id" : goodsId
				},
				cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
				success : function(result) {
					toastr.success("删除成功!");
					setTimeout(function() {
						location.href="/fleaMarketSystem/skip/skip_intoUser";
					}, 1000);
			   }
              })
}

//得到我发布的商品分页
function getMyPublishPage(goodsPicVO){
	console.log("0" + goodsPicVO)
	var totalRecords = goodsPicVO.totalRecords;
	console.log("1?" + totalRecords)
	var pageIndex = goodsPicVO.pageIndex;
	console.log("2?" + goodsPicVO)
	var pageSize = goodsPicVO.pageSize;
	console.log("3?" + pageSize)
	var totalPages = goodsPicVO.totalPages;
	console.log("4?" + totalPages)
	var havePrePage = goodsPicVO.havePrePage;
	console.log("5?" + havePrePage)
	var haveNextPage = goodsPicVO.haveNextPage;
	console.log("6?" + haveNextPage)
	var str = '<ul >' + '<li class="prev">' + "上一页" + '</li>'
	var strStart = '';
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
	$(".pagination").html(str);
	
}
$("#myInfo").click(function() {

	location.href = "/fleaMarketSystem/skip/skip_intoUserInfo";
})

$("#myPublish").click(function() {

	location.href = "/fleaMarketSystem/skip/skip_intoUser";
})

$("#myWants").click(function() {

	 location.href="/fleaMarketSystem/skip/skip_intoUserWants";
})
//跳转首页
$("#homePage").click(function() {

	 location.href="/fleaMarketSystem/skip/skip_intoIndex";
})
//跳转首页
$(".brand").click(function() {

	 location.href="/fleaMarketSystem/skip/skip_intoIndex";
})
