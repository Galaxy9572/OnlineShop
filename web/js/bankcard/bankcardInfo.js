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
        var bankName = $("#bankName").val();
        var bankCardId = $("#bankCardId").val();
        $.post(
            "addBankCard",{
                "userId":userId,
                "bankCardId":bankCardId,
                "bankName":bankName
            },function (data) {
                showInfo(data);
            },"json"
        );
    }
};

var deleteBankCard = function (bankCardId) {
    confirm("你确定要删除吗", "操作将无法复原！", function (isConfirm) {
        if (isConfirm) {
            $.ajax({
                url:"deleteBankCard",
                type:"post",
                dataType:"json",
                data:{
                    "bankCardId":bankCardId
                },
                success:function (data) {
                    showInfo(data);
                }
            });
        } else {
            //取消按钮：什么都不干
        }
    }, {confirmButtonText: '确定', cancelButtonText: '取消', width: 400});
};