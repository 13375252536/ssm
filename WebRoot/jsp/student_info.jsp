<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/8/23
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Test</title>
    <link type="text/css" rel="stylesheet" href="../css/main.css"/>
    <style type="text/css">
        body{width:100%;height:100%;background-color: #FFFFFF;text-align: center;}
        .input_txt{width:200px;height:20px;line-height:20px;}
        .info{height:40px;line-height:40px;}
        .info th{text-align: right;width:65px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
        .info td{text-align:left;}
    </style>
</head>
<body>
<form action="save.html" name="studentForm" id="studentForm" target="result" method="post" onsubmit="return checkInfo();"  enctype="multipart/form-data">
    <input type="hidden" name="id" id="id" value="${student.id}"/>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr class="info">
            <th>学生学号:</th>
            <td><input type="text" name="sno" id="sno" class="input_txt" value="${student.sno}"/></td>
        </tr>
        <tr class="info">
            <th>学生姓名:</th>
            <td><input type="text" name="name" id="name" class="input_txt" value="${student.name}"/></td>
        </tr>
        <%--上传图片--%>
        <tr class="info">
            <th>学生照片:</th>
            <td><input type="file" name="file" id="portrait" class="input_txt" accept="image/*"/></td>
        </tr>
        <tr class="info">
            <th>学生性别:</th>
            <td>
                <select name="gender" id="gender" class="input_txt">
                    <option value="">请选择</option>
                    <option <c:if test="${student.gender=='男'}">selected</c:if>>男</option>
                    <option <c:if test="${student.gender=='女'}">selected</c:if>>女</option>
                </select>
            </td>
        </tr>
        <tr class="info">
            <th>学生年龄:</th>
            <td><input type="text" name="age" id="age" class="input_txt" value="${student.age}"/></td>
        </tr>
        <tr class="info">
            <th>学生班级:</th>
            <td>
                <input type="text" name="grade" id="grade" class="input_txt" value="${student.grade}"/></td>
            </td>
        </tr>
        <tr class="info">
            <th>身份证号:</th>
            <td>
                <input type="text" name="idNum" id="idNum" class="input_txt" value="${student.idNum}"/></td>
            </td>
        </tr>
    </table>
</form>
<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
    <script type="text/javascript" src="../js/jquery-1.5.1.min.js"></script>
    <script type="text/javascript">
        var dg;
        $(document).ready(function(){
            dg = frameElement.lhgDG;
            dg.addBtn('ok','保存',function(){
                $("#studentForm").submit();
            });
        });

        function checkInfo(){
            if($("#sno").val()==""){
                alert("请输入学生学号!");
                $("#sno").focus();
                return false;
            }
            if($("#name").val()==""){
                alert("请输入学生姓名!");
                $("#name").focus();
                return false;
            }
            if($("#age").val()==""){
                alert("请输入学生年龄!");
                $("#age").focus();
                return false;
            }
            if($("#id").val()==""||$("#id").val()==null){
                if ($('#portrait').val()==""||$('#portrait').val()==null) {
                    alert("请上传学生照片!");
                    $("#portrait").focus();
                    return false;
                }
            }

            if($("#gender").val()==""||$("#gender").val()==null){
                alert("请选择学生性别!");
                $("#gender").focus();
                return false;
            }
            if($("#grade").val()==""){
                alert("请输入学生班级!");
                $("#grade").focus();
                return false;
            }
            if($("#idNum").val()==""){
                alert("请输入身份证号!");
                $("#idNum").focus();
                return false;
            }
            return true;
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
        function snoExist(){
            alert("该学生学号已存在！");
            $("#sno").select();
            $("#sno").focus();
        }
        function idNumExist() {
            alert("该身份证号已存在！");
            $("#idNum").select();
            $("#idNum").focus();
        }
    </script>
</body>
</html>
