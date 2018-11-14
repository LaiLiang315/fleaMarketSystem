//筛选类型
var typeId = null
$(document).ready(function() {
	// 获取六条分类信息
	getTypeInfo();
	// 获取所有分类所有商品的图片
	// listGoodsInfo_ajax();
	// 小轮播自动进行
	$('#featured').carousel({
		interval : 4000
	})
});
// 获取分类信息
function getTypeInfo() {
	$.ajax({
		async : false,
		type : 'POST',
		url : '/fleaMarketSystem/goodsType/goodsType_getListGoodsTypeDTO',
		/* data:{"typeOne.TypeOne_id":$("typeOne.TypeOne_name")}, */
		cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
		processData : false, // 不序列化data
		contentType : false,
		success : function(result) {
			var listGoodsTypeDTO = JSON.parse(result)
			putType(listGoodsTypeDTO) //
			getSubMenu(listGoodsTypeDTO) //
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
				+ 'Q" class="subMenu">' + '<a id="'
				+ listGoodsTypeDTO[i].typeOne.typeOne_id + '">'
				+ listGoodsTypeDTO[i].typeOne.typeOne_name + '</a>'
		strStart = strStart + '</li>' + '</ul>'
	}
	strStart = strStart + '</ul>'
	document.querySelector("#sideManu").innerHTML = strStart;

}

// $(' subMenu > a').click(function(e) {
// alert(e)
// });
// 获得二级分类信息

function getTypeTwo(typeOne) {
	console.log("KKK" + typeOne)
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
			// console.log("qqqq")
			// console.log("result" + result)
			var types = JSON.parse(result)
			putTypeTwo(types) // 获取二级分类
		}
	})
};

// 查询分类下拉菜单
function putTypeTwo(types) {
	console.log("HHHHGGG" + types)
	var length = types.length;
	var str = '<ul class="sub" >'
	// 获取二级菜单
	for (j = 0; j < types.length; j++) {
		str = str + '<li  id="' + types[j].type_id
				+ '" class="dd" onClick="getListGoodsInfo(id)">' + '<a>'
				+ types[j].type_name + '</a>' + '</li>'
		//			

		console.log("II" + types[j].type_id)
	}
	str = str + '</ul>'
	//
	console.log("types[0].type_belong" + (types[0].type_belong))
	$("#" + types[0].type_belong + "Q").append(str)

}
function getSubMenu(listGoodsTypeDTO) {
	var subMenuIds = new Array();
	var length = listGoodsTypeDTO.length // 得到类型一长度
	console.log('length' + length)
	for (i = 0; i < length; i++) {

		subMenuIds[i] = listGoodsTypeDTO[i].typeOne.typeOne_id
		console.log("bgbgb" + subMenuIds[i])
		// 点击一级菜单事件
		$('#' + subMenuIds[i] + "Q").on("click", function(e) {

			$(this).children('ul').remove();
			var subMenuChild = $(this).children('ul');// 点击的
			subMenuChild.slideUp(1000);
			subMenuChild.remove()
			var otherSubMenuChild = $(this).siblings().children('ul')
			otherSubMenuChild.slideUp(500);
			$(this).siblings().removeClass('open');
			if ($(this).hasClass('open')) {
				$(this).removeClass('open');
				e.stopPropagation();
			} else {
				$(this).addClass('open');
				subMenuChild.slideDown(500);
				var typeOne = e.target.id;
				getTypeTwo(typeOne); // 调用得到二级菜单
				// e.stopPropagation();
				// e.preventDefault(); //阻止链接打开 url
				console.log("MMMNNBVFGHH" + $(this).html());
				var sub = $(this).parent('li')
				console.log("MMMHH" + sub.html());

			}
		});
	}
}

function listGoodsInfo_ajax() {

};

// 获取所有分类所有商品的图片
function getListGoodsInfo(str) {

	console.log(typeof (str))
	alert("a");
	$
			.ajax({
				type : 'POST',
				url : '/fleaMarketSystem/goodsInfoManager/goodsInfoManager_findAllGoodsByTypeVO',
				data : {
					'typeId.type_id' : str
				},
				cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
				// processData : false, // 不序列化data
				// contentType : false,
				success : function(result) {
					console.log("++++++++++++++++++++")
					console.log("啦啦啦啦啦all了" + result)
					var typeInfoPicVO = JSON.parse(result)
					// getgoodsListPage(goodsManagerVO) //获取所有分类所有商品的图片
					console.log("ig牛逼" + typeInfoPicVO.listGoodsPicDTO)
					Page(typeInfoPicVO);
					getTypeGoodsListAndPage(typeInfoPicVO)
				}
			})
	// 跟据二级菜单得到一级菜单
	getTypeOne(str);

}

function getTypeGoodsListAndPage(typeInfoPicVO) {
	alert("c")
	var length = typeInfoPicVO.listGoodsPicDTO.length;
	console.log("TREDGJIU" + length)
	var strStart = '';
	// getPic(picture_name);
	for (i = 0; i < length; i++) {
		strStart = strStart
				+ '<li>'
				+ '<div class="thumbnail">'
				+ '<a>'
				+ '<img style="width:80px" src="/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName='
				+ typeInfoPicVO.listGoodsPicDTO[i].pic.picture_name + '" />'
				+ '</a>' + '<div class="caption">' + '<h5>'
				+ typeInfoPicVO.listGoodsPicDTO[i].info.goods_name + '</h5>'
				+ '<p>' + typeInfoPicVO.listGoodsPicDTO[i].info.goods_name
				+ '</p>' + '<h4 style="text-align:center">'
				+ '<a class ="btn" >' + '<i class="icon-zoom-in">' + '</i>'
				+ '</a>' + '<a class="btn">' + '<i class="icon-shopping-cart">'
				+ '</i>' + '</a>' + '<a class="btn btn-primary">' + '￥'
				+ typeInfoPicVO.listGoodsPicDTO[i].info.goods_price + '</a>'
				+ '</h4>' + '</div>'
		strStart = strStart + '</li>'
	}
	strStart = strStart + '</ul>'
	document.querySelector("#latestGoods").innerHTML = strStart;

}

