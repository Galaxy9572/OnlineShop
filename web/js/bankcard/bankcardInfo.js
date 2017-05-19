/**
 * Created by ljy56 on 2017/5/11.
 */
var showInfo = function (data) {
    var status = data.status;
    var msg = data.msg;
    if (status === "1") {
        alert("提示", msg, null, {type: 'success'});
    } else {
        alert("提示", msg, null, {type: 'error'});
    }
};

var checkInfo = function () {
    var bankCardName = $("#bankCardName").val();
    var bankCardId = $("#bankCardId").val();
    if(bankCardName === "" || bankCardId === ""){
        alert("请将信息填写完整哦",null,{type:'error'});
        return false;
    }
    return true;
};

var addBankCard = function () {
    if(checkInfo()){
        var userId = $("#input_userId").val();
        var bankCardName = $("#bankCardName").val();
        var bankCardId = $("#bankCardId").val();
        $.post(
            "deleteBankCard",{
                "userId":userId,
                "bankCardId":bankCardId,
                "bankCardName":bankCardName
            },function (data) {
                showInfo(data);
            },"json"
        );
    }
};

var deleteBankCard = function (bankCardId) {
    $.ajax({
        url:"deleteBankcardById",
        type:"post",
        dataType:"json",
        data:{
            "bankCardId":bankCardId
        },
        success:function (data) {
            showInfo(data);
        }
    });
};