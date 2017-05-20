
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>商店管理</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/beAlert.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/shop/sellerCenter.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/tables.css">
    <script src="<%=path%>/js/jquery-1.12.3.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>
    <script src="<%=path%>/js/bootstrap-paginator.min.js"></script>
    <script src="<%=path%>/js/beAlert.js"></script>
    <script src="<%=path%>/js/shop/sellerCenter.js"></script>
</head>
<body>
    <div id="div_top">
        <a href="<%=path%>"><img class="logo" alt="LOGO" src="<%=path%>/image/logo.png"/></a>
        <div class="separator"></div>
        <div id="div_title">
            <h1>卖家中心</h1>
        </div>
    </div>
    <div id="div_middle">
        <div id="div_left">
            <dl id="dl_shopOperator">
                <dd><a href="#div_info" class="a_shopOperator">信息概览</a></dd>
                <dd><a href="#div_addGoods" class="a_shopOperator">添加商品</a></dd>
                <dd><a href="#div_goodsManage" class="a_shopOperator">商品管理</a></dd>
                <dd><a href="#div_order" class="a_shopOperator">订单</a></dd>
                <dd><a href="#div_msg" class="a_shopOperator">我的消息</a></dd>
            </dl>
        </div>
        <div id="div_right">
            <div id="div_addGoods" class="content">
                <table id="addGoodsTable" class="addTable">
                    <tr><th colspan="2">添加商品</th></tr>
                    <tr>
                        <td>商品名</td><td><input type="text" id="input_goodsName" class="inputs"></td>
                    </tr>
                    <tr>
                        <td>商品种类</td>
                        <td>
                            <select id="select_addGoodsType">
                                <c:if test="${requestScope.goodsType != null}">
                                    <c:forEach var="type" items="${requestScope.goodsType}">
                                        <option value="${type.key()}">${type.value()}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>价格</td><td><input type="text" id="input_price" class="inputs"></td>
                    </tr>
                    <tr>
                        <td>折扣</td><td><input type="text" id="input_discount" class="inputs"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="button" id="bt_submit" class="submit" value="确定" onclick="addGoods();"></td>
                    </tr>
                </table>
            </div>
            <div id="div_goodsManage" class="content">
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
                        <th width="10%">ID</th>
                        <th width="10%">商品名</th>
                        <th width="10%">商品类型</th>
                        <th width="10%">价格</th>
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
            <div id="div_order" class="content">
                <h3 class="tableTitle">订单</h3>
                订单状态：<select id="select_orderStatement">
                            <option value="0">全部</option>
                            <c:forEach var="item" items="${requestScope.orderStatement}">
                                <option value="${item.key()}">${item.value()}</option>
                            </c:forEach>
                        </select>
                <table id="orderTable" class="genTable">
                    <thead class="genTableTitle">
                    <tr>
                        <th width="5%"><input type="checkbox" id="cbSelectAllOrders">&nbsp;全选</th>
                        <th width="8%">买家ID</th>
                        <th width="10%">商品ID</th>
                        <th width="10%">状态</th>
                        <th width="15%">创建时间</th>
                        <th width="15%">修改时间</th>
                        <th width="10%">操作</th>
                    </tr>
                    </thead>
                    <tbody id="orderTableBody">
                    </tbody>
                </table>
                <!-- 底部分页按钮 -->
                <div id="orderPaginator"></div>
            </div>
            <div id="div_msg" class="content">
                <h3 class="tableTitle">我的消息</h3>
                消息状态：<select id="select_msgStatement">
                            <option value="0">全部</option>
                            <c:forEach var="item" items="${requestScope.userMsgStatement}">
                                <option value="${item.key()}">${item.value()}</option>
                            </c:forEach>
                        </select>
                <input type="button" value="搜索" id="bt_msgQuerySubmit" class="bt_search">
                <table id="msgTable" class="genTable">
                    <thead class="genTableTitle">
                    <tr>
                        <th width="5%"><input type="checkbox" id="cbSelectAllMsg">&nbsp;全选</th>
                        <th width="10%">发送者</th>
                        <th width="55%">内容</th>
                        <th width="10%">状态</th>
                        <th width="15%">发送时间</th>
                        <th width="10%">操作</th>
                    </tr>
                    </thead>
                    <tbody id="msgTableBody">
                    </tbody>
                </table>
                <!-- 底部分页按钮 -->
                <div id="msgPaginator"></div>
            </div>
            <div id="div_info" class="content">

            </div>
        </div>
    </div>
    <div id="div_bottom">

    </div>
    <input type="hidden" id="input_userId" value="${sessionScope.user.userId}">
    <input type="hidden" id="input_shopId" value="${sessionScope.userShop.shopId}">
</body>
</html>
