var username = "";
var userId = "";
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
//得到当前登陆的用户
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
					   userId = jsonData.session.attributes.user_session.user_id;
						username = jsonData.session.attributes.user_session.username
						getNewUser()
						//获取用户收藏
						getUserWangts()
					}
				}
			})
}

//更新session
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
//			 userId = jsonData.session.attributes.user_session.user_id;
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
function getUserWangts(){
	$.ajax({
		async : false,
		type : 'POST',
		url : '/fleaMarketSystem/goodsInfoManager/goodsInfoManager_getUserWangtsVO',
		data : {
			'newUser.user_id':userId
		},
		cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
		success : function(result) {
			var goodsPicVO = JSON.parse(result);
			var str = '<ul>'
			if(typeof(goodsPicVO.listGoodsPicDTO) === "undefined"){
				str = str + '<div class="no-data">'+'<p>'+'您没有收藏任何二货哦~'+'</p>'+'</div>'+'</ul>'
				 $(".fr").html(str)
			}else{
				var length = goodsPicVO.listGoodsPicDTO.length;
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
							+ '" href="javaScript:;" class="delete" onClick="deleteUserWant(this)">'
							+ '删除' + '</a>' + '</div>' + '</div>'
							+ '</li>'
				}
				str = str + '</ul>'
				
				$(".fr").html(str);
			}
		}
	})
	
}

//删除我收藏的商品
function deleteUserWant(e){
	var goodsId = e.id 
	$
			.ajax({
				async : false,
				type : 'POST',
				url : '/fleaMarketSystem/goodsInfoManager/goodsInfoManager_deleteGoodsUserWant',
				data : {
					"data_id" : goodsId
				},
				cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
				success : function(result) {
					toastr.success("删除成功!");
					setTimeout(function() {
						location.href="/fleaMarketSystem/skip/skip_intoUserWants";
						
					}, 1000);
			   }
              })
}







//页面跳转
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
