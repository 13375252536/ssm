<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/7
  Time: 13:08
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
        .info th{text-align: right;width:120px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
        .info td{text-align:left;}
    </style>
</head>
<body>
<form action="saveDynamicManagement.html" name="dynamicManagementForm" id="dynamicManagementForm" target="result" method="post" onsubmit="return checkInfo();"  enctype="multipart/form-data">
    <input type="hidden" name="id" id="id" value="${dynamicManagement.id}"/>
    <input type="hidden" name="content" id="content"/>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>标题:</th>
            <td><input type="text" name="name" id="name" class="input_txt" value="${dynamicManagement.name}"/></td>
        </tr>
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>简介:</th>
            <td><input type="text" name="introduction" id="introduction" class="input_txt" value="${dynamicManagement.introduction}"/></td>
        </tr>
        <tr class="info">
            <th>发布单位:</th>
            <td>
                <select name="releaseUnit" id="releaseUnit" style="vertical-align: middle;">
                    <option value="">请选择</option>
                    <c:forEach items="${selectOrganizationInfo}" var="OrganizationManagement">
                        <option value="${OrganizationManagement.id}">${OrganizationManagement.organizationName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>领导标记:</th>
            <td>
                <select  name="leadershipTag" id="leadershipTag" style="vertical-align: middle;">
                    <option value="0">请选择</option>
                    <option <c:if test="${dynamicManagement.leadershipTag=='不标记'}">selected</c:if>>不标记</option>
                    <option <c:if test="${dynamicManagement.leadershipTag=='标记'}">selected</c:if>>标记</option>
                </select>
            </td>
        </tr>
        <tr class="info">
            <th>所属基地:</th>
            <td>
                <select name="base" id="base" style="vertical-align: middle;">
                    <option value="">请选择</option>
                    <c:forEach items="${selectBaseInfo}" var="base">
                        <option value="${base.id}">${base.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr class="info">
            <th>所属地区:</th>
            <td>
                <select name="region" id="region" style="vertical-align: middle;">
                    <option value="">请选择</option>
                <c:forEach items="${selectAreaInfo}" var="region">
                    <option value="${region.id}">${region.name}</option>
                </c:forEach>
                </select>
            </td>
        </tr>
        <tr class="info">
            <th>所属社会团体:</th>
            <td>
                <select  name="socialGroups" id="socialGroups" style="vertical-align: middle;">
                    <option value="">请选择</option>
                    <option <c:if test="${dynamicManagement.socialGroups=='中国科协'}">selected</c:if>>中国科协</option>
                    <option <c:if test="${dynamicManagement.socialGroups=='全国妇联'}">selected</c:if>>全国妇联</option>
                    <option <c:if test="${dynamicManagement.socialGroups=='中国残联'}">selected</c:if>>中国残联</option>
                    <option <c:if test="${dynamicManagement.socialGroups=='自然科学基金会'}">selected</c:if>>自然科学基金会</option>
                </select>
            </td>
        </tr>
        <tr class="info">
            <th>动态分类:</th>
            <td>
                <select name="dynamicClassification" id="dynamicClassification">
                    <option value="">请选择</option>
                    <option <c:if test="${dynamicManagement.dynamicClassification=='动态咨讯'}">selected</c:if>>动态咨讯</option>
                    <option <c:if test="${dynamicManagement.dynamicClassification=='政策动态'}">selected</c:if>>政策动态</option>
                </select>
            </td>
        </tr>
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>来源:</th>
            <td><input id="source" name="source" type="text" value="${dynamicManagement.source}"/></td>
        </tr>
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>发布时间:</th>
            <td><input type="text" name="reportDate" id="reportDate" value="<fmt:formatDate value="${dynamicManagement.reportDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker()" readonly="readonly" style="width:70px;"/></td>
        </tr>
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>排序:</th>
            <td><input type="text" name="sorting" id="sorting" class="input_txt" value="${dynamicManagement.sorting}"/></td>
        </tr>
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>正文:</th>
            <td><script id="editor" type="text/plain" style="width: 80%;height: 200px">${dynamicManagement.content}</script></td>
        </tr>
        <c:if test="${dynamicManagement.id!=null}">
            <tr class="info">
                <th>原图:</th>
                <td><img src="${dynamicManagement.fileURL}" style="width: 100px;height: 100px"></td>
            </tr>
        </c:if>
        <tr class="info">
            <th>上传图片:</th>
            <td><input type="file" name="file" id="fileURL"/></td>
        </tr>
        <tr class="info">
            <th>预览效果:</th>
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
            //大文本编辑器获取值
            var ue = UE.getEditor('editor');
            document.getElementById("content").value=UE.getEditor('editor').getContent();
            $("#dynamicManagementForm").submit();
        });
        if($("#id").val()!=""||$("#id").val()!=null){
            var region = "${dynamicManagement.region}";
            var releaseUnit = "${dynamicManagement.releaseUnit}";
            var base = "${dynamicManagement.base}";
            if(region!=""){
                $("#region").val(region);
            }
            if(releaseUnit!=""){
                $("#releaseUnit").val(releaseUnit);
            }
            if(base!=""){
                $("#base").val(base);
            }
        }
    });

    $("#base").change(function () {
        var base = $('#base').val();
        $.ajax({
            url:'http://localhost:8080/homePage/selectRegionIdByBaseId.html',
            dataType: 'json',
            data: {'id': base},
            type: 'post',
            success:function (rs) {
                var option = "<option value='"+rs.id+"'>"+rs.name+"</option>";
                $("#region").html(option);
            }
        });
    });

    $("#region").change(function () {
        var region = $('#region').val();
        $.ajax({
            url:'http://localhost:8080/homePage/selectBaseIdByRegionId.html',
            dataType: 'json',
            data: {'id': region},
            type: 'post',
            success:function (rs) {
                var option = "<option value=''></option>";
                $.each(rs , function(index , item){
                    option += "<option "+'value='+item.id+">"+item.name+" </option>";
                    $("#base").html(option);
                })
            }
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

        if($("#introduction").val()==""){
            alert("请输入简介!");
            $("#introduction").focus();
            return false;
        }
        if ($("#introduction").val().length>200){
            alert("简介不得长于200个字符");
            $("#introduction").focus();
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

        if ($("#leadershipTag").val()==0) {
            alert("请选择领导标记!");
            $("#leadershipTag").focus();
            return false;
        }
        if ($("#source").val() == ''){
            alert("请输入来源!");
            $("#source").focus();
            return false;
        }
        if($("#reportDate").val()==""||$("#reportDate").val()==null){
            alert("请输入发布日期!");
            $("#reportDate").focus();
            return false;
        }

        if($("#content").val()==""){
            alert("请输入正文!");
            $("#content").focus();
            return false;
        }
        if ($("#content").val().length>5000){
            alert("正文不得长于5000个字符");
            $("#content").focus();
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
    setTimeout("ueditor()",500);
    function ueditor(){
        UE.getEditor('editor');
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
