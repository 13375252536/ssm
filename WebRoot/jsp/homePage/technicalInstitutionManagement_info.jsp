<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/5
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form action="saveTechnicalInstitutionManagement.html" name="technicalInstitutionManagementForm" id="technicalInstitutionManagementForm" target="result" method="post" onsubmit="return checkInfo();"  enctype="multipart/form-data">
    <input type="hidden" name="id" id="id" value="${technicalInstitutionManagement.id}"/>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>上传文件:</th>
            <td><input type="file" name="file" id="fileURL" class="input_txt"/></td>
        </tr>
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>名称:</th>
            <td><input type="text" name="name" id="name" class="input_txt" value="${technicalInstitutionManagement.name}"/></td>
        </tr>
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>排序:</th>
            <td><input type="text" name="sorting" id="sorting" class="input_txt" value="${technicalInstitutionManagement.sorting}"/></td>
        </tr>
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>链接网址:</th>
            <td><input type="text" name="link" id="link" class="input_txt" value="${technicalInstitutionManagement.link}"/></td>
        </tr>
        <c:if test="${technicalInstitutionManagement.id!=null}">
            <tr class="info">
                <th>原图预览:</th>
                <td><img src="${technicalInstitutionManagement.fileURL}" style="width: 100px;height: 100px"></td>
            </tr>
        </c:if>
    </table>
</form>
<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
<script type="text/javascript" src="../../js/jquery-1.5.1.min.js"></script>
<script>
    var dg;
    $(document).ready(function(){
        dg = frameElement.lhgDG;
        dg.addBtn('ok','保存',function(){
            $("#technicalInstitutionManagementForm").submit();
        });
    });
    function checkInfo(){
        if($("#name").val()==""){
            alert("请输入名称!");
            $("#name").focus();
            return false;
        }
        if ($("#name").val().length>64){
            alert("名称不得长于64个字符");
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
                $("#file").focus();
                return false;
            }
        }
        if($("#link").val()==""){
            alert("请输入链接!");
            $("#link").focus();
            return false;
        }
        if ($("#link").val().length>200){
            alert("链接不得长于200个字符");
            $("#link").focus();
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
