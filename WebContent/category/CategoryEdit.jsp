<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
	<title>类型修改</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/toastr.css">
	<style type="text/css">
		.layui-form-item .layui-inline{ width:50%; float:left; margin-right:0; }
		@media(max-width:1240px){
			.layui-form-item .layui-inline{ width:100%; float:none; }
		}
	</style>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.1.8.2.min.js"></script>
</head>
<body class="childrenBody">
<input id="fd" type="hidden" value="${data_id }"/>
	<form class="layui-form" style="width:100%;">
	<h1 style="text-align: center;">修改类型</h1>
	<hr>
	<div style="margin:auto; width:70%;">
	
		<div class="layui-form-item">
		<div class="layui-inline">
	
			<label class="layui-form-label" >一级类型</label>
			<div class="layui-input-block">
				<input  id="productionInfoAuthor" name="typeOneName" class="layui-input "  readonly/>
			</div>
		</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-inline">
			    <label class="layui-form-label">二级类型</label>
				<div class="layui-input-block" >
					<input type="text" id="productionInfoAuthor" name="typeName" class="layui-input userEmail"  lay-verify="email" placeholder="">
				</div>
		    </div>
		</div>
		<div class="layui-upload">
		
		
		
		<div style="margin:auto;width:250px">
		<input type="button" class="layui-btn" id="excuteUpload" onclick="checkNull();" value="确认修改" style="margin:auto;width:250px"/>
		</div>
	</div>
	</div>
	</form>
	
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/toastr.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/category/categoryEdit.js"></script>
</body>
</html>