<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/13
  Time: 11:36
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
<form action="listPageExhibitionHallManagement.html" method="post" id="ExhibitionHallManagementForm" name="ExhibitionHallManagementForm">
    <div style="margin-top: 10px">（1）请为每个展厅上传一张预览图，必须为图片。（2）所上传图片的尺寸为233×170！（3）前台首页展示的是已发布已置顶的排序值最小的几条数据。（4）排序值越小，显示越靠前。</div>
    <div class="search_div">
        <span class="label">标题:</span>
        <input type="text" name="name" value="${exhibitionHallManagement.name}"/>
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
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllExhibitionHallManagement()"/></th>
            <th>序号</th>
            <th>标题</th>
            <th>简介</th>
            <th>发布人</th>
            <th>发布时间</th>
            <th>创建时间</th>
            <th>修改人</th>
            <th>修改时间</th>
            <th>排序</th>
            <th>置顶</th>
            <th>发布标识</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPageExhibitionHallManagement}">
                <c:forEach items="${listPageExhibitionHallManagement}" var="exhibitionHallManagement" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="exhibitionHallManagementIds" id="exhibitionHallManagementIds${exhibitionHallManagement.id }" value="${exhibitionHallManagement.id }"/></td>
                        <td>${vs.index+1}</td>
                        <td>${exhibitionHallManagement.name}</td>
                        <td>${exhibitionHallManagement.introduction}</td>
                        <td>${exhibitionHallManagement.reportPeople}</td>
                        <td><fmt:formatDate value="${exhibitionHallManagement.reportDate}" pattern="yyyy-MM-dd"/></td>
                        <td><fmt:formatDate value="${exhibitionHallManagement.releaseTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${exhibitionHallManagement.modifier}</td>
                        <td><fmt:formatDate value="${exhibitionHallManagement.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${exhibitionHallManagement.sorting}</td>
                        <td><c:if test="${exhibitionHallManagement.placedTop==0}">未置顶</c:if><c:if test="${exhibitionHallManagement.placedTop==1}">已置顶</c:if></td>
                        <td><c:if test="${exhibitionHallManagement.reportMarks==0}">未发布</c:if><c:if test="${exhibitionHallManagement.reportMarks==1}">已发布</c:if></td>
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
            <a href="javascript:insertExhibitionHallManagement();" class="myBtn"><em>发布</em></a>
            <a href="javascript:updateExhibitionHallManagementCancelReportMarks();" class="myBtn"><em>撤回发布</em></a>
            <a href="javascript:deleteExhibitionHallManagement();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updateExhibitionHallManagement();" class="myBtn"><em>修改</em></a>
            <a href="javascript:updateExhibitionHallManagementPlacedTop();" class="myBtn"><em>置顶</em></a>
            <a href="javascript:updateExhibitionHallManagementCancelPlacedTop();" class="myBtn"><em>取消置顶</em></a>
        </div>
        ${exhibitionHallManagement.page.pageStr}
    </div>
</form>
<script>
    function search(){
        $("#ExhibitionHallManagementForm").submit();
    }

    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });
    function sltAllExhibitionHallManagement(){
        if($("#sltAll").attr("checked")){
            $("input[name='exhibitionHallManagementIds']").attr("checked",true);
        }else{
            $("input[name='exhibitionHallManagementIds']").attr("checked",false);
        }
    }
    function deleteExhibitionHallManagement(){
        var chk_value = [];//定义一个数组
        $("input[name='exhibitionHallManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要删除该记录？")){
                var url = "deleteExhibitionHallManagement.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function updateExhibitionHallManagementCancelReportMarks() {
        var chk_value = [];//定义一个数组
        $("input[name='exhibitionHallManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要撤回该信息？")){
                var url = "updateExhibitionHallManagementCancelReportMarks.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }



    function updateExhibitionHallManagementPlacedTop(){
        var chk_value = [];//定义一个数组
        $("input[name='exhibitionHallManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要将该记录置顶？")){
                var url = "updateExhibitionHallManagementPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }


    function updateExhibitionHallManagementCancelPlacedTop(){
        var chk_value = [];//定义一个数组
        $("input[name='exhibitionHallManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要将该记录取消置顶？")){
                var url = "updateExhibitionHallManagementCancelPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }


    function insertExhibitionHallManagement(){
        var dg = new $.dialog({
            title:'添加',
            id:'exhibitionHallManagement_new',
            width:630,
            height:490,
            iconTitle:false,
            cover:true,
            maxBtn:false,
            xButton:true,
            resize:false,
            page:'insertExhibitionHallManagement.html'
        });
        dg.ShowDialog();
    }

    function updateExhibitionHallManagement() {
        var chk_value = [];//定义一个数组
        $("input[name='exhibitionHallManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'exhibitionHallManagement_edit',
                width:630,
                height:490,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updateExhibitionHallManagement.html?id='+id
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
