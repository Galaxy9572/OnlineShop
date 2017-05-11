<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>页面走丢了哦</title>
<style type="text/css">
	#div_errorMsg{
		margin:0 auto;
		text-align: center;
	}
</style>
</head>
<body>
	<div id="div_errorMsg"> 
		<img alt="404" src="<%=path%>/image/common/404.png">
	</div>
</body>
</html>