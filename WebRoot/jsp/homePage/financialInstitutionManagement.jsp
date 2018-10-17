<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/4
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Test</title>
    <script type="text/javascript" src="../../js/jquery-1.5.1.min.js"></script>
    <script type="text/javascript" src="../../js/datePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="../../js/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
    <link type="text/css" rel="stylesheet" href="../../css/main.css"/>
</head>
<body>
<form action="listPageFinancialInstitutionManagement.html" method="post" id="FinancialInstitutionManagementForm" name="FinancialInstitutionManagementForm">
    <div style="margin-top: 10px">金融机构：前台需要上传图片来展示</div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table"  style="font-size: 12px;table-layout:fixed">
        <tr class="main_head">
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllFinancialInstitutionManagement()"/></th>
            <th>序号</th>
            <th>名称</th>
            <th>链接</th>
            <th>路径</th>
            <th>排序</th>
            <th>类别</th>
            <th>置顶</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPageFinancialInstitutionManagement}">
                <c:forEach items="${listPageFinancialInstitutionManagement}" var="financialInstitutionManagement" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="financialInstitutionManagementIds" id="financialInstitutionManagementIds${financialInstitutionManagement.id }" value="${financialInstitutionManagement.id }"/></td>
                        <td>${vs.index+1}</td>
                        <td>${financialInstitutionManagement.name}</td>
                        <td>${financialInstitutionManagement.link}</td>
                        <td>${financialInstitutionManagement.fileURL}</td>
                        <td>${financialInstitutionManagement.sorting}</td>
                        <td>${financialInstitutionManagement.type}</td>
                        <td><c:if test="${financialInstitutionManagement.placedTop==0}">未置顶</c:if><c:if test="${financialInstitutionManagement.placedTop==1}">已置顶</c:if></td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr class="main_info">
                    <td colspan="10">没有相关数据</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>
    <div class="page_and_btn">
        <div>
            <a href="javascript:insertFinancialInstitutionManagement();" class="myBtn"><em>新增</em></a>
            <a href="javascript:deleteFinancialInstitutionManagement();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updateFinancialInstitutionManagement();" class="myBtn"><em>修改</em></a>
            <a href="javascript:updateFinancialInstitutionManagementPlacedTop();" class="myBtn"><em>置顶</em></a>
            <a href="javascript:updateFinancialInstitutionManagementCancelPlacedTop();" class="myBtn"><em>取消置顶</em></a>
        </div>
        ${financialInstitutionManagement.page.pageStr}
    </div>
</form>
<script>
    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });
    function sltAllFinancialInstitutionManagement(){
        if($("#sltAll").attr("checked")){
            $("input[name='financialInstitutionManagementIds']").attr("checked",true);
        }else{
            $("input[name='financialInstitutionManagementIds']").attr("checked",false);
        }
    }
    function deleteFinancialInstitutionManagement(){
        var chk_value = [];//定义一个数组
        $("input[name='financialInstitutionManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要删除该记录？")){
                var url = "deleteFinancialInstitutionManagement.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }
    function updateFinancialInstitutionManagementPlacedTop() {
        var chk_value = [];//定义一个数组
        $("input[name='financialInstitutionManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要置顶该记录？")){
                var url = "updateFinancialInstitutionManagementPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function updateFinancialInstitutionManagementCancelPlacedTop() {
        var chk_value = [];//定义一个数组
        $("input[name='financialInstitutionManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要取消该记录的置顶？")){
                var url = "updateFinancialInstitutionManagementCancelPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }
    function insertFinancialInstitutionManagement(){
        var dg = new $.dialog({
            title:'添加',
            id:'financialInstitutionManagement_new',
            width:360,
            height:270,
            iconTitle:false,
            cover:true,
            maxBtn:false,
            xButton:true,
            resize:false,
            page:'insertFinancialInstitutionManagement.html'
        });
        dg.ShowDialog();
    }

    function updateFinancialInstitutionManagement() {
        var chk_value = [];//定义一个数组
        $("input[name='financialInstitutionManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'financialInstitutionManagement_edit',
                width:360,
                height:360,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updateFinancialInstitutionManagement.html?id='+id
            });
            dg.ShowDialog();
        }else {
            alert("请选择一条记录!")
        }
    }

    $('.main_info td').css({"white-space": "nowrap","text-overflow": "ellipsis","overflow": "hidden"});
</script>
</body>
</html>
