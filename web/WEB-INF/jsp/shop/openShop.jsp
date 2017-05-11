<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>开店</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
      <link rel="stylesheet" type="text/css" href="<%=path%>/css/beAlert.css">
      <link rel="stylesheet" type="text/css" href="<%=path%>/css/shop/openShop.css">
      <script src="<%=path%>/js/jquery-1.12.3.min.js"></script>
      <script src="<%=path%>/js/jquery-1.8.3.min.js"></script>
      <script src="<%=path%>/js/beAlert.js"></script>
      <script src="<%=path%>/js/shop/openShop.js"></script>
  </head>
  
  <body>
    <div id="div_top">
      <a href="<%=path%>"><img class="logo" alt="LOGO" src="<%=path%>/image/logo.png" /></a>
      <div class="separator"></div>
      <div id="div_title">
        <h1>开店</h1>
      </div>
    </div>
    <div id="div_middle">
        <div id="div_shop_table">
            <table id="shop_table">
                <tr>
                    <td>店铺头像</td><td><img id="portrait" src="<%=path%>/image/default-head.png"></td>
                </tr>
                <tr>
                    <td>店主</td><td>${sessionScope.user.userName}</td>
                </tr>
                <tr>
                    <td>店铺名</td><td><input type="text" id="input_shopName" class="inputs"/></td>
                </tr>
                <tr>
                    <td>店铺类型</td>
                    <td>
                        <select id="select_shopType" class="select">
                            <c:forEach var="type" items="${requestScope.shopType}" varStatus="status">
                                <option value="${type.key()}">${type.value()}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>地点：</td>
                    <td>
                        <div id="city_1">
                            省份：<select id="select_province">
                                    <option value="湖南">湖南</option>
                                </select>
                            市/区：<select id="select_city">
                                    <option value="益阳">益阳</option>
                                </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input id="bt_submit" class="submit" type="button" value="确认" onclick="submit();"></td>
                </tr>
                <input type="hidden" id="hidden_userId" value="${sessionScope.user.userId}">
            </table>
        </div>
    </div>
    <div id="div_bottom">
        <div id="div_bottom_rights" class="bottom_rights">
            <hr class="bottom_separator">
            <p>
                基于SpringMVC、Spring和MyBatis的网上商城<br> 1306102-04 廖俊瑶 毕业设计 <br>
                <img class="img_frameworks" alt="Spring" src="<%=path%>/image/spring-logo.png" />
                <img class="img_frameworks" alt="MyBatis" src="<%=path%>/image/mybatis-logo.png" />
                <br>
            </p>
        </div>
    </div>
  </body>
</html>
