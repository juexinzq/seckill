//存放主要交互逻辑代码
//javascript 模块化
var seckill={
    //封装秒杀相关ajax的url
    URL:{

    },
    //验证手机号
    validatePhone:function () {

    },
    //详情页秒杀逻辑
    detail:{
        //详情页初始化
        init:function (params) {
            //手机验证和登陆，计时交互
            //规划交互流程
            //在cookie查找手机号
            var killPhone=$.cookie('killPhone');
            var startTime=params['startTime'];
            var endTime=params['endTime'];
            var seckillId=params['seckillId'];

            //验证手机号
        }
    }
}