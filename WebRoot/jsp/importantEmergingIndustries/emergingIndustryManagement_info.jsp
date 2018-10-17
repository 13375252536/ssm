<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/14
  Time: 13:20
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
<form action="saveEmergingIndustryManagement.html" name="emergingIndustryManagementForm" id="emergingIndustryManagementForm" target="result" method="post" onsubmit="return checkInfo();"  enctype="multipart/form-data">
    <input type="hidden" name="id" id="id" value="${emergingIndustryManagement.id}"/>
    <input type="hidden" name="content" id="content"/>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>类别:</th>
            <td>
                <select id="type" name="type">
                    <option value="0">请选择</option>
                    <option <c:if test="${emergingIndustryManagement.type=='节能环保产业'}">selected</c:if>>节能环保产业</option>
                    <option <c:if test="${emergingIndustryManagement.type=='新一代信息技术'}">selected</c:if>>新一代信息技术</option>
                    <option <c:if test="${emergingIndustryManagement.type=='生物产业'}">selected</c:if>>生物产业</option>
                    <option <c:if test="${emergingIndustryManagement.type=='高端装备制造业'}">selected</c:if>>高端装备制造业</option>
                    <option <c:if test="${emergingIndustryManagement.type=='新能源产业'}">selected</c:if>>新能源产业</option>
                    <option <c:if test="${emergingIndustryManagement.type=='新材料产业'}">selected</c:if>>新材料产业</option>
                    <option <c:if test="${emergingIndustryManagement.type=='新能源汽车'}">selected</c:if>>新能源汽车</option>
                    <option <c:if test="${emergingIndustryManagement.type=='数字创意'}">selected</c:if>>数字创意</option>
                </select>
            </td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>标题:</th>
            <td><input type="text" name="name" id="name" class="input_txt" value="${emergingIndustryManagement.name}"/></td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>简介:</th>
            <td><input type="text" name="introduction" id="introduction" class="input_txt" value="${emergingIndustryManagement.introduction}"/></td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>发布时间:</th>
            <td><input type="text" name="reportDate" id="reportDate" value="<fmt:formatDate value="${emergingIndustryManagement.reportDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker()" readonly="readonly" style="width:80px;"/></td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>排序:</th>
            <td><input type="text" name="sorting" id="sorting" class="input_txt" value="${emergingIndustryManagement.sorting}"/></td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>正文:</th>
            <td><script id="editor" type="text/plain" style="width: 80%;height: 200px">${emergingIndustryManagement.content}</script></td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>来源:</th>
            <td><input type="text" name="source" id="source" class="input_txt" value="${emergingIndustryManagement.source}"/></td>
        </tr>
    </table>
</form>
<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
<script type="text/javascript" charset="utf-8">window.UEDITOR_HOME_URL = "<%=path%>/ueditor/";</script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/ueditor/ueditor.all.js"></script>

<script type="text/javascript" src="../../js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="../../js/datePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../../js/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>

<script type="text/javascript" src="../../js/jquery-1.5.1.min.js"></script>

<script>
    var dg;
    $(document).ready(function(){
        dg = frameElement.lhgDG;
        dg.addBtn('ok','保存',function(){
            var ue = UE.getEditor('editor');
            document.getElementById("content").value=UE.getEditor('editor').getContent();
            $("#emergingIndustryManagementForm").submit();
        });
    });

    setTimeout("ueditor()",500);
    function ueditor(){
        UE.getEditor('editor');
    }
    function checkInfo(){
        if($("#name").val()==""){
            alert("请输入标题!");
            $("#name").focus();
            return false;
        }
        if ($("#name").val().length>64){
            alert("标题不得长于64个字符");
            $("#name").focus();
            return false;
        }

        if($("#sorting").val()==""){
            alert("请输入排序!");
            $("#sorting").focus();
            return false;
        }
        if ($("#sorting").val().length>11){
            alert("排序不得长于11个字符");
            $("#sorting").focus();
            return false;
        }
        var reg = /^\w+$/;
        if(!reg.test($("#sorting").val())){
            alert("排序请输入数字!");
            $("#sorting").focus();
            return false;
        }

        if ($("#content").val().length<1){
            alert("请输入正文!");
            $("#editor").focus();
            return false;
        } else if ($("#content").val().length>5000){
            alert("正文不能超过5000字符!");
            $("#editor").focus();
            return false;
        }
        if($('#introduction').val()==""){
            alert("请输入简介!");
            $("#introduction").focus();
            return false;
        }else if ($('#introduction').val().length>200) {
            alert("简介不能超过200个字符!");
            $("#introduction").focus();
            return false;
        }
        if($('#reportDate').val()==""){
            alert("请输入发布时间!");
            $("#reportDate").focus();
            return false;
        }
        if ($("#source").val().length<1){
            alert("请输入来源!");
            $("#source").focus();
            return false;
        } else if ($("#source").val().length>200) {
            alert("来源不能超过200个字符!");
            $("#source").focus();
            return false;
        }

        if ($("#type").find("option:selected").val()=="0"){
            alert("请选择类别!");
            $("#type").focus();
            return false;
        }
    }

    function nameExist() {
        alert("该标题已存在！");
        $("#name").select();
        $("#name").focus();
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
