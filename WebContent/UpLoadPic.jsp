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
				<c:choose>
					<c:when test="${user_session eq null}">
						<div class="span6"></div>

					</c:when>
					<c:otherwise>
						<div class="span6" >
							欢迎!<strong> ${user_session.nickname }</strong>
							 <span id="dropMenu1" data-toggle="dropdown" data-hover="dropdown"><a href="#"><img
									class="img-circle " style="width: 50px; height: 50px;"
									src="${pageContext.request.contextPath}/themes/img/1.jpg"
									alt="" /></a></span>
									<ul class="dropdown-menu" >
        
      </ul> 
								
						</div>

					</c:otherwise>
				</c:choose>

			</div>


			<!-- Navbar ================================================== -->
			<div id="logoArea" class="navbar">
				<a id="smallScreen" data-target="#topMenu" data-toggle="collapse"
					class="btn btn-navbar"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<div class="navbar-inner">
					<a class="brand" href="index.html"><img
						src="${pageContext.request.contextPath}/themes/images/logo.png"
						alt="Bootsshop" /></a>
					<form class="form-inline navbar-search" method="post"
						action="products.html">
						<input id="srchFld" class="srchTxt" type="text" style="height: 30px" />
						 <select class="srchTxt">
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
					<ul id="topMenu" class="nav pull-right">

						<c:choose>
							<c:when test="${user_session eq null}">
								<li class="login"><a href="#login" role="button"
									data-toggle="modal" style=""><span
										class="btn btn-large btn-success">登陆</span></a>
									<div id="login" class="modal hide fade in" tabindex="-1"
										role="dialog" aria-labelledby="login" aria-hidden="false">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">×</button>
											<h3>Login Block</h3>
										</div>
										<div class="modal-body">
											<form class="form-horizontal loginFrm">
												<div class="control-group">
													<input type="text" id="inputEmail" placeholder="Email">
												</div>
												<div class="control-group">
													<input type="password" id="inputPassword"
														placeholder="Password">
												</div>
												<div class="control-group">
													<label class="checkbox"> <input type="checkbox">
														Remember me
													</label>
												</div>

											</form>
											<button id="Sign" type="submit" class="btn btn-success">Sign
												in</button>
											<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
										</div>
									</div></li>

								<li class="register"><a href="#register" role="button"
									data-toggle="modal" style="padding-right: 0"><span
										class="btn btn-large btn-success">注册</span></a></li>
							</c:when>
							<c:otherwise>
								<li class="reSale"><a  role="button"
									 style="padding-right: 0"><span
										class="btn btn-large btn-success">一键转卖</span></a></li>
							</c:otherwise>
						</c:choose>
						<!-- <li class="resale"><a href="#resale" role="button"
							data-toggle="modal" style="padding-right: 0"><span
								class="btn btn-large btn-success">一键转卖</span></a></li> -->
					</ul>
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
						<!--<div class="layui-unselect layui-form-select">
							<div class="layui-select-title"><input type="text" placeholder="请选择分类" value="" readonly="" class="layui-input layui-unselect"><i class="layui-edge"></i></div>
							<dl class="layui-anim layui-anim-upbit">
								<dd lay-value="1" class="">手机</dd>
								<dd lay-value="2" class="">电脑</dd>
								<dd lay-value="4" class="">配件</dd>
								<dd lay-value="5" class="">电器</dd>
								<dd lay-value="6" class="">书籍</dd>
								<dd lay-value="7" class="">娱乐</dd>
								<dd lay-value="8" class="">运动</dd>
								<dd lay-value="9" class="">代步</dd>
							</dl>
						</div>-->
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
<body>
	
	</body>
	<script type="text/javascript"src="${pageContext.request.contextPath }/js/jquery.1.8.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.plugin.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/toastr.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/upload/upload.js"></script>
</html>