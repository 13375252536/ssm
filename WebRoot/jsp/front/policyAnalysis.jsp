<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/10/5
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>政策分析-国家创新创业政策信息服务网</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="../../css/base.css">
    <link rel="stylesheet" href="../../css/common.css">
    <link rel="stylesheet" href="../../css/baseCon.css">
</head>
<body>
<div class="analyze">
    <div class="eacher" id="queryGraph"></div>
    <ul class="queryCate" id="policyTab">
        <li class="current tabTit2">政策关注度</li>
        <li class="tabTit1">双创活跃度</li>
        <li class="tabTit3">政策数量分布</li>
    </ul>
    <div class="policyTop">
        <p class="topTitle" id="hotTop5Name"></p>
        <ul class="topInfo" id="hotTop5Content">
        </ul>
    </div>
    <ul class="queryMax clearfix">
        <li>
            <p class="title">年度最火政策</p>
            <ul class="maxList" id="yearHotPolicyList">
            </ul>
        </li>
        <li>
            <p class="title">季度最火政策</p>
            <ul class="maxList" id="quarterHotPolicyList">
            </ul>
        </li>
        <li>
            <p class="title">月度最火政策</p>
            <ul class="maxList" id="monthHotPolicyList">
            </ul>
        </li>
        <li class="end">
            <p class="title">周度最火政策</p>
            <ul class="maxList" id="weekHotPolicyList">
            </ul>
        </li>
    </ul>
</div>
<script type="text/javascript" src="../../js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../../js/headerFooter.js"></script>
<script type="text/javascript" src="../../js/common.js"></script>
<script type="text/javascript" src="../../js/analyzeMap.js"></script>
<script src="../../js/queryHotMap.js" type="text/javascript"></script>
<%--<script src="../../js/echarts.js" type="text/javascript"></script>--%>
</body>
</html>
