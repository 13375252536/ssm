<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/25
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<html>
<head>
    <title>My Test</title>
    <link type="text/css" rel="stylesheet" href="../../css/main.css"/>
    <style type="text/css">
        body{width:100%;height:100%;background-color: #FFFFFF;text-align: center;}
        .input_txt{width:200px;height:20px;line-height:20px;}
        .info{height:40px;line-height:40px;}
        .info th{text-align: right;width:80px;color: #4f4f4f;padding-right:5px;font-size: 12px;}
        .info td{text-align:left;}
    </style>
</head>
<body>
<form action="saveFundFeeEnquiry.html" name="fundFeeEnquiryForm" id="fundFeeEnquiryForm" target="result" method="post" onsubmit="return checkInfo();"  enctype="multipart/form-data">
    <input type="hidden" name="id" id="id" value="${fundFeeEnquiry.id}"/>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr class="info">
            <th>费用标题:</th>
            <td><input type="text" name="name" id="name" class="input_txt" value="${fundFeeEnquiry.name}"/></td>
        </tr>

        <tr class="info">
            <th>费用种类:</th>
            <td>
                <select name="type" id="type" style="vertical-align: middle;">
                    <option value="0">请选择</option>
                    <option value="1">中央设立政府性基金和行政事业性收费</option>
                    <option value="2">省（区、市）设立行政事业性收费</option>
                    <option value="3">省（区、市）设立涉企行政事业性收费</option>
                </select>
            </td>
        </tr>




        <c:if test="${fundFeeEnquiry.id!=null}">
            <tr class="info">
                <th>原图:</th>
                <td><img src="${fundFeeEnquiry.fileURL}" style="width: 100px;height: 100px"></td>
            </tr>
        </c:if>

        <tr class="info">
            <th>上传附件:</th>
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
            $("#fundFeeEnquiryForm").submit();
        });
        if($("#id").val()!=""||$("#id").val()!=null){
            var type = "${fundFeeEnquiry.type}";
            if(type!=""){
                $("#type").val(type);
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

        if($("#id").val()==""||$("#id").val()==null){
            if ($('#file').val()==""||$('#file').val()==null) {
                alert("请上传附件!");
                $("#file").focus();
                return false;
            }
        }

        if ($("#type").find("option:selected").val()=="0"){
            alert("请选择费用种类!");
            $("#type").focus();
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
        $('#file').change(function () {
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
    });


</script>

</body>
</html>
