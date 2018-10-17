<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/10
  Time: 13:14
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
        .info th{text-align: right;width:90px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
        .info td{text-align:left;}
    </style>
</head>
<body>
<form action="savePolicyClassificationMaintenance.html" name="policyClassificationMaintenanceForm" id="policyClassificationMaintenanceForm" target="result" method="post" onsubmit="return checkInfo();"  enctype="multipart/form-data">
    <input type="hidden" name="id" id="id" value="${policyClassificationMaintenance.id}"/>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr class="info">
            <th><span class="star" style="color:#f82e2a">*</span>政策分类名称:</th>
            <td><input type="text" name="name" id="name" class="input_txt" value="${policyClassificationMaintenance.name}"/></td>
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
            $("#policyClassificationMaintenanceForm").submit();
        });
    });
    function checkInfo(){
        if($("#name").val()==""){
            alert("请输入政策分类名称!");
            $("#name").focus();
            return false;
        }
        if ($("#name").val().length>64){
            alert("政策分类名称不得长于64个字符");
            $("#name").focus();
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
    function failed(){
        alert("该政策分类名称已存在！");
        $("#name").select();
        $("#name").focus();
    }
</script>

</body>
</html>
