<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>作品添加</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/layui/css/layui.css"
	media="all" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/toastr.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/category/add.css">
<style type="text/css">
.layui-form-item .layui-inline {
	width: 33.333%;
	float: left;
	margin-right: 0;
	
}
.layui-form-item .layui-form-label{
width:100px
}
@media ( max-width :1240px) {
	.layui-form-item .layui-inline {
		width: 100%;
		float: none;
	}
}
</style>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.1.8.2.min.js"></script>
</head>
<body class="childrenBody">
	<form class="layui-form" style="width: 100%;">
		<h1 style="text-align: center;">添加类型</h1>
		<div style="width: 60%;">
			<div class="layui-form-item input-line">
			<label class="layui-form-label">选择添加的类型</label>
			<div class="layui-input-block">
				<input type="radio" class="buyMethod" name="transactionMode"
					value="1" title="一级类型">
				<div class="layui-unselect layui-form-radio layui-form-radioed">
					<i class="layui-anim layui-icon"></i><span>一级类型</span>
				</div>
				<input type="radio" class="buyMethod" name="transactionMode"
					value="2" title="二级类型" checked="">
				<div class="layui-unselect layui-form-radio ">
					<i class="layui-anim layui-icon"></i><span>二级类型</span>
				</div>
			</div>
		</div>
			
		</div>
			 <div class="layui-form-item">
				<label class="layui-form-label">已有一级类型</label>
				<div class="layui-input-inline" id="typeOne">
				</div>
			</div> 
			<div class="layui-form-item">
				<label class="layui-form-label">添加的类型名称</label>
				<div class="layui-input-inline"style="width: 40%;" >
					<input type="text" name="goods_type_title"
						class="layui-input userEmail" lay-verify="email"
						placeholder="请输入类型名称">
				</div>
			</div>

		<div class="layui-form-item" style="margin-top: 40px;">
			<div class="layui-input-block">
				<input type="button" class="layui-btn" id="addCategory"
					onclick="" lay-filter="addUser" value="立即提交">
			</div>
		</div>
	</form>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/layui/layui.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/category/categoryAdd.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/toastr.js"></script>
	<script type="text/javascript">
		layui.use('form', function() {
			var form = layui.form;
			form.render();
		});
	</script>
</body>
</html>