
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商店管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/public.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/beAlert.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shop/shopManage.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tables.css">
    <script src="${pageContext.request.contextPath}/js/jQuery-1.12.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-paginator.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/beAlert.js"></script>
    <script src="${pageContext.request.contextPath}/js/shop/shopManage.js"></script>
</head>
<body>
    <div id="div_top">
        <a href="${pageContext.request.contextPath}"><img class="logo" alt="LOGO" src="${pageContext.request.contextPath}/image/logo.png"/></a>
        <div class="separator"></div>
        <div id="div_title">
            <h1>商店管理</h1>
        </div>
    </div>
    <div id="div_middle">
        <div id="div_left">
            <dl id="dl_userOperator">
                <dd><a href="#div_info" class="a_userOperator">信息概览</a></dd>
                <dd><a href="#div_addGoods" class="a_userOperator">用户管理</a></dd>
                <dd><a href="#div_goodsManage" class="a_userOperator">商店管理</a></dd>
                <dd><a href="#div_readyToSend" class="a_userOperator">商品管理</a></dd>
                <dd><a href="#div_msg" class="a_userOperator">商品管理</a></dd>
                <dd><a href="#div_data" class="a_userOperator">数据统计</a></dd>
            </dl>
        </div>
        <div id="div_rights">
            <div id="div_info">

            </div>
            <div id="div_addGoods">

            </div>
            <div id="div_goodsManage">

            </div>
            <div id="div_readyToSend">

            </div>
            <div id="div_msg">

            </div>
            <div id="div_data">

            </div>
        </div>
    </div>
    <div id="div_bottom">

    </div>
</body>
</html>
