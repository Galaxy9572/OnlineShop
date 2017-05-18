<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>商品详情</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/beAlert.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/goods/goodsList.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/tables.css">
    <script src="<%=path%>/js/jquery-1.12.3.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>
    <script src="<%=path%>/js/bootstrap-paginator.min.js"></script>
    <script src="<%=path%>/js/beAlert.js"></script>
    <script src="<%=path%>/js/goods/goodsDetail.js"></script>
</head>
<body>
<div id="div_top">
    <a href="<%=path%>"><img class="logo" alt="LOGO" src="<%=path%>/image/logo.png"/></a>
    <div class="separator"></div>
    <div id="div_title">
        <h1>商品详情</h1>
    </div>
</div>
<div id="div_middle">
    <div id="div_goods">
        <div id="div_img">

        </div>
        <div id="goodsDetail">

        </div>
    </div>
</div>
<div id="div_bottom">

</div>
</body>
</html>
