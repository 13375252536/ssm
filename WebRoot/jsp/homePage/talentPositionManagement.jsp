<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/4
  Time: 16:02
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
<form action="listPageTalentPositionManagement.html" method="post" id="TalentPositionManagementForm" name="TalentPositionManagementForm">
    <div style="margin-top: 10px"></div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table"  style="font-size: 12px;table-layout:fixed">
        <tr class="main_head">
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllTalentPositionManagement()"/></th>
            <th>序号</th>
            <th>名称</th>
            <th>链接</th>
            <th>路径</th>
            <th>排序</th>
            <th>类别</th>
            <th>置顶</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPageTalentPositionManagement}">
                <c:forEach items="${listPageTalentPositionManagement}" var="talentPositionManagement" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="talentPositionManagementIds" id="talentPositionManagementIds${talentPositionManagement.id }" value="${talentPositionManagement.id }"/></td>
                        <td>${vs.index+1}</td>
                        <td>${talentPositionManagement.name}</td>
                        <td>${talentPositionManagement.link}</td>
                        <td>${talentPositionManagement.fileURL}</td>
                        <td>${talentPositionManagement.sorting}</td>
                        <td>${talentPositionManagement.type}</td>
                        <td><c:if test="${talentPositionManagement.placedTop==0}">未置顶</c:if><c:if test="${talentPositionManagement.placedTop==1}">已置顶</c:if></td>
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
            <a href="javascript:insertTalentPositionManagement();" class="myBtn"><em>新增</em></a>
            <a href="javascript:deleteTalentPositionManagement();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updateTalentPositionManagement();" class="myBtn"><em>修改</em></a>
            <a href="javascript:updateTalentPositionManagementPlacedTop();" class="myBtn"><em>置顶</em></a>
            <a href="javascript:updateTalentPositionManagementCancelPlacedTop();" class="myBtn"><em>取消置顶</em></a>
        </div>
        ${talentPositionManagement.page.pageStr}
    </div>
</form>
<script>
    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });
    function sltAllTalentPositionManagement(){
        if($("#sltAll").attr("checked")){
            $("input[name='talentPositionManagementIds']").attr("checked",true);
        }else{
            $("input[name='talentPositionManagementIds']").attr("checked",false);
        }
    }
    function deleteTalentPositionManagement(){
        var chk_value = [];//定义一个数组
        $("input[name='talentPositionManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要删除该记录？")){
                var url = "deleteTalentPositionManagement.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }
    function updateTalentPositionManagementPlacedTop() {
        var chk_value = [];//定义一个数组
        $("input[name='talentPositionManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要置顶该记录？")){
                var url = "updateTalentPositionManagementPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function updateTalentPositionManagementCancelPlacedTop() {
        var chk_value = [];//定义一个数组
        $("input[name='talentPositionManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要取消该记录的置顶？")){
                var url = "updateTalentPositionManagementCancelPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }
    function insertTalentPositionManagement(){
        var dg = new $.dialog({
            title:'添加',
            id:'talentPositionManagement_new',
            width:360,
            height:270,
            iconTitle:false,
            cover:true,
            maxBtn:false,
            xButton:true,
            resize:false,
            page:'insertTalentPositionManagement.html'
        });
        dg.ShowDialog();
    }

    function updateTalentPositionManagement() {
        var chk_value = [];//定义一个数组
        $("input[name='talentPositionManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'talentPositionManagement_edit',
                width:360,
                height:350,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updateTalentPositionManagement.html?id='+id
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
