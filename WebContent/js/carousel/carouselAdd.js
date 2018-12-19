var data_id="";

// 上传轮播图
layui.use('upload', function() {

	// var $ = layui.jquery, upload = layui.upload;
	var upload = layui.upload;
	// 普通图片上传
	var uploadInst = upload.render({

		elem : '#file1',
		url : '/fleaMarketSystem/carouselManager/carouselManager_uploadAndSaveCarousel',
		accept : 'images',
//		data : {"data_id":data_id
//		},
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
			console.log("LLL" + res.fileFileName)
			
			// 上传成功
			 location.href="/fleaMarketSystem/skip/skip_intoCarouselList";
		},
		error : function() {
		}
	});
});