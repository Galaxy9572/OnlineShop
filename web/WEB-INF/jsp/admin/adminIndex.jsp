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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/public.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/beAlert.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/adminIndex.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tables.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
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
                <dd><a href="#div_buyerManage" class="a_userOperator">买家管理</a></dd>
                <dd><a href="#div_sellerManage" class="a_userOperator">卖家管理</a></dd>
                <dd><a href="#div_shopManage" class="a_userOperator">商店管理</a></dd>
                <dd><a href="#div_goodsManage" class="a_userOperator">商品管理</a></dd>
                <dd><a href="#div_data" class="a_userOperator">数据统计</a></dd>
            </dl>
        </div>
        <div id="div_right">
            <div id="div_buyerManage" class="content">
                <h3 class="tableTitle">买家管理</h3>
                <div id="div_buyerFilter">
                    用户ID： <input type="text" id="buyerId" class="inputs">
                    用户名： <input type="text" id="buyerName" class="inputs">
                    当前页： <select>
                                <c:if test="${requestScope.buyerPage != null}">
                                    <c:forEach begin="1" end="${requestScope.buyerPage.totalPageCount}" varStatus="status">
                                        <option value="${status.index}">${status.index}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                    <input type="button" value="搜索" id="bt_buyerQuerySubmit" class="bt_search">
                    <br><br>
                </div>
                <table id="buyerManageTable" class="genTable">
                    <thead class="genTableTitle">
                    <tr>
                        <th width="5%"><input type="checkbox">&nbsp;全选</th>
                        <th width="10%">ID</th>
                        <th width="15%">用户名</th>
                        <th width="10%">用户类型</th>
                        <th width="15%">E-Mail</th>
                        <th width="10%">手机</th>
                        <th width="10%">状态</th>
                        <th width="10%">创建时间</th>
                        <th width="10%">修改时间</th>
                        <th width="5%">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                        <c:when test="${requestScope.allBuyers == null}">
                            <tr><td colspan="10">暂无记录</td></tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="item" items="${requestScope.allBuyers}">
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>${item.userId}</td>
                                    <td>${item.userName}</td>
                                    <td>${item.userType}</td>
                                    <td>${item.email}</td>
                                    <td>${item.phone}</td>
                                    <td>${item.statement}</td>
                                    <td>${item.createTime}</td>
                                    <td>${item.modifyTime}</td>
                                    <td><a href="">删除</a></td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                    </tbody>
                </table>
                <div class="div_page">
                    ${requestScope.page.totalCount}
                </div>
            </div>
            <div id="div_sellerManage" class="content">
                <h3 class="tableTitle">卖家管理</h3>
                <div id="div_sellerFilter">
                    用户ID： <input type="text" id="sellerId" class="inputs">
                    用户名： <input type="text" id="sellerName" class="inputs">
                    <input type="button" value="搜索" id="bt_sellerQuerySubmit" class="bt_search">
                    <br><br>
                </div>
                <table id="sellerManageTable" class="genTable">
                    <thead class="genTableTitle">
                    <tr>
                        <th width="5%"><input type="checkbox">&nbsp;全选</th>
                        <th width="10%">ID</th>
                        <th width="15%">用户名</th>
                        <th width="10%">用户类型</th>
                        <th width="15%">E-Mail</th>
                        <th width="10%">手机</th>
                        <th width="10%">状态</th>
                        <th width="10%">创建时间</th>
                        <th width="10%">修改时间</th>
                        <th width="5%">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                        <c:when test="${requestScope.allSellers == null}">
                            <tr><td colspan="10">暂无记录</td></tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="item" items="${requestScope.allSellers}">
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>${item.userId}</td>
                                    <td>${item.userName}</td>
                                    <td>${item.userType}</td>
                                    <td>${item.email}</td>
                                    <td>${item.phone}</td>
                                    <td>${item.statement}</td>
                                    <td>${item.createTime}</td>
                                    <td>${item.modifyTime}</td>
                                    <td><a href="">删除</a></td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                    </tbody>
                </table>
                <div class="div_page">
                    ${requestScope.page.totalCount}
                </div>
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
