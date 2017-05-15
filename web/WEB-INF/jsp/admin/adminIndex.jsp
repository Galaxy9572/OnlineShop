<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>OnlineShop管理系统</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/beAlert.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/admin/adminIndex.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/tables.css">
    <script src="<%=path%>/js/jquery-1.12.3.min.js"></script>
    <script src="<%=path%>/js/jquery-1.8.3.min.js"></script>
    <script src="<%=path%>/js/bootstrap.min.js"></script>
    <script src="<%=path%>/js/bootstrap-paginator.min.js"></script>
    <script src="<%=path%>/js/beAlert.js"></script>
    <script src="<%=path%>/js/admin/adminIndex.js"></script>
</head>
<body>
    <div id="div_top">
        <a href="<%=path%>"><img class="logo" alt="LOGO" src="<%=path%>/image/logo.png"/></a>
        <div class="separator"></div>
        <div id="div_title">
            <h1>OnlineShop管理系统</h1>
        </div>
    </div>
    <div id="div_middle">
        <div id="div_left">
            <dl id="dl_userOperator">
                <dd><a href="#div_info" class="a_userOperator">信息概览</a></dd>
                <dd><a href="#div_userManage" class="a_userOperator">用户管理</a></dd>
                <dd><a href="#div_shopManage" class="a_userOperator">商店管理</a></dd>
                <dd><a href="#div_goodsManage" class="a_userOperator">商品管理</a></dd>
                <dd><a href="#div_data" class="a_userOperator">数据统计</a></dd>
            </dl>
        </div>
        <div id="div_right">
            <div id="div_userManage" class="content">
                <h3 class="tableTitle">用户管理</h3>
                <div id="div_userFilter">
                    用户名： <input type="text" id="userName">
                    用户类型：<select id="select_userType">
                                <option value="0">全部</option>
                                <option value="1">买家</option>
                                <option value="2">卖家</option>
                            </select>
                    <input type="button" id="multiDeleteUser" value="批量删除" onclick="deleteUsers();">
                    <input type="button" value="搜索" id="bt_userQuerySubmit" class="bt_search">
                    <br><br>
                </div>
                <table id="userManageTable" class="genTable">
                    <thead class="genTableTitle">
                    <tr>
                        <th width="5%"><input type="checkbox" id="cbSelectAllUser">&nbsp;全选</th>
                        <th width="10%">ID</th>
                        <th width="10%">用户名</th>
                        <th width="8%">用户类型</th>
                        <th width="12%">E-Mail</th>
                        <th width="10%">手机</th>
                        <th width="10%">状态</th>
                        <th width="15%">创建时间</th>
                        <th width="15%">修改时间</th>
                        <th width="10%">操作</th>
                    </tr>
                    </thead>

                    <tbody id="userManageTableBody">
                    </tbody>
                </table>
                <!-- 底部分页按钮 -->
                <div id="userPaginator"></div>
            </div>
            <div id="div_shopManage" class="content">
                <h3 class="tableTitle">商店管理</h3>
                <div id="div_shopFilter">
                    商店名： <input type="text" id="shopName" class="input_search">
                    商店类型：<select id="select_shopType">
                        <option value="0">全部</option>
                        <c:forEach var="item" items="${requestScope.shopTypes}">
                            <option value="${item.key()}">${item.value()}</option>
                        </c:forEach>
                    </select>
                    <input type="button" value="搜索" id="bt_shopQuerySubmit" class="bt_search">
                    <br><br>
                </div>
                <table id="shopManageTable" class="genTable">
                    <thead class="genTableTitle">
                    <tr>
                        <th width="5%"><input type="checkbox">&nbsp;全选</th>
                        <th width="5%">ID</th>
                        <th width="10%">店主ID</th>
                        <th width="8%">商店名</th>
                        <th width="5%">类型</th>
                        <th width="12%">地点</th>
                        <th width="10%">评分</th>
                        <th width="10%">状态</th>
                        <th width="15%">创建时间</th>
                        <th width="15%">修改时间</th>
                        <th width="10%">操作</th>
                    </tr>
                    </thead>
                    <tbody id="shopManageTableBody">
                    </tbody>
                </table>
                <!-- 底部分页按钮 -->
                <div id="shopPaginator"></div>
            </div>
            <div id="div_goodsManage" class="content">
                <h3 class="tableTitle">商品管理</h3>
                <div id="div_goodsFilter">
                    商品名： <input type="text" id="goodsName" class="input_search">
                    商店类型：<select id="select_goodsType">
                    <option value="0">全部</option>
                    <c:forEach var="item" items="${requestScope.shopTypes}">
                        <option value="${item.key()}">${item.value()}</option>
                    </c:forEach>
                </select>
                    <input type="button" value="搜索" id="bt_goodsQuerySubmit" class="bt_search">
                    <br><br>
                </div>
                <table id="goodsManageTable" class="genTable">
                    <thead class="genTableTitle">
                    <tr>
                        <th width="5%"><input type="checkbox">&nbsp;全选</th>
                        <th width="8%">商品ID</th>
                        <th width="8%">商店ID</th>
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

                    <tbody id="goodsManageTableBody">
                    </tbody>
                </table>
                <!-- 底部分页按钮 -->
                <div id="goodsPaginator"></div>
            </div>
            <div id="div_data" class="content">

            </div>
            <div id="div_info" class="content">
                <h3 class="tableTitle">信息概览</h3>
                <table id="infoTable" class="genTable">
                    <tr>
                        <td>当前用户数：</td><td>${requestScope.allUserNum}</td>
                    </tr>
                    <tr>
                        <td>当前商店数：</td><td>${requestScope.allShopNum}</td>
                    </tr>
                    <tr>
                        <td>当前商品数：</td><td>${requestScope.allGoodsNum}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div id="div_bottom">

    </div>
</body>
</html>
