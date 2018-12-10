$(document).ready(function() {
});


//注册页面点击登陆按钮
$("#loginIn").on("click",function(){
	location.href="/fleaMarketSystem/skip/skip_intoLogin";
	
})

$(document).on("click","#register",function() {
	var username1 = $("input[name='phoneNum']").val();
	var password1 = $("input[name='password']").val();
	console.log("username1:"+username1)
	console.log("password2:"+password1)
	if(username1==""||username1==null||!(/^1[34578]\d{9}$/.test(username1))){
		toastr.error("请输入正确的手机号!");
	}else if(password1==""||password1==null){
		toastr.error("请填写密码!");}
	register_ajax()
	console.log("点击了提交按钮");
	
})
//function register(){
//	
//}

//用户注册
function register_ajax(){
	var username1 = $("input[name='phoneNum']").val();
	var password1 = $("input[name='password']").val();
	console.log("username1===" + username1);
	console.log("username1===" + password1);
	var formData = new FormData();
	formData.append("newUser.username", username1);
	formData.append("newUser.password", password1); 
	alert("MM")
	$.ajax({
		async : false,
		type : 'POST',
		url : '/fleaMarketSystem/loginRegister/loginRegister_userRegister',
		data : formData, // 前台传给后台的数据
		cache : false, // cache的作用就是第一次请求完毕之后，如果再次去请求，可以直接从缓存里面读取而不是再到服务器端读取。
		processData : false,
		contentType : false,
//		dataType : "josn",
		success : function(result) {
			var KK =JSON.parse(result);
			console.log("nN"+KK)
			if(KK=="注册成功"){
				toastr.success("注册成功，请登陆!");
				
			}else if(KK=="该用户已存在"){
				toastr.error("该用户已存在请，重新注册!");
				
			}
		}
	})
	
}





