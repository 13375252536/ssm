<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/11
  Time: 16:29
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
<form action="saveActivityManagement.html" name="activityManagementForm" id="activityManagementForm" target="result" method="post" onsubmit="return checkInfo();"  enctype="multipart/form-data">
    <input type="hidden" name="id" id="id" value="${activityManagement.id}"/>
    <input type="hidden" name="content" id="content"/>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>活动标题:</th>
            <td><input type="text" name="name" id="name" class="input_txt" value="${activityManagement.name}"/></td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>活动种类:</th>
            <td>
                <select name="type" id="type" style="vertical-align: middle;">
                    <option value="0">请选择</option>
                    <option <c:if test="${activityManagement.type=='主会场活动'}">selected</c:if>>主会场活动</option>
                    <option <c:if test="${activityManagement.type=='分会场活动'}">selected</c:if>>分会场活动</option>
                    <option <c:if test="${activityManagement.type=='部委活动'}">selected</c:if>>部委活动</option>
                    <option <c:if test="${activityManagement.type=='创响中国'}">selected</c:if>>创响中国</option>
                </select>
            </td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>所属区域:</th>
            <td>
                <select name="area" id="area" style="vertical-align: middle;">
                    <option value="0">请选择</option>
                    <c:forEach items="${selectAreaInfo}" var="area">
                        <option value="${area.id}">${area.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>所属单位:</th>
            <td>
                <select name="reportUnit" id="reportUnit" style="vertical-align: middle;">
                    <option value="0">请选择</option>
                    <c:forEach items="${selectOrganizationInfo}" var="organization">
                        <option value="${organization.id}">${organization.organizationName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>活动内容:</th>
            <td><script id="editor" type="text/plain" style="width: 80%;height: 200px">${activityManagement.content}</script></td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>活动简介:</th>
            <td><input type="text" name="introduction" id="introduction" class="input_txt" value="${activityManagement.introduction}"/></td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>发布时间:</th>
            <td><input type="text" name="reportDate" id="reportDate" value="<fmt:formatDate value="${activityManagement.reportDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker()" readonly="readonly" style="width:70px;"/></td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>来源:</th>
            <td><input type="text" name="source" id="source" class="input_txt" value="${activityManagement.source}"/></td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>排序:</th>
            <td><input type="text" name="sorting" id="sorting" class="input_txt" value="${activityManagement.sorting}"/></td>
        </tr>

        <c:if test="${activityManagement.id!=null}">
            <tr class="info">
                <th>原图:</th>
                <td><img src="${activityManagement.fileURL}" style="width: 100px;height: 100px"></td>
            </tr>
        </c:if>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>上传图片:</th>
            <td><input type="file" name="file" id="fileURL" class="input_txt"/></td>
        </tr>

        <tr class="info">
            <th>预览图片:</th>
            <td class="imgBox"></td>
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
            $("#activityManagementForm").submit();
        });
        if($("#id").val()!=""||$("#id").val()!=null){
            var area = "${activityManagement.area}";
            var reportUnit = "${activityManagement.reportUnit}";
            if(area!=""){
                $("#area").val(area);
            }
            if(reportUnit!=""){
                $("#reportUnit").val(reportUnit);
            }
        }
    });

    setTimeout("ueditor()",500);
    function ueditor(){
        UE.getEditor('editor');
    }
    function checkInfo(){
        if($("#name").val()==""){
            alert("请输入活动标题!");
            $("#name").focus();
            return false;
        }
        if ($("#name").val().length>64){
            alert("活动标题不得长于64个字符");
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

        if($("#id").val()==""||$("#id").val()==null){
            if ($('#fileURL').val()==""||$('#fileURL').val()==null) {
                alert("请上传图片!");
                $("#fileURL").focus();
                return false;
            }
        }
        if ($("#type").find("option:selected").val()=="0"){
            alert("请选择活动种类!");
            $("#type").focus();
            return false;
        }
        if ($("#area").find("option:selected").val()=="0") {
            alert("请选择所属区域!");
            $("#area").focus();
            return false;
        }

        if ($("#reportUnit").find("option:selected").val()=="0") {
            alert("请选择所属单位!");
            $("#reportUnit").focus();
            return false;
        }
        if ($("#content").val().length<1){
            alert("请输入活动内容!");
            $("#editor").focus();
            return false;
        } else if ($("#content").val().length>5000){
            alert("活动内容不能超过5000字符!");
            $("#editor").focus();
            return false;
        }
        if($('#introduction').val()==""){
            alert("请输入活动简介!");
            $("#introduction").focus();
            return false;
        }else if ($('#introduction').val().length>200) {
            alert("活动简介不能超过200个字符!");
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
        } else if ($("#source").val().length>200){
            alert("活动来源不能超过200个字符!");
            $("#source").focus();
            return false;
        }
    }

    function nameExist() {
        alert("该活动标题已存在！");
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
    $(function() {
        $('#fileURL').change(function () {
            $('.imgBox').html("");
            var imgArr = []; //获取的图片地址
            var fileList = $(this)[0].files;   //或获取的图片文件
            var Length = fileList.length;
            for (var i = 0; i < Length; i++) {
                var imgUrl = window.URL.createObjectURL(fileList[i]); //获取图片地址
                imgArr.push(imgUrl);
                var $img = $("<img class='img'>");
                $('.imgBox').append($img);
                $img.attr('src', imgArr[i]);
                $img.css({'height':'100px','width':'100px'})
            }
        });
    })



</script>

</body>
</html>
