<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css" />
</head>
<body>
<div id="header">
		<a href="/" class="logo"></a>
	</div>
<div id="register-main" class="clearfix">
		<div class="layui-tab layui-tab-brief reg-left fl">
			<ul class="layui-tab-title">
				<li class="layui-this">手机号注册</li>
			</ul>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show layui-form">
					<div class="layui-form-item">
						<input type="text" name="phoneNum" autocomplete="off" placeholder="请输入常用手机号" class="layui-input phoneNum">
					</div>
					<div class="layui-form-item">
						<input type="password" name="password" autocomplete="off" placeholder="请输入密码" class="layui-input password">
					</div>
					<a href="javascript:;" class="layui-btn register-btn">注 册</a>
				</div>
				<!-- <div class="layui-tab-item">内容2</div> -->
			</div>
		</div>
		<div class="reg-right right-box fr">
			<p>已有跳蚤市场账号：</p>
			<a href="/login">立即登录</a>
		</div>
	</div>
</body>
</html>