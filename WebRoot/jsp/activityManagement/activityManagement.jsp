<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/11
  Time: 13:52
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
<form action="listPageActivityManagement.html" method="post" id="ActivityManagementForm" name="ActivityManagementForm">
    <div style="margin-top: 10px">（1）请为每个活动上传一张预览图，必须为图片。（2）所上传图片的尺寸为292×163！（3）前台首页展示的是已发布已置顶的排序值最小的几条数据。（4）排序值越小，显示越靠前。</div>
    <div class="search_div">
        <span class="label">活动标题:</span>
        <input type="text" name="name" value="${activityManagement.name}"/>
        <span class="label">活动种类:</span>
        <select name="type" id="type" style="vertical-align: middle;">
            <option value="0">请选择</option>
            <option>主会场活动</option>
            <option>分会场活动</option>
            <option>部委活动</option>
            <option>创响中国</option>
        </select>
        <span class="label">所属区域:</span>
        <select name="area" id="area" style="vertical-align: middle;">
            <option value="0">请选择</option>
           <c:forEach items="${selectAreaInfo}" var="area">
            <option value="${area.id}">${area.name}</option>
           </c:forEach>
        </select>
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
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllActivityManagement()"/></th>
            <th>序号</th>
            <th>活动标题</th>
            <th>活动种类</th>
            <th>所属区域</th>
            <th>活动简介</th>
            <th>发布单位</th>
            <th>发布人</th>
            <th>发布时间</th>
            <th>来源</th>
            <th>创建时间</th>
            <th>修改人</th>
            <th>修改时间</th>
            <th>排序</th>
            <th>置顶</th>
            <th>发布标识</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPageActivityManagement}">
                <c:forEach items="${listPageActivityManagement}" var="activityManagement" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="activityManagementIds" id="activityManagementIds${activityManagement.id }" value="${activityManagement.id }"/></td>
                        <td>${vs.index+1}</td>
                        <td>${activityManagement.name}</td>
                        <td>${activityManagement.type}</td>
                        <td>${activityManagement.areaName}</td>
                        <td>${activityManagement.introduction}</td>
                        <td>${activityManagement.reportUnitName}</td>
                        <td>${activityManagement.reportPeople}</td>
                        <td><fmt:formatDate value="${activityManagement.reportDate}" pattern="yyyy-MM-dd"/></td>
                        <td>${activityManagement.source}</td>
                       <td><fmt:formatDate value="${activityManagement.releaseTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${activityManagement.modifier}</td>
                        <td><fmt:formatDate value="${activityManagement.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${activityManagement.sorting}</td>
                        <td><c:if test="${activityManagement.placedTop==0}">未置顶</c:if><c:if test="${activityManagement.placedTop==1}">已置顶</c:if></td>
                        <td><c:if test="${activityManagement.reportMarks==0}">未发布</c:if><c:if test="${activityManagement.reportMarks==1}">已发布</c:if></td>
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
            <a href="javascript:insertActivityManagement();" class="myBtn"><em>发布</em></a>
            <a href="javascript:updateActivityManagementCancelReportMarks();" class="myBtn"><em>撤回发布</em></a>
            <a href="javascript:deleteActivityManagement();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updateActivityManagement();" class="myBtn"><em>修改</em></a>
            <a href="javascript:updateActivityManagementPlacedTop();" class="myBtn"><em>置顶</em></a>
            <a href="javascript:updateActivityManagementCancelPlacedTop();" class="myBtn"><em>取消置顶</em></a>
        </div>
        ${activityManagement.page.pageStr}
    </div>
</form>
<script>
    function search(){
        $("#ActivityManagementForm").submit();
    }

    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });
    function sltAllActivityManagement(){
        if($("#sltAll").attr("checked")){
            $("input[name='activityManagementIds']").attr("checked",true);
        }else{
            $("input[name='activityManagementIds']").attr("checked",false);
        }
    }
    function deleteActivityManagement(){
        var chk_value = [];//定义一个数组
        $("input[name='activityManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要删除该记录？")){
                var url = "deleteActivityManagement.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function updateActivityManagementCancelReportMarks() {
        var chk_value = [];//定义一个数组
        $("input[name='activityManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要撤回该信息？")){
                var url = "updateActivityManagementCancelReportMarks.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }



    function updateActivityManagementPlacedTop(){
        var chk_value = [];//定义一个数组
        $("input[name='activityManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要将该记录置顶？")){
                var url = "updateActivityManagementPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }


    function updateActivityManagementCancelPlacedTop(){
        var chk_value = [];//定义一个数组
        $("input[name='activityManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要将该记录取消置顶？")){
                var url = "updateActivityManagementCancelPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }


    function insertActivityManagement(){
        var dg = new $.dialog({
            title:'添加',
            id:'activityManagement_new',
            width:630,
            height:490,
            iconTitle:false,
            cover:true,
            maxBtn:false,
            xButton:true,
            resize:false,
            page:'insertActivityManagement.html'
        });
        dg.ShowDialog();
    }

    function updateActivityManagement() {
        var chk_value = [];//定义一个数组
        $("input[name='activityManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'activityManagement_edit',
                width:630,
                height:490,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updateActivityManagement.html?id='+id
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
