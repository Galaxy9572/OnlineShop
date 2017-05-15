var doSearch = function() {
    var keyWord = $("#input_search").val();
    var type = $("#select_search").find("option:selected").val();
    if (keyWord === "") {
        alert("搜索内容不能为空哦");
        return;
    }
    $.get("search", {"type": type, "keyWord": keyWord}, "json");
};

var logout = function () {
    confirm("提示","你确定要退出登录吗",function (isConfirm) {
        if(isConfirm){
            window.location.href="user/logout";
        }
    },{type:"question"});
};
