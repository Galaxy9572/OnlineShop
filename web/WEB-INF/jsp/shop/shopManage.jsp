
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商店管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/public.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/beAlert.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shop/shopManage.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tables.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.3.min.js"></script>
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
            <dl id="dl_shopOperator">
                <dd><a href="#div_info" class="a_shopOperator">信息概览</a></dd>
                <dd><a href="#div_addGoods" class="a_shopOperator">添加商品</a></dd>
                <dd><a href="#div_goodsManage" class="a_shopOperator">商品管理</a></dd>
                <dd><a href="#div_readyToSend" class="a_shopOperator">待发货</a></dd>
                <dd><a href="#div_msg" class="a_shopOperator">我的消息</a></dd>
                <dd><a href="#div_data" class="a_shopOperator">数据统计</a></dd>
            </dl>
        </div>
        <div id="div_right">
            <div id="div_addGoods">
                <h3 class="tableTitle">添加商品</h3>
                <table id="addGoodsTable" class="genTable">
                    <tr>
                        <td>当前商品数：</td><td>${requestScope.allUserGoodsNum}</td>
                    </tr>
                </table>
            </div>
            <div id="div_goodsManage">
                <h3 class="tableTitle">商品管理</h3>
                <div id="div_goodsFilter">
                    商品名： <input type="text" id="goodsName">
                    商品类型：<select id="select_goodsType">
                                <option value="0">全部</option>
                                <c:forEach var="item" items="${requestScope.goodsType}">
                                    <option value="${item.key()}">${item.value()}</option>
                                </c:forEach>
                            </select>
                    <input type="button" value="搜索" id="bt_goodsQuerySubmit" class="bt_search">
                    <br><br>
                </div>
                <table id="goodsManageTable" class="genTable">
                    <thead class="genTableTitle">
                    <tr>
                        <th width="5%"><input type="checkbox" id="cbSelectAllGoods">&nbsp;全选</th>
                        <th width="8%">ID</th>
                        <th width="10%">商品名</th>
                        <th width="8%">商品类型</th>
                        <th width="8%">价格</th>
                        <th width="8%">折扣</th>
                        <th width="8%">评分</th>
                        <th width="10%">状态</th>
                        <th width="15%">创建时间</th>
                        <th width="15%">修改时间</th>
                        <th width="10%">操作</th>
                    </tr>
                    </thead>
                    <tbody id="goodsManageTableBody">
                    </tbody>
                </table>
                <!-- 底部分页按钮 -->
                <div id="goodsPaginator"></div>
            </div>
            <div id="div_readyToSend">

            </div>
            <div id="div_msg">

            </div>
            <div id="div_data">

            </div>
            <div id="div_info">

            </div>
        </div>
    </div>
    <div id="div_bottom">

    </div>
</body>
</html>
