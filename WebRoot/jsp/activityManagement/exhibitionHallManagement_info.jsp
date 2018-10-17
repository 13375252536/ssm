<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/13
  Time: 11:37
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
<form action="saveExhibitionHallManagement.html" name="exhibitionHallManagementForm" id="exhibitionHallManagementForm" target="result" method="post" onsubmit="return checkInfo();"  enctype="multipart/form-data">
    <input type="hidden" name="id" id="id" value="${exhibitionHallManagement.id}"/>
    <input type="hidden" name="content" id="content"/>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>标题:</th>
            <td><input type="text" name="name" id="name" class="input_txt" value="${exhibitionHallManagement.name}"/></td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>内容:</th>
            <td><script id="editor" type="text/plain" style="width: 80%;height: 200px">${exhibitionHallManagement.content}</script></td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>简介:</th>
            <td><input type="text" name="introduction" id="introduction" class="input_txt" value="${exhibitionHallManagement.introduction}"/></td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>发布时间:</th>
            <td><input type="text" name="reportDate" id="reportDate" value="<fmt:formatDate value="${exhibitionHallManagement.reportDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker()" readonly="readonly" style="width:70px;"/></td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>排序:</th>
            <td><input type="text" name="sorting" id="sorting" class="input_txt" value="${exhibitionHallManagement.sorting}"/></td>
        </tr>

        <c:if test="${exhibitionHallManagement.id!=null}">
            <tr class="info">
                <th>原图:</th>
                <td><img src="${exhibitionHallManagement.fileURL}" style="width: 100px;height: 100px"></td>
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
            $("#exhibitionHallManagementForm").submit();
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

        if($("#id").val()==""||$("#id").val()==null){
            if ($('#fileURL').val()==""||$('#fileURL').val()==null) {
                alert("请上传图片!");
                $("#fileURL").focus();
                return false;
            }
        }


        if ($("#content").val().length<1){
            alert("请输入内容!");
            $("#editor").focus();
            return false;
        } else if ($("#content").val().length>5000){
            alert("内容不能超过5000字符!");
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
