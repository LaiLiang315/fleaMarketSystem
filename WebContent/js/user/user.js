var username="";
var newUser="";
$(document).ready(function() {
	// 获取当前登陆的用户
	getuser()
	 if(!user || typeof(user) =="undefined" || user == null){
	 toastr.error("非法登陆，正在退出");
	 setTimeout(function(){
	 window.location.href = "/fleaMarketSystem/skip/skip_intoIndex";
	 },1000);
	 }
   
    
//$(".user-info").childen("img").attr("src",)
});
//更新session
function getNewUser() {
	$.ajax({
		async : false,
		type : 'POST',
		url : '/fleaMarketSystem/loginRegister/loginRegister_getNewSes',
		data :{ 'newUser.username' : username}
		,cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
		dataType : "text",
		success : function(result) {
			var jsonData = JSON.parse(result);
			newUser = jsonData.session.attributes.user_session
//			userId = jsonData.session.attributes.user_session.user_id;
			console.log("qa:"+result)
			 getheadPic()
		}
	})
}
//得到头像
function getheadPic(){
	var dd = newUser.headportrait;
	
if(dd==undefined){
		
	}else{
	$("#headPic").attr("src","/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName="+dd);
	$(".user-info").children("img").attr("src","/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName="+dd);
    $("#ss").children("img").attr("src","/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName="+dd);
	}
//	console.log("nnn"+$(".user-info").children("img").html())
//	$("#headPic").attr("src","/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName="+dd);
//	$(".user-info").children("img").attr("src","/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName="+dd);
//    $("#ss").children("img").attr("src","/fleaMarketSystem/carouselManager/carouselManager_IoReadImage?fileFileName="+dd);

}

//得到当前登陆的用户
function getuser() {
	$.ajax({
		async : false,
		type : 'POST',
		url : '/fleaMarketSystem/loginRegister/loginRegister_getSes',
		cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
		dataType : "text",
		success : function(result) {
			var jsonData = JSON.parse(result);
            var sess = jsonData.session.attributes.user_session
			if(typeof(sess) =="undefined"){
			toastr.error("非法登陆，正在退出");
			 setTimeout(function(){
			 window.location.href = "/fleaMarketSystem/skip/skip_intoIndex";
			 },1000);	
		}else{
			user = jsonData.session.attributes.user_session
			userId = jsonData.session.attributes.user_session.user_id;
			username = jsonData.session.attributes.user_session.username
			getNewUser()
		}
		}
	})
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