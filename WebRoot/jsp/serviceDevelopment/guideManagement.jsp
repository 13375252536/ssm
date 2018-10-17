<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/25
  Time: 9:49
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
<form action="listPageGuideManagement.html" method="post" id="GuideManagementForm" name="GuideManagementForm">
    <div style="margin-top: 10px">双创动态管理：插入数据时上传图片，系统会自动截取第一张图片作为缩略图。缩略图大小为：500*290,200*90;如果没有图片的话请不要置顶展示在首页，否则会影响首页排版！
        搜索完成之后请记得清空搜索框内容</div>
    <div class="search_div">
        <span class="label">标题:</span>
        <input type="text" name="name" value="${guideManagement.name}"/>
        <a href="javascript:search();" class="myBtn"><em>查询</em></a>
    </div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table"  style="font-size: 12px;table-layout:fixed">
        <tr class="main_head">
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllGuideManagement()"/></th>
            <th>序号</th>
            <th>标题</th>
            <th>简介</th>
            <th>来源</th>
            <th>分类</th>
            <th>发布时间</th>
            <th>创建时间</th>
            <th>创建人</th>
            <th>更新人</th>
            <th>更新时间</th>
            <th>发布标识</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPageGuideManagement}">
                <c:forEach items="${listPageGuideManagement}" var="guideManagement" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="guideManagementIds" id="guideManagementIds${guideManagement.id }" value="${guideManagement.id }"/></td>
                        <td>${vs.index+1}</td>
                        <td>${guideManagement.name}</td>
                        <td>${guideManagement.introduction}</td>
                        <td>${guideManagement.source}</td>
                        <td><c:if test="${guideManagement.type==1}">创业者服务</c:if><c:if test="${guideManagement.type==2}">孵化器及众创空间服务</c:if></td>
                        <td><fmt:formatDate value="${guideManagement.reportDate}" pattern="yyyy-MM-dd"/></td>
                        <td><fmt:formatDate value="${guideManagement.releaseTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${guideManagement.releasePeople}</td>
                        <td>${guideManagement.modifier}</td>
                        <td><fmt:formatDate value="${guideManagement.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><c:if test="${guideManagement.reportMarks==0}">未发布</c:if><c:if test="${guideManagement.reportMarks==1}">已发布</c:if></td>
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
            <a href="javascript:insertGuideManagement();" class="myBtn"><em>添加</em></a>
            <a href="javascript:deleteGuideManagement();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updateGuideManagement();" class="myBtn"><em>修改</em></a>
            <a href="javascript:updateGuideManagementReportMarks();" class="myBtn"><em>发布</em></a>
            <a href="javascript:updateGuideManagementCancelReportMarks();" class="myBtn"><em>撤回</em></a>
        </div>
        ${guideManagement.page.pageStr}
    </div>
</form>
<script>
    function search(){
        $("#GuideManagementForm").submit();
    }

    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });
    function sltAllGuideManagement(){
        if($("#sltAll").attr("checked")){
            $("input[name='guideManagementIds']").attr("checked",true);
        }else{
            $("input[name='guideManagementIds']").attr("checked",false);
        }
    }
    function deleteGuideManagement(){
        var chk_value = [];//定义一个数组
        $("input[name='guideManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要删除该记录？")){
                var url = "deleteGuideManagement.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }


    function updateGuideManagementReportMarks() {
        var chk_value = [];//定义一个数组
        $("input[name='guideManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要发布该记录？")){
                var url = "updateGuideManagementReportMarks.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function updateGuideManagementCancelReportMarks() {
        var chk_value = [];//定义一个数组
        $("input[name='guideManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要撤回该记录？")){
                var url = "updateGuideManagementCancelReportMarks.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function insertGuideManagement(){
        var dg = new $.dialog({
            title:'添加',
            id:'guideManagement_new',
            width:630,
            height:490,
            iconTitle:false,
            cover:true,
            maxBtn:false,
            xButton:true,
            resize:false,
            page:'insertGuideManagement.html'
        });
        dg.ShowDialog();
    }

    function updateGuideManagement() {
        var chk_value = [];//定义一个数组
        $("input[name='guideManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'guideManagement_edit',
                width:630,
                height:490,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updateGuideManagement.html?id='+id
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
