<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My Test</title>

    <link type="text/css" rel="stylesheet" href="../../css/main.css"/>
    <link rel="stylesheet" type="text/css" href="../../jquery-easyui-1.6.4/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../../jquery-easyui-1.6.4/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../../jquery-easyui-1.6.4/demo/demo.css">
    <script type="text/javascript" src="../../js/jquery-1.5.1.min.js"></script>
    <script type="text/javascript" src="../../jquery-easyui-1.6.4/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        window.UEDITOR_HOME_URL = "/ueditor/";
    </script>

    <style type="text/css">
        body{width:100%;height:100%;background-color: #FFFFFF;text-align: center;}
        .input_txt{width:200px;height:20px;line-height:20px;}
        .info{height:40px;line-height:40px;}
        .info th{text-align: left;width:120px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
        .info td{text-align:left}
    </style>
</head>
<body>


<form action="savePolicyIssued.html" name="policyIssuedForm" id="policyIssuedForm" target="result" method="post" onsubmit="return checkInfo();" enctype="multipart/form-data">
    <input type="hidden" name="id" id="id" value="${policyIssued.id }"/>
    <input type="hidden" name="content" id="content">
    <table border="0" cellpadding="0" cellspacing="0">
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>标题:</th>
            <td><input type="text" name="name" id="name" class="input_txt" value="${policyIssued.name }"/></td>
            <th><span class="star" style="color:#f82e2a">*</span>发布单位(可多选):</th>
            <td>
                <input class="easyui-combobox"
                       style="width: 250px"
                       name="reportUnit"
                       id="reportUnit"
                       value="${policyIssued.reportUnit }"
                       data-options="
 					url:'getReportUnit.html',
 		 			method:'get',
					valueField:'organizationName',
 					textField:'organizationName',
 					multiple:true,
					panelHeight:'100px'
 			    ">
            </td>
            </tr>
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>发文字号:</th>
            <td><input type="text" name="postShopName" id="postShopName" class="input_txt" value="${policyIssued.postShopName }"></td>
            <th>生态圈(可多选)</th>
            <td>
                <input class="easyui-combobox"
                       style="width: 250px"
                       name="ecosphereKeyword"
                       id="ecosphereKeyword"
                       value="${policyIssued.ecosphereKeyword }"
                       data-options="
 					url:'getEcosphereKeyword.html',
 		 			method:'get',
					valueField:'name',
 					textField:'name',
 					multiple:true,
					panelHeight:'auto'
 			">
            </td>
        </tr>
        <tr class="info">
            <th>发布时间:</th>
            <td>
                <input type="text" name="reportDate" id="reportDate" value="<fmt:formatDate value="${policyIssued.reportDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker()" readonly="readonly" style="width:200px;"/>
            </td>
            <th>主题分类:</th>
            <td>
                <input class="easyui-combobox"
                       style="width: 250px"
                       name="policyTheme"
                       id="policyTheme"
                       value="${policyIssued.policyTheme}"
                       data-options="
 					url:'getPolicyTheme.html',
 		 			method:'get',
					valueField:'name',
 					textField:'name',
 					multiple:false,
					panelHeight:'150px'
 			">
            </td>
        </tr>
        <tr class="info">
            <th>政策排序:</th>
            <td><input type="text" name="sorting" id="sorting" class="input_txt" value="${policyIssued.sorting }"/></td>
            <th>时间轴:</th>
            <td>
                <input class="easyui-combobox"
                       style="width: 250px"
                       name="timelinePhase"
                       id="timelinePhase"
                       value="${policyIssued.timelinePhase }"
                       data-options="
 					url:'getTimelinePhase.html',
 		 			method:'get',
					valueField:'name',
 					textField:'name',
 					multiple:false,
					panelHeight:'auto'
 			">
            </td>
        </tr>
        <tr class="info">
            <th>政策解读简介:</th>
            <td><textarea name="policyIntroduction" style="width: 200px;">${policyIssued.policyIntroduction }</textarea></td>
            <th>创业人群(可多选)</th>
            <td>
                <input class="easyui-combobox"
                       style="width: 250px"
                       name="businessPeople"
                       id="businessPeople"
                       value="${policyIssued.businessPeople }"
                       data-options="
 					url:'getBusinessPeople.html',
 		 			method:'get',
					valueField:'name',
 					textField:'name',
 					multiple:true,
					panelHeight:'auto'
 			">
            </td>
        </tr>
        <tr class="info">
            <th>访谈时间:</th>
            <td>
                <input type="text" name="interviewDate" id="interviewDate" value="<fmt:formatDate value="${policyIssued.interviewDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker()" readonly="readonly" style="width:200px;"/>
            </td>
            <th>行业(可多选):</th>
            <td>
                <input class="easyui-combobox"
                       style="width: 250px"
                       name="industry"
                       id="industry"
                       value="${policyIssued.industry }"
                       data-options="
 					url:'getIndustry.html',
 		 			method:'get',
					valueField:'name',
 					textField:'name',
 					multiple:true,
					panelHeight:'auto'
 			">
            </td>
        </tr>
        <tr class="info">
            <th>访谈视频地址:</th>
            <td><input type="text" name="interviewVideoFileURL" id="interviewVideoFileURL" class="input_txt" value="${policyIssued.interviewVideoFileURL }"/></td>
            <th>政策隶属:</th>
            <td>
                <input class="easyui-combobox"
                       style="width: 250px"
                       name="policyIs"
                       id="policyIs"
                       value="${policyIssued.policyIs}"
                       data-options="
					valueField:'value',
 					textField:'name',
 					multiple:false,
					panelHeight:'auto',
					data:[{name:'全部',value:'1'},{name:'国家政策',value:'2'},{name:'区域政策',value:'3'}]
 			">
            </td>
        </tr>
        <tr class="info">
            <th>访谈简介:</th>
            <td><textarea style="width: 200px" name="interviewIntroduction" id="interviewIntroduction">${policyIssued.interviewIntroduction }</textarea></td>
            <th>创业服务(可多选):</th>
            <td>
                <input class="easyui-combobox"
                       style="width: 250px"
                       name="innovationService"
                       id="innovationService"
                       value="${policyIssued.innovationService }"
                       data-options="
					valueField:'name',
 					textField:'name',
 					multiple:true,
					panelHeight:'auto',
					data:[{name:'金融服务'},{name:'技术服务'},{name:'场地服务'},{name:'人才服务'}]
 			">
            </td>
        </tr>
        <tr class="info">
            <th>访谈嘉宾:</th>
            <td><textarea style="width: 200px" name="interviewGuest" id="interviewGuest">${policyIssued.interviewGuest }</textarea></td>
            <th>政策分类:</th>
            <td>
                <input class="easyui-combobox"
                       style="width: 250px"
                       name="policyClassification"
                       id="policyClassification"
                       value="${policyIssued.policyClassification }"
                       data-options="
 					url:'getPolicyClassification.html',
 		 			method:'get',
					valueField:'name',
 					textField:'name',
 					multiple:false,
					panelHeight:'auto'
 			">
            </td>
        </tr>
        <tr class="info">
            <th>上传动态封面图片:</th>
            <td>
                <input type="file" name="file" id="file" accept="image/*">
            </td>
            <th>区域:</th>
            <td>
                <input class="easyui-combobox"
                       style="width: 250px"
                       name="region"
                       id="region"
                       value="${policyIssued.region }"
                       data-options="
 					url:'getRegion.html',
 		 			method:'get',
					valueField:'name',
 					textField:'name',
 					multiple:false,
					panelHeight:'150px'
 			">
            </td>
        </tr>
        <tr class="info">
            <th>图片预览:</th>
            <td>
                 <div class="imgBox" style="width: 100px;height: auto;"></div>
            </td>
        </tr>
        <tr class="info">
            <th>政策内容:</th>
            <td colspan="3"><script id="editor" type="text/plain" style="width:80%;height:200px;">${policyIssued.content}</script></td>
        </tr>
    </table>
</form>
<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
<!-- 百度富文本编辑框-->
<script type="text/javascript" charset="utf-8">window.UEDITOR_HOME_URL = "/ueditor/";</script>
<script type="text/javascript"  src="../../js/datePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../../js/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
<script type="text/javascript" charset="utf-8" src="../../ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="../../ueditor/ueditor.all.js"></script>

<script type="text/javascript">

    var dg;
    $(document).ready(function () {
        dg = frameElement.lhgDG;
        dg.addBtn('ok', '保存', function () {
            //大文本编辑器获取值
            var ue = UE.getEditor('editor');
            document.getElementById("content").value = UE.getEditor('editor').getContent();
            $("#policyIssuedForm").submit();
        });

    });

    //百度富文本
    setTimeout("ueditor()", 500);
    function ueditor() {
        UE.getEditor('editor');
    }

    function checkInfo() {
        if($('#reportUnit').combobox('getValues')==null || $('#reportUnit').combobox('getValues')==""){
            alert("请选择发布单位!");
            $("#reportUnit").focus();
            return false;
        }

        if ($("#name").val() == "") {
            alert("请输入政策标题!");
            $("#name").focus();
            return false;
        }

        if ($("#name").val().length>64){
            alert("政策标题不得长于64个字符");
            $("#name").focus();
            return false;
        }
        if ($("#postShopName").val() == "") {
            alert("请输入发文字号!");
            $("#postShopName").focus();
            return false;
        }

        if ($("#postShopName").val().length >255) {
            alert("发文字号不能超过255个字符!");
            $("#postShopName").focus();
            return false;
        }

    }

    function nameExist() {
        alert("该标题已存在！");
        $("#name").select();
        $("#name").focus();
    }

    function success() {
        if (dg.curWin.document.forms[0]) {
            dg.curWin.document.forms[0].action = dg.curWin.location + "";
            dg.curWin.document.forms[0].submit();
        } else {
            dg.curWin.location.reload();
        }
        dg.cancel();
    }

    $(function () {
        console.log("true");
        $('#file').change(function () {
            $('.imgBox').html("");
            var imgArr = []; //获取的图片地址
            var fileList = $(this)[0].files;   //或获取的图片文件
            console.log(fileList);
            var Length = fileList.length;
            for (var i = 0; i < Length; i++) {
                var imgUrl = window.URL.createObjectURL(fileList[i]); //获取图片地址
                imgArr.push(imgUrl);
                console.log(imgArr);
                var $img = $("<img class='img'>");
                $('.imgBox').append($img);
                $img.attr('src', imgArr[i]);
                $img.css({'height': '100px', 'width': '100px'})
            }
        });
    });


</script>
<script type="text/javascript">


</script>
</body>
</html>