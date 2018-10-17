<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/10/6
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title id="title">国家创新创业政策信息服务网</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../../js/layui/css/layui.css">
    <link rel="stylesheet" href="../../css/yzhStyle.css">
    <link rel="stylesheet" href="../../css/baseDetail.css">
    <link rel="stylesheet" href="../../css/common.css">
    <script type="text/javascript" src="../../js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="../../js/imgHandle.js"></script>
    <style>
        .dtxq-title-container{padding-top:15px;padding-bottom:0;border-bottom:none;}
        .dtxq-title-container .tongji{margin-top: 7px;margin-bottom: 0;}
        .dtxq-title-container .dashedKong{overflow: hidden;}
        .dtxq-title-container .dashedKong .label2,.dtxq-title-container .dashedKong .label1{float: left;}
        .dtxq-title-container .tongji .label3{margin-right:0;padding-left: 22px;}
        p span{font-size: 16px;}
        p img{display: inline-block;max-width: 80%;}
        .layui-layer-btn{
            text-align: center;
        }
        .readOther{
            position: absolute;
            top: 43px;
        }
        .dtxq-title-container .tongji .label3{
            position: absolute;
            margin-left: -19px;
            padding-left: 0;
        }
        #dtxq-content p:first-child span {
            font-family: 黑体;
            line-height: 200%;
            font-size: 29px;
        }
    </style>
</head>
<body>
<div class="center">
    <div class="index">
        <a class="ind1" href="home.html">首页</a>
        <a>政策详情</a>
    </div>
    <div class="dtxq-article-container">
        <div class="dtxq-title-container" style="position: relative;">
            <p class="tongji dashedKong">
                <label class="label2" id="dtxq-date" style="margin-right:25px;"></label>
                <label class="label1" id="dtxq-laiyuan"></label>
                <label class="label4" id="dtxq-num"></label>
                <label class="label4" style="margin-right:55px;" id="xz-num"></label>
            </p>
            <p class="tongji readOther">
                <%--<a href="javascript:;" id="tpjd">政策解读</a>--%>
                <%--<a href="javascript:;" id="zcjd"></a>--%>
                <%--<a href="javascript:;" id="spft"></a>--%>
                <%--<a href="javascript:;" id="download">下载</a>--%>
                <label class="bdsharebuttonbox label3" data-tag="share_1">
                    <span>分享到</span>
                    <a class="bds_weixin" data-cmd="weixin"></a>
                    <a class="bds_tsina" data-cmd="tsina"></a>
                </label>
            </p>
        </div>
        <div class="dtxq-article-content">
            <div id="dtxq-content" style="min-height: 200px;position: relative;"></div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="../../js/layui/layui.all.js" ></script>
<script type="text/javascript" src="../../js/headerFooter.js"></script>
<script type="text/javascript" src="../../js/common.js"></script>


<script>
    $(function() {
        function getQueryVariable(variable) {
            var query = window.location.search.substring(1);
            var vars = query.split("&");
            for(var i = 0; i < vars.length; i++) {
                var pair = vars[i].split("=");
                if(pair[0] == variable) {
                    return pair[1];
                }
            }
            return(false);
        };
        //详情
        var id = getQueryVariable('id');
        var bdUrl = 'http://localhost:8080/front/skipPolicyDetails.html?id=' + id;
        $.ajax({
            type: "post",
            data: "",
            url: 'getPolicyIssuedPageViewsById.html?id=' + id + '',
            dataType: "json",
            beforeSend: function (xhr) {
                $('#dtxq-content').append('<img src="/imgs/huanchong.gif" id="huanchong">');
            },
            success: function (res) {
                    var data = res.data[0];
                    $("#title").text(preDetailTitle + data.name);
                    var shareTitle = data.name;
                    window._bd_share_config = {
                        common: {
                            bdText: "",
                            bdDesc: "你好",
                            bdUrl: bdUrl,
                        },
                        share: [{
                            "bdSize": 16
                        }],
                    };
                with(document) 0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];
                    if (data.reportUnit == '') {
                        $('#dtxq-laiyuan').hide();
                    } else {
                        $('#dtxq-laiyuan').text('发布单位：' + data.reportUnit);
                    }
                    ;
                    $('#dtxq-title').text(data.name);
                    $('#dtxq-date').text(data.reportDate);
                    $('#dtxq-content').append(data.content);
                    var count = res.pageView;
                    $('#dtxq-num').html('浏览量：<span>'+ count +'</span>');

            }
        });
    });
    //分享向下滑动自动 吸顶
    $(document).on("scroll",function(){
        if($(document).scrollTop()>230){
            $(".dtxq-title-container .tongji.readOther").css({'position':'fixed','top':'25px'});
        }else{
            $(".dtxq-title-container .tongji.readOther").css({'position':'absolute','top':'43px'});
        }
    })

</script>


</html>
