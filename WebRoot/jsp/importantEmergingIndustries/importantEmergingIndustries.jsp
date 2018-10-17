<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/14
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Test</title>
    <script type="text/javascript" src="../../js/jquery-1.5.1.min.js"></script>
    <script type="text/javascript" src="../../js/datePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="../../js/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
    <link type="text/css" rel="stylesheet" href="../../css/main.css"/>
</head>
<body>
<form action="listPageImportantEmergingIndustries.html" method="post" id="ImportantEmergingIndustriesForm" name="ImportantEmergingIndustriesForm">
    <div style="margin-top: 10px"></div>
    <div class="search_div">
        <input type="hidden" name="type" id="type" value="${importantEmergingIndustries.type}">
        <span class="label">标题:</span>
        <input type="text" name="name" value="${importantEmergingIndustries.name}"/>
        <span class="label">发布标识:</span>
        <select name="reportMarks" id="reportMarks" style="vertical-align: middle;">
            <option value="2">请选择</option>
            <option value="0">未发布</option>
            <option value="1">已发布</option>
        </select>
        <span class="label">置顶:</span>
        <select name="placedTop" id="placedTop" style="vertical-align: middle;">
            <option value="2">请选择</option>
            <option value="0">未置顶</option>
            <option value="1">已置顶</option>
        </select>
        <a href="javascript:search();" class="myBtn"><em>查询</em></a>
    </div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table"  style="font-size: 12px;table-layout:fixed">
        <tr class="main_head">
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllImportantEmergingIndustries()"/></th>
            <th>序号</th>
            <th>标题</th>
            <th>简介</th>
            <th>发布时间</th>
            <th>创建时间</th>
            <th>修改时间</th>
            <th>排序</th>
            <th>发布标识</th>
            <th>置顶</th>
            <th>来源</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPageImportantEmergingIndustries}">
                <c:forEach items="${listPageImportantEmergingIndustries}" var="importantEmergingIndustries" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="importantEmergingIndustriesIds" id="importantEmergingIndustriesIds${importantEmergingIndustries.id }" value="${importantEmergingIndustries.id }"/></td>
                        <td>${vs.index+1}</td>
                        <td>${importantEmergingIndustries.name}</td>
                        <td>${importantEmergingIndustries.introduction}</td>
                        <td><fmt:formatDate value="${importantEmergingIndustries.reportDate}" pattern="yyyy-MM-dd"/></td>
                        <td><fmt:formatDate value="${importantEmergingIndustries.releaseTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><fmt:formatDate value="${importantEmergingIndustries.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${importantEmergingIndustries.sorting}</td>
                        <td><c:if test="${importantEmergingIndustries.reportMarks==0}">未发布</c:if><c:if test="${importantEmergingIndustries.reportMarks==1}">已发布</c:if></td>
                        <td><c:if test="${importantEmergingIndustries.placedTop==0}">未置顶</c:if><c:if test="${importantEmergingIndustries.placedTop==1}">已置顶</c:if></td>
                        <td>${importantEmergingIndustries.source}</td>
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
            <a href="javascript:insertImportantEmergingIndustries();" class="myBtn"><em>添加</em></a>
            <a href="javascript:deleteImportantEmergingIndustries();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updateImportantEmergingIndustries();" class="myBtn"><em>修改</em></a>
            <a href="javascript:updateImportantEmergingIndustriesPlacedTop();" class="myBtn"><em>置顶</em></a>
            <a href="javascript:updateImportantEmergingIndustriesCancelPlacedTop();" class="myBtn"><em>取消置顶</em></a>
            <a href="javascript:updateImportantEmergingIndustriesReportMarks();" class="myBtn"><em>发布</em></a>
            <a href="javascript:updateImportantEmergingIndustriesCancelReportMarks();" class="myBtn"><em>撤回发布</em></a>
        </div>
        ${importantEmergingIndustries.page.pageStr}
    </div>
</form>
<script>
    function search(){
        $("#ImportantEmergingIndustriesForm").submit();
    }

    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });
    function sltAllImportantEmergingIndustries(){
        if($("#sltAll").attr("checked")){
            $("input[name='importantEmergingIndustriesIds']").attr("checked",true);
        }else{
            $("input[name='importantEmergingIndustriesIds']").attr("checked",false);
        }
    }
    function deleteImportantEmergingIndustries(){
        var chk_value = [];//定义一个数组
        $("input[name='importantEmergingIndustriesIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要删除该记录？")){
                var url = "deleteImportantEmergingIndustries.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function updateImportantEmergingIndustriesCancelReportMarks() {
        var chk_value = [];//定义一个数组
        $("input[name='importantEmergingIndustriesIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要撤回该信息？")){
                var url = "updateImportantEmergingIndustriesCancelReportMarks.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function updateImportantEmergingIndustriesReportMarks() {
        var chk_value = [];//定义一个数组
        $("input[name='importantEmergingIndustriesIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要发布该信息？")){
                var url = "updateImportantEmergingIndustriesReportMarks.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function updateImportantEmergingIndustriesPlacedTop(){
        var chk_value = [];//定义一个数组
        $("input[name='importantEmergingIndustriesIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要将该记录置顶？")){
                var url = "updateImportantEmergingIndustriesPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }


    function updateImportantEmergingIndustriesCancelPlacedTop(){
        var chk_value = [];//定义一个数组
        $("input[name='importantEmergingIndustriesIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要将该记录取消置顶？")){
                var url = "updateImportantEmergingIndustriesCancelPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }


    function insertImportantEmergingIndustries(){
        var dg = new $.dialog({
            title:'添加',
            id:'importantEmergingIndustries_new',
            width:630,
            height:490,
            iconTitle:false,
            cover:true,
            maxBtn:false,
            xButton:true,
            resize:false,
            page:'insertImportantEmergingIndustries.html?type='+${importantEmergingIndustries.type}
        });
        dg.ShowDialog();
    }

    function updateImportantEmergingIndustries() {
        var chk_value = [];//定义一个数组
        $("input[name='importantEmergingIndustriesIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'importantEmergingIndustries_edit',
                width:630,
                height:490,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updateImportantEmergingIndustries.html?id='+id+'&type='+${importantEmergingIndustries.type}
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
