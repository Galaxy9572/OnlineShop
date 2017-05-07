/**
 * Created by ljy56 on 2017/4/13.
 */
$(window).load(function () {
    $(".a_userOperator:eq(0)").css("color", "#3cf");
    $(".a_userOperator").click(function () {
        $(".a_userOperator").css("color", "#000");
        $(this).css("color", "#3cf");
    });

});

var PAGESIZE = 10;
var options = {
    currentPage: 1,  //当前页数
    totalPages: 10,  //总页数，这里只是暂时的，后头会根据查出来的条件进行更改
    size:"normal",
    alignment:"center",
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
                return  page;
        }
    },
    onPageClicked: function (e, originalEvent, type, page) {
        var userName = $("#textInput").val(); //取内容
        var userType = $("#select_userType").find("option:selected").val();
        userManageTable(userName,userType,page,PAGESIZE);//默认每页最多10条
    }
}

//生成表格
function userManageTable(userName,userType,pageNumber,pageSize) {
    var url = "queryUserByCondition"; //请求的网址
    var reqParams = {
        'userName':userName,
        'userType':userType,
        'pageNumber':pageNumber,
        'pageSize':pageSize
    };//请求数据
    $(function () {
        $.ajax({
            type:"POST",
            url:url,
            data:reqParams,
            async:false,
            dataType:"json",
            success: function(data){
                if(data.isError == false) {
                    // options.totalPages = data.pages;
                    var newoptions = {
                        currentPage: 1,  //当前页数
                        totalPages: data.pages==0?1:data.pages,  //总页数
                        size:"normal",
                        alignment:"center",
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
                                    return  page;
                            }
                        },
                        onPageClicked: function (e, originalEvent, type, page) {
                            var userName = $("#textInput").val(); //取内容
                            var userType = $("#select_userType").find("option:selected").val();
                            userManageTable(userName,userType,page,PAGESIZE);//默认每页最多10条
                        }
                    };
                    $('#bottomTab').bootstrapPaginator("setOptions",newoptions); //重新设置总页面数目
                    var dataList = data.dataList;
                    $("#userManageTableBody").empty();//清空表格内容
                    if (dataList.length > 0 ) {
                        $(dataList).each(function(){//重新生成
                            $("#userManageTableBody").append('<tr>')
                                .append('<td>' + '<input type="checkbox">' + '</td>')
                                .append('<td>' + this.userId + '</td>')
                                .append('<td>' + this.userName + '</td>')
                                .append('<td>' + this.userType + '</td>')
                                .append('<td>' + this.email + '</td>')
                                .append('<td>' + this.phone + '</td>')
                                .append('<td>' + this.statement + '</td>')
                                .append('<td>' + this.regTime + '</td>')
                                .append('<td>' + this.modifyTime + '</td>')
                                .append('<td>' + '<input type="button" value="删除">' + '</td>')
                                .append('</tr>');
                        });
                    } else {
                        $("#tableBody").append('<tr><th colspan ="4"><center>暂无数据</center></th></tr>');
                    }
                }else{
                    alert(data.errorMsg);
                }
            },
            error: function(e){
                alert("查询失败:" + e);
            }
        });
    });
}

//渲染完就执行
$(function() {
    //生成底部分页栏
    $('#bottomTab').bootstrapPaginator(options);
    userManageTable("","",1,10);//默认空白查全部
    //创建结算规则
    $("#bt_userQuerySubmit").bind("click",function(){
        var userName = $("#userName").val();
        var userType = $("#select_userType").find("option:selected").val();
        userManageTable(userName,userType,1,PAGESIZE);
    });
});