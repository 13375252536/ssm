<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/22
  Time: 18:47
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
        .info th{text-align: right;width:80px;color: #4f4f4f;padding-right:5px;font-size: 12px;}
        .info td{text-align:left;}
    </style>
</head>
<body>
<form action="saveMakeRecommendations.html" name="makeRecommendationsForm" id="makeRecommendationsForm" target="result" method="post" onsubmit="return checkInfo();"  enctype="multipart/form-data">
    <input type="hidden" name="id" id="id" value="${makeRecommendations.id}"/>
    <input type="hidden" name="state" id="state"/>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr class="info">
            <th>单位:</th>
            <td><input type="text" name="unit" id="unit" class="input_txt" value="${makeRecommendations.unit}" readonly="readonly"/></td>
        </tr>
        <tr class="info">
            <th>姓名:</th>
            <td><input type="text" name="name" id="name" class="input_txt" value="${makeRecommendations.name}" readonly="readonly"/></td>
        </tr>
        <tr class="info">
            <th>电话:</th>
            <td><input type="text" name="telNum" id="telNum" class="input_txt" value="${makeRecommendations.telNum}" readonly="readonly"/></td>
        </tr>

        <tr class="info">
            <th>邮箱:</th>
            <td><input type="text" name="email" id="email" class="input_txt" value="${makeRecommendations.email}" readonly="readonly"/></td>
        </tr>
        <tr class="info">
            <th>标题:</th>
            <td><input type="text" name="title" id="title" class="input_txt" value="${makeRecommendations.title}" readonly="readonly"/></td>
        </tr>
        <tr class="info">
            <th>内容:</th>
            <td><textarea readonly="readonly" name="content" id="content" style="width: 250px;height: 200px">${makeRecommendations.content}</textarea></td>
        </tr>
        <tr class="info">
            <th>时间:</th>
            <td><input type="text" name="time" id="time" value="<fmt:formatDate value="${makeRecommendations.time}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="readonly" style="width:200px;"/></td>
        </tr>
        <tr class="info">
            <th>审批:</th>
            <td>
                <input type="radio" name="stateValue" value="1"/>
                <label>审核通过</label>
                <input type="radio" name="stateValue" value="2"/>
                <label>审核未通过</label>
            </td>
        </tr>
    </table>
</form>
<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
<script type="text/javascript" src="../../js/jquery-1.5.1.min.js"></script>
<script>
    var dg;
    var stateRadio = document.getElementsByName("stateValue");
    $(document).ready(function(){
        dg = frameElement.lhgDG;
        dg.addBtn('ok','保存',function(){
            for(var i=0; i<stateRadio.length; i ++){
                if(stateRadio[i].checked){
                    document.getElementById("state").value=stateRadio[i].value;
                }
            }
            $("#makeRecommendationsForm").submit();
        });
    });
    var temp=0;
    function checkInfo(){
        for(var i=0; i<stateRadio.length; i ++){
            if (stateRadio[i].checked==true){
                temp++;
            }
        }
        if (temp!=1){
            alert("请选择审批结果!");
            document.getElementsByName("stateValue")[0].focus();
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
