<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>二手交易市场</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap style -->
<link
	href="${pageContext.request.contextPath }/themes/css/font-awesome.css"
	rel="stylesheet" type="text/css">
<link id="callCss" rel="stylesheet"
	href="${pageContext.request.contextPath }/themes/bootshop/bootstrap.min.css"
	media="screen" />


<link href="${pageContext.request.contextPath }/themes/css/base.css"
	rel="stylesheet" media="screen" />
<!-- Bootstrap style responsive -->
<link
	href="${pageContext.request.contextPath }/themes/css/bootstrap-responsive.min.css"
	rel="stylesheet" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/toastr.css">
<link href="${pageContext.request.contextPath }/css/page.css"
	rel="stylesheet" type="text/css" />

<style type="text/css" id="enject"></style>
</head>
<body>
	<div id="header">
		<div class="container">
			<div id="welcomeLine" class="row">
				<c:choose>
					<c:when test="${user_session eq null}">
						<div class="span6"></div>

					</c:when>
					<c:otherwise>
						<div class="span6" style="">
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
						<input id="srchFld" class="srchTxt" type="text" /> <select
							class="srchTxt">
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
	<!-- Header End====================================================================== -->
	<div id="carouselBlk">
		<div id="myCarousel" class="carousel slide">
			
	</div>
	</div>
	<div id="mainBody">
		<div class="container">
			<div class="row">
				<!-- Sidebar ================================================== -->
				<div id="sidebar" class="span3">
					<div class="well well-small">
						<a id="myCart" href="product_summary.html"><img
							src="${pageContext.request.contextPath}/themes/images/ico-cart.png"
							alt="cart">3 Items in your cart <span
							class="badge badge-warning pull-right">$155.00</span></a>
					</div>
					<ul id="sideManu" class="nav nav-tabs nav-stacked">

					</ul>
					<br />
					<div class="thumbnail" style="text-align: center"></div>
				</div>
				<!-- Sidebar end=============================================== -->
				<div class="span9">
					<!-- Cheapest Goods ================================================================== -->
					<div class="well well-small">
						<h4>
							Cheapest Goods <small class="pull-right"> </small>
						</h4>
						 <div  class="row-fluid">
							<div id="featured" class="carousel slide">
								
							</div>
						</div> 
					</div>
					<!-- Latest Goods ================================================================== -->
					<h4>Latest Goods</h4>
					<ul id="latestGoods" class="thumbnails">

					</ul>
					<!-- 分页 ================================================================== -->

					<div id="pagination" class="pagination"></div>
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
	<!-- Placed at the end of the document so the pages load faster ============================================= -->
	<script src="${pageContext.request.contextPath}/themes/js/jquery.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/themes/js/bootstrap.min.js"
		type="text/javascript"></script>
		<script
		src="${pageContext.request.contextPath}/js/myCarousel/getMyCarousel.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/toastr.js"></script>
	<script src="${pageContext.request.contextPath}/js/menu/menu.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/js/menu/goodsInfoList.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/js/loginRegister/loginRegister.js"
		type="text/javascript"></script>
	
	
	<script
		src="${pageContext.request.contextPath}/themes/js/jquery.lightbox-0.5.js"></script>
</body>
</html>