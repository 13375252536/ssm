<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/10/1
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title id="title"></title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../../css/yzhStyle.css">
    <link rel="stylesheet" href="../../css/baseDetail.css">
    <link rel="stylesheet" href="../../css/common.css">
    <script type="text/javascript" src="../../js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="../../js/imgHandle.js"></script>
    <script type="text/javascript" src="../../js/headerFooter.js"></script>
    <script type="text/javascript" src="../../js/common.js"></script>
    <style type="text/css">
        p span {
            font-size: 16px;
        }

        p img {
            display: inline-block;
            max-width: 80%;
        }
    </style>
</head>
<body>
<div class="center">
    <div class="index">
        <a class="ind1" href="home.html">首页</a>
        <a>动态详情</a>
    </div>
    <div class="dtxq-article-container">
        <div class="dtxq-title-container">
            <p class="tongji">
                <label class="label1 gray" id="dtxq-laiyuan"></label>
                <label class="label2 gray" id="dtxq-date"></label>
                <label class="label4 gray" id="dtxq-num">浏览量：<span></span></label>
                <label class="bdsharebuttonbox label3" data-tag="share_1">
                    <span>分享到</span>
                    <a class="bds_weixin" data-cmd="weixin"></a>
                    <a class="bds_tsina" data-cmd="tsina"></a>
                </label>
            </p>
            <p class="biaoti" id="dtxq-title"></p>
        </div>
        <div class="dtxq-article-content">
            <div id="dtxq-content" style="min-height: 200px;position: relative;"></div>
        </div>
    </div>
</div>
</body>
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
        console.log(id);
        var bdUrl = 'http://localhost:8080/front/skipDynamicDetails.html?id=' + id;
        $.ajax({
            type: "post",
            data: "",
            url: 'getDynamicManagementInfoById.html?id=' + id + '',
            dataType: "json",
            beforeSend: function (xhr) {
                $('#dtxq-content').append('<img src="/imgs/huanchong.gif" id="huanchong">');
            },
            success: function (res) {
                var data = res.data[0];
                $("#title").text(preDetailTitle + data.name);
                var shareTitle = res.data.name;
                // 分享开始
                window._bd_share_config = {
                    common: {
                        bdText: "",
                        bdDesc: "你好",
                        bdUrl: bdUrl
                    },
                    share: [{
                        "bdSize": 16
                    }],
                };
                with (document) 0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?cdnversion=' + ~(-new Date() / 36e5)];
                // 分享结束
                if (res.data.source == '') {
                    $('#dtxq-laiyuan').hide();
                } else {
                    $('#dtxq-laiyuan').text('来源：' + data.source);
                }
                $('#dtxq-title').text(data.name);
                $('#dtxq-date').text(data.reportDate);
                var count = res.pageView;
                $('#dtxq-num span').html(+count);
                $('#dtxq-content').append(data.content);
            },
            error: function (xhr) {

            },
            complete: function (xhr) {
                $('#huanchong').remove();
            }

        })
    })
</script>

</html>