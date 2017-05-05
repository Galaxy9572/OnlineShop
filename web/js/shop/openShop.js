    /**
     * Created by ljy56 on 2017/4/4.
     */
    var submit = function () {
    var userId = $("#hidden_userId").val();
    var shopName = $("#input_shopName").val();
    var shopType = $("#select_shopType").find("option:selected").val();
    $.ajax({
        url:"shop/openShop/confirm",
        type:"post",
        dataType:"json",
        data:{
            "userId":userId,
            "shopName":shopName,
            "shopType":shopType
        },
        success:function (data) {
            var status = data.status;
            var msg = data.msg;
            if(status === "1"){
                alert("提示",msg,null,null);
            }else{
                alert("提示",msg,null,null);
            }
        }
    });
};