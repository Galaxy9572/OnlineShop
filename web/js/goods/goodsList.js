/**
 * ljy56
 * 2017/5/14
 */
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
                                .append("<td>" + '<input type="button" value="删除">' + "</td>")
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