<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ljy56
  Date: 2017/4/3
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OnlineShop管理系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/public.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/beAlert.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/adminIndex.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tables.css">
    <script src="${pageContext.request.contextPath}/js/jQuery-1.12.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-paginator.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/beAlert.js"></script>
    <script src="${pageContext.request.contextPath}/js/admin/adminIndex.js"></script>
</head>
<body>
    <div id="div_top">
        <a href="${pageContext.request.contextPath}"><img class="logo" alt="LOGO" src="${pageContext.request.contextPath}/image/logo.png"/></a>
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
                <h3 class="tableTitle">买家管理</h3>
                <div id="div_userFilter">
                    用户名： <input type="text" id="userName">
                    用户类型：<select id="select_userType">
                                <option value="0">全部</option>
                                <option value="1">买家</option>
                                <option value="2">卖家</option>
                            </select>
                    <input type="button" value="搜索" id="bt_userQuerySubmit" class="bt_search">
                    <br><br>
                </div>
                <table id="userManageTable" class="genTable">
                    <thead class="genTableTitle">
                    <tr>
                        <th width="5%"><input type="checkbox">&nbsp;全选</th>
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
                <div id="bottomTab"></div>
            </div>
            <div id="div_shopManage" class="content">

            </div>
            <div id="div_goodsManage" class="content">

            </div>
            <div id="div_data" class="content">

            </div>
            <div id="div_info" class="content">

            </div>
        </div>
    </div>
    <div id="div_bottom">

    </div>
</body>
</html>
