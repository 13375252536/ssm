<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/18
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        .info th{text-align: right;width:200px;color: #4f4f4f;padding-right:5px;font-size: 12px;}
        .info td{text-align:left;}
    </style>
</head>
<body>
<form action="saveDemonstrationBaseManagement.html" name="demonstrationBaseManagementForm" id="demonstrationBaseManagementForm" target="result" method="post" onsubmit="return checkInfo();"  enctype="multipart/form-data">
    <input type="hidden" name="id" id="id" value="${demonstrationBaseManagement.id}"/>
    <input type="hidden" name="introduction" id="introduction"/>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>基地名称:</th>
            <td><input type="text" name="name" id="name" class="input_txt" value="${demonstrationBaseManagement.name}"/></td>
        </tr>
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>基地种类:</th>
            <td>
                <select name="type" id="type" style="vertical-align: middle;">
                    <option value="0">请选择</option>
                    <option <c:if test="${demonstrationBaseManagement.type=='区域示范基地'}">selected</c:if>>区域示范基地</option>
                    <option <c:if test="${demonstrationBaseManagement.type=='高校和科研院所示范基地'}">selected</c:if>>高校和科研院所示范基地</option>
                    <option <c:if test="${demonstrationBaseManagement.type=='企业示范基地'}">selected</c:if>>企业示范基地</option>
                </select>
            </td>
        </tr>
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>基地批次:</th>
            <td>
                <select name="batch" id="batch" style="vertical-align: middle;">
                    <option value="0">请选择</option>
                    <option <c:if test="${demonstrationBaseManagement.batch=='首批'}">selected</c:if>>首批</option>
                    <option <c:if test="${demonstrationBaseManagement.batch=='第二批'}">selected</c:if>>第二批</option>
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
            <th><span class="star" style="color:#f82e2a">*</span>发布单位:</th>
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
            <th>第一标题:</th>
            <td><input type="text" name="firstTitle" id="firstTitle" class="input_txt" value="${demonstrationBaseManagement.firstTitle}"/></td>
        </tr>
        <tr class="info">
            <th>第一内容:</th>
            <td><textarea name="firstContent" id="firstContent" class="input_txt">${demonstrationBaseManagement.firstContent}</textarea></td>
        </tr>
        <tr class="info">
            <th>第二标题:</th>
            <td><input type="text" name="secondTitle" id="secondTitle" class="input_txt" value="${demonstrationBaseManagement.secondTitle}"/></td>
        </tr>
        <tr class="info">
            <th>第二内容:</th>
            <td><textarea name="secondContent" id="secondContent" class="input_txt">${demonstrationBaseManagement.secondContent}</textarea></td>
        </tr>
        <tr class="info">
            <th>第三标题:</th>
            <td><input type="text" name="thirdTitle" id="thirdTitle" class="input_txt" value="${demonstrationBaseManagement.thirdTitle}"/></td>
        </tr>
        <tr class="info">
            <th>第三内容:</th>
            <td><textarea name="thirdContent" id="thirdContent" class="input_txt">${demonstrationBaseManagement.thirdContent}</textarea></td>
        </tr>

        <tr class="info">
            <th>第四标题:</th>
            <td><input type="text" name="fourthTitle" id="fourthTitle" class="input_txt" value="${demonstrationBaseManagement.fourthTitle}"/></td>
        </tr>
        <tr class="info">
            <th>第四内容:</th>
            <td><textarea name="fourthContent" id="fourthContent" class="input_txt">${demonstrationBaseManagement.fourthContent}</textarea></td>
        </tr>

        <tr class="info">
            <th>第五标题:</th>
            <td><input type="text" name="fifthTitle" id="fifthTitle" class="input_txt" value="${demonstrationBaseManagement.fifthTitle}"/></td>
        </tr>
        <tr class="info">
            <th>第五内容:</th>
            <td><textarea name="fifthContent" id="fifthContent" class="input_txt">${demonstrationBaseManagement.fifthContent}</textarea></td>
        </tr>

        <tr class="info">
            <th>第六标题:</th>
            <td><input type="text" name="sixthTitle" id="sixthTitle" class="input_txt" value="${demonstrationBaseManagement.sixthTitle}"/></td>
        </tr>
        <tr class="info">
            <th>第六内容:</th>
            <td><textarea name="sixthContent" id="sixthContent" class="input_txt">${demonstrationBaseManagement.sixthContent}</textarea></td>
        </tr>
        <tr class="info">
            <th>第七标题:</th>
            <td><input type="text" name="seventhTitle" id="seventhTitle" class="input_txt" value="${demonstrationBaseManagement.seventhTitle}"/></td>
        </tr>
        <tr class="info">
            <th>第七内容:</th>
            <td><textarea name="seventhContent" id="seventhContent" class="input_txt">${demonstrationBaseManagement.seventhContent}</textarea></td>
        </tr>
        <tr class="info">
            <th>第八标题:</th>
            <td><input type="text" name="eighthTitle" id="eighthTitle" class="input_txt" value="${demonstrationBaseManagement.eighthTitle}"/></td>
        </tr>
        <tr class="info">
            <th>第九标题:</th>
            <td><input type="text" name="ninthTitle" id="ninthTitle" class="input_txt" value="${demonstrationBaseManagement.ninthTitle}"/></td>
        </tr>
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>排序:</th>
            <td><input type="text" name="sorting" id="sorting" class="input_txt" value="${demonstrationBaseManagement.sorting}"/></td>
        </tr>
        <c:if test="${demonstrationBaseManagement.id!=null}">
            <tr class="info">
                <th>原图:</th>
                <td><img src="${demonstrationBaseManagement.fileURL}" style="width: 100px;height: 100px"></td>
            </tr>
        </c:if>
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>上传附件:</th>
            <td><input type="file" name="file" id="file" class="input_txt"/></td>
        </tr>
        <tr class="info">
            <th>预览:</th>
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
            $("#demonstrationBaseManagementForm").submit();
        });
        if($("#id").val()!=""||$("#id").val()!=null){
            var area = "${demonstrationBaseManagement.area}";
            var reportUnit = "${demonstrationBaseManagement.reportUnit}";
            if(area!=""){
                $("#area").val(area);
            }
            if(reportUnit!=""){
                $("#reportUnit").val(reportUnit);
            }
        }
    });
    function checkInfo(){
        if($("#name").val()==""){
            alert("请输入基地名称!");
            $("#name").focus();
            return false;
        }
        if ($("#name").val().length>64){
            alert("基地名称不得长于64个字符");
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
            if ($('#file').val()==""||$('#file').val()==null) {
                alert("请上传图片!");
                $("#file").focus();
                return false;
            }
        }

        if ($("#type").find("option:selected").val()=="0"){
            alert("请选择基地种类!");
            $("#type").focus();
            return false;
        }

        if ($("#batch").find("option:selected").val()=="0"){
            alert("请选择批次!");
            $("#batch").focus();
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
        if ($("#firstTitle").val().length>64){
            alert("第一标题不得长于64个字符");
            $("#firstTitle").focus();
            return false;
        }
        if ($("#firstTitle").val().length>64){
            alert("第一标题不得长于64个字符");
            $("#firstTitle").focus();
            return false;
        }
        if ($("#secondTitle").val().length>64){
            alert("第二标题不得长于64个字符");
            $("#secondTitle").focus();
            return false;
        }
        if ($("#thirdTitle").val().length>64){
            alert("第三标题不得长于64个字符");
            $("#thirdTitle").focus();
            return false;
        }
        if ($("#fourthTitle").val().length>64){
            alert("第四标题不得长于64个字符");
            $("#fourthTitle").focus();
            return false;
        }
        if ($("#fifthTitle").val().length>64){
            alert("第五标题不得长于64个字符");
            $("#fifthTitle").focus();
            return false;
        }
        if ($("#sixthTitle").val().length>64){
            alert("第六标题不得长于64个字符");
            $("#sixthTitle").focus();
            return false;
        }
        if ($("#seventhTitle").val().length>64){
            alert("第七标题不得长于64个字符");
            $("#seventhTitle").focus();
            return false;
        }
        if ($("#eighthTitle").val().length>64){
            alert("第八标题不得长于64个字符");
            $("#eighthTitle").focus();
            return false;
        }
        if ($("#ninthTitle").val().length>64){
            alert("第九标题不得长于64个字符");
            $("#ninthTitle").focus();
            return false;
        }
        if ($("#seventhContent").val().length>5000){
            alert("第七内容不得长于5000个字符");
            $("#seventhContent").focus();
            return false;
        }
        if ($("#sixthContent").val().length>5000){
            alert("第六内容不得长于5000个字符");
            $("#sixthContent").focus();
            return false;
        }
        if ($("#fifthContent").val().length>5000){
            alert("第五内容不得长于5000个字符");
            $("#fifthContent").focus();
            return false;
        }
        if ($("#fourthContent").val().length>5000){
            alert("第四内容不得长于5000个字符");
            $("#fourthContent").focus();
            return false;
        }
        if ($("#thirdContent").val().length>5000){
            alert("第三内容不得长于5000个字符");
            $("#thirdContent").focus();
            return false;
        }
        if ($("#secondContent").val().length>5000){
            alert("第二内容不得长于5000个字符");
            $("#secondContent").focus();
            return false;
        }
        if ($("#firstContent").val().length>5000){
            alert("第一内容不得长于5000个字符");
            $("#firstContent").focus();
            return false;
        }
    }

    function nameExist() {
        alert("该基地名称已存在！");
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
