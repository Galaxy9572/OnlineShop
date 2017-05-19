<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>买家中心</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/beAlert.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/user/buyerCenter.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/tables.css">
    <script src="<%=path%>/js/jquery-1.12.3.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>
    <script src="<%=path%>/js/bootstrap-paginator.min.js"></script>
    <script src="<%=path%>/js/beAlert.js"></script>
    <%--<script src="<%=path%>/js/echarts.min.js"></script>--%>
    <script src="<%=path%>/js/user/buyerCenter.js"></script>
</head>
<body>
<div id="div_top">
    <a href="<%=path%>"><img class="logo" alt="LOGO" src="<%=path%>/image/logo.png"/></a>
    <div class="separator"></div>
    <div id="div_title">
        <h1>买家中心</h1>
    </div>
</div>
<div id="div_middle">
    <div id="div_left">
        <dl id="dl_userOperator">
            <dd><a href="#div_summary" class="a_userOperator">信息概览</a></dd>
            <dd><a href="#div_order" class="a_userOperator">我的订单</a></dd>
            <dd><a href="#div_message" class="a_userOperator">我的消息</a></dd>
            <dd><a href="#div_cart" class="a_userOperator">购物车</a></dd>
            <dd><a href="#div_bought" class="a_userOperator">已买到的宝贝</a></dd>
        </dl>
    </div>
    <div id="div_right">
        <div id="div_order" class="content">
            <h3 class="tableTitle">我的订单</h3>
            订单状态：<select id="select_orderStatement">
                        <option value="0">全部</option>
                        <c:forEach var="item" items="${requestScope.orderStatement}">
                            <option value="${item.key()}">${item.value()}</option>
                        </c:forEach>
                    </select>
            <table id="orderTable" class="genTable">
                <thead class="genTableTitle">
                    <tr>
                        <th width="5%"><input type="checkbox">&nbsp;全选</th>
                        <th width="15%">订单号</th>
                        <th width="15%">创建时间</th>
                        <th width="15%">状态</th>
                        <th width="5%">操作</th>
                    </tr>
                </thead>
                <tbody id="orderTableBody">
                </tbody>
            </table>
            <div id="orderPaginator"></div>
        </div>
        <div id="div_message" class="content">
            <h3 class="tableTitle">我的消息</h3>
            消息状态：<select id="select_msgStatement">
                        <option value="0">全部</option>
                        <c:forEach var="item" items="${requestScope.userMsgStatement}">
                            <option value="${item.key()}">${item.value()}</option>
                        </c:forEach>
                    </select>
            <table id="messageTable" class="genTable">
                <thead class="genTableTitle">
                <tr>
                    <th width="5%"><input type="checkbox">&nbsp;全选</th>
                    <th width="15%">发送者</th>
                    <th width="15%">内容</th>
                    <th width="15%">发送时间</th>
                    <th width="5%">操作</th>
                </tr>
                </thead>
                <tbody id="msgTableBody">
                </tbody>
            </table>
            <div id="msgPaginator"></div>
        </div>
        <div id="div_cart" class="content">
            <h3 class="tableTitle">购物车</h3>
            <table id="cartTable" class="genTable">
                <thead class="genTableTitle">
                <tr>
                    <th width="5%"><input type="checkbox">&nbsp;全选</th>
                    <th width="15%">商品ID</th>
                    <th width="15%">加入时间</th>
                    <th width="15%">修改时间</th>
                    <th width="5%">操作</th>
                </tr>
                </thead>
                <tbody id="cartTableBody">
                </tbody>
            </table>
            <div id="cartPaginator"></div>
        </div>
        <div id="div_bought" class="content">
            <h3 class="tableTitle">已买到的宝贝</h3>
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
            <table id="boughtTable" class="genTable">
                <thead class="genTableTitle">
                <tr>
                    <th width="5%"><input type="checkbox">&nbsp;全选</th>
                    <th width="8%">商品ID</th>
                    <th width="10%">商品名</th>
                    <th width="6%">商品种类</th>
                    <th width="15%">价格</th>
                    <th width="5%">折扣</th>
                    <th width="5%">评分</th>
                    <th width="5%">状态</th>
                    <th width="14%">创建时间</th>
                    <th width="14%">修改时间</th>
                    <th width="10%">操作</th>
                </tr>
                </thead>
                <tbody id="boughtTableBody">
                </tbody>
            </table>
            <!-- 底部分页按钮 -->
            <div id="boughtPaginator"></div>
        </div>
        <div id="div_summary" class="content">

        </div>
    </div>
    <div id="div_bottom">

    </div>
</div>
<input type="hidden" id="input_userId" value="${sessionScope.user.userId}"/>
</body>
</html>
