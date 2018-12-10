

//登陆页面点击注册按钮
$("#register").on("click",function(){
	location.href="/fleaMarketSystem/skip/skip_intoRegister";
	
})

$(document).on("click","#loginInto",function() {
	var username1 = $("input[name='phoneNum']").val();
	var password1 = $("input[name='password']").val();
	console.log("username1:"+username1)
	console.log("password2:"+password1)
	if(username1==""||username1==null||!(/^1[34578]\d{9}$/.test(username1))){
		toastr.error("请输入正确的手机号!");
	}else if(password1==""||password1==null){
		toastr.error("请填写密码!");}
	login_ajax()
	console.log("点击了提交按钮");
	
})
//function register(){
//	
//}

//用户登陆验证
function login_ajax(){
	console.log("此对话显示该js正在执行login_ajax");
	var username1 = $("input[name='phoneNum']").val();
	var password1 = $("input[name='password']").val();
	console.log("username===" + username1);
	console.log("username===" + password1);
	var formData = new FormData();
	formData.append("newUser.username", username1);
	formData.append("newUser.password", password1); 
	$.ajax({
		url : "/fleaMarketSystem/loginRegister/loginRegister_login",
		type : "post",
		data : formData, // 前台传给后台的数据
		// 报错请加入以下三行，则ajax提交无问题
		cache : false,
		processData : false,
		contentType : false,
		success : function(result) {
			var dd = result;
//			var dd = JSON.parse(result); // 转换成json对象
			console.log("result----" + result);
			if (dd == "success") {
				toastr.success("用户登陆成功!");
				setTimeout(function() {
					location.href="/fleaMarketSystem/skip/skip_intoUpLoadPic";
					
				}, 1000);
			} else {
				if (dd == "error") {
					toastr.error("用户账户或密码输入错误!");
				}
			}
		}
	})
	
}





