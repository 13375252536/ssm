<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/29
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>活动跟踪-国家创新创业政策信息服务网</title>
    <meta name="keywords" content="双创活动周,创响中国">
    <meta name="description"
          content="国家创新创业政策信息服务网由国家发展和改革委员会主办，国家信息中心及下属单位负责运行维护，整合共享国务院和国务院各部门，以及各省、自治区、直辖市人民政府等相关职能部门发布的创新创业信息，现开通“头条资讯、政策库、政策分析、示范基地、活动跟踪、服务拓展、建言献策”等栏目，权威统一发布创新创业政策、动态、活动、服务等信息，建设政府与公众互动交流新渠道。">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="/css/base.css">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/policyKu.css">
    <script type="text/javascript" src="/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/js/headerFooter.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <script type="text/javascript" src="/js/activeAfter.js"></script>
    <style>.tabs li .current:after, .tabs li a:hover:after {
        bottom: 0;
    }</style>
</head>
<body>
<div class="quanchuanggai" id="banner">
</div>
<div class="actList">
    <div class="mainActi">
        <h2 class="acttit anchor-item" id="zyhd">主要活动</h2>
        <div class="pTopBot fix">
            <div class="actiBox fl">
                <a href=""><img src="/imgs/hdgz1.png"></a>
                <ul id="ccn">

                </ul>
            </div>
            <div class="actiBox actiBox2 fr">
                <a href=""><img src="/imgs/hdgz2.png"></a>
                <ul id="scz">

                </ul>
            </div>
        </div>
        <div class="load-more-wrapper" style="display: none;">
            <div class="load-more-btn">
                <img src="/imgs/hdgz_more_arrow.png">
                <span>点击查看更多</span>
            </div>
        </div>
        <div class="tbConBox" id="buwei">
            <h2 class="acttit pl30 anchor-item">部委</h2>
            <div class="ConBoxDet">

            </div>
            <div class="load-more-wrapper" style="display: block;">
                <div class="load-more-btn" id="buwei-more">
                    <img src="/imgs/hdgz_more_arrow.png">
                    <span>点击查看更多</span>
                </div>
            </div>
        </div>
        <div class="tbConBox" id="diqu">
            <h2 class="acttit pl30 anchor-item" id="difang">地方</h2>
            <div class="ConBoxDet">

            </div>
            <div class="load-more-wrapper" style="display: block;">
                <div class="load-more-btn" id="difang-more">
                    <img src="/imgs/hdgz_more_arrow.png">
                    <span>点击查看更多</span>
                </div>
            </div>
        </div>
        <div class="tbConBox" id="jidi">
            <h2 class="acttit pl30 anchor-item">基地</h2>
            <div class="ConBoxDet">

            </div>
            <div class="load-more-wrapper" style="display: block;">
                <div class="load-more-btn" id="jidi-more">
                    <img src="/imgs/hdgz_more_arrow.png">
                    <span>点击查看更多</span>
                </div>
            </div>
        </div>
        <div class="tbConBox" id="tuanti">
            <h2 class="acttit anchor-item" id="shtt">社会团体</h2>
            <div class="ConBoxDet">

            </div>
            <div class="load-more-wrapper" style="display: block;">
                <div class="load-more-btn" id="tuanti-more">
                    <img src="/imgs/hdgz_more_arrow.png">
                    <span>点击查看更多</span>
                </div>
            </div>
        </div>
    </div>
    <!-- 右侧导航栏 -->
    <ul class="right-nav-container pa" style="position: absolute; margin-left: 0px; top: 64px;">
        <li class="active"><a href="http://localhost:8080/front/activityTrace.html#zyhd"><img
                src="/imgs/hdgzr_01.png" class="right-nav-img"><img
                src="/imgs/hdgzr_active_01.png" class="right-nav-img-active"></a></li>
        <li class=""><a href="http://localhost:8080/front/activityTrace.html#buwei"><img
                src="/imgs/hdgzr_02.png" class="right-nav-img"><img
                src="/imgs/hdgzr_active_02.png" class="right-nav-img-active"></a></li>
        <li class=""><a href="http://localhost:8080/front/activityTrace.html#difang"><img
                src="/imgs/hdgzr_03.png" class="right-nav-img"><img
                src="/imgs/hdgzr_active_03.png" class="right-nav-img-active"></a></li>
        <li class=""><a href="http://localhost:8080/front/activityTrace.html#jidi"><img
                src="/imgs/hdgzr_04.png" class="right-nav-img"><img
                src="/imgs/hdgzr_active_04.png" class="right-nav-img-active"></a></li>
        <li class=""><a href="http://localhost:8080/front/activityTrace.html#shtt"><img
                src="/imgs/hdgzr_05.png" class="right-nav-img"><img
                src="/imgs/hdgzr_active_05.png" class="right-nav-img-active"></a></li>
        <%--<div class="goTop"><a><img src="/imgs/hdgzr_06.png" class="right-nav-img"><img--%>
                <%--src="/imgs/hdgzr_active_06.png" class="right-nav-img-active"></a></div>--%>
    </ul>
</div>
</body>
</html>
