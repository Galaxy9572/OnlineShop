<%--
  Created by IntelliJ IDEA.
  User: ljy56
  Date: 2017/4/3
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>用户信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/userInfo.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/public.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/beAlert.css">
    <script src="${pageContext.request.contextPath}/js/user/userInfo.js"></script>
    <script src="${pageContext.request.contextPath}/js/jQuery-1.12.3.js"></script>
    <script src="${pageContext.request.contextPath}/js/beAlert.js"></script>
</head>
<body>
    <div id="div_top">
        <a href="${pageContext.request.contextPath}"><img class="logo" alt="LOGO" src="${pageContext.request.contextPath}/image/logo.png" /></a>
        <div class="separator"></div>
        <div id="div_title">
            <h1>用户信息</h1>
        </div>
    </div>
    <div id="div_middle">
        <div id="div_userInfo_table">
            <table id="userInfo_table">
                <tr>
                    <td>头像：</td>
                    <td colspan="2"><img id="portrait" alt="portrait" src="${pageContext.request.contextPath}/image/default-head.png" ></td>
                </tr>
                <tr>
                    <td>用户名：</td>
                    <td colspan="2">${sessionScope.user.userName}</td>
                </tr>
                <tr>
                    <td>手机号：</td>
                    <td colspan="2"><input class="inputs" id="input_phone" type="text" value="${sessionScope.user.phone}"></td>
                </tr>
                <tr>
                    <td>电子邮件：</td>
                    <td colspan="2"><input class="inputs" id="input_email" type="text" value="${sessionScope.user.email}"></td>
                </tr>
                <tr>
                    <td>用户类型：</td>
                    <td colspan="2">
                        <c:if test="${sessionScope.user.userType == '1'}">
                            普通用户
                            <a href="${pageContext.request.contextPath}/shop/openShop">成为卖家</a>
                        </c:if>
                        <c:if test="${sessionScope.user.userType == '2'}">
                            卖家
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input id="bt_submit" class="submit" type="button" value="确认" onclick="modifyInfo(${sessionScope.user.userName});"></td>
                </tr>
            </table>
        </div>
    </div>
    <div id="div_bottom">
        <div id="div_bottom_rights" class="bottom_rights">
            <hr class="bottom_separator">
            <p>
                基于SpringMVC、Spring和MyBatis的网上商城<br>
                1306102-04 廖俊瑶 毕业设计
                <br>
                <img class="img_frameworks" alt="Spring" src="${pageContext.request.contextPath}/image/spring-logo.png"/>
                <img class="img_frameworks" alt="MyBatis" src="${pageContext.request.contextPath}/image/mybatis-logo.png"/>
                <br>
            </p>
        </div>
    </div>
</body>
</html>
