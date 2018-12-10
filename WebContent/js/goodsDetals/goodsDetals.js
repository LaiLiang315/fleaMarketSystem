//点击菜单栏时局部刷新页面
$(document).ready(function() {
	console.log('dd:' + $('#hh').val());
	// var data_id = '${data_id}';
	// console.log(data_id)
	// alert("data_id"+data_id)
	// console.log("data_id"+data_id)
	// getuser()
	$(".warp").hide();
	$(".detals").show();
	putDetal()
	showIndex()
});

// 将详情页新信息放入
function putDetal() {
	var goodsId = $("#hh").val()
	// 获取商品图片
	$
			.ajax({
				async : false,
				type : 'POST',
				url : '/fleaMarketSystem/goodsInfoManager/goodsInfoManager_getPicsByGoodsId',
				data : {
					'data_id' : goodsId,
				},
				cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
				success : function(result) {
					console.log("listPics" + result)
					var listPics = JSON.parse(result)

					if (listPics.length > 0) {
						// 把图片塞入对应位置
						var str = "";
						str = '<a>'
								+ '<img src="/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName='
								+ listPics[0].picture_name
								+ '" style="width:100%" />' + '</a>'
						$("#gallery").html(str);
						// console.log("MMM" + $("#gallery").html())
						// var strart="";
						// strart = '<h3>'+'"'+ +'"'+'</h3>'

						// 调用获取商品信息
						getGoods(goodsId)
					}
				}
			})
}

// 获取商品信息
function getGoods(goodsId) {
//	alert("gb")
	$
			.ajax({
				async : false,
				type : 'POST',
				url : '/fleaMarketSystem/goodsInfoManager/goodsInfoManager_getgoodsInfoByGoodsId',
				data : {
					'data_id' : goodsId,
				},
				cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
				success : function(result) {
					console.log("BBCC" + result)
					var goodsInfo = JSON.parse(result);
					var str = "";
					str = '<h3>'
							+ goodsInfo.goods_name
							+ '</h3>'
							+ '<small>'
							+ goodsInfo.goods_state
							+ '</small>'
							+ '<hr class="soft"/>'
							+ '<form class="form-horizontal qtyFrm">'
							+ '<div class="control-group">'
							+ '<label class="control-label"> <span>'
							+ goodsInfo.goods_price
							+ '</span></label>'
							+ '<div class="controls">'
							+ '<button type="submit" class="btn btn-large btn-primary pull-right">'
							+ 'Add to cart' + '<i class=" icon-shopping-cart">'
							+ '</i> </button>' + '</div>' + '<div>' + '</form>'
							+ '<hr class="soft clr"/>' + '<p>'
							+ goodsInfo.goods_describe + '</p>'
							+ '<a class="btn btn-small pull-right" href="">'
							+ 'More Details' + '</a>' + '<br class="clr"/>'
							+ '<hr class="soft"/>'
					$("#infomation").html(str);
				}
			})
}

// 点击菜单栏显示菜单
function showIndex() {
$("#sideManu").on("click",function(){
	alert("1111")
	$(".warp").show();
	$(".detals").hide();
	
	
})
	
}

// 得到当前登陆的用户
function getuser() {
	$.ajax({
		async : false,
		type : 'POST',
		url : '/fleaMarketSystem/loginRegister/loginRegister_getSes',
		cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
		processData : false, // 不序列化data
		contentType : false,
		success : function(result) {
//			alert("SESSION")
			console.log("SESSION" + result)
			var sessin = JSON.parse(result)
		}
	})

}

// 得到商品详情图片
function getDetalsPic() {
	// $("#gallery")
	var str = "";

}
