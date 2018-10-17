<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/28
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>服务拓展-国家创新创业政策信息服务网</title>

    <link rel="stylesheet" type="text/css" href="/js/layui/css/layui.css">
    <link rel="stylesheet" href="/css/base.css">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/shenpi.css">
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/js/headerFooter.js"></script>
    <script type="text/javascript" src="/js/serviceOver.js"></script>
    <style>
        .sertit2L:after {
            width: 97px;
        }

        .listBox > a {
            position: relative;
        }

        .listBox > a > span {
            font-size: 16px;
            width: 20px;
            height: 20px;
            position: absolute;
            left: -20px;
            top: 18px;
        }
    </style>
</head>
<body>
<div class="center" style="padding-top: 29px;">
    <div class="list-all">
        <a class="list over">创业者服务</a>
        <a class="list1">孵化器及众创空间服务</a>
    </div>
    <div class="user">
        <h2 class="sertit"><b>创业者服务</b></h2>
        <h3 class="sertit2 sertit2L" style="display: block;">双创时间轴</h3>
        <div class="main-container" style="margin-top:15px;">
            <div class="soBanner" id="soBanner" style="display: block;">

             </div>
            <h3 class="sertit2">政策服务</h3>
            <div class="zcservice">
                <a href="">
                    <img src="/imgs/shuishou.png">
                </a>
                <a href="javascript:;" id="xiaoweiqiye">
                    <img src="/imgs/xwqy.png">
                </a>
                <a href="">
                    <img src="/imgs/jijin.png">
                </a>
            </div>
            <!-- 办事指南开始 -->
            <h3 class="sertit2">办事指南</h3>
            <div class="cxzg-hddt-wrapper pointerS">
                <ul class="news-list" id="cyzfw" style="padding-left: 15px; display: block;">


                </ul>
                <ul class="news-list" id="fhq" style="padding-left: 15px; display: none;">


                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
