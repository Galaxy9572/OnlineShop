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

var deleteBankCard = function (bankCardId) {
    $.ajax({
        url:"deleteBankcardById",
        type:"post",
        dataType:"json",
        data:{
            "bakCardId":bankCardId
        },
        success:function (data) {
            showInfo(data);
        }
    });
};