/**
 * Created by ljy56 on 2017/4/15.
 */
var submit = function () {
    var userName = $("#input_userName").val();
    var password = $("#input_password").val();
    $.ajax({
        url:"login",
        type:"post",
        dataType:"json",
        data: {
            "userName":userName,
            "password":password
        },
        success:function (data) {
            var status = data.status;
            var msg = data.msg;
            if(status === "1"){
                alert("提示",msg,null,{type:"success"});
                window.location.href = "index";
            }else{
                alert("提示",msg,null,{type:"error"});
            }
        }
    });
};
