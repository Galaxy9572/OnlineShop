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
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/goods/goodsDetail.css">
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
        <img id="img_goods" src="<%=path%>/image/goods/mansuit1.jpg" />
        <div id="div_goodsDetail">
            <div id="div_goodsDetail_up">
                <h1 id="goodsName">${requestScope.goodsDetail.goodsName}</h1>
                <h4 id="goodsPriceNoDiscount">原价&nbsp;&nbsp;￥${requestScope.goodsDetail.price}</h4>
                <h2 id="goodsPrice">现价&nbsp;&nbsp;￥${requestScope.goodsDetail.price}</h2>
            </div>
            <div id="div_collect">
                <a href="javascript:collect();">
                    <img id="img_collect" src="<%=path%>/image/common/collected.png"/>收藏商品
                </a>
            </div>
            <div id="div_ops">
                <button id="bt_buyNow">立即购买</button>
                <button id="addToCart" onclick="addToCart()">加入购物车</button>
            </div>
        </div>
    </div>

    <div id="div_shopInfo">

    </div>
</div>
<div id="div_bottom">

</div>
<input id="input_userId" type="hidden" value="${sessionScope.user.userId}"/>
<input id="input_shopId" type="hidden" value="${sessionScope.userShop.shopId}"/>
<input id="input_goodsId" type="hidden" value="${requestScope.goodsDetail.goodsId}"/>
</body>
</html>
