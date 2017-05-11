<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">

<title>搜索结果</title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/common.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/search/searchResult.css">

</head>

<body>
	<div id="body">
		<div id="div_top">
			<div id="div_top_logo" class="div_tops">
				<img id="img_logo" src="<%=path%>/image/logo.png">
			</div>
			<div id="div_search" class="div_tops">
				<select id="select_search">
					<option value="1">用户</option>
					<option value="2">商品</option>
					<option value="3">商家</option>
				</select>
				<input id="input_search" type="text" maxlength="15" name="keyWord" placeholder="搜索用户、商品、商家"> <input id="bt_search"
					type="submit" value="">
			</div>
			<div id="div_searchResult">
				<table id="searchResultTable" class="orderTable">
					<thead class="tableTitle">
                    <tr>
                        <c:choose>
                            <c:when test="${requestScope.userSearchResult != null}">
                                <th width="5%"><input type="checkbox">&nbsp;全选</th>
                                <th width="15%">用户名</th>
                                <th width="15%">用户类型</th>
                                <th width="5%">操作</th>
                            </c:when>
                            <c:when test="${requestScope.goodsSearchResult != null}">
                                <th width="5%"><input type="checkbox">&nbsp;全选</th>
                                <th width="15%">商品名</th>
                                <th width="15%">所属商店</th>
                                <th width="10%">价格</th>
                                <th width="10%">折扣</th>
                                <th width="5%">操作</th>
                            </c:when>
							<c:when test="${requestScope.shopSearchResult != null}">
								<th width="5%"><input type="checkbox">&nbsp;全选</th>
								<th width="15%">商店名</th>
								<th width="15%">地区</th>
								<th width="5%">操作</th>
							</c:when>
                        </c:choose>
					</tr>
					</thead>
					<tbody>
                    <tr>
					<c:choose>
						<c:when test="${requestScope.userSearchResult == null || requestScope.goodsSearchResult == null || requestScope.shopSearchResult == null}">
							<td colspan="5">暂无记录</td>
						</c:when>
                        <c:when test="${requestScope.userSearchResult != null}">
                            <th width="5%"><input type="checkbox">&nbsp;全选</th>
                            <th width="15%">用户名</th>
                            <th width="15%">用户类型</th>
                            <th width="5%">操作</th>
                        </c:when>
                        <c:when test="${requestScope.goodsSearchResult != null}">
                            <th width="5%"><input type="checkbox">&nbsp;全选</th>
                            <th width="15%">商品名</th>
                            <th width="15%">所属商店</th>
                            <th width="10%">价格</th>
                            <th width="10%">折扣</th>
                            <th width="5%">操作</th>
                        </c:when>
                        <c:when test="${requestScope.shopSearchResult != null}">
                            <th width="5%"><input type="checkbox">&nbsp;全选</th>
                            <th width="15%">商店名</th>
                            <th width="15%">地区</th>
                            <th width="5%">操作</th>
                        </c:when>
                    </c:choose>
                    </tr>
                    </tbody>
                </table>
			</div>

		</div>
		<div id="div_middle"></div>
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
	</div>
</body>
</html>
