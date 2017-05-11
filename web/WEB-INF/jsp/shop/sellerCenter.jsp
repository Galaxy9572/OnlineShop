<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>卖家中心</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/beAlert.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/shop/sellerCenter.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/tables.css">
    <script src="<%=path%>/js/jquery-1.12.3.min.js"></script>
    <script src="<%=path%>/js/jquery-1.8.3.min.js"></script>
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
        <dl id="dl_userOperator">
            <dd><a href="#div_summary" class="a_userOperator">信息概览</a></dd>
            <dd><a href="#div_message" class="a_userOperator">我的消息</a></dd>
            <dd><a href="#div_allGoods" class="a_userOperator">所有商品</a></dd>
            <dd><a href="#div_addGoods" class="a_userOperator">添加商品</a></dd>
            <dd><a href="#div_readyToSend" class="a_userOperator">待发货</a></dd>
            <dd><a href="#div_data" class="a_userOperator">数据统计</a></dd>
        </dl>
    </div>
    <div id="div_right">
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
        <div id="div_allGoods" class="content">
            <h3 class="tableTitle">所有商品</h3>
            <table id="allGoodsTable" class="genTable">
                <thead class="genTableTitle">
                    <tr>
                        <th>ID</th><th>商品名</th><th>种类</th><th>价格</th><th>折扣</th><th>状态</th><th>评分</th>
                    </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${requestScope.allGoods == null}">
                        <tr><td colspan="7">暂无记录</td></tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="goods" items="${requestScope.allGoods}">
                            <tr>
                                <td>${goods.goodsId}</td><td>${goods.goodsName}</td><td>${goods.goodsType}</td><td>${goods.price}</td><td>${goods.discount}</td><td>${goods.statement}</td><td>${goods.rank}</td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </div>
        <div id="div_addGoods" class="content">
            <table id="addGoodsTable" class="addTable">
                <tr><th colspan="2">添加商品</th></tr>
                <tr>
                    <td>商品名</td><td><input type="text" id="input_goodsName" class="inputs"></td>
                </tr>
                <tr>
                    <td>商品种类</td>
                    <td>
                        <select id="select_goodsType">
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
                    <td colspan="2"><input type="button" id="bt_submit" class="bt_submit" value="确定" onclick="addGoods();"></td>
                </tr>
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
        <div id="div_data" class="content">

        </div>
        <div id="div_summary" class="content">

        </div>
    </div>
</div>
<div id="div_bottom">

</div>
</body>
</html>
