$(document).ready(function() {
	
});

////获取session
//function getSession(){
//	var session =session.getAttribute("user_session")
//	console.log("ss"+session)
//	
//}


//$('body').on('hidden.bs.modal', '.modal', function () {
//	alert("jjjjj")
//    $(this).removeData('bs.modal'); 
//});
//登陆
$(document).on("click","#Sign",function() {
	
	var username = $("input[id='inputEmail']").val();
	var password = $("input[id='inputPassword']").val();
	console.log("1"+username)
	console.log("2	"+password)
	if(username==""||username==null||!(/^1[34578]\d{9}$/.test(username))){
		toastr.error("请输入正确的手机号!");
	}else if(password==""||password==null){
		toastr.error("请填写密码!");}
	console.log("点击了提交按钮");
	login_ajax(); // 执行login的异步
				})
//登陆验证
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
//					$("input[id='inputPassword']").val('')
				}
			}
		}
	})
}

function resale(){
	var str ='<ul>';
	str = str + '<li>'+'<a href="#register" role="button" data-toggle="modal" style="padding-right: 0">'+'<span>'+'一键转卖'+'</span>'+'</a>'+'</li>'
	alert("str")
	$("#topMenu").html(str)
}

//点击一键转卖
$(document).on("click",".reSale",function(){
	alert("一键转卖")
	location.href="/fleaMarketSystem/skip/skip_intoUpLoadPic";
	
})


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
//用户注销登陆
function loginOut(){
//	layer.confirm('确认退出吗？',function(){
		$.ajax({
			url:"/fleaMarketSystem/loginRegister/loginRegister_loginOut",
			type: "post",
	        //报错请加入以下三行，则ajax提交无问题
	        cache: false,  
	        processData: false,  
	        contentType: false,
	        success: function(result){
	        	if(result=="logoutSuccess"){
	        		console.log("010211");
	        		toastr.success("成功退出!");
	        		setTimeout(function() {
	           		 location.href="/fleaMarketSystem/skip/skip_intoIndex";
				        }, 500);
	        	}
	        }
		});
//	});
	
	
}

//鼠标悬停显示
$("#ss").mouseover(function(){
	$(".dropdown-menu").css('display','block')
	
	
})
//鼠标离开事件
$(".dropdown").mouseleave(function(){
	$(".dropdown-menu").css('display','none')
		
	})

//鼠标点退出登陆
$("#quite").on("click",function(){
	loginOut()
})


//用户注册
function register_ajax(){
	
	
}





