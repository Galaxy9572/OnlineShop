/**
 * Created by ljy56 on 2017/4/13.
 */
$(window).load(function () {
    $(".a_userOperator:eq(0)").css("color", "#3cf");
    $(".a_userOperator").click(function () {
        $(".a_userOperator").css("color", "#000");
        $(this).css("color", "#3cf");
    });
    $("#cbSelectAllUser").click(function () {
        if ($(this).prop("checked")) {
            selectAllCheckboxes("user", true);
        } else {
            selectAllCheckboxes("user", false);
        }
    });
});

var showInfo = function (data) {
    var status = data.status;
    var msg = data.msg;
    if (status === "1") {
        alert("提示", msg, null, {type: 'success'});
    } else {
        alert("提示", msg, null, {type: 'error'});
    }
};

/**
 * 根据指定的复选框类型和选择状态选择复选框
 * @param checkboxType user,shop,goods
 * @param ifSelect true或者false
 */
var selectAllCheckboxes = function (checkboxType, ifSelect) {
    $("." + checkboxType + "Checkboxes").each(function () {
        $(this).prop("checked", ifSelect);
    });
};

/**
 * 获取被选中的用户的ID
 */
var getSelectedUserIds = function () {
    var selectedUsers = $(".userCheckboxes:checked");
    var userIds = [];
    selectedUsers.each(function (i) {
        if ($(this).prop("checked") === true) {
            userIds[i] = $(this).attr("data-userId");
        }
    });
    // console.log("选中的用户ID："+userIds);
    return userIds;
};

var deleteUser = function (userId) {
    confirm("你确定要删除吗", "操作将无法复原！", function (isConfirm) {
        if (isConfirm) {
            $.ajax({
                url: "deleteUser",
                type: "post",
                dataType: "json",
                data: {
                    "userId":userId
                },
                success: function (data) {
                    showInfo(data);
                }
            });
        } else {
            //取消按钮：什么都不干
        }
    }, {confirmButtonText: '确定', cancelButtonText: '取消', width: 400});
};

var deleteUsers = function () {
    confirm("你确定要删除吗", "操作将无法复原！", function (isConfirm) {
        if (isConfirm) {
            var userIds = getSelectedUserIds();
            $.ajax({
                url: "deleteUser",
                type: "post",
                dataType: "json",
                data: {"userIds": userIds},
                success: function (data) {
                    showInfo(data);
                }
            });
        } else {
            //取消按钮：什么都不干
        }
    }, {confirmButtonText: '确定', cancelButtonText: '取消', width: 400});
};

var deleteShop = function (shopId) {
    confirm("你确定要删除吗", "操作将无法复原！", function (isConfirm) {
        if (isConfirm) {
            $.ajax({
                url: "deleteShop",
                type: "post",
                dataType: "json",
                data: {
                    "shopId":shopId
                },
                success: function (data) {
                    showInfo(data);
                }
            });
        } else {
            //取消按钮：什么都不干
        }
    }, {confirmButtonText: '确定', cancelButtonText: '取消', width: 400});
};

var deleteGoods = function (goodsId) {
    confirm("你确定要删除吗", "操作将无法复原！", function (isConfirm) {
        if (isConfirm) {
            $.ajax({
                url: "deleteGoods",
                type: "post",
                dataType: "json",
                data: {"goodsId": goodsId},
                success: function (data) {
                    showInfo(data);
                }
            });
        } else {
            //取消按钮：什么都不干
        }
    }, {confirmButtonText: '确定', cancelButtonText: '取消', width: 400});
};

var PAGESIZE = 10;
var userTableOptions = {
    currentPage: 1,  //当前页数
    totalPages: 10,  //总页数，这里只是暂时的，后头会根据查出来的条件进行更改
    size: "normal",
    alignment: "center",
    itemTexts: function (type, page, current) {
        switch (type) {
            case "first":
                return "第一页";
            case "prev":
                return "前一页";
            case "next":
                return "后一页";
            case "last":
                return "最后页";
            case "page":
                return page;
        }
    },
    onPageClicked: function (e, originalEvent, type, page) {
        var userName = $("#userName").val(); //取内容
        var userType = $("#select_userType").find("option:selected").val();
        userManageTable(userName, userType, page, PAGESIZE);//默认每页最多10条
    }
};

