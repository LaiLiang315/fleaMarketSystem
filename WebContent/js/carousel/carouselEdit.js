var data_id = $("#ss").val();
$(document).ready(function() {
	//得到轮播图
	getCarousel()
});
//得到轮播图
function getCarousel(){
	$.ajax({
		url : "/fleaMarketSystem/carouselManager/carouselManager_findCarousel",//数据传输的目的地址，将在这里对前台数据进行操作
		type : "post",
		data : { "carousel.carousel_id":data_id
		},
		success : function(result) {
			console.log("sdfs"+result)
			var carousel = JSON.parse(result);
			var pic = carousel.carousel_picture
			var str = '<img class="layui-upload-img" id="demo1" src="/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName='+pic+'" style="width:288px;height:288px;"/>'
				$("#carouselList").html(str)
				
			console.log("sdsad")
		}
	})
	
	
}
// 上传轮播图
layui.use('upload', function() {

	// var $ = layui.jquery, upload = layui.upload;
	var upload = layui.upload;
	// 普通图片上传
	var uploadInst = upload.render({

		elem : '#file1',
		url : '/fleaMarketSystem/carouselManager/carouselManager_uploadAndSaveCarousel',
		accept : 'images',
		data : { "data_id":data_id
		},
		bindAction : '#addCarousel' // 指向一个按钮触发上传
		,
		auto : false // 不自动上传
		,
		choose : function(obj) {
			var files = this.files = obj.pushFile(); // 将每次选择的文件追加到文件队列
			obj.preview(function(index, file, result) {
				$('#demo1').attr('src', result); // 图片链接（base64）
				
			});
		},
		before : function(obj) {
		},
		done : function(res, index, upload) {
			toastr.success("修改成功");
			 location.href="/fleaMarketSystem/skip/skip_intoCarouselList";
			
		},
		error : function() {
		}
	});
});


