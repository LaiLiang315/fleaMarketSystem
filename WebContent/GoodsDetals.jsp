<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>二手市场</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link id="callCss" rel="stylesheet" href="themes/bootshop/bootstrap.min.css" media="screen"/>
    <link href="themes/css/base.css" rel="stylesheet" media="screen"/>
<!-- Bootstrap style responsive -->	 
	<link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet"/>
	<link href="themes/css/font-awesome.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="header">
<div class="container">
<div id="welcomeLine" class="row">
	<div class="span6">Welcome!<strong> User</strong></div>
	<div class="span6">
	</div>
</div>
<!-- Navbar ================================================== -->
<div id="logoArea" class="navbar">
<a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
	<span class="icon-bar"></span>
	<span class="icon-bar"></span>
	<span class="icon-bar"></span>
</a>
  <div class="navbar-inner">
    <a class="brand" href="index.html"><img src="themes/images/logo.png" alt="Bootsshop"/></a>
		<form class="form-inline navbar-search" method="post" action="products.html" >
		<input id="srchFld" class="srchTxt" type="text" />
		  <select class="srchTxt">
			<option>All</option>
			<option>CLOTHES </option>
			<option>FOOD AND BEVERAGES </option>
			<option>HEALTH & BEAUTY </option>
			<option>SPORTS & LEISURE </option>
			<option>BOOKS & ENTERTAINMENTS </option>
		</select> 
		  <button type="submit" id="submitButton" class="btn btn-primary">Go</button>
    </form>
    <ul id="topMenu" class="nav pull-right">
	 <li class="">
	 <a href="#login" role="button" data-toggle="modal" style="padding-right:0"><span class="btn btn-large btn-danger">退出登陆</span></a>
	<div id="login" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="login" aria-hidden="false" >
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3>Login Block</h3>
		  </div>
		  <div class="modal-body">
			<form class="form-horizontal loginFrm">
			  <div class="control-group">								
				<input type="text" id="inputEmail" placeholder="Email">
			  </div>
			  <div class="control-group">
				<input type="password" id="inputPassword" placeholder="Password">
			  </div>
			  <div class="control-group">
				<label class="checkbox">
				<input type="checkbox"> Remember me
				</label>
			  </div>
			</form>		
			<button type="submit" class="btn btn-success">Sign in</button>
			<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
		  </div>
	</div>
	</li>
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
							src="themes/images/ico-cart.png" alt="cart">3 Items in your
							cart <span class="badge badge-warning pull-right">$155.00</span></a>
					</div>
					<ul id="sideManu" class="nav nav-tabs nav-stacked">
						<li class="subMenu open"><a> ELECTRONICS [230]</a>
							<ul>
								<li><a class="active" href="products.html"><i
										class="icon-chevron-right"></i>Cameras (100) </a></li>
								<li><a href="products.html"><i
										class="icon-chevron-right"></i>Computers, Tablets & laptop
										(30)</a></li>
								<li><a href="products.html"><i
										class="icon-chevron-right"></i>Mobile Phone (80)</a></li>
								<li><a href="products.html"><i
										class="icon-chevron-right"></i>Sound & Vision (15)</a></li>
							</ul></li>
						<li class="subMenu"><a> CLOTHES [840] </a>
							<ul style="display: none">
								<li><a href="products.html"><i
										class="icon-chevron-right"></i>Women's Clothing (45)</a></li>
								<li><a href="products.html"><i
										class="icon-chevron-right"></i>Women's Shoes (8)</a></li>
								<li><a href="products.html"><i
										class="icon-chevron-right"></i>Women's Hand Bags (5)</a></li>
								<li><a href="products.html"><i
										class="icon-chevron-right"></i>Men's Clothings (45)</a></li>
								<li><a href="products.html"><i
										class="icon-chevron-right"></i>Men's Shoes (6)</a></li>
								<li><a href="products.html"><i
										class="icon-chevron-right"></i>Kids Clothing (5)</a></li>
								<li><a href="products.html"><i
										class="icon-chevron-right"></i>Kids Shoes (3)</a></li>
							</ul></li>
						<li class="subMenu"><a>FOOD AND BEVERAGES [1000]</a>
							<ul style="display: none">
								<li><a href="products.html"><i
										class="icon-chevron-right"></i>Angoves (35)</a></li>
								<li><a href="products.html"><i
										class="icon-chevron-right"></i>Bouchard Aine & Fils (8)</a></li>
								<li><a href="products.html"><i
										class="icon-chevron-right"></i>French Rabbit (5)</a></li>
								<li><a href="products.html"><i
										class="icon-chevron-right"></i>Louis Bernard (45)</a></li>
								<li><a href="products.html"><i
										class="icon-chevron-right"></i>BIB Wine (Bag in Box) (8)</a></li>
								<li><a href="products.html"><i
										class="icon-chevron-right"></i>Other Liquors & Wine (5)</a></li>
								<li><a href="products.html"><i
										class="icon-chevron-right"></i>Garden (3)</a></li>
								<li><a href="products.html"><i
										class="icon-chevron-right"></i>Khao Shong (11)</a></li>
							</ul></li>
						<li><a href="products.html">HEALTH & BEAUTY [18]</a></li>
						<li><a href="products.html">SPORTS & LEISURE [58]</a></li>
						<li><a href="products.html">BOOKS & ENTERTAINMENTS [14]</a></li>
					</ul>
					<br />
					<div class="thumbnail">
						<img src="themes/images/products/panasonic.jpg"
							alt="Bootshop panasonoc New camera" />
						<div class="caption">
							<h5>Panasonic</h5>
							<h4 style="text-align: center">
								<a class="btn" href="product_details.html"> <i
									class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
									class="icon-shopping-cart"></i></a> <a class="btn btn-primary"
									href="#">$222.00</a>
							</h4>
						</div>
					</div>
					<br />
					<div class="thumbnail">
						<img src="themes/images/products/kindle.png"
							title="Bootshop New Kindel" alt="Bootshop Kindel">
						<div class="caption">
							<h5>Kindle</h5>
							<h4 style="text-align: center">
								<a class="btn" href="product_details.html"> <i
									class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
									class="icon-shopping-cart"></i></a> <a class="btn btn-primary"
									href="#">$222.00</a>
							</h4>
						</div>
					</div>
					<br />
					<div class="thumbnail">
						<img src="themes/images/payment_methods.png"
							title="Bootshop Payment Methods" alt="Payments Methods">
						<div class="caption">
							<h5>Payment Methods</h5>
						</div>
					</div>
				</div>
				<!-- Sidebar end=============================================== -->
				<div class="span9">
					<ul class="breadcrumb">
						<li><a href="index.html">Home</a> <span class="divider">/</span></li>
						<li><a href="products.html">Products</a> <span
							class="divider">/</span></li>
						<li class="active">product Details</li>
					</ul>
					<div class="row">
						<div id="gallery" class="span3">
							<a href="themes/images/products/large/f1.jpg"
								title="Fujifilm FinePix S2950 Digital Camera"> <img
								src="themes/images/products/large/3.jpg" style="width: 100%"
								alt="Fujifilm FinePix S2950 Digital Camera" />
							</a>
							<div id="differentview" class="moreOptopm carousel slide">
								<div class="carousel-inner">
									<div class="item active">
										<a href="themes/images/products/large/f1.jpg"> <img
											style="width: 29%" src="themes/images/products/large/f1.jpg"
											alt="" /></a> <a href="themes/images/products/large/f2.jpg">
											<img style="width: 29%"
											src="themes/images/products/large/f2.jpg" alt="" />
										</a> <a href="themes/images/products/large/f3.jpg"> <img
											style="width: 29%" src="themes/images/products/large/f3.jpg"
											alt="" /></a>
									</div>
									<div class="item">
										<a href="themes/images/products/large/f3.jpg"> <img
											style="width: 29%" src="themes/images/products/large/f3.jpg"
											alt="" /></a> <a href="themes/images/products/large/f1.jpg">
											<img style="width: 29%"
											src="themes/images/products/large/f1.jpg" alt="" />
										</a> <a href="themes/images/products/large/f2.jpg"> <img
											style="width: 29%" src="themes/images/products/large/f2.jpg"
											alt="" /></a>
									</div>
								</div>
								<!--  
			  <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
              <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a> 
			  -->
							</div>

							<div class="btn-toolbar">
								<div class="btn-group">
									<span class="btn"><i class="icon-envelope"></i></span> <span
										class="btn"><i class="icon-print"></i></span> <span
										class="btn"><i class="icon-zoom-in"></i></span> <span
										class="btn"><i class="icon-star"></i></span> <span
										class="btn"><i class=" icon-thumbs-up"></i></span> <span
										class="btn"><i class="icon-thumbs-down"></i></span>
								</div>
							</div>
						</div>
						<div class="span6">
							<h3>一个大橘子</h3>
							<small>香甜可口</small>
							<hr class="soft" />
							<form class="form-horizontal qtyFrm">
								<div class="control-group">
									<label class="control-label"><span>$222.00</span></label>
									<div class="controls">

										<button type="submit"
											class="btn btn-large btn-primary pull-right">
											Add to cart <i class=" icon-shopping-cart"></i>
										</button>
									</div>
								</div>
							</form>

							<hr class="soft" />
							<h4>100 items in stock</h4>
							<form class="form-horizontal qtyFrm pull-right"></form>
							<hr class="soft clr" />
							<p>产自江西赣州，运用天然有机肥料，采用山泉水进行浇水，橘子个大，味道甜如蜜</p>
							<a class="btn btn-small pull-right" href="#detail">More
								Details</a> <br class="clr" /> <a href="#" name="detail"></a>
							<hr class="soft" />
						</div>

						<div class="span9">
							<ul id="productDetail" class="nav nav-tabs">
								<li class="active"><a href="#home" data-toggle="tab">Product
										Details</a></li>
								<li><a href="#profile" data-toggle="tab">Related
										Products</a></li>
							</ul>
							<div id="myTabContent" class="tab-content">
								<div class="tab-pane fade active in" id="home">
									<h4>Product Information</h4>
									<table class="table table-bordered">
										<tbody>
											<tr class="techSpecRow">
												<th colspan="2">Product Details</th>
											</tr>
											<tr class="techSpecRow">
												<td class="techSpecTD1">Brand:</td>
												<td class="techSpecTD2">Fujifilm</td>
											</tr>
											<tr class="techSpecRow">
												<td class="techSpecTD1">Model:</td>
												<td class="techSpecTD2">FinePix S2950HD</td>
											</tr>
											<tr class="techSpecRow">
												<td class="techSpecTD1">Released on:</td>
												<td class="techSpecTD2">2011-01-28</td>
											</tr>
											<tr class="techSpecRow">
												<td class="techSpecTD1">Dimensions:</td>
												<td class="techSpecTD2">5.50" h x 5.50" w x 2.00" l,
													.75 pounds</td>
											</tr>
											<tr class="techSpecRow">
												<td class="techSpecTD1">Display size:</td>
												<td class="techSpecTD2">3</td>
											</tr>
										</tbody>
									</table>

									<h5>Features</h5>
									<p>
										14 Megapixels. 18.0 x Optical Zoom. 3.0-inch LCD Screen. Full
										HD photos and 1280 x 720p HD movie capture. ISO sensitivity
										ISO6400 at reduced resolution. Tracking Auto Focus. Motion
										Panorama Mode. Face Detection technology with Blink detection
										and Smile and shoot mode. 4 x AA batteries not included. WxDxH
										110.2 ×81.4x73.4mm. Weight 0.341kg (excluding battery and
										memory card). Weight 0.437kg (including battery and memory
										card).<br /> OND363338
									</p>

									<h4>Editorial Reviews</h4>
									<h5>Manufacturer's Description</h5>
									<p>With a generous 18x Fujinon optical zoom lens, the S2950
										really packs a punch, especially when matched with its 14
										megapixel sensor, large 3.0" LCD screen and 720p HD (30fps)
										movie capture.</p>

									<h5>Electric powered Fujinon 18x zoom lens</h5>
									<p>The S2950 sports an impressive 28mm – 504mm* high
										precision Fujinon optical zoom lens. Simple to operate with an
										electric powered zoom lever, the huge zoom range means that
										you can capture all the detail, even when you're at a
										considerable distance away. You can even operate the zoom
										during video shooting. Unlike a bulky D-SLR, bridge cameras
										allow you great versatility of zoom, without the hassle of
										carrying a bag of lenses.</p>
									<h5>Impressive panoramas</h5>
									<p>With its easy to use Panoramic shooting mode you can get
										creative on the S2950, however basic your skills, and rest
										assured that you will not risk shooting uneven landscapes or
										shaky horizons. The camera enables you to take three
										successive shots with a helpful tool which automatically
										releases the shutter once the images are fully aligned to
										seamlessly stitch the shots together in-camera. It's so easy
										and the results are impressive.</p>

									<h5>Sharp, clear shots</h5>
									<p>Even at the longest zoom settings or in the most
										challenging of lighting conditions, the S2950 is able to
										produce crisp, clean results. With its mechanically stabilised
										1/2 3", 14 megapixel CCD sensor, and high ISO sensitivity
										settings, Fujifilm's Dual Image Stabilisation technology
										combines to reduce the blurring effects of both hand-shake and
										subject movement to provide superb pictures.</p>
								</div>
								<div class="tab-pane fade" id="profile">
									<div id="myTab" class="pull-right">
										<a href="#listView" data-toggle="tab"><span
											class="btn btn-large"><i class="icon-list"></i></span></a> <a
											href="#blockView" data-toggle="tab"><span
											class="btn btn-large btn-primary"><i
												class="icon-th-large"></i></span></a>
									</div>
									<br class="clr" />
									<hr class="soft" />
									<div class="tab-content">
										<div class="tab-pane" id="listView">
											<div class="row">
												<div class="span2">
													<img src="themes/images/products/4.jpg" alt="" />
												</div>
												<div class="span4">
													<h3>New | Available</h3>
													<hr class="soft" />
													<h5>Product Name</h5>
													<p>Nowadays the lingerie industry is one of the most
														successful business spheres.We always stay in touch with
														the latest fashion tendencies - that is why our goods are
														so popular..</p>
													<a class="btn btn-small pull-right"
														href="product_details.html">View Details</a> <br
														class="clr" />
												</div>
												<div class="span3 alignR">
													<form class="form-horizontal qtyFrm">
														<h3>$222.00</h3>
														<label class="checkbox"> <input type="checkbox">
															Adds product to compair
														</label><br />
														<div class="btn-group">
															<a href="product_details.html"
																class="btn btn-large btn-primary"> Add to <i
																class=" icon-shopping-cart"></i></a> <a
																href="product_details.html" class="btn btn-large"><i
																class="icon-zoom-in"></i></a>
														</div>
													</form>
												</div>
											</div>
											<hr class="soft" />
											<div class="row">
												<div class="span2">
													<img src="themes/images/products/5.jpg" alt="" />
												</div>
												<div class="span4">
													<h3>New | Available</h3>
													<hr class="soft" />
													<h5>Product Name</h5>
													<p>Nowadays the lingerie industry is one of the most
														successful business spheres.We always stay in touch with
														the latest fashion tendencies - that is why our goods are
														so popular..</p>
													<a class="btn btn-small pull-right"
														href="product_details.html">View Details</a> <br
														class="clr" />
												</div>
												<div class="span3 alignR">
													<form class="form-horizontal qtyFrm">
														<h3>$222.00</h3>
														<label class="checkbox"> <input type="checkbox">
															Adds product to compair
														</label><br />
														<div class="btn-group">
															<a href="product_details.html"
																class="btn btn-large btn-primary"> Add to <i
																class=" icon-shopping-cart"></i></a> <a
																href="product_details.html" class="btn btn-large"><i
																class="icon-zoom-in"></i></a>
														</div>
													</form>
												</div>
											</div>
											<hr class="soft" />
											<div class="row">
												<div class="span2">
													<img src="themes/images/products/6.jpg" alt="" />
												</div>
												<div class="span4">
													<h3>New | Available</h3>
													<hr class="soft" />
													<h5>Product Name</h5>
													<p>Nowadays the lingerie industry is one of the most
														successful business spheres.We always stay in touch with
														the latest fashion tendencies - that is why our goods are
														so popular..</p>
													<a class="btn btn-small pull-right"
														href="product_details.html">View Details</a> <br
														class="clr" />
												</div>
												<div class="span3 alignR">
													<form class="form-horizontal qtyFrm">
														<h3>$222.00</h3>
														<label class="checkbox"> <input type="checkbox">
															Adds product to compair
														</label><br />
														<div class="btn-group">
															<a href="product_details.html"
																class="btn btn-large btn-primary"> Add to <i
																class=" icon-shopping-cart"></i></a> <a
																href="product_details.html" class="btn btn-large"><i
																class="icon-zoom-in"></i></a>
														</div>
													</form>
												</div>
											</div>
											<hr class="soft" />
											<div class="row">
												<div class="span2">
													<img src="themes/images/products/7.jpg" alt="" />
												</div>
												<div class="span4">
													<h3>New | Available</h3>
													<hr class="soft" />
													<h5>Product Name</h5>
													<p>Nowadays the lingerie industry is one of the most
														successful business spheres.We always stay in touch with
														the latest fashion tendencies - that is why our goods are
														so popular..</p>
													<a class="btn btn-small pull-right"
														href="product_details.html">View Details</a> <br
														class="clr" />
												</div>
												<div class="span3 alignR">
													<form class="form-horizontal qtyFrm">
														<h3>$222.00</h3>
														<label class="checkbox"> <input type="checkbox">
															Adds product to compair
														</label><br />
														<div class="btn-group">
															<a href="product_details.html"
																class="btn btn-large btn-primary"> Add to <i
																class=" icon-shopping-cart"></i></a> <a
																href="product_details.html" class="btn btn-large"><i
																class="icon-zoom-in"></i></a>
														</div>
													</form>
												</div>
											</div>

											<hr class="soft" />
											<div class="row">
												<div class="span2">
													<img src="themes/images/products/8.jpg" alt="" />
												</div>
												<div class="span4">
													<h3>New | Available</h3>
													<hr class="soft" />
													<h5>Product Name</h5>
													<p>Nowadays the lingerie industry is one of the most
														successful business spheres.We always stay in touch with
														the latest fashion tendencies - that is why our goods are
														so popular..</p>
													<a class="btn btn-small pull-right"
														href="product_details.html">View Details</a> <br
														class="clr" />
												</div>
												<div class="span3 alignR">
													<form class="form-horizontal qtyFrm">
														<h3>$222.00</h3>
														<label class="checkbox"> <input type="checkbox">
															Adds product to compair
														</label><br />
														<div class="btn-group">
															<a href="product_details.html"
																class="btn btn-large btn-primary"> Add to <i
																class=" icon-shopping-cart"></i></a> <a
																href="product_details.html" class="btn btn-large"><i
																class="icon-zoom-in"></i></a>
														</div>
													</form>
												</div>
											</div>
											<hr class="soft" />
											<div class="row">
												<div class="span2">
													<img src="themes/images/products/9.jpg" alt="" />
												</div>
												<div class="span4">
													<h3>New | Available</h3>
													<hr class="soft" />
													<h5>Product Name</h5>
													<p>Nowadays the lingerie industry is one of the most
														successful business spheres.We always stay in touch with
														the latest fashion tendencies - that is why our goods are
														so popular..</p>
													<a class="btn btn-small pull-right"
														href="product_details.html">View Details</a> <br
														class="clr" />
												</div>
												<div class="span3 alignR">
													<form class="form-horizontal qtyFrm">
														<h3>$222.00</h3>
														<label class="checkbox"> <input type="checkbox">
															Adds product to compair
														</label><br />
														<div class="btn-group">
															<a href="product_details.html"
																class="btn btn-large btn-primary"> Add to <i
																class=" icon-shopping-cart"></i></a> <a
																href="product_details.html" class="btn btn-large"><i
																class="icon-zoom-in"></i></a>
														</div>
													</form>
												</div>
											</div>
											<hr class="soft" />
										</div>
										<div class="tab-pane active" id="blockView">
											<ul class="thumbnails">
												<li class="span3">
													<div class="thumbnail">
														<a href="product_details.html"><img
															src="themes/images/products/10.jpg" alt="" /></a>
														<div class="caption">
															<h5>Manicure &amp; Pedicure</h5>
															<p>Lorem Ipsum is simply dummy text.</p>
															<h4 style="text-align: center">
																<a class="btn" href="product_details.html"> <i
																	class="icon-zoom-in"></i></a> <a class="btn" href="#">Add
																	to <i class="icon-shopping-cart"></i>
																</a> <a class="btn btn-primary" href="#">&euro;222.00</a>
															</h4>
														</div>
													</div>
												</li>
												<li class="span3">
													<div class="thumbnail">
														<a href="product_details.html"><img
															src="themes/images/products/11.jpg" alt="" /></a>
														<div class="caption">
															<h5>Manicure &amp; Pedicure</h5>
															<p>Lorem Ipsum is simply dummy text.</p>
															<h4 style="text-align: center">
																<a class="btn" href="product_details.html"> <i
																	class="icon-zoom-in"></i></a> <a class="btn" href="#">Add
																	to <i class="icon-shopping-cart"></i>
																</a> <a class="btn btn-primary" href="#">&euro;222.00</a>
															</h4>
														</div>
													</div>
												</li>
												<li class="span3">
													<div class="thumbnail">
														<a href="product_details.html"><img
															src="themes/images/products/12.jpg" alt="" /></a>
														<div class="caption">
															<h5>Manicure &amp; Pedicure</h5>
															<p>Lorem Ipsum is simply dummy text.</p>
															<h4 style="text-align: center">
																<a class="btn" href="product_details.html"> <i
																	class="icon-zoom-in"></i></a> <a class="btn" href="#">Add
																	to <i class="icon-shopping-cart"></i>
																</a> <a class="btn btn-primary" href="#">&euro;222.00</a>
															</h4>
														</div>
													</div>
												</li>
												<li class="span3">
													<div class="thumbnail">
														<a href="product_details.html"><img
															src="themes/images/products/13.jpg" alt="" /></a>
														<div class="caption">
															<h5>Manicure &amp; Pedicure</h5>
															<p>Lorem Ipsum is simply dummy text.</p>
															<h4 style="text-align: center">
																<a class="btn" href="product_details.html"> <i
																	class="icon-zoom-in"></i></a> <a class="btn" href="#">Add
																	to <i class="icon-shopping-cart"></i>
																</a> <a class="btn btn-primary" href="#">&euro;222.00</a>
															</h4>
														</div>
													</div>
												</li>
												<li class="span3">
													<div class="thumbnail">
														<a href="product_details.html"><img
															src="themes/images/products/1.jpg" alt="" /></a>
														<div class="caption">
															<h5>Manicure &amp; Pedicure</h5>
															<p>Lorem Ipsum is simply dummy text.</p>
															<h4 style="text-align: center">
																<a class="btn" href="product_details.html"> <i
																	class="icon-zoom-in"></i></a> <a class="btn" href="#">Add
																	to <i class="icon-shopping-cart"></i>
																</a> <a class="btn btn-primary" href="#">&euro;222.00</a>
															</h4>
														</div>
													</div>
												</li>
												<li class="span3">
													<div class="thumbnail">
														<a href="product_details.html"><img
															src="themes/images/products/2.jpg" alt="" /></a>
														<div class="caption">
															<h5>Manicure &amp; Pedicure</h5>
															<p>Lorem Ipsum is simply dummy text.</p>
															<h4 style="text-align: center">
																<a class="btn" href="product_details.html"> <i
																	class="icon-zoom-in"></i></a> <a class="btn" href="#">Add
																	to <i class="icon-shopping-cart"></i>
																</a> <a class="btn btn-primary" href="#">&euro;222.00</a>
															</h4>
														</div>
													</div>
												</li>
											</ul>
											<hr class="soft" />
										</div>
									</div>
									<br class="clr">
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- MainBody End ============================= -->
<!-- Footer ================================================================== -->
	<div  id="footerSection">
	<div class="container">
		<div class="row">
			<div class="span3">
				<h5>ACCOUNT</h5>
				<a href="login.html">YOUR ACCOUNT</a>
				<a href="login.html">PERSONAL INFORMATION</a> 
				<a href="login.html">ADDRESSES</a> 
				<a href="login.html">DISCOUNT</a>  
				<a href="login.html">ORDER HISTORY</a>
			 </div>
			<div class="span3">
				<h5>INFORMATION</h5>
				<a href="contact.html">CONTACT</a>  
				<a href="register.html">REGISTRATION</a>  
				<a href="legal_notice.html">LEGAL NOTICE</a>  
				<a href="tac.html">TERMS AND CONDITIONS</a> 
				<a href="faq.html">FAQ</a>
			 </div>
			<div class="span3">
				<h5>OUR OFFERS</h5>
				<a href="#">NEW PRODUCTS</a> 
				<a href="#">TOP SELLERS</a>  
				<a href="special_offer.html">SPECIAL OFFERS</a>  
				<a href="#">MANUFACTURERS</a> 
				<a href="#">SUPPLIERS</a> 
			 </div>
			<div id="socialMedia" class="span3 pull-right">
				<h5>SOCIAL MEDIA </h5>
				<a href="#"><img width="60" height="60" src="themes/images/facebook.png" title="facebook" alt="facebook"/></a>
				<a href="#"><img width="60" height="60" src="themes/images/twitter.png" title="twitter" alt="twitter"/></a>
				<a href="#"><img width="60" height="60" src="themes/images/youtube.png" title="youtube" alt="youtube"/></a>
			 </div> 
		 </div>
		<p class="pull-right">&copy; Bootshop</p>
	</div><!-- Container End -->
	</div>
<!-- Placed at the end of the document so the pages load faster ============================================= -->
	<script src="${pageContext.request.contextPath}/themes/js/jquery.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/themes/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/themes/js/google-code-prettify/prettify.js"></script>
	<script src="${pageContext.request.contextPath}/js/menu/menu.js"
	<script
		src="${pageContext.request.contextPath}/js/menu/goodsInfoList.js"
		type="text/javascript"></script>
		type="text/javascript"></script>
    <script src="themes/js/jquery.lightbox-0.5.js"></script>
	
</body>
</html>