//生成表格
function userManageTable(userName, userType, pageNumber, pageSize) {
    var url = "queryUserByCondition"; //请求的URL
    var reqParams = {
        'userName': userName,
        'userType': userType,
        'pageNumber': pageNumber,
        'pageSize': pageSize
    };//请求数据
    $(function () {
        $.ajax({
            type: "POST",
            url: url,
            data: reqParams,
            async: false,
            dataType: "json",
            success: function (data) {
                if (data.isError == false) {
                    // options.totalPages = data.pages;
                    var newoptions = {
                        currentPage: 1,  //当前页数
                        totalPages: data.pages == 0 ? 1 : data.pages,  //总页数
                        size: "normal",
                        alignment: "center",
                        itemTexts: function (type, page, current) {
                            switch (type) {
                                case "first":
                                    return "第一页";
                                case "prev":
                                    return "前一页";
                                case "next":
                                    return "后一页";
                                case "last":
                                    return "最后页";
                                case "page":
                                    return page;
                            }
                        },
                        onPageClicked: function (e, originalEvent, type, page) {
                            var userName = $("#textInput").val(); //取内容
                            var userType = $("#select_userType").find("option:selected").val();
                            userManageTable(userName, userType, page, PAGESIZE);//默认每页最多10条
                        }
                    };
                    $('#userPaginator').bootstrapPaginator("setOptions", newoptions); //重新设置总页面数目
                    var dataList = data.dataList;
                    $("#userManageTableBody").empty();//清空表格内容
                    if (dataList.length > 0) {
                        $(dataList).each(function () {//重新生成
                            $("#userManageTableBody").append("<tr>")
                                .append("<td>" + "<input type='checkbox' class='userCheckboxes' data-userId='" + this.userId + "'</td>")
                                .append("<td>" + this.userId + "</td>")
                                .append("<td>" + this.userName + "</td>")
                                .append("<td>" + this.userType + "</td>")
                                .append("<td>" + this.email + "</td>")
                                .append("<td>" + this.phone + "</td>")
                                .append("<td>" + this.statement + "</td>")
                                .append("<td>" + this.regTime + "</td>")
                                .append("<td>" + this.modifyTime + "</td>")
                                .append("<td>" + "<input type='button' value='删除' onclick='deleteUser("+this.userId+");'>" + "</td>")
                                .append('</tr>');
                        });
                    } else {
                        $("#userManageTableBody").append('<tr><th colspan ="10"><center>暂无数据</center></th></tr>');
                    }
                } else {
                    alert(data.errorMsg);
                }
            },
            error: function (e) {
                alert("查询失败:" + e);
            }
        });
    });
}

var shopTableOptions = {
    currentPage: 1,  //当前页数
    totalPages: 10,  //总页数，这里只是暂时的，后头会根据查出来的条件进行更改
    size: "normal",
    alignment: "center",
    itemTexts: function (type, page, current) {
        switch (type) {
            case "first":
                return "第一页";
            case "prev":
                return "前一页";
            case "next":
                return "后一页";
            case "last":
                return "最后页";
            case "page":
                return page;
        }
    },
    onPageClicked: function (e, originalEvent, type, page) {
        var shopName = $("#shopName").val(); //取内容
        var shopType = $("#select_shopType").find("option:selected").val();
        shopManageTable(shopName, shopType, page, PAGESIZE);//默认每页最多10条
    }
};

