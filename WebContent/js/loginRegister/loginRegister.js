//登陆
$(document).on("click","#Sign",function() {
	var username = $("input[id='inputEmail']").val();
	var password = $("input[id='inputPassword']").val();
	if(username==""||username==null||!(/^1[34578]\d{9}$/.test(username))){
		toastr.error("请输入正确的手机号!");
	}else if(password==""||password==null){
		toastr.error("请填写密码!");}
	console.log("点击了提交按钮");
	login_ajax(); // 执行login的异步

				})

function login_ajax() {
	console.log("此对话显示该js正在执行login_ajax");
	
	var username = $("input[id='inputEmail']").val();
	var password = $("input[id='inputPassword']").val();
	console.log("username===" + username);
	console.log("username===" + password);
	var formData = new FormData();
	formData.append("newUser.username", username);
	formData.append("newUser.password", password); 
	$.ajax({
		url : "/fleaMarketSystem/loginRegister/loginRegister_login",
		type : "post",
		data : formData, // 前台传给后台的数据
		// 报错请加入以下三行，则ajax提交无问题
		cache : false,
		processData : false,
		contentType : false,
		success : function(result) {
			alert("---")
			var dd = result;
//			var dd = JSON.parse(result); // 转换成json对象
			console.log("result----" + result);
			if (dd == "success") {
				console.log("===="+username);
				toastr.success("用户登陆成功!");
				
				
				setTimeout(function() {
					location.href="/fleaMarketSystem/skip/skip_intoIndex";
				}, 1000);
			} else {
				if (dd == "error") {
					toastr.error("用户账户或密码输入错误!");
					$("input[id='inputPassword']").val('')
				}
			}
		}
	})
}
//得到用户
function getUser(username){
	$.ajax({
		type : "POST",
		url : "/fleaMarketSystem/loginRegister/loginRegister_getUserByUserName",
		
		data : {'newUser.username':username},
		cache : false,
		success : function(result){
			console.log("MMM"+result)
			var user = JSON.parse(result);
			console.log("MMM"+user)
			$("strong").html(user.nickname);
		}
		
	})
}

$

















//var str = '<div id="login" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="login" aria-hidden="true">'
//+ '<div class="modal-header">'
//
//+ '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">'
//+ '×'
//+ '</button>'
//+ '<h3>'
//+ 'Login Block'
//+ '</h3>'
//+ '</div>'
//+ '<div class="modal-body">'
//+ '<form class="form-horizontal loginFrm">'
//+ '<div class="control-group">'
//+ '<input type="text" id="inputEmail" placeholder="Email">'
//+ '</div>'
//+ '<div class="control-group">'
//+ '<input type="password" id="inputPassword" placeholder="Password">'
//+ '</div>'
//+ '<div class="control-group">'
//+ '<label class="checkbox">'
//+ '<input type="checkbox">'
//+ 'Remember me'
//+ '</label>' + '</div>'
//+'</form>'
//+'<button id="Sign in" type="submit" class="btn btn-success">'
//+'Sign in'
//+'</button>'
//+'<button class="btn" data-dismiss="modal" aria-hidden="true">'
//+'Close'
//+'</button>'
//+'</div>'
//+'</div>'