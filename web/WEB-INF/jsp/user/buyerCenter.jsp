<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <title>买家中心</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/public.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/beAlert.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/buyerCenter.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tables.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/beAlert.js"></script>
    <script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/user/buyerCenter.js"></script>
</head>
<body>
<div id="div_top">
    <a href="${pageContext.request.contextPath}"><img class="logo" alt="LOGO" src="${pageContext.request.contextPath}/image/logo.png"/></a>
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
            <dd><a href="#div_readyToSend" class="a_userOperator">待发货</a></dd>
            <dd><a href="#div_readyToReceive" class="a_userOperator">待收货</a></dd>
            <dd><a href="#div_data" class="a_userOperator">数据统计</a></dd>
        </dl>
    </div>
    <div id="div_right">
        <div id="div_order" class="content">
            <h3 class="tableTitle">我的订单</h3>
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
                <tbody>
                <c:choose>
                    <c:when test="${requestScope.userOrder == null}">
                        <tr><td colspan="5">暂无记录</td></tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td><input type="checkbox"></td>
                            <td>${requestScope.userOrder.orderId}</td>
                            <td>${requestScope.userOrder.createTime}</td>
                            <td>${requestScope.userOrder.statement}</td>
                            <td><a href="">删除</a></td>
                        </tr>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </div>
        <div id="div_message" class="content">
            <h3 class="tableTitle">我的消息</h3>
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
                <tbody>
                <c:choose>
                    <c:when test="${requestScope.userMessage == null}">
                        <tr><td colspan="5">暂无记录</td></tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td><input type="checkbox"></td>
                            <td>${requestScope.userMessage.fromUser}</td>
                            <td>${requestScope.userMessage.context}</td>
                            <td>${requestScope.userMessage.createTime}</td>
                            <td><a href="">删除</a></td>
                        </tr>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </div>
        <div id="div_cart" class="content">
            <h3 class="tableTitle">购物车</h3>
            <table id="cartTable" class="genTable">
                <thead class="genTableTitle">
                <tr>
                    <th width="5%"><input type="checkbox">&nbsp;全选</th>
                    <th width="15%">商品名</th>
                    <th width="15%">价格</th>
                    <th width="15%">时间</th>
                    <th width="5%">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${requestScope.userMessage == null}">
                        <tr><td colspan="5">暂无记录</td></tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td><input type="checkbox"></td>
                            <td>${requestScope.userCart.goodsName}</td>
                            <td>${requestScope.userCart.price}</td>
                            <td>${requestScope.userCart.createTime}</td>
                            <td><a href="">删除</a></td>
                        </tr>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </div>
        <div id="div_bought" class="content">
            <h3 class="tableTitle">已买到的宝贝</h3>
            <table id="boughtTable" class="genTable">
                <thead class="genTableTitle">
                <tr>
                    <th width="5%"><input type="checkbox">&nbsp;全选</th>
                    <th width="15%">商品名</th>
                    <th width="15%">价格</th>
                    <th width="15%">时间</th>
                    <th width="5%">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${requestScope.userMessage == null}">
                        <tr><td colspan="5">暂无记录</td></tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td><input type="checkbox"></td>
                            <td>${requestScope.userBought.goodsName}</td>
                            <td>${requestScope.userBought.price}</td>
                            <td>${requestScope.userBought.createTime}</td>
                            <td><a href="">删除</a></td>
                        </tr>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </div>
        <div id="div_readyToSend" class="content">
            <h3 class="tableTitle">待发货</h3>
            <table id="readyToSendTable" class="genTable">
                <thead class="genTableTitle">
                <tr>
                    <th width="5%"><input type="checkbox">&nbsp;全选</th>
                    <th width="15%">商品名</th>
                    <th width="15%">价格</th>
                    <th width="15%">时间</th>
                    <th width="5%">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${requestScope.userMessage == null}">
                        <tr><td colspan="5">暂无记录</td></tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td><input type="checkbox"></td>
                            <td>${requestScope.userBought.goodsName}</td>
                            <td>${requestScope.userBought.price}</td>
                            <td>${requestScope.userBought.createTime}</td>
                            <td><a href="">删除</a></td>
                        </tr>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </div>
        <div id="div_readyToReceive" class="content">
            <h3 class="tableTitle">待收货</h3>
            <table id="readyToReceiveTable" class="genTable">
                <thead class="genTableTitle">
                <tr>
                    <th width="5%"><input type="checkbox">&nbsp;全选</th>
                    <th width="15%">商品名</th>
                    <th width="15%">价格</th>
                    <th width="15%">时间</th>
                    <th width="5%">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${requestScope.userMessage == null}">
                        <tr><td colspan="5">暂无记录</td></tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td><input type="checkbox"></td>
                            <td>${requestScope.userBought.goodsName}</td>
                            <td>${requestScope.userBought.price}</td>
                            <td>${requestScope.userBought.createTime}</td>
                            <td><a href="">删除</a></td>
                        </tr>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </div>
        <div id="div_data" class="content">
            <div id="div_echarts"></div>
        </div>
        <div id="div_summary" class="content">

        </div>
    </div>
    <div id="div_bottom">

    </div>
</div>
</body>
</html>
