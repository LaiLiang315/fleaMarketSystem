<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>二手市场</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link id="callCss" rel="stylesheet"
	href="${pageContext.request.contextPath }/themes/bootshop/bootstrap.min.css"
	media="screen" />
<link href="${pageContext.request.contextPath }/themes/css/base.css"
	rel="stylesheet" media="screen" />
<!-- Bootstrap style responsive -->
<link
	href="${pageContext.request.contextPath }/themes/css/bootstrap-responsive.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath }/themes/css/font-awesome.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/css/page.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<input id="hh" type="hidden" value="${data_id }"/>
	<div id="header">
		<div class="container">

			<div id="welcomeLine" class="row">
				<div class="span6" style="">
					欢迎!<strong> ${user_session.nickname }</strong> <a href="#"><img
						class="img-circle " style="width: 50px; height: 50px;"
						src="${pageContext.request.contextPath}/themes/img/1.jpg" alt="" /></a>
				</div>
			</div>
			<!-- Navbar ================================================== -->
			<div id="logoArea" class="navbar">
				<a id="smallScreen" data-target="#topMenu" data-toggle="collapse"
					class="btn btn-navbar"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a>
				<div class="navbar-inner">
					<a class="brand" href="index.html"><img
						src="themes/images/logo.png" alt="Bootsshop" /></a>
					<form class="form-inline navbar-search" method="post"
						action="products.html">
						<input id="srchFld" class="srchTxt" type="text" /> <select
							class="srchTxt">
							<option>All</option>
							<option>CLOTHES</option>
							<option>FOOD AND BEVERAGES</option>
							<option>HEALTH & BEAUTY</option>
							<option>SPORTS & LEISURE</option>
							<option>BOOKS & ENTERTAINMENTS</option>
						</select>
						<button type="submit" id="submitButton" class="btn btn-primary">Go</button>
					</form>
					<ul id="topMenu" class="nav pull-right">
						<li class=""><a href="#login" role="button"
							data-toggle="modal" style="padding-right: 0"><span
								class="btn btn-large btn-danger">退出登陆</span></a>
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
									<button type="submit" class="btn btn-success">Sign in</button>
									<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
								</div>
							</div></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- Header End====================================================================== -->
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
				</div>
				<!-- Sidebar end=============================================== -->


				<div class="span9">

					<div class="detals">
						<ul class="breadcrumb">
							<li><a href="index.html">Home</a> <span class="divider">/</span></li>
							<li><a href="products.html">Products</a> <span
								class="divider">/</span></li>
							<li class="active">product Details</li>
						</ul>
						<div class="row">
							<div id="gallery" class="span3">
       
		                   	</div>
						    <div id="infomation" class="span6">
						    
						    </div> 
						
						</div>
                         


					</div>


					<div class="warp" style="display: none;">
						<!-- Cheapest Goods ================================================================== -->
						<div class="well well-small">
							<h4>
								Cheapest Goods <small class="pull-right"> </small>
							</h4>
							<div class="row-fluid">
								<div id="featured" class="carousel slide">
									<div id="cheapestGoods" class="carousel-inner"></div>
									<a class="left carousel-control" href="#featured"
										data-slide="prev">‹</a> <a class="right carousel-control"
										href="#featured" data-slide="next">›</a>
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
	</div>
	<!-- MainBody End ============================= -->
	<!-- Placed at the end of the document so the pages load faster ============================================= -->
	<script src="${pageContext.request.contextPath}/themes/js/jquery.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/themes/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/menu/menu.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/js/menu/goodsInfoList.js"
		type="text/javascript"></script>
		<script
		src="${pageContext.request.contextPath}/js/goodsDetals/goodsDetals.js"
		type="text/javascript"></script>

	<script
		src="${pageContext.request.contextPath }/themes/js/jquery.lightbox-0.5.js"></script>

</body>
</html>