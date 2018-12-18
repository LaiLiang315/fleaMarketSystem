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
	console.log("bn" + goodsId)
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

					if (listPics.length = 1) {
						// 把图片塞入对应位置
						var str = "";
						str = '<a>'
								+ '<img src="/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName='
								+ listPics[0].picture_name
								+ '" style="width:340px;height:90px" />'
								+ '</a>'
								
						$("#gallery").html(str);
						// console.log("MMM" + $("#gallery").html())
						// var strart="";
						// strart = '<h3>'+'"'+ +'"'+'</h3>'

						// 调用获取商品信息
						getGoods(goodsId)
					}else if(listPics.length > 1){
						var str = "";
						str = '<a>'
							+ '<img src="/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName='
							+ listPics[0].picture_name
							+ '" style="width:340px;height:90px" />'
							+ '</a>'
							+ '<a>'
							+ '<img src="/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName='
							+ listPics[1].picture_name
							+ '" style="width:68px;height:90px ;padding-top:10px" />'
							+ '</a>'
					$("#gallery").html(str);
						getGoods(goodsId)
					}
				}
			})
}

// 获取商品信息
function getGoods(goodsId) {
	// alert("gb")
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
							// + '<form class="form-horizontal qtyFrm">'
							+ '<div class="control-group">'
							+ '<label class="control-label"> <span>'
							+ goodsInfo.goods_price
							+ '</span></label>'
							+ '<div class="controls">'
							+ '<button id="'
							+ goodsInfo.goods_id
							+ '" onClick="getMessage(this)" class="btn btn-large btn-primary pull-right">'
							+ '联系卖家'
							+ '<i class=" icon-shopping-cart">'
							+ '</i> </button>'
							+ '</div>'
							+ '<div>' /* + '</form>' */
							+ '<hr class="soft clr"/>'
							+ '<p>'
							+ goodsInfo.goods_describe
							+ '</p>'
							+ '<a class="btn btn-small pull-right" href="javaScript:;">'
							+ 'More Details' + '</a>' + '<br class="clr"/>'
							+ '<hr class="soft"/>'
					$("#infomation").html(str);
				}
			})
}

// 点击菜单栏显示菜单
function showIndex() {
	$("#sideManu").on("click", function() {
		alert("1111")
		$(".warp").show();
		$(".detals").hide();

	})

}
// 得到用户信息
function getMessage(e) {
	var goodsId = e.id;
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
					console.log("gggggg" + result)
					var goodsInfo = JSON.parse(result);
					var str = '';
					str = '<div id="getMessage" class="modal hide fade in" role="dialog" aria-hidden="false"style="display:block;magin:250px 0 0 -100px;text-align:center;">'
							+ '<div class="modal-header">'
							+ '<button type="button" id="sz" class="close" data-dismiss="modal" aria-hidden="true">×</button>'+
							'<h4>联系方式</h4>'
							+ '</div> <div class="modal-body">'
							+ '<p>手机号：'+goodsInfo.user_phoneNum
							+ '</p>'
							+ '<p>QQ号：'+goodsInfo.user_qq + '</p>' + '<p>微信号：'+goodsInfo.user_weixin+ '</p>'+'</div>'
					$("#message").html(str)
					//点击关闭
$("#sz").on("click",function(){
	$("#getMessage").slideToggle();
})
				}
			})
}

// <div class="layui-layer layui-layer-page layer-anim" id="layui-layer1"
// type="page" times="1" showtime="0" contype="object" style="z-index: 19891015;
// top: 112.5px; left: 608px;">
// <div id="" class="layui-layer-content"><div class="user-contect
// layui-layer-wrap" style="display: block;">
// <div class="contect-header">联系方式</div>
// <p>手机号：18635518086</p>
// <p>QQ号：278923146</p>
// <p>微信号：djalemix</p>
// </div></div>
// <span class="layui-layer-setwin">
// <a class="layui-layer-ico layui-layer-close layui-layer-close2"
// href="javascript:;"></a></span>
// <span class="layui-layer-resize"></span></div>

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
			// alert("SESSION")
			console.log("SESSION" + result)
			var sessin = JSON.parse(result)
		}
	})

}

// 得到商品详情图片
function getDetalsPic() {
	// $("#gallery")
	var str = "";
//	<a href="#getmessage" role="button" data-toggle="modal" style="">
}
