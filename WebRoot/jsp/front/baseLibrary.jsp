<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/28
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>基地库-国家创新创业政策信息服务网</title>
    <meta name="keywords" content="双创示范基地查询,示范基地,双创示范基地">
    <meta name="description" content="国家创新创业政策信息服务网由国家发展和改革委员会主办，国家信息中心及下属单位负责运行维护，整合共享国务院和国务院各部门，以及各省、自治区、直辖市人民政府等相关职能部门发布的创新创业信息，现开通“头条资讯、政策库、政策分析、示范基地、活动跟踪、服务拓展、建言献策”等栏目，权威统一发布创新创业政策、动态、活动、服务等信息，建设政府与公众互动交流新渠道。">
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../../js/layui/css/layui.css">
    <link rel="stylesheet" href="../../css/base.css">
    <link rel="stylesheet" href="../../css/yzhStyle.css">
    <link rel="stylesheet" href="../../css/common.css">
    <script type="text/javascript" src="../../js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="../../js/imgHandle.js"></script>
    <script type="text/javascript" src="../../js/headerFooter.js"></script>
    <script type="text/javascript" src="../../js/layui/layui.js"></script>
    <script type="text/javascript" src="../../js/common.js"></script>
    <script type="text/javascript" src="../../js/jidiku.js"></script>
</head>
<body>
<div class="center" style="padding-top:15px;">
    <div class="main-container">
        <div class="index-public-title jidiku">
            <a href="">基地库</a>
        </div>
        <div class="jidiku-news-container">
            <div class="news-list">
                <ul id="jidiku-news-list-ul" style="min-height: 200px;position: relative;">


                </ul>
                <div id="jidiku-fenye">

                </div>
            </div>
            <div class="news-tab">
                <div class="title">
                    <div class="img-wrapper"><img src="/imgs/jidi_icon1.png"></div>
                    <label class="label1" id="jidizongshu"></label>
                    <label class="label2">基地</label>
                </div>
                <div class="query">
                    <p>
                        <span>省份</span>
                        <select class="province">
                            <option value="">请选择</option>
                        </select>
                    </p>
                    <p>
                        <span>基地名称</span>
                        <input type="text" id="baseName"/>
                    </p>
                    <p class="t-center">
                        <button onclick="jidikuRequest()">查询</button>
                    </p>
                </div>
                <div class="news-tab-btn">
                    <div class="news-tab-guidao">
                        <img src="/imgs/tab_guidao.png">
                        <div class="biao hangbiao active"><img src="/imgs/tab_biao.png"></div>
                        <div class="biao hangbiao" style="top:102px;"><img src="/imgs/tab_biao.png"></div>
                        <div class="biao hangbiao" style="top:230px;"><img src="/imgs/tab_biao.png"></div>
                    </div>
                    <div class="tab-btn">
                        <a class="a1 active" href="javascript:;" id="quanbu">全部</a>
                        <a class="a2 jidiku-pici" href="javascript:;" id="quanbu-pici">批次</a>
                        <a class="a3 jidiku-pici" href="javascript:;" id="shoupi">首批</a>
                        <a class="a4 jidiku-pici" href="javascript:;" id="dierpi">第二批</a>
                        <a class="a5 jidiku-leixing" href="javascript:;" id="quanbu-leixing">类型</a>
                        <a class="a6 jidiku-leixing" href="javascript:;" id="type00">区域示范基地</a>
                        <a class="a7 jidiku-leixing" href="javascript:;" id="type01">高校和科研院所示范基地</a>
                        <a class="a8 jidiku-leixing" href="javascript:;" id="type02">企业示范基地</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
