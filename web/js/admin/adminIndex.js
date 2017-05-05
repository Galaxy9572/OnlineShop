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