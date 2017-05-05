/**
 * Created by ljy56 on 2017/4/3.
 */
var modifyInfo = function (userName) {
    var phone = $("#input_phone").val();
    var email = $("#input_email").val();
    if(checkInfo(phone)){
        $.ajax({
           url:"../user/modifyInfo",
            type:"post",
            dataType:"json",
            data:{
                "userName":userName,
                "phone":phone,
                "email":email
            },
            success:function (data) {
                var status = data.status;
                var msg = data.msg;
                alert("提示",msg,null,null);
            }
        });
    }
};

var checkInfo = function(phone){
    if(phone.length!==11){
        alert("提示","手机号码填写错误",null,{type:"error"});
        return false;
    }
    return true;
};
