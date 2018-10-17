<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/10/1
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>政策-国家创新创业政策信息服务网</title>
    <meta name="keywords" content="双创政策查询,双创,创新,创业,创新创业,双创政策,国家双创政策,国家双创政策查询,双创税收查询">
    <meta name="description" content="国家创新创业政策信息服务网由国家发展和改革委员会主办，国家信息中心及下属单位负责运行维护，整合共享国务院和国务院各部门，以及各省、自治区、直辖市人民政府等相关职能部门发布的创新创业信息，现开通“头条资讯、政策库、政策分析、示范基地、活动跟踪、服务拓展、建言献策”等栏目，权威统一发布创新创业政策、动态、活动、服务等信息，建设政府与公众互动交流新渠道。">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="../../css/base.css">
    <link rel="stylesheet" href="../../css/common.css">
    <link rel="stylesheet" href="../../js/layui/css/layui.css">
    <link rel="stylesheet" href="../../css/policyKu.css">
    <style>
        .listCon .listBox>a{position: relative;}
        .listCon .listBox>a:before{font-size:16px;width: 20px;height:20px;position: absolute;left: -20px;top:26px;}
        .listCon .listBox:first-child>a:before{content: '1.';}
        .listCon .listBox:nth-child(2)>a:before{content: '2.';}
        .listCon .listBox:nth-child(3)>a:before{content: '3.';}
        .listCon .listBox:nth-child(4)>a:before{content: '4.';}
        .listCon .listBox:nth-child(5)>a:before{content: '5.';}
        .listCon .listBox:nth-child(6)>a:before{content: '6.';}
        .listCon .listBox:nth-child(7)>a:before{content: '7.';}
        .listCon .listBox:nth-child(8)>a:before{content: '8.';}
        .listCon .listBox:nth-child(9)>a:before{content: '9.';}
        .listCon .listBox:nth-child(10)>a:before{content: '10.';left: -26px;}
    </style>
    <link id="layuicss-laydate" rel="stylesheet" href="../../js/layui/css/modules/laydate/default/laydate.css" media="all">
    <link id="layuicss-layer" rel="stylesheet" href="../../js/layui/css/modules/layer/default/layer.css" media="all">
    <link id="layuicss-skincodecss" rel="stylesheet" href="../../js/layui/css/modules/code.css" media="all">
</head>
<body>
<div class="policyDT">
    <div class="policyDTtop">
        <div class="polCon">
            <ul class="zctt-list" id="zctt-list">

            </ul>
        </div>
    </div>
    <div class="actList">
        <div class="listAll posR">
            <div class="tabs">
                <ul>
                    <li id="leixing-all"><a class="tabFir current">全部</a></li>
                    <li id="buwei-dt"><a class="">部委</a></li>
                    <li class="city" id="difang-dt"><a><em id="dfdt-text">地方动态</em><img
                            style="display:inline-block;padding-left:5px;"
                            src="/imgs/down_arrow_icon.png">
                        <div id="city-list" style="left: -1px;">
                            <b id="" class="filter-itm-a buxian on" style="margin-left: 15px;">不限</b>
                        </div>
            <li id="jidi-dt"><a class="">基地</a></li>
            </ul>
        </div>
        <div class="lisitConAll">
            <div class="listCon" id="dtlist"
                 style="min-height: 200px; position: relative; padding: 0px 30px; display: block; opacity: 1;">


            </div>

        </div>
        <div id="page">

        </div>
    </div>
</div>
</div>
<!-- 返回顶部按钮 -->
<a class="TopBack" href="http://103.235.234.108:13108/policyKu.html#"><span>Top</span></a>

<script type="text/javascript" src="../../js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../../js/headerFooter.js"></script>
<script type="text/javascript" src="../../js/common.js"></script>
<script type="text/javascript" src="../../js/layui/layui.all.js"></script>
<script type="text/javascript" src="../../js/policyKu.js"></script>
</body>
</html>