//生成表格
function shopManageTable(shopName, shopType, pageNumber, pageSize) {
    var url = "queryShopByCondition"; //请求的URL
    var reqParams = {
        'shopName': shopName,
        'shopType': shopType,
        'pageNumber': pageNumber,
        'pageSize': pageSize
    };//请求数据
    $(function () {
        $.ajax({
            type: "POST",
            url: url,
            data: reqParams,
            async: false,
            dataType: "json",
            success: function (data) {
                if (data.isError == false) {
                    // options.totalPages = data.pages;
                    var newoptions = {
                        currentPage: 1,  //当前页数
                        totalPages: data.pages == 0 ? 1 : data.pages,  //总页数
                        size: "normal",
                        alignment: "center",
                        itemTexts: function (type, page, current) {
                            switch (type) {
                                case "first":
                                    return "第一页";
                                case "prev":
                                    return "前一页";
                                case "next":
                                    return "后一页";
                                case "last":
                                    return "最后页";
                                case "page":
                                    return page;
                            }
                        },
                        onPageClicked: function (e, originalEvent, type, page) {
                            var shopName = $("#shopName").val(); //取内容
                            var shopType = $("#select_shopType").find("option:selected").val();
                            shopManageTable(shopName, shopType, page, PAGESIZE);//默认每页最多10条
                        }
                    };
                    $('#shopPaginator').bootstrapPaginator("setOptions", newoptions); //重新设置总页面数目
                    var dataList = data.dataList;
                    $("#shopManageTableBody").empty();//清空表格内容
                    if (dataList.length > 0) {
                        $(dataList).each(function () {//重新生成
                            $("#shopManageTableBody").append('<tr>')
                                .append("<td>" + "<input type='checkbox' class='shopCheckboxes' data-shopId='" + this.shopId + "'</td>")
                                .append("<td>" + this.shopId + "</td>")
                                .append("<td>" + this.userId + "</td>")
                                .append("<td>" + this.shopName + "</td>")
                                .append("<td>" + this.shopType + "</td>")
                                .append("<td>" + this.location + "</td>")
                                .append("<td>" + this.rank + "</td>")
                                .append("<td>" + this.statement + "</td>")
                                .append("<td>" + this.createTime + "</td>")
                                .append("<td>" + this.modifyTime + "</td>")
                                .append("<td>" + "<input type='button' value='删除' onclick='deleteShop("+this.shopId+");'>" + "</td>")
                                .append('</tr>');
                        });
                    } else {
                        $("#shopManageTableBody").append('<tr><th colspan ="11"><center>暂无数据</center></th></tr>');
                    }
                } else {
                    alert(data.errorMsg);
                }
            },
            error: function (e) {
                alert("查询失败:" + e);
            }
        });
    });
}

var goodsTableOptions = {
    currentPage: 1,  //当前页数
    totalPages: 10,  //总页数，这里只是暂时的，后头会根据查出来的条件进行更改
    size: "normal",
    alignment: "center",
    itemTexts: function (type, page, current) {
        switch (type) {
            case "first":
                return "第一页";
            case "prev":
                return "前一页";
            case "next":
                return "后一页";
            case "last":
                return "最后页";
            case "page":
                return page;
        }
    },
    onPageClicked: function (e, originalEvent, type, page) {
        var shopName = $("#shopName").val(); //取内容
        var shopType = $("#select_shopType").find("option:selected").val();
        shopManageTable(shopName, shopType, page, PAGESIZE);//默认每页最多10条
    }
};

