<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>uploadPicture</title>

<link  rel="stylesheet"
	href="${pageContext.request.contextPath }/themes/bootshop/bootstrap.min.css"
	 />
	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/layui/css/layui.css"  />
	<link href="${pageContext.request.contextPath }/themes/css/base.css"
	rel="stylesheet" media="screen" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/publish.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css" />
	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/toastr.css">
	<style type="text/css">
		input[type="text"]{ height: 38px }
		input[readonly]{cursor: pointer ;background-color: #ffffff;}
	</style>
</head>
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
				<form class="form-inline navbar-search" method="post"
					action="products.html">
					<input id="srchFld" class="srchTxt" type="text"
						style="height: 30px" /> <select class="srchTxt">
						<option>所有</option>
						<option>手机数码</option>
						<option>生活百货</option>
						<option>书集资料</option>
						<option>健身器材</option>
						<option>美妆</option>
					</select>
					<button type="submit" id="submitButton" class="btn btn-primary">确定</button>
				</form>
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
<div id="main" class="clearfix" style="width: 1170px">
			<h2>发布 闲置</h2>
			<div class="publish-main layui-form layui-form-pane">
				<div class="input-line image" id="test2" >
					<div class="layui-box layui-upload-button" id="test1"style="float:left;cursor:pointer;">
						<!-- <input class="layui-upload-file info-img-upload"> -->
						<span class="layui-upload-icon">
						<i class="layui-icon"></i>上传图片
						</span></div>
				</div>
				
				<div class="layui-form-item input-line"style="padding-top:40px">
					<label class="layui-form-label">商品名称</label>
					<div class="layui-input-inline" style="width: 390px;">
						<input type="text" name="goods_name" placeholder="请输入商品名称" class="layui-input userName">
					</div>
					<div class="layui-form-mid layui-word-aux">14个字以内</div>
				</div>
				<div class="layui-form-item layui-form-text input-line">
					<label class="layui-form-label good-description">商品详情</label>
					<div class="layui-input-block">
						<textarea id="goods_describe" name="goods_describe" placeholder="请输入商品详情" class="layui-textarea goods-des"></textarea>
					</div>
				</div>
				<div class="layui-form-item input-line">
					<label class="layui-form-label">分类</label>
					<div class="layui-input-inline">
						<select name="goodsInfo.goods_type" id="selectTypes" class="userGrade" lay-filter="userGrade">

						</select>
					</div>
				</div>
				<div class="layui-form-item input-line" id="price">
					<label class="layui-form-label">价格</label>
					<div class="layui-input-inline">
						<input type="text" name="goods_price" autocomplete="off" placeholder="请输入价格" class="layui-input price">
					</div>
					<div class="layui-form-mid layui-word-aux">元　　　</div>
				</div>
				
				
				<div class="layui-form-item input-line">
					<label class="layui-form-label">交易方式</label>
					<div class="layui-input-block">
						<input type="radio" class="buyMethod" name="transactionMode" value="1" title="线下交易">
						<div class="layui-unselect layui-form-radio"><i class="layui-anim layui-icon"></i><span>线下交易</span></div>
						<input type="radio" class="buyMethod" name="transactionMode" value="2" title="在线交易/线下交易" checked="">
						<div class="layui-unselect layui-form-radio layui-form-radioed"><i class="layui-anim layui-icon"></i><span>在线交易/线下交易</span></div>
					</div>
				</div>
				<div class="layui-form-item input-line" id="address">
					<label class="layui-form-label">交易地址</label>
					<div class="layui-input-block">
						<input type="text" name="title" autocomplete="off" placeholder="请输入交易地址" class="layui-input goods-address">
					</div>
				</div>
				<div class="layui-form-item input-line" id="phoneNumber">
				
					<label class="layui-form-label">手机号</label>
					<div class="layui-input-inline">
						<input type="text" name="title" autocomplete="off" placeholder="请输入手机号" class="layui-input phone-number" value="">
					</div>
					<label class="layui-form-label">QQ号</label>
					<div class="layui-input-inline">
						<input type="text" name="title" autocomplete="off" placeholder="请输入QQ号" class="layui-input qq-number">
					</div>
					<label class="layui-form-label">微信号</label>
					<div class="layui-input-inline">
						<input type="text" name="title" autocomplete="off" placeholder="请输入微信号" class="layui-input wx-number">
					</div>
				</div>
				<!-- <div class="layui-form-item input-line" id="qqNumber">
				<label class="layui-form-label">QQ号</label>
				<div class="layui-input-inline">
					<input type="text" name="title" autocomplete="off" placeholder="请输入QQ号" class="layui-input">
				</div>
  			</div>
			<div class="layui-form-item input-line" id="wxNumber">
				<label class="layui-form-label">微信号</label>
				<div class="layui-input-inline">
					<input type="text" name="title" autocomplete="off" placeholder="请输入微信号" class="layui-input">
				</div>
  			</div> -->
				<div style="margin: auto; width: 250px">
					<button type="button" class="layui-btn" id="testListAction" >确认发布</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置信息</button>
				
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
<body>
	
	</body>
	<script type="text/javascript"src="${pageContext.request.contextPath }/js/jquery.1.8.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.plugin.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/toastr.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/upload/upload.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/loginRegister/loginRegister.js" ></script>
</html>