<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html>
<head>
    <title>商品列表</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/beAlert.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/goods/goodsList.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/tables.css">
    <script src="<%=path%>/js/jquery-1.12.3.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>
    <script src="<%=path%>/js/bootstrap-paginator.min.js"></script>
    <script src="<%=path%>/js/beAlert.js"></script>
    <script src="<%=path%>/js/goods/goodsList.js"></script>
</head>
<body>
    <div id="div_top">
        <a href="<%=path%>"><img class="logo" alt="LOGO" src="<%=path%>/image/logo.png"/></a>
        <div class="separator"></div>
        <div id="div_title">
            <h1>商品列表 -- ${requestScope.goodsType}</h1>
        </div>
    </div>
    <div class="div_middle">
        <c:forEach var="item" items="${requestScope.goodsList}">
            <div class="div_goodsList">
                <div class="div_goodsImg">
                    <a href="<%=path%>/goods/goodsDetail?id=${item.goodsId}" target="_blank">
                        <img  src="<%=path%>/image/goods/mansuit1.jpg"/>
                    </a>
                </div>
                <div class="div_goodsDetail">
                    <p class="productPrice">￥${item.price}</p>
                    <a href="<%=path%>/goods/goodsDetail?id=${item.goodsId}" target="_blank">
                        <p class="productName">${item.goodsName}</p>
                    </a>
                </div>
            </div>
        </c:forEach>

    </div>
    <div id="div_bottom">

    </div>
</body>
<input type="hidden" value="${requestScope.goodsType}">
</html>
