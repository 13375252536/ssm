<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/5
  Time: 10:07
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
<form action="listPageTechnicalAdvisoryManagement.html" method="post" id="TechnicalAdvisoryManagementForm" name="TechnicalAdvisoryManagementForm">
    <div style="margin-top: 10px">服务资讯不展示图片，只展示标题，不需要上传图片</div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table"  style="font-size: 12px;table-layout:fixed">
        <tr class="main_head">
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllTechnicalAdvisoryManagement()"/></th>
            <th>序号</th>
            <th>名称</th>
            <th>链接</th>
            <th>排序</th>
            <th>类别</th>
            <th>置顶</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPageTechnicalAdvisoryManagement}">
                <c:forEach items="${listPageTechnicalAdvisoryManagement}" var="technicalAdvisoryManagement" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="technicalAdvisoryManagementIds" id="technicalAdvisoryManagementIds${technicalAdvisoryManagement.id }" value="${technicalAdvisoryManagement.id }"/></td>
                        <td>${vs.index+1}</td>
                        <td>${technicalAdvisoryManagement.name}</td>
                        <td>${technicalAdvisoryManagement.link}</td>
                        <td>${technicalAdvisoryManagement.sorting}</td>
                        <td>${technicalAdvisoryManagement.type}</td>
                        <td><c:if test="${technicalAdvisoryManagement.placedTop==0}">未置顶</c:if><c:if test="${technicalAdvisoryManagement.placedTop==1}">已置顶</c:if></td>
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
            <a href="javascript:insertTechnicalAdvisoryManagement();" class="myBtn"><em>新增</em></a>
            <a href="javascript:deleteTechnicalAdvisoryManagement();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updateTechnicalAdvisoryManagement();" class="myBtn"><em>修改</em></a>
            <a href="javascript:updateTechnicalAdvisoryManagementPlacedTop();" class="myBtn"><em>置顶</em></a>
            <a href="javascript:updateTechnicalAdvisoryManagementCancelPlacedTop();" class="myBtn"><em>取消置顶</em></a>
        </div>
        ${technicalAdvisoryManagement.page.pageStr}
    </div>
</form>
<script>
    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });
    function sltAllTechnicalAdvisoryManagement(){
        if($("#sltAll").attr("checked")){
            $("input[name='technicalAdvisoryManagementIds']").attr("checked",true);
        }else{
            $("input[name='technicalAdvisoryManagementIds']").attr("checked",false);
        }
    }
    function deleteTechnicalAdvisoryManagement(){
        var chk_value = [];//定义一个数组
        $("input[name='technicalAdvisoryManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要删除该记录？")){
                var url = "deleteTechnicalAdvisoryManagement.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }
    function updateTechnicalAdvisoryManagementPlacedTop() {
        var chk_value = [];//定义一个数组
        $("input[name='technicalAdvisoryManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要置顶该记录？")){
                var url = "updateTechnicalAdvisoryManagementPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function updateTechnicalAdvisoryManagementCancelPlacedTop() {
        var chk_value = [];//定义一个数组
        $("input[name='technicalAdvisoryManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要取消该记录的置顶？")){
                var url = "updateTechnicalAdvisoryManagementCancelPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }
    function insertTechnicalAdvisoryManagement(){
        var dg = new $.dialog({
            title:'添加',
            id:'technicalAdvisoryManagement_new',
            width:360,
            height:270,
            iconTitle:false,
            cover:true,
            maxBtn:false,
            xButton:true,
            resize:false,
            page:'insertTechnicalAdvisoryManagement.html'
        });
        dg.ShowDialog();
    }

    function updateTechnicalAdvisoryManagement() {
        var chk_value = [];//定义一个数组
        $("input[name='technicalAdvisoryManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'technicalAdvisoryManagement_edit',
                width:360,
                height:350,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updateTechnicalAdvisoryManagement.html?id='+id
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
