<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>银行卡</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/bankcard/bankcardInfo.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/beAlert.css">
    <script src="<%=path%>/js/bankcard/bankcardInfo.js"></script>
    <script src="<%=path%>/js/jquery-1.12.3.min.js"></script>
    <script src="<%=path%>/js/jquery-1.8.3.min.js"></script>
    <script src="<%=path%>/js/beAlert.js"></script>
</head>
<body>
    <div id="div_top">
        <a href="<%=path%>"><img class="logo" alt="LOGO" src="<%=path%>/image/logo.png" /></a>
        <div class="separator"></div>
        <div id="div_title">
            <h1>银行卡</h1>
        </div>
    </div>
    <div id="div_middle">
        <div id="div_left">
            <dl id="dl_userOperator">
                <dd><a href="#div_myBankcard" class="a_userOperator">我的银行卡</a></dd>
                <dd><a href="#div_addBankcard" class="a_userOperator">添加银行卡</a></dd>
            </dl>
        </div>
        <div id="div_right">
            <div id="div_addBankcard" class="content">
                <h3 class="tableTitle">添加银行卡</h3>
                <table id="addBankCardTable">
                    <tr>
                        <td>银行名称</td><td><input type="text" id="bankCardName" class="inputs"/></td>
                    </tr>
                    <tr>
                        <td>卡号</td><td><input type="text" id="bankCardId" class="inputs"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><button id="bt_submit">确定</button></td>
                    </tr>
                </table>
            </div>
            <div id="div_myBankcard" class="content">
                <c:forEach var="item" items="${requestScope.myBancards}">
                    <div class="div_bankcard">
                        <img src="<%=path%>/image/common/bankcard.png" class="bankcardImg"/>
                        <div class="div_bankcard_info">
                            银行：${item.bankName}
                            卡号：${item.bankCardId}
                        </div>
                        <div class="div_bankcard_operate">
                            <a href="javascript:void(0);" onclick="deleteBankCard(${item.bankCardId});">删除</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <div id="div_bottom">

    </div>
    <input id="input_userId" type="hidden" value="${sessionScope.user.userId}"/>
</body>
</html>
