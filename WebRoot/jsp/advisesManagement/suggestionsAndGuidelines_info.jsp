<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/22
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>My Test</title>
    <link type="text/css" rel="stylesheet" href="../../css/main.css"/>
    <style type="text/css">
        body{width:100%;height:100%;background-color: #FFFFFF;text-align: center;}
        .input_txt{width:200px;height:20px;line-height:20px;}
        .info{height:40px;line-height:40px;}
        .info th{text-align: right;width:65px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
        .info td{text-align:left;}
    </style>
</head>
<body>
<form action="saveSuggestionsAndGuidelines.html" name="suggestionsAndGuidelinesForm" id="suggestionsAndGuidelinesForm" target="result" method="post" onsubmit="return checkInfo();"  enctype="multipart/form-data">
    <input type="hidden" name="content" id="content"/>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr class="info">
            <th>建言须知:</th>
            <td><script id="editor" type="text/plain" style="width: 80%;height: 200px">${suggestionsAndGuidelines.content}</script></td>
        </tr>
    </table>
</form>
<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
<script type="text/javascript" charset="utf-8">window.UEDITOR_HOME_URL = "<%=path%>/ueditor/";</script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/ueditor.all.js"></script>

<script type="text/javascript" src="../../js/jquery-1.5.1.min.js"></script>

<script>
    var dg;
    $(document).ready(function(){
        dg = frameElement.lhgDG;
        dg.addBtn('ok','保存',function(){
            var ue = UE.getEditor('editor');
            document.getElementById("content").value=UE.getEditor('editor').getContent();
            $("#suggestionsAndGuidelinesForm").submit();
        });
    });

    setTimeout("ueditor()",500);
    function ueditor(){
        UE.getEditor('editor');
    }
    function checkInfo(){
        if ($("#content").val().length<1){
            alert("请输入内容!");
            $("#content").focus();
            return false;
        } else if ($("#content").val().length>10000){
            alert("内容不能超过10000字符!");
            $("#content").focus();
            return false;
        }
     
    }



    function success(){
        if(dg.curWin.document.forms[0]){
            dg.curWin.document.forms[0].action = dg.curWin.location+"";
            dg.curWin.document.forms[0].submit();
        }else{
            dg.curWin.location.reload();
        }
        dg.cancel();
    }
</script>

</body>
</html>
