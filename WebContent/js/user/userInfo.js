var userId ="";
var user="";
$(document).ready(function() {
	// 获取当前登陆的用户
	getuser()
	// if(!user || typeof(user) =="undefined" || user == null){
	// toastr.error("非法登陆，正在退出");
	// setTimeout(function(){
	// window.location.href = "/fleaMarketSystem/skip/skip_intoIndex";
	// },1000);
	// }
getheadPic()
//$(".user-info").childen("img").attr("src",)
});

//得到头像
function getheadPic(){
	var dd = user.headportrait;
	console.log("nnn"+$(".user-info").children("img").html())
	$("#headPic").attr("src","/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName="+dd);
	$(".user-info").children("img").attr("src","/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName="+dd);
}

$("#myInfo").click(function(){
	
	location.href="/fleaMarketSystem/skip/skip_intoUserInfo";
})

$("#myPublish").click(function(){
	
	location.href="/fleaMarketSystem/skip/skip_intoUser";
})

$("#myWants").click(function(){
	
//	location.href="/fleaMarketSystem/skip/skip_intoWants";
})

//var newUser = $("#user").val();
//console.log(newUser)
// 得到当前登陆的用户
function getuser() {
	$.ajax({
		async : false,
		type : 'POST',
		url : '/fleaMarketSystem/loginRegister/loginRegister_getSes',
		cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
		dataType : "text",
		success : function(result) {
			var jsonData = JSON.parse(result);
			user = jsonData.session.attributes.user_session
			userId = jsonData.session.attributes.user_session.user_id;
			console.log("user:"+result)
		}
	})
}

$('.userinfo-submit').click(function(){
	if($('input[name=sex]:checked').length != 1){
		return layer.tips('请选择性别', '.sex-wrap')
	}
})
console.log("j"+userId)
//上传头像
layui
		.use(
				'upload',
				function() {
					console.log("Z"+userId)
//					var $ = layui.jquery, upload = layui.upload;
					var upload = layui.upload;
					// 普通图片上传
					var uploadInst = upload
							.render({

								elem : '#test1',
								url : '/fleaMarketSystem/carouselManager/carouselManager_uploadPic',
								accept : 'images',
								data : {
									'user.user_id' : userId
								},
								bindAction : '#testListAction' // 指向一个按钮触发上传
								,
								auto : false // 不自动上传
//								,dataType : "josn"
								,
								choose : function(obj) {
									var files = this.files = obj.pushFile(); // 将每次选择的文件追加到文件队列
								
									obj.preview(function(index, file, result) {
										alert("zzz")
										console.log("LLL"+file)
										$('#headPic').attr('src', result); // 图片链接（base64）
									    $(".user-header").attr('src',result); 
									
									});
								}
								,done : function(res,index,upload) {
									console.log("LLL"+res.fileFileName)
									// 上传成功
									location.href="/fleaMarketSystem/skip/skip_intoUserInfo";
								},
								before : function(obj) {
									console.log("+++"+userId)
									// 预读本地文件示例，不支持ie8
									
								}
								,error : function() {
									alert("KK")
								}
							});
				});