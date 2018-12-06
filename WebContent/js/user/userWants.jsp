<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

    	<div id="header">
		<div class="container">
			<div id="welcomeLine" class="row">
						<div class="span6" >
								
						</div>


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
				<div style="position: relative;"class="dropdown">
					<ul id="topMenu" class="nav pull-right ">
						<li><label style="margin-top: 26px; color: white;">
								欢迎! <strong style="color: white;">
									${user_session.nickname }</strong>
						</label></li>

						<li><a role="button" href="#" id="ss"><img
								class="img-circle " style="width: 50px; height: 50px;"
								src="${pageContext.request.contextPath}/themes/img/1.jpg" alt="" /></a>
						</li>
						<!-- <li class="resale"><a href="#resale" role="button"
							data-toggle="modal" style="padding-right: 0"><span
								class="btn btn-large btn-success">一键转卖</span></a></li> -->
					</ul>
				<div style="position: absolute;">
				<ul class="dropdown-menu"
					style="z-index: 20;  display: ; left: 988.4px; top: 68px">
					<li id="myPage"><a href="#">个人主页</a></li>
					<li id=""><a href="#">历史订单</a></li>
					<li id=""><a href="#">购 &nbsp;物&nbsp;车</a></li>
					<li id="quite"><a href="#">注 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;销</a></li>

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
		<img src="/upload/avatar/201812/upload_251f03b5e11346d689f6c2ebf63d5821.jpg" class="user-header">
		<a href="/user/userinfo" class="username">用户7292</a>
		<div class="auth">
			<a class="realname-auth" href="/user/auth"><i class="icon" title="未实名认证"></i></a>
			<a class="phone-auth" href="/user/auth"><i class="icon" style="color:#f40;" title="已绑定手机"></i></a>
			<a class="email-auth" href="/user/auth"><i class="icon" title="未绑定邮箱"></i></a>
		</div>
	</div>
	<div class="sider-nav">
		<ul>
			<li><a href="/user/index" class=""><i class="icon"></i>我发布的</a></li>
			<li><a href="/user/want" class="active"><i class="icon"></i>我想要的</a></li>
			<li><a href="/user/message" class=""><i class="icon"></i>我的留言</a></li>
			<li><a href="/user/userinfo" class=""><i class="icon"></i>个人信息</a></li>
			<li><a href="/user/auth" class=""><i class="icon"></i>实名认证</a></li>
			<li><a href="/user/help" class=""><i class="icon"></i>意见反馈</a></li>
		</ul>
	</div>
</div>
		<div class="user-main fr">
			<ul>
				<!-- <li>
					<div class="list-header">
						<span>时间：2016-12-12</span>
					</div>
					<div class="list-main clearfix">
						<a href="" class="goods-images fl"><img src="/images/web/user/default.png" ></a>
						<div class="good-info fl">
							<a href="" class="goods-title">我的商品的标题我的商品的标题</a>
							<p class="goods-price">￥<span>3.00</span></p>
						</div>
						<div class="operation fr">
							<a href="" class="">查看详情</a>
							<a href="" class="">移除想要</a>
						</div>
					</div>
				</li> -->
				
				<div class="no-data">
					<p>您没有收藏任何二货哦~</p>
				</div>
				
			</ul>
			<div id="page"></div>
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
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/toastr.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/loginRegister/loginRegister.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/user/userInfo.js"></script>
</html>