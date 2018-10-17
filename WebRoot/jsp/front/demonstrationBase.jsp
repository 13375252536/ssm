<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/26
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>示范基地-国家创新创业政策信息服务网</title>
    <meta name="keywords" content="国家双创示范基地,国家示范基地">
    <meta name="description"
          content="国家创新创业政策信息服务网由国家发展和改革委员会主办，国家信息中心及下属单位负责运行维护，整合共享国务院和国务院各部门，以及各省、自治区、直辖市人民政府等相关职能部门发布的创新创业信息，现开通“头条资讯、政策库、政策分析、示范基地、活动跟踪、服务拓展、建言献策”等栏目，权威统一发布创新创业政策、动态、活动、服务等信息，建设政府与公众互动交流新渠道。">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="/css/base.css">
    <link rel="stylesheet" href="/css/actList.css">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/js/layui/css/layui.css">
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/js/layui/layui.all.js"></script>
    <script type="text/javascript" src="/js/imgHandle.js"></script>
    <script src="/js/headerFooter.js" type="text/javascript"></script>
    <script src="/js/baseExp.js" type="text/javascript"></script>
    <style type="text/css">
        .container{
            width:1170px;
            margin:0 auto
        }
        .tabs li a {
            width: 200px;
        }

        .tabs .leixing a {
            padding-left: 15px;
        }
    </style>
</head>
<body>
<div class="container">
    <%--基地轮播图--%>
    <div class="cxzg-video-wrapper">
        <div class="cxzg-slider-container">
            <ul class="cxzg-slider-body" id="cxzg-slider-body" style="left: -2460px;"></ul>
            <div class="prev" id="cxzg-prev"><img src="/imgs/i_prev.png"></div>
            <div class="next" id="cxzg-next"><img src="/imgs/i_next.png"></div>
            <div class="bottom-bg">
                <ul id="cxzg-title-ul" style="height: 100%;"></ul>
            </div>
            <div class="up_focus" id="cxzg-focus"></div>
        </div>
    </div>
    <%--基地查询菜单--%>

    <h2 class="basetit" style="margin-top:22px;">最新动态</h2>
    <div class="listAll posR">
        <div class="tabs">
            <ul>
                <li><a class="current tabFir" id="quanbu">全部</a></li>
                <li class="pici">
                    <a id="pici-quanbu"><em id="pici-text">批次</em>
                        <img style="display:inline-block;padding-left:5px;" src="/imgs/down_arrow_icon.png">
                        <div style="width:201px;left:-2px;">
                            <b id="buxian" data-value="" class="on">不限</b><br>
                            <b id="shoupi" data-value="1">首批</b><br>
                            <b id="dierpi" data-value="2">第二批</b>
                        </div>
                    </a>
                </li>
                <li class="leixing">
                    <a id="leixing-quanbu" style="width: 215px;"><em id="leixing-text">类型</em>
                        <img style="display:inline-block;"  src="/imgs/down_arrow_icon.png">
                        <div style="width:247px;left:-2px;">
                            <b id="typebuxian" data-value="" class="on">不限</b><br>
                            <b id="type00" data-value="00">区域示范基地</b><br>
                            <b id="type01" data-value="02">企业示范基地</b><br>
                            <b id="type02" data-value="01">高校和科研院所示范基地</b>
                        </div>
                    </a>
                </li>
            </ul>
        </div>
        <div class="lisitConAll">
            <div class="listCon" style="display: block;">
                <div id="dtlist" style="min-height: 200px;position: relative;"></div>
                <!--分页-->
                <div id="page">
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
