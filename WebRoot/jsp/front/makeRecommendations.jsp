<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/27
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>建言献策-国家创新创业政策信息服务网</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" href="../../js/layui/css/modules/layer/default/layer.css">
    <link rel="stylesheet" href="../../css/base.css">
    <link rel="stylesheet" href="../../css/common.css">
    <link rel="stylesheet" href="../../css/baseCon.css">
    <script type="text/javascript" src="../../js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="../../js/layui/lay/modules/layer.js"></script>
    <script type="text/javascript" src="../../js/Validform.js"></script>
    <script src="../../js/headerFooter.js" type="text/javascript"></script>
    <script src="../../js/common.js"></script>
    <script type="text/javascript" src="../../js/makeRecommend.js"></script>
    <style>
        #unitname + span {
            display: none;
        }

        #unitname.Validform_error {
            background: #fff;
        }
    </style>
</head>
<body>
<div class="adviceContent">
    <h2 class="basetit">建言献策</h2>
    <div class="adviceMessage">
        <form class="leaveMessage" id="adviceForm">
            <ul class="messageItem">
                <li style="margin-top:0;">
                    <span class="star">*</span>
                    <span>姓 名：</span>
                    <input type="text" name="name" id="name" datatype="zh2-10" placeholder="请输入姓名">
                    <span class="Validform_checktip"></span>
                </li>
                <li>
                    <span style="padding-left:10px">单 位：</span>
                    <input type="text" name="unit" id="unitname" placeholder="请输入单位名称">
                </li>
                <li>
                    <span class="star">*</span>
                    <span>手 机：</span>
                    <input type="text" name="telNum" id="phone" placeholder="请填写正确的手机号" datatype="m">
                    <span class="Validform_checktip"></span>
                </li>
                <li>
                    <span class="star">*</span>
                    <span>邮 箱：</span>
                    <input type="email" name="email" id="email" placeholder="请填写正确的邮箱" datatype="e">
                    <span class="Validform_checktip"></span>
                </li>
                <li>
                    <span class="star">*</span>
                    <span>标 题：</span>
                    <input type="text" maxlength="25" name="title" id="title" placeholder="(最多25个字符)" datatype="*1-25">
                    <span class="Validform_checktip"></span>
                </li>
                <li class="adviceArea">
                    <span class="star">*</span>
                    <span>正 文：</span>
                    <textarea maxlength="500" class="adviceText" id="content" name="content" placeholder="(最多500个字符)"
                              datatype="*1-500"></textarea>
                    <span class="Validform_checktip"></span>
                </li>
                <li class="adviceCode">
                    <span class="star">*</span>
                    <span>验证码：</span>
                    <input type="text" name="code" id="code"/>&nbsp;&nbsp;
                    <img id="codeImg" alt="点击更换" title="点击更换" src=""/>
                    <a id="changeCode">看不清? 换一张</a>
                </li>
                <li>
                    <button type="button" id="btn_sub" class="submitBtn" onclick="check()">提交</button>
                    <button type="button" class="refillBtn" onclick="reWrite()">重置</button>
                </li>
            </ul>
        </form>
        <!--建言须知-->
        <div class="adviceNotice">
            <dl class="noticeInfor" id="message1">

            </dl>
        </div>
    </div>
</div>
</body>
</html>
