<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户个人信息</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/themes/bootshop/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/layui/css/layui.css" />
<link href="${pageContext.request.contextPath }/themes/css/base.css"
	rel="stylesheet" media="screen" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/publish.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/public.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/user.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/toastr.css">
<style type="text/css">
input[type="text"] {
	height: 38px
}

input[readonly] {
	cursor: pointer;
	background-color: #ffffff;
}
</style>
</head>
<body>
<input id="user" type="hidden" value="${user_session}">
	<div id="header">
		<div class="container">
			<div id="welcomeLine" class="row">
				<div class="span6"></div>


			</div>


			<!-- Navbar ================================================== -->
			<div id="logoArea" class="navbar">
				<a id="smallScreen" data-target="#topMenu" data-toggle="collapse"
					class="btn btn-navbar"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<div class="navbar-inner">
					<a class="brand" href="#"><img
						src="${pageContext.request.contextPath}/themes/images/logo.png"
						alt="Bootsshop" /></a>

					<!--================ 登陆   ==================== -->
					<div style="position: relative;" class="dropdown">
						<ul id="topMenu" class="nav pull-right ">
							<li><label style="margin-top: 26px; color: white;">
									欢迎! <strong style="color: white;">
										${user_session.nickname }</strong>
							</label></li>

							<li><a role="button" href="#" id="ss"><img
									class="img-circle " style="width: 50px; height: 50px;"
									src="${pageContext.request.contextPath}/themes/img/1.jpg"
									alt="" /></a></li>
							<!-- <li class="resale"><a href="#resale" role="button"
							data-toggle="modal" style="padding-right: 0"><span
								class="btn btn-large btn-success">一键转卖</span></a></li> -->
						</ul>
						<div style="position: absolute;">
							<ul class="dropdown-menu"
								style="z-index: 20; display:; left: 988.4px; top: 68px">
								<li id="myPage"><a href="#">个人主页</a></li>
								<li id=""><a href="#">历史订单</a></li>
								<li id=""><a href="#">购 &nbsp;物&nbsp;车</a></li>
								<li id="quite"><a href="#">注
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;销</a></li>

							</ul>
						</div>
					</div>
					<!--================ 登陆结束   ==================== -->
				</div>

			</div>
		</div>
	</div>
	<div id="main" class="clearfix">
		<div class="user-sider fl">
			<div class="user-info">
				<img src="/images/web/user/default.png" class="user-header"> <a
					href="/user/userinfo" class="username">${user_session.nickname }</a>
				<div class="auth">
					<a class="realname-auth" href="/user/auth"><i class="icon"
						title="未实名认证"></i></a> <a class="phone-auth" href="/user/auth"><i
						class="icon" style="color: #f40;" title="已绑定手机"></i></a> <a
						class="email-auth" href="/user/auth"><i class="icon"
						title="未绑定邮箱"></i></a>
				</div>
			</div>
			<div class="sider-nav">
				<ul>
					<li id="myPublish"><a href="javaScript:;" class=""><i class="icon"></i>我发布的</a></li>
					<li id="myWants"><a href="javaScript:;" class=""><i class="icon"></i>我想要的</a></li>
					<li><a href="javaScript:;" class=""><i class="icon"></i>我的留言</a></li>
					<li id="myInfo"><a href="javaScript:;" class="active"><i
							class="icon"></i>个人信息</a></li>
					<li><a href="" class="javaScript:;"><i class="icon"></i>实名认证</a></li>
					<li><a href="" class="javaScript:;"><i class="icon"></i>意见反馈</a></li>
				</ul>
			</div>
		</div>
		<div class="user-main userinfo fr" >
			<div class="layui-form">
				<div class="layui-form-item">
					<label class="layui-form-label picture-para">头像</label>
					<div class="layui-input-block">
						<img id="headPic" src="" class="user-info-picture"style="float:left">
						<div class="layui-box layui-upload-button"style="position:relative">
								<input id="dddd" type="file" name="avatar" lay-type="images"
									class="change-picture" value="修改头像" style="display:none;">
							<span style="border:1px solid green;line-height:36px;float:left;margin:30px 40px " id="test1" class="layui-upload-icon">
							<i class="layui-icon"></i>上传图片</span>
							
						</div>
					</div>
				</div>
				<script>
					function ddd(){
						$("#dddd").click();
					}
				</script>
				<div class="layui-form-item">
					<label class="layui-form-label"><em>*</em> 昵称</label>
					<div class="layui-input-inline">
						<input type="text" name="nick-name" autocomplete="off"
							class="layui-input nick-name" value="${user_session.nickname }">
					</div>
					<div class="layui-form-mid layui-word-aux">3-16位
						汉字、数字、字母（大小写）、下划线组成</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><em>*</em> 性别</label>
					<div class="layui-input-inline sex-wrap">
						<input type="radio" name="sex" value="男" title="男">
						<div class="layui-unselect layui-form-radio">
							<i class="layui-anim layui-icon"></i><span>男</span>
						</div>
						<input type="radio" name="sex" value="女" title="女">
						<div class="layui-unselect layui-form-radio">
							<i class="layui-anim layui-icon layui-anim-scaleSpring"></i><span>女</span>
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">生日</label>
					<div class="layui-input-inline">
						<input class="layui-input birthday" placeholder=""
							onclick="layui.laydate({elem: this})" value="">
					</div>
					<div class="layui-form-mid layui-word-aux">（该信息其他人不可见）</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">地址</label>
					<div class="layui-input-block">
						<input type="text" name="signature" autocomplete="off"
							class="layui-input signature" value="" style="width: 79%;">
					</div>
				</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label"></label>
					<div class="">
						<a  id="testListAction" class="userinfo-submit layui-btn">保存修改</a>
					</div>
				</div>
			</div>
		</div>
	<!-- Footer ================================================================== -->
	<div id="footerSection">
		<div class="container">
			<div class="row">
				<div class="span3">
					<h5>ACCOUNT</h5>
					<a href="login.html">YOUR ACCOUNT</a> <a href="login.html">PERSONAL
						INFORMATION</a> <a href="login.html">ADDRESSES</a> <a
						href="login.html">DISCOUNT</a> <a href="login.html">ORDER
						HISTORY</a>
				</div>
				<div class="span3">
					<h5>INFORMATION</h5>
					<a href="contact.html">CONTACT</a> <a href="register.html">REGISTRATION</a>
					<a href="legal_notice.html">LEGAL NOTICE</a> <a href="tac.html">TERMS
						AND CONDITIONS</a> <a href="faq.html">FAQ</a>
				</div>
				<div class="span3">
					<h5>OUR OFFERS</h5>
					<a href="#">NEW PRODUCTS</a> <a href="#">TOP SELLERS</a> <a
						href="special_offer.html">SPECIAL OFFERS</a> <a href="#">MANUFACTURERS</a>
					<a href="#">SUPPLIERS</a>
				</div>
				<div id="socialMedia" class="span3 pull-right">
					<h5>SOCIAL MEDIA</h5>
					<a href="#"><img width="60" height="60"
						src="themes/images/facebook.png" title="facebook" alt="facebook" /></a>
					<a href="#"><img width="60" height="60"
						src="themes/images/twitter.png" title="twitter" alt="twitter" /></a>
					<a href="#"><img width="60" height="60"
						src="themes/images/youtube.png" title="youtube" alt="youtube" /></a>
				</div>
			</div>
			<p class="pull-right">&copy; Bootshop</p>
		</div>
		<!-- Container End -->
	</div>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.1.8.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.plugin.min.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath }/layui/layui.js"></script>
<%-- <script type="text/javascript"
	src="${pageContext.request.contextPath }/layui/layui.all.js"></script> --%>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/toastr.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/loginRegister/loginRegister.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/user/userInfo.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/user/allcity.js"></script>
	


</html>