// "totalRecords": 5,
// "pageIndex": 1,
// "pageSize": 10,
// "totalPages": 1,
// "havePrePage": false,
// "haveNextPage": false
//获取分页
function Page(typeInfoPicVO) {
	var totalRecords = typeInfoPicVO.totalRecords;
	console.log("1?"+totalRecords)
	var pageIndex = typeInfoPicVO.pageIndex;
	console.log("2?"+pageIndex)
	var pageSize = typeInfoPicVO.pageSize;
	console.log("3?"+pageSize)
	var totalPages = typeInfoPicVO.totalPages;
	console.log("4?"+totalPages)
	var havePrePage = typeInfoPicVO.havePrePage;
	console.log("5?"+havePrePage)
	var haveNextPage = typeInfoPicVO.haveNextPage;
	console.log("6?"+haveNextPage)
	var str = '<ul>'+'<li class="prev">'+"上一页"+'</li>'
		console.log(totalPages)
	for(i=0;i<totalPages;i++){
//		var $li = $("<li>"+(i+1)+"</li>")
            str =str +'<li>'+(i+1)+'</li>'
            
            console.log("<<<>>>"+str)
						if(i===0){
							$("<li>"+(i+1)+"</li>").addClass("active")
						}
			
	}
	str = str +  '<li class="next">'+"下一页"+'</li>'+'</ul>'
	console.log("r"+str)
	$(".pagination").append(str)

$(".prev").on("click",function(){
	if(havePrePage=true){
		
		
	}
	
	
})



}

// 按类型得到商品信息
// function getTypeOfGoods(_ref){
// var pageSize = _ref.pageSize
// curPage = _ref.pageIndex
// totalRecords = _ref.totalRecords
// totalPages = _ref.totalPages
// havePrePage = _ref.havePrePage
// haveNextPage = _ref.haveNextPage
// if(totalRecords >0 &&totalPages>0){
// this.init();
// }else{
// console.error("总页数或者总数据参数不对")
// }
//  
//  
// }
//  
// getTypeOfGoods.prototype = {
// init: function init() {
// var pagination = document.getElementById(this.id);
// pagination.innerHTML = '';
// this.ul.innerHTML = '';
// pagination.appendChild(this.ul);
// var that = this;
// //首页
// that.firstPage();
// //上一页
// that.lastPage();
// //分页
// that.getPages().forEach(function (item) {
// var li = document.createElement('li');
// if (item == that.curPage) {
// li.className = 'active';
// } else {
// li.onclick = function () {
// that.curPage = parseInt(this.innerHTML);
// that.init();
// that.getPage(that.curPage);
// };
// }
// li.innerHTML = item;
// that.ul.appendChild(li);
// });
// }
//  
//  
// }

function getTypeOne(str) {
	console.log("===" + str)
	$
			.ajax({
				type : 'POST',
				url : '/fleaMarketSystem/goodsInfoManager/goodsInfoManager_getTypeOneByTypeId',
				data : {
					'typeId.type_id' : str
				},
				cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
				// processData : false, // 不序列化data
				// contentType : false,
				success : function(result) {
					console.log("哈哈哈哈哈哈哈哈哈哈哈" + result)
					var type = JSON.parse(result)
					getSubMenuAgain(type)
				}
			})
}
function getSubMenuAgain(type) {
	alert("b")
	$('body').on("click", "#'" + type.type_belong + "'", function() {
		alert("jinlaile123456")
		$(this).addClass('open');
		subMenuChild.slideDown(500);
		var typeOne = e.target.id;
		getTypeTwo(typeOne);

	})

}

// console.log("cnm"+goodsManagerVO.listGoodsManagerDTO.listGoodsPicDTO.length)
// console.log("qnm"+goodsManagerVO.listGoodsManagerDTO.length)
// var subIds = new Array();
// for(i=0;i<goodsManagerVO.listGoodsManagerDTO.length;i++){
// alert("bbbbb")
// subIds[i]=goodsManagerVO.listGoodsManagerDTO[i].type.type_id;
// console.log("rnm"+subIds[i])
// 事件委托
// $('#sideManu').on("click", ".sub>li", function(e) {
// alert("GGGFFDDS" + e)
// console.log("MMMNNBVFGHH" + $(this).parents('.subMenu').html());
// $(this).parents('.subMenu').addClass('open');
// var typeId = $(this).attr("id");
// console.log("FFFFDD" + typeId);
// getGoodsListPage(typeId)
// e.stopPropagation();
// })
// huoqu分页
// function getGoodsListPage(typeId) {
// console.log("gg" + typeId);
// $
// .ajax({
// type : 'POST',
// url :
// '/fleaMarketSystem/goodsInfoManager/goodsInfoManager_findAllGoodsByTypeVO',
// data : {
// 'typeId.type_id' : typeId
// },
// cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
// // processData : false, // 不序列化data
// // contentType : false,
// success : function(result) {
// console.log("++++++++++++++++++++")
// console.log("啦啦啦啦啦all了" + result)
// var typeInfoPicVO = JSON.parse(result)
// // getgoodsListPage(goodsManagerVO) //获取所有分类所有商品的图片
// console.log("ig牛逼" + typeInfoPicVO.listGoodsPicDTO.length)
// getTypeOfGoods(typeInfoPicVO);
//						
// }
// })
//
// }

