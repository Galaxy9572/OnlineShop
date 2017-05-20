/**
 * 初始化左侧导航条
 */
$(window).load(function () {
    $(".a_shopOperator:eq(0)").css("color", "#3cf");
    $(".a_shopOperator").click(function () {
        $(".a_shopOperator").css("color", "#000");
        $(this).css("color", "#3cf");
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

var addGoods = function () {
    var shopId = $("#input_shopId").val();
    var goodsName = $("#input_goodsName").val();
    var goodsType = $("#select_addGoodsType").find("option:selected").val();
    var price = $("#input_price").val();
    var discount = $("#input_discount").val();
    console.log(shopId);
    if(shopId === "" || goodsName === "" || goodsType === "" || price === "" || discount === ""){
        alert("请将表格填写完整",null,{type:"error"});
        return;
    }
    $.post(
        "../goods/addGoods",
        {
            "shopId":shopId,
            "goodsName":goodsName,
            "goodsType":goodsType,
            "price":price,
            "discount":discount
        },
        function (data) {
            showInfo(data);
        },"json");
};

var deleteGoods = function (goodsId) {
    confirm("你确定要删除吗", "操作将无法复原！", function (isConfirm) {
        if (isConfirm) {
            $.ajax({
                url: "../goods/deleteGoodsById",
                type: "post",
                dataType: "json",
                data: {
                    "goodsId":goodsId
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

var deleteOrder = function (orderId) {
    confirm("你确定要删除吗", "操作将无法复原！", function (isConfirm) {
        if (isConfirm) {
            console.log(msgId);
            $.ajax({
                url: "../order/deleteOrder",
                type: "post",
                dataType: "json",
                data: {
                    "orderId":orderId
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

var deleteMsg = function (msgId) {
    confirm("你确定要删除吗", "操作将无法复原！", function (isConfirm) {
        if (isConfirm) {
            console.log(msgId);
            $.ajax({
                url: "../userMsg/deleteMsg",
                type: "post",
                dataType: "json",
                data: {
                    "messageId":msgId
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

var PAGESIZE = 10;
var goodsManageTableOptions = {
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
        var goodsName = $("#goodsName").val(); //取内容
        var goodsType = $("#select_goodsType").find("option:selected").val();
        goodsManageTable(goodsName, goodsType, page, PAGESIZE);//默认每页最多10条
    }
};

var msgTableOptions = {
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
        var userId = $("#input_userId").val();
        var msgStatement = $("#select_msgStatement").find("option:selected").val();
        msgTable(userId,msgStatement, page, PAGESIZE);//默认每页最多10条
    }
};

var orderTableOptions = {
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
        var statement = $("#select_orderStatement").find("option:selected").val();
        orderTable(statement,page, PAGESIZE);//默认每页最多10条
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
                if (data.isError === false) {
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
                                .append("<td>" + "<input type='checkbox' data-goodsId='" + this.goodsId + "'</td>")
                                .append("<td>" + this.goodsId + "</td>")
                                .append("<td>" + this.goodsName + "</td>")
                                .append("<td>" + this.goodsType + "</td>")
                                .append("<td>" + this.price + "</td>")
                                .append("<td>" + this.discount + "</td>")
                                .append("<td>" + this.rank + "</td>")
                                .append("<td>" + this.statement + "</td>")
                                .append("<td>" + this.createTime + "</td>")
                                .append("<td>" + this.modifyTime + "</td>")
                                .append("<td>" + "<input type='button' value='删除' onclick='deleteGoods("+this.goodsId+")'>" + "</td>")
                                .append('</tr>');
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

//生成表格
function orderTable(userId,statement,pageNumber, pageSize) {
    var url = "../order/queryOrderByCondition"; //请求的URL
    var reqParams = {
        "queryType":"seller",
        "userId":userId,
        "statement":statement,
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
                if (data.isError === false) {
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
                            var userId = $("#input_userId").val();
                            var orderStatement = $("#select_orderStatement").find("option:selected").val();
                            orderTable(userId,orderStatement,page, PAGESIZE);//默认每页最多10条
                        }
                    };
                    $('#orderPaginator').bootstrapPaginator("setOptions", newoptions); //重新设置总页面数目
                    var dataList = data.dataList;
                    $("#orderTableBody").empty();//清空表格内容
                    if (dataList.length > 0) {
                        $(dataList).each(function () {//重新生成
                            $("#orderTableBody").append('<tr>')
                                .append("<td>" + "<input type='checkbox' data-msgId='" + this.messageId + "'</td>")
                                .append("<td>" + this.userId + "</td>")
                                .append("<td>" + this.goodsId + "</td>")
                                .append("<td>" + this.statement + "</td>")
                                .append("<td>" + this.createDate + "</td>")
                                .append("<td>" + this.modifyDate + "</td>")
                                .append("<td>" + "<input type='button' value='删除' onclick='deleteOrder("+this.orderId+");'>" + "</td>")
                                .append("</tr>");
                        });
                    } else {
                        $("#orderTableBody").append('<tr><th colspan ="6"><center>暂无消息</center></th></tr>');
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

//生成表格
function msgTable(userId, statement, pageNumber, pageSize) {
    var url = "../userMsg/queryMsgByCondition"; //请求的URL
    var reqParams = {
        'userId': userId,
        'statement': statement,
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
                if (data.isError === false) {
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
                            var userId = $("#input_userId").val();
                            var statement = $("#select_msgStatement").find("option:selected").val();
                            msgTable(userId, statement, page, PAGESIZE);//默认每页最多10条
                        }
                    };
                    $('#msgPaginator').bootstrapPaginator("setOptions", newoptions); //重新设置总页面数目
                    var dataList = data.dataList;
                    $("#msgTableBody").empty();//清空表格内容
                    if (dataList.length > 0) {
                        $(dataList).each(function () {//重新生成
                            $("#msgTableBody").append('<tr>')
                                .append("<td>" + "<input type='checkbox' data-msgId='" + this.messageId + "'</td>")
                                .append("<td>" + this.fromUserId + "</td>")
                                .append("<td>" + this.context + "</td>")
                                .append("<td>" + this.statement + "</td>")
                                .append("<td>" + this.createTime + "</td>")
                                .append("<td>" + "<input type='button' value='删除' onclick='deleteMsg("+this.messageId+")'>" + "</td>")
                                .append("</tr>");
                        });
                    } else {
                        $("#msgTableBody").append('<tr><th colspan ="6"><center>暂无消息</center></th></tr>');
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
    var userId = $("#input_userId").val();
    //生成底部分页栏
    $('#goodsPaginator').bootstrapPaginator(goodsManageTableOptions);
    var goodsName = $("#goodsName").val();
    var goodsType = $("#select_goodsType").find("option:selected").val();
    goodsManageTable(goodsName, goodsType, 1, 10);//默认空白查全部
    //创建结算规则
    $("#bt_goodsQuerySubmit").bind("click", function () {
        var goodsName = $("#goodsName").val();
        var goodsType = $("#select_goodsType").find("option:selected").val();
        goodsManageTable(goodsName, goodsType, 1, PAGESIZE);
    });

    //生成底部分页栏
    $('#orderPaginator').bootstrapPaginator(orderTableOptions);
    var orderStatement = $("#select_orderStatement").find("option:selected").val();
    orderTable(userId,orderStatement, 1, 10);//默认空白查全部
    //创建结算规则
    $("#bt_orderQuerySubmit").bind("click", function () {
        var orderStatement = $("#select_orderStatement").find("option:selected").val();
        orderTable(userId,orderStatement, 1, PAGESIZE);
    });

    //生成底部分页栏
    $('#msgPaginator').bootstrapPaginator(msgTableOptions);
    var msgStatement = $("#select_msgStatement").find("option:selected").val();
    msgTable(userId, msgStatement, 1, 10);//默认空白查全部
    //创建结算规则
    $("#bt_msgQuerySubmit").bind("click", function () {
        var userId = $("#input_userId").val();
        var msgStatement = $("#select_msgStatement").find("option:selected").val();
        msgTable(userId, msgStatement, 1, PAGESIZE);
    });
});