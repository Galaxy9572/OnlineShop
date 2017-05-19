/**
 * ljy56
 * 2017/5/18
 */
var checkIfLogin = function(userId){
    if(userId === ""){
        window.location.href="../user/login";
    }
};

var showInfo = function (data) {
    var status = data.status;
    var msg = data.msg;
    if (status === "1") {
        alert("提示", msg, null, {type: 'success'});
    } else {
        alert("提示", msg, null, {type: 'error'});
    }
};

var collect = function () {
    var userId = $("#input_userId").val();
    var shopId = $("#input_shopId").val();
    var goodsId = $("#input_goodsId").val();
    checkIfLogin(userId);
    $.post(
        "../collect/collect",{
            "goodsId":goodsId,
            "userId":userId,
            "shopId":shopId
        },
        function (data) {
            showInfo(data);
        },"json"
    );
};

var addToCart = function () {
    var userId = $("#input_userId").val();
    var goodsId = $("#input_goodsId").val();
    checkIfLogin(userId);
    $.post(
        "../shoppingCart/addToCart",{
            "goodsId":goodsId,
            "userId":userId
        },
        function (data) {
            showInfo(data);
        },"json"
    );
};

var buyNow = function () {

};