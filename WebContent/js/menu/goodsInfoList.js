//筛选类型
var typeId = null
$(document).ready(function() {
	// 获取六条最新商品
	getSixGoods();
	// 按照类型获取四条最新商品
	getCheapestFourTypeGoods();
});
// 获取六条商品信息
function getSixGoods() {
	$
			.ajax({
				async : false,
				type : 'POST',
				url : '/fleaMarketSystem/goodsInfoManager/goodsInfoManager_findFirstPicLatestDTO',
				data : '',
				cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
				processData : false, // 不序列化data
				contentType : false,
				success : function(result) {
					// console.log("GOOD" + result)
					var listGoodsPicDTO = JSON.parse(result)
					putInfo(listGoodsPicDTO)
				}
			})
};

function putInfo(listGoodsPicDTO) {
	console.log("HHHH" + listGoodsPicDTO);

	var length = listGoodsPicDTO.length;
	var strStart = '';
	// getPic(picture_name);
	for (i = 0; i < length; i++) {
		strStart = strStart
				+ '<li>'
				+ '<div class="thumbnail">'
				+ '<a>'
				+ '<img style="width:80px" src="/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName='
				+ listGoodsPicDTO[i].pic.picture_name + '" />' + '</a>'
				+ '<div class="caption">' + '<h5>'
				+ listGoodsPicDTO[i].info.goods_name + '</h5>' + '<p>'
				+ listGoodsPicDTO[i].info.goods_name + '</p>'
				+ '<h4 style="text-align:center">' + '<a class ="btn" >'
				+ '<i class="icon-zoom-in">' + '</i>' + '</a>'
				+ '<a class="btn">' + '购买' + '<i class="icon-shopping-cart">'
				+ '</i>' + '</a>' + '<a class="btn btn-primary">' + '￥'
				+ listGoodsPicDTO[i].info.goods_price + '</a>' + '</h4>'
				+ '</div>'
		strStart = strStart + '</li>'
	}
	strStart = strStart + '</ul>'
	document.querySelector("#latestGoods").innerHTML = strStart;

}

function getCheapestFourTypeGoods() {
	$
			.ajax({
				async : false,
				type : 'POST',
				url : '/fleaMarketSystem/goodsInfoManager/goodsInfoManager_findFourInfoDTO',
				data : '',
				cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
				processData : false, // 不序列化data
				contentType : false,
				success : function(result) {
					// console.log("four" + result)
					var listGoodsManagerDTO = JSON.parse(result)
					putFourInfo(listGoodsManagerDTO)
				}
			})

}

function putFourInfo(listGoodsManagerDTO) {
	var length = listGoodsManagerDTO.length;
	var strStart = ''
	var str = ''
	for (i = 0; i < length; i++) {
		strStart = strStart + '<div class="item'
		if (i == 0) {
			strStart = strStart + " active"
		}
		strStart = strStart + '"><ul>';

		for (j = 0; j < listGoodsManagerDTO[i].listGoodsPicDTO.length; j++) {
			str = strStart
					+ '<li class="span3">'
					+ '<div class="thumbnail">'
					+ '<i class="tag">'
					+ '</i>'
					+ '<a href="">'
					+ '<img src="/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName='
					+ listGoodsManagerDTO[i].listGoodsPicDTO[j].pic.picture_name
					+ '" alt="">'
					+ '</a>'
					+ '<div class="caption">'
					+ '<h5>'
					+ listGoodsManagerDTO[i].listGoodsPicDTO[j].info.goods_name
					+ '</h5>'
					+ '<h4>'
					+ '<a class="btn" href="">'
					+ 'VIEW'
					+ '</a>'
					+ '<span class="pull-right">'
					+ '￥'
					+ listGoodsManagerDTO[i].listGoodsPicDTO[j].info.goods_price
					+ '</span>' + '</h4>' + '</div>' + '</div>'
			strStart = strStart + '</li>'
		}
		strStart = str + '</ul></div>'
	}
	$("#cheapestGoods").html(strStart);
}
////登陆
//$(document).on("click","#Sign",function() {
//	var username = $("input[id='inputEmail']").val();
//	var password = $("input[id='inputPassword']").val();
//	if(username==""||username==null||!(/^1[34578]\d{9}$/.test(username))){
//		toastr.error("请输入正确的手机号!");
//	}else if(password==""||password==null){
//		toastr.error("请填写密码!");}
//	console.log("点击了提交按钮");
//	login_ajax(); // 执行login的异步
//
//				})
//
//function login_ajax() {
//	console.log("此对话显示该js正在执行login_ajax");
//	
//	var username = $("input[id='inputEmail']").val();
//	var password = $("input[id='inputPassword']").val();
//	console.log("username===" + username);
//	console.log("username===" + password);
//	var formData = new FormData();
//	formData.append("newUser.username", username);
//	formData.append("newUser.password", password); 
//	$.ajax({
//		url : "/fleaMarketSystem/loginRegister/loginRegister_login",
//		type : "post",
//		data : formData, // 前台传给后台的数据
//		// 报错请加入以下三行，则ajax提交无问题
//		cache : false,
//		processData : false,
//		contentType : false,
//		success : function(result) {
//			alert("---")
//			var dd = result;
////			var dd = JSON.parse(result); // 转换成json对象
//			console.log("result----" + result);
//			if (dd == "success") {
//				console.log("===="+username);
//				toastr.success("用户登陆成功!");
//				getUser(username)
//				getSixGoods();
//				setTimeout(function() {
//					 location.href="/fleaMarketSystem/skip/skip_intoIndex";
//				}, 1000);
//			} else {
//				if (dd == "error") {
//					toastr.error("用户账户或密码输入错误!");
//					$("input[id='inputPassword']").val('')
//				}
//			}
//		}
//	})
//}
////得到用户
//function getUser(username){
//	$.ajax({
//		type : "POST",
//		url : "/fleaMarketSystem/loginRegister/loginRegister_getUserByUserName",
//		
//		data : {'newUser.username':username},
//		cache : false,
//		success : function(result){
//			console.log("MMM"+result)
//			var user = JSON.parse(result);
//			console.log("MMM"+user)
//			$("strong").html(user.nickname);
//		}
//		
//	})
//	
//	function loginOut(){
//		
//		
//	}
//	
//}
