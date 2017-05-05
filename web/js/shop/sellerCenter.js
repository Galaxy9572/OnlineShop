/**
 * Created by ljy56 on 2017/4/12.
 */
/**
 * 初始化左侧导航条
 */
$(window).load(function () {
    $(".a_userOperator:eq(0)").css("color", "#3cf");
    $(".a_userOperator").click(function () {
        $(".a_userOperator").css("color", "#000");
        $(this).css("color", "#3cf");
    });
});

var addGoods = function () {
    var goodsName = $("#input_goodsName").val();
    var goodsType = $("#select_goodsType").find("option:selected").val();
    var price = $("#input_price").val();
    var discount = $("#input_discount").val();
  $.post("../goods/addGoods",{"goodsName":goodsName,"goodsType":goodsType,"price":price,"discount":discount},function (data) {
      var status = data.status;
      var msg = data.msg;
      if(status === "1"){
          alert(msg,null,{type:"success"});
      }else{
          alert(msg,null,{type:"error"});
      }
  },"json");
};