//生成表格
function goodsManageTable(goodsName, goodsType, pageNumber, pageSize) {
    var url = "../goods/queryGoodsByCondition"; //请求的URL
    var reqParams = {
        'goodsName': goodsName,
        'goodsType': goodsType,
        'pageNumber': pageNumber,
        'pageSize': pageSize
    };//请求数据
    $(function () {
        $.ajax({
            type: "POST",
            url: url,
            data: reqParams,
            async: false,
            dataType: "json",
            success: function (data) {
                if (data.isError == false) {
                    // options.totalPages = data.pages;
                    var newoptions = {
                        currentPage: 1,  //当前页数
                        totalPages: data.pages == 0 ? 1 : data.pages,  //总页数
                        size: "normal",
                        alignment: "center",
                        itemTexts: function (type, page, current) {
                            switch (type) {
                                case "first":
                                    return "第一页";
                                case "prev":
                                    return "前一页";
                                case "next":
                                    return "后一页";
                                case "last":
                                    return "最后页";
                                case "page":
                                    return page;
                            }
                        },
                        onPageClicked: function (e, originalEvent, type, page) {
                            var goodsName = $("#goodsName").val();
                            var goodsType = $("#select_goodsType").find("option:selected").val();
                            goodsManageTable(goodsName, goodsType, page, PAGESIZE);//默认每页最多10条
                        }
                    };
                    $('#goodsPaginator').bootstrapPaginator("setOptions", newoptions); //重新设置总页面数目
                    var dataList = data.dataList;
                    $("#goodsManageTableBody").empty();//清空表格内容
                    if (dataList.length > 0) {
                        $(dataList).each(function () {//重新生成
                            $("#goodsManageTableBody").append('<tr>')
                                .append("<td>" + "<input type='checkbox' class='goodsCheckboxes' data-goodsId='" + this.goodsId + "'</td>")
                                .append("<td>" + this.goodsId + "</td>")
                                .append("<td>" + this.shopId + "</td>")
                                .append("<td>" + this.goodsName + "</td>")
                                .append("<td>" + this.goodsType + "</td>")
                                .append("<td>" + this.price + "</td>")
                                .append("<td>" + this.discout + "</td>")
                                .append("<td>" + this.rank + "</td>")
                                .append("<td>" + this.statement + "</td>")
                                .append("<td>" + this.createTime + "</td>")
                                .append("<td>" + this.modifyTime + "</td>")
                                .append("<td>" + "<input type='button' value='删除' onclick='deleteGoods("+this.goodsId+")'>" + "</td>")
                                .append("</tr>");
                        });
                    } else {
                        $("#goodsManageTableBody").append('<tr><th colspan ="12"><center>暂无数据</center></th></tr>');
                    }
                } else {
                    alert(data.errorMsg);
                }
            },
            error: function (e) {
                alert("查询失败:" + e);
            }
        });
    });
}

//渲染完就执行
$(function () {
    //生成底部分页栏
    $('#userPaginator').bootstrapPaginator(userTableOptions);
    var userName = $("#userName").val();
    var userType = $("#select_userType").find("option:selected").val();
    userManageTable(userName, userType, 1, 10);//默认空白查全部
    //创建结算规则
    $("#bt_userQuerySubmit").bind("click", function () {
        var userName = $("#userName").val();
        var userType = $("#select_userType").find("option:selected").val();
        userManageTable(userName, userType, 1, PAGESIZE);
    });

    //生成底部分页栏
    $('#shopPaginator').bootstrapPaginator(shopTableOptions);
    var shopName = $("#shopName").val();
    var shopType = $("#select_shopType").find("option:selected").val();
    shopManageTable(shopName, shopType, 1, 10);//默认空白查全部
    //创建结算规则
    $("#bt_shopQuerySubmit").bind("click", function () {
        var shopName = $("#shopName").val();
        var shopType = $("#select_shopType").find("option:selected").val();
        userManageTable(userName, userType, 1, PAGESIZE);
    });

    //生成底部分页栏
    $('#goodsPaginator').bootstrapPaginator(goodsTableOptions);
    var goodsName = $("#goodsName").val();
    var goodsType = $("#select_goodsType").find("option:selected").val();
    goodsManageTable(shopName, shopType, 1, 10);//默认空白查全部
    //创建结算规则
    $("#bt_goodsQuerySubmit").bind("click", function () {
        var goodsName = $("#goodsName").val();
        var goodsType = $("#select_goodsType").find("option:selected").val();
        goodsManageTable(goodsName, goodsType, 1, PAGESIZE);
    });
});