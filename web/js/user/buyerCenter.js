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
    initEcharts();
});

/**
 * 初始化数据表
 */
var initEcharts = function(){
    var myChart = echarts.init(document.getElementById("div_echarts"));
    var option = {
        title : {
            text: '数据统计',
            subtext: '纯属虚构',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['衣服','家电','户外用品']
        },
        series : [
            {
                name: '数据统计',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {value:335, name:'衣服'},
                    {value:310, name:'家电'},
                    {value:234, name:'户外用品'}
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    myChart.setOption(option);
};




