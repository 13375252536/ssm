<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/8/29
  Time: 13:29
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
<form action="saveImageManagement.html" name="imageManagementForm" id="imageManagementForm" target="result" method="post" onsubmit="return checkInfo();"  enctype="multipart/form-data">
    <input type="hidden" name="id" id="id" value="${imageManagement.id}"/>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>名称:</th>
            <td><input type="text" name="name" id="name" class="input_txt" value="${imageManagement.name}"/></td>
        </tr>
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>类型:</th>
            <td>
                <select name="type" id="type" class="input_txt">
                    <option <c:if test="${imageManagement.type=='首页-创响中国跳转'}">selected</c:if>>首页-创响中国跳转</option>
                    <option <c:if test="${imageManagement.type=='双创活动周'}">selected</c:if>>双创活动周</option>
                    <option <c:if test="${imageManagement.type=='战略性新兴产业'}">selected</c:if>>战略性新兴产业</option>
                    <option <c:if test="${imageManagement.type=='创响中国'}">selected</c:if>>创响中国</option>
                    <option <c:if test="${imageManagement.type=='活动跟踪'}">selected</c:if>>活动跟踪</option>
                    <option <c:if test="${imageManagement.type=='全面创新改革试验'}">selected</c:if>>全面创新改革试验</option>
                    <option <c:if test="${imageManagement.type=='服务拓展-双创税收优惠政策查询'}">selected</c:if>>服务拓展-双创税收优惠政策查询</option>
                    <option <c:if test="${imageManagement.type=='服务拓展-政府性基金和行政事业性收费查询'}">selected</c:if>>服务拓展-政府性基金和行政事业性收费查询</option>
                    <option <c:if test="${imageManagement.type=='服务拓展-取消下放的行政审批事项查询'}">selected</c:if>>服务拓展-取消下放的行政审批事项查询</option>
                </select>
            </td>
        </tr>
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>链接:</th>
            <td><input type="text" name="link" id="link" class="input_txt" value="${imageManagement.link}"/></td>
        </tr>
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>排序:</th>
            <td><input type="text" name="sorting" id="sorting" class="input_txt" value="${imageManagement.sorting}"/></td>
        </tr>
        <c:if test="${imageManagement.id!=null}">
        <tr class="info">
            <th>原图:</th>
            <td><img src="${imageManagement.fileURL}" style="width: 100px;height: 100px"></td>
        </tr>
        </c:if>
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>上传图片:</th>
            <td><input type="file" name="file" id="file" class="input_txt" accept="image/*"/></td>
        </tr>
        <tr class="info">
            <th>预览效果:</th>
            <td class="imgBox"></td>
        </tr>
    </table>
</form>
<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
<script type="text/javascript" src="../../js/jquery-1.5.1.min.js"></script>
<script>
    var dg;
    $(document).ready(function(){
        dg = frameElement.lhgDG;
        dg.addBtn('ok','保存',function(){
            $("#imageManagementForm").submit();
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

        if ($("#type").find("option:selected").val()=="0") {
            alert("请选择类别!");
            $("#type").focus();
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
            if ($('#file').val()==""||$('#file').val()==null) {
                alert("请上传图片!");
                $("#file").focus();
                return false;
            }
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
        $('#file').change(function () {
            $('.imgBox').html("");
            var imgArr = []; //获取的图片地址
            var fileList = $(this)[0].files;   //或获取的图片文件
            var Length = fileList.length;
            for (var i = 0; i < Length; i++) {
                var imgUrl = window.URL.createObjectURL(fileList[i]); //获取图片地址
                imgArr.push(imgUrl);
                console.log(imgArr);
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
