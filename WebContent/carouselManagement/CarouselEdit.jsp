<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<title>编辑轮播图</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/production/list.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/toastr.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.1.8.2.min.js"></script>
</head>
<body class="childrenBody">
<input type="hidden" id="ss" value="${data_id}">
	<form class="layui-form" style="width:100%;">
	<h1 style="text-align: center;">修改轮播图</h1>
	<div style="width:60%;">
		<div class="layui-form-item">	
			<label class="layui-form-label">轮播图片</label>
			<div class="layui-input-block"id="carouselList" style="border: 1px solid black;width: 288px;overflow: hidden">
			 <img class="layui-upload-img" id="demo1" src="${pageContext.request.contextPath }/themes/img/1.jpg" style="width:288px;height:288px;"> 
			</div>
		</div>
	</div>	
<!-- ================================控制首页轮播图模块上传==================================== -->
<!-- ===========轮播背景图上传======= -->
<div class="layui-upload" style="margin-left:180px;">
<div id="upload1" >
  <button type="button" class="layui-btn" onclick="file1.click()">点击上传轮播图</button>
  <input type="file" class="file" id="file1" name="file" style="display:none"/><br/>
  <div class="layui-upload-list">
    <!-- <img class="layui-upload-img" id="demo1" style="width:288px;height:130px;"> -->
    <p id="demoText"></p>
  </div>
</div>


</div>
	<div class="layui-form-item" style="margin-top:40px;margin-left: 90px">
			<div class="layui-input-block">
				<input type="button" class="layui-btn" id="addCarousel" lay-filter="addUser" value="立即提交">
		    </div>
	</div>
	</form>
	<script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/toastr.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/carousel/carouselEdit.js"></script>
</body>
</html>