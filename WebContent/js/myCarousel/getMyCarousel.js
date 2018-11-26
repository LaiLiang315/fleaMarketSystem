$(document).ready(function() {
	// 大轮播图自动播放
	$('#myCarousel').carousel({
		interval : 4000
	})
	// 得到轮播图
	getCarousel()
	
	getPersonInfo()
	
})

function getCarousel() {
	$
			.ajax({
				async : false,
				type : 'POST',
				url : '/fleaMarketSystem/carouselManager/carouselManager_findCarousels',
				data : '',
				cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
				processData : false, // 不序列化data
				contentType : false,
				success : function(result) {
					console.log("GH" + result)
					var myCarousels = JSON.parse(result)
					putCarousels(myCarousels)
				}
			})
}

function putCarousels(myCarousels) {
	var str = '<div class="carousel-inner">';
	var length = myCarousels.length
	console.log("1+++++" + myCarousels[0].carousel_picture)
	for (i = 0; i < length; i++) {
		str = str
				+ '<div class="item">'
				+ '<div class="container">'
				+ '<a>'
				+ '<img style="width: 100%" src="/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName='
				+ myCarousels[i].carousel_picture + '"/>' + '</a>'
				+ '<div class="carousel-caption">' + '<h4>' +'来自火星的商店'+ '</h4>' + '<p>'+'Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.'
				+ '</p>' + '</div>' + '</div>'
		str = str + '</div>'
	}
	str = str
			+ '</div>'
			+ '<a class="left carousel-control" href="#myCarousel" data-slide="prev">'
			+ '&lsaquo;' + '</a>'+'<a class="right carousel-control" href="#myCarousel" data-slide="next">'+'&rsaquo;'+'</a>'
			$("#myCarousel").html(str)
}

function getPersonInfo(){
	
	$("#dropMenu1").hover(function(){
		console.log("bbb"+$(".dropdown-menu").html())
		
		$(".dropdown-menu").addClass("open");
	})
//	,function(){
//		
//		$(".dropdown-header").removeClass("close");
//	}
	
	
}

function getuser(){
	alert("111")
	$.ajax({
		async : false,
		type : 'POST',
		url : '/fleaMarketSystem/loginRegister/loginRegister_getSes',
		cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
		processData : false, // 不序列化data
		contentType : false,
		success : function(result) {
			alert("SESSION")
			console.log("SESSION"+result)
			var sessin = JSON.parse(result)
		}
	})

}

