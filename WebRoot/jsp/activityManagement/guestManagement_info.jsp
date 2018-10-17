<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/13
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Test</title>
    <link type="text/css" rel="stylesheet" href="../../css/main.css"/>
    <style type="text/css">
        body{width:100%;height:100%;background-color: #FFFFFF;text-align: center;}
        .input_txt{width:200px;height:20px;line-height:20px;}
        .info{height:40px;line-height:40px;}
        .info th{text-align: right;width:100px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
        .info td{text-align:left;}
    </style>
</head>
<body>
<form action="saveGuestManagement.html" name="guestManagementForm" id="guestManagementForm" target="result" method="post" onsubmit="return checkInfo();"  enctype="multipart/form-data">
    <input type="hidden" name="id" id="id" value="${guestManagement.id}"/>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>标题:</th>
            <td><input type="text" name="name" id="name" class="input_txt" value="${guestManagement.name}"/></td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>所属活动类别:</th>
            <td>
                <select id="activityCategory" name="activityCategory">
                    <option value="0">请选择</option>
                    <c:forEach items="${selectActivityCategoryInfo}" var="activityCategory">
                        <option value="${activityCategory.id}">${activityCategory.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>发布时间:</th>
            <td><input type="text" name="reportDate" id="reportDate" value="<fmt:formatDate value="${guestManagement.reportDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker()" readonly="readonly" style="width:70px;"/></td>
        </tr>

        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>排序:</th>
            <td><input type="text" name="sorting" id="sorting" class="input_txt" value="${guestManagement.sorting}"/></td>
        </tr>

        <c:if test="${guestManagement.id!=null}">
            <tr class="info">
                <th>原图:</th>
                <td><img src="${guestManagement.fileURL}" style="width: 100px;height: 100px"></td>
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
<script type="text/javascript" src="../../js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="../../js/datePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../../js/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>

<script type="text/javascript" src="../../js/jquery-1.5.1.min.js"></script>

<script>
    var dg;
    $(document).ready(function(){
        dg = frameElement.lhgDG;
        dg.addBtn('ok','保存',function(){
        $("#guestManagementForm").submit();
        });
        if($("#id").val()!=""||$("#id").val()!=null){
            var activityCategory = "${guestManagement.activityCategory}";
            if(activityCategory!=""){
                $("#activityCategory").val(activityCategory);
            }
        }
    });



    function checkInfo(){
        if($("#name").val()==""){
            alert("请输入活动标题!");
            $("#name").focus();
            return false;
        }
        if ($("#name").val().length>64){
            alert("区域名称不得长于64个字符");
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
        if ($("#activityCategory").find("option:selected").val()=="0") {
            alert("请选择活动类别!");
            $("#activityCategory").focus();
            return false;
        }
        if($('#reportDate').val()==""||$('#reportDate').val()==null){
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
