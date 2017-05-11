<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">

<title>用户登录</title>

<link rel="stylesheet" type="text/css" href="<%=path%>/css/user/userLogin.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/beAlert.css">
<script src="<%=path%>/js/jquery-1.12.3.min.js"></script>
<script src="<%=path%>/js/beAlert.js"></script>
<script src="<%=path%>/js/user/userLogin.js"></script>
</head>

<body>
	<div id="div_top">
		<a href="<%=path%>"><img class="logo" alt="LOGO" src="<%=path%>/image/logo.png" /></a>
		<div class="separator"></div>
		<div id="div_title">
			<h1>用户登录</h1>
		</div>
	</div>
	<div id="div_middle">
		<div id="div_logn_table">
			<table id="login_table">
				<tr>
					<td colspan="2"><img id="portrait" alt="portrait" src="<%=path%>/image/default-head.png"></td>
				</tr>
				<tr>
					<td>用户名：</td>
					<td colspan="2"><input class="inputs" id="input_userName" type="text" name="userName"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td colspan="2"><input class="inputs" id="input_password" type="password" name="password"></td>
				</tr>
				<tr>
					<td colspan="2"><input id="popup-submit" type="button" class="submit" value="确认" onclick="submit()"></td>
				</tr>
			</table>
		</div>
	</div>
	<div id="div_bottom">
		<div id="div_bottom_rights" class="bottom_rights">
			<hr class="bottom_separator">
			<p>
				基于SpringMVC、Spring和MyBatis的网上商城<br> 1306102-04 廖俊瑶 毕业设计 <br>
				<img class="img_frameworks" alt="Spring" src="<%=path%>/image/spring-logo.png" />
				<img class="img_frameworks" alt="MyBatis" src="<%=path%>/image/mybatis-logo.png" />
				<br>
			</p>
		</div>
	</div>
</body>
</html>
