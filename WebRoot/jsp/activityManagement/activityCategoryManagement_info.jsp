<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/13
  Time: 14:26
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
        .info th{text-align: right;width:250px;color: #4f4f4f;padding-right:5px;font-size: 12px;}
        .info td{text-align:left;}
    </style>
</head>
<body>
<form action="saveActivityCategoryManagement.html" name="activityCategoryManagementForm" id="activityCategoryManagementForm" target="result" method="post" onsubmit="return checkInfo();"  enctype="multipart/form-data">
    <input type="hidden" name="id" id="id" value="${activityCategoryManagement.id}"/>
    <input type="hidden" name="introduction" id="introduction"/>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>活动标题:</th>
            <td><input type="text" name="name" id="name" class="input_txt" value="${activityCategoryManagement.name}"/></td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>活动种类:</th>
            <td>
                <select name="type" id="type" style="vertical-align: middle;">
                    <option value="0">请选择</option>
                    <option <c:if test="${activityCategoryManagement.type=='基地活动'}">selected</c:if>>基地活动</option>
                    <option <c:if test="${activityCategoryManagement.type=='社会团体活动'}">selected</c:if>>社会团体活动</option>
                    <option <c:if test="${activityCategoryManagement.type=='部委活动'}">selected</c:if>>部委活动</option>
                    <option <c:if test="${activityCategoryManagement.type=='地方活动'}">selected</c:if>>地方活动</option>
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
            <th><span class="star" style="color:#f82e2a">*</span>来源:</th>
            <td><input type="text" name="source" id="source" class="input_txt" value="${activityCategoryManagement.source}"/></td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>活动介绍:</th>
            <td><script id="editor" type="text/plain" style="width: 80%;height: 200px">${activityCategoryManagement.introduction}</script></td>
        </tr>

        <c:if test="${activityCategoryManagement.id!=null}">
            <tr class="info">
                <th>活动图片原图:</th>
                <td><img src="${activityCategoryManagement.activityPhotosURL}" style="width: 100px;height: 100px"></td>
            </tr>
        </c:if>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>上传活动图片:</th>
            <td><input type="file" name="activityPhotos" id="activityPhotosURL" class="input_txt"/></td>
        </tr>

        <tr class="info">
            <th>预览活动图片:</th>
            <td class="imgBox1"></td>
        </tr>

        <c:if test="${activityCategoryManagement.id!=null}">
            <tr class="info">
                <th>banner图片原图:</th>
                <td><img src="${activityCategoryManagement.bannerPhotosURL}" style="width: 100px;height: 100px"></td>
            </tr>
        </c:if>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>上传banner图片:</th>
            <td><input type="file" name="bannerPhotos" id="bannerPhotosURL" class="input_txt"/></td>
        </tr>

        <tr class="info">
            <th>预览banner图片:</th>
            <td class="imgBox2"></td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>跳转链接:</th>
            <td><input type="text" id="link" name="link" value="${activityCategoryManagement.link}" class="input_txt"/></td>
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
            document.getElementById("introduction").value=UE.getEditor('editor').getContent();
            $("#activityCategoryManagementForm").submit();
        });
        if ($("#id").val()!=""){
            var area = "${activityCategoryManagement.area}";
            if(area!=""){
                $("#area").val(area);
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

        if($("#id").val()==""||$("#id").val()==null){
            if ($('#activityPhotosURL').val()==""||$('#activityPhotosURL').val()==null) {
                alert("请上传活动图片!");
                $("#activityPhotosURL").focus();
                return false;
            }
        }

        if($("#id").val()==""||$("#id").val()==null){
            if ($('#bannerPhotosURL').val()==""||$('#bannerPhotosURL').val()==null) {
                alert("请上传banner图片!");
                $("#bannerPhotosURL").focus();
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


        if ($("#introduction").val().length<1){
            alert("请输入活动介绍!");
            $("#editor").focus();
            return false;
        } else if ($("#introduction").val().length>5000){
            alert("活动介绍不能超过5000字符!");
            $("#editor").focus();
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
        if($("#link").val()==""){
            alert("请输入跳转链接!");
            $("#link").focus();
            return false;
        } else if ($("#link").val().length>255){
            alert("跳转链接不能超过255个字符!");
            $("#link").focus();
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
        $('#activityPhotosURL').change(function () {
            $('.imgBox1').html("");
            var imgArr = []; //获取的图片地址
            var fileList = $(this)[0].files;   //或获取的图片文件
            var Length = fileList.length;
            for (var i = 0; i < Length; i++) {
                var imgUrl = window.URL.createObjectURL(fileList[i]); //获取图片地址
                imgArr.push(imgUrl);
                var $img = $("<img class='img'>");
                $('.imgBox1').append($img);
                $img.attr('src', imgArr[i]);
                $img.css({'height':'100px','width':'100px'})
            }
        });
    });

    $(function() {
        $('#bannerPhotosURL').change(function () {
            $('.imgBox2').html("");
            var imgArr = []; //获取的图片地址
            var fileList = $(this)[0].files;   //或获取的图片文件
            var Length = fileList.length;
            for (var i = 0; i < Length; i++) {
                var imgUrl = window.URL.createObjectURL(fileList[i]); //获取图片地址
                imgArr.push(imgUrl);
                var $img = $("<img class='img'>");
                $('.imgBox2').append($img);
                $img.attr('src', imgArr[i]);
                $img.css({'height':'100px','width':'100px'})
            }
        });
    });


</script>
</body>
</html>
