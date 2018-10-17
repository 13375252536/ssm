<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/6
  Time: 10:05
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
<form action="listPagePositionManagement.html" method="post" id="PositionManagementForm" name="PositionManagementForm">
    <div style="margin-top: 10px">广告位图片的大小为1000*80，请上传符合条件的图片，否则将无法显示！如果链接是其他网站请以http://开头！</div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table"  style="font-size: 12px;table-layout:fixed">
        <tr class="main_head">
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllPositionManagement()"/></th>
            <th>序号</th>
            <th>名称</th>
            <th>链接</th>
            <th>路径</th>
            <th>插入用户</th>
            <th>插入时间</th>
            <th>更新用户</th>
            <th>更新时间</th>
            <th>排序</th>
            <th>置顶</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPagePositionManagement}">
                <c:forEach items="${listPagePositionManagement}" var="positionManagement" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="positionManagementIds" id="positionManagementIds${positionManagement.id }" value="${positionManagement.id }"/></td>
                        <td>${vs.index+1}</td>
                        <td>${positionManagement.name}</td>
                        <td>${positionManagement.link}</td>
                        <td>${positionManagement.fileURL}</td>
                        <td>${positionManagement.releasePeople}</td>
                        <td><fmt:formatDate value="${positionManagement.releaseTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${positionManagement.modifier}</td>
                        <td><fmt:formatDate value="${positionManagement.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${positionManagement.sorting}</td>
                        <td><c:if test="${positionManagement.placedTop==0}">未置顶</c:if><c:if test="${positionManagement.placedTop==1}">已置顶</c:if></td>
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
            <a href="javascript:insertPositionManagement();" class="myBtn"><em>新增</em></a>
            <a href="javascript:deletePositionManagement();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updatePositionManagement();" class="myBtn"><em>修改</em></a>
            <a href="javascript:updatePositionManagementPlacedTop();" class="myBtn"><em>置顶</em></a>
            <a href="javascript:updatePositionManagementCancelPlacedTop();" class="myBtn"><em>取消置顶</em></a>
        </div>
        ${positionManagement.page.pageStr}
    </div>
</form>
<script>
    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });
    function sltAllPositionManagement(){
        if($("#sltAll").attr("checked")){
            $("input[name='positionManagementIds']").attr("checked",true);
        }else{
            $("input[name='positionManagementIds']").attr("checked",false);
        }
    }
    function deletePositionManagement(){
        var chk_value = [];//定义一个数组
        $("input[name='positionManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要删除该记录？")){
                var url = "deletePositionManagement.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }
    function updatePositionManagementPlacedTop() {
        var chk_value = [];//定义一个数组
        $("input[name='positionManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要置顶该记录？")){
                var url = "updatePositionManagementPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function updatePositionManagementCancelPlacedTop() {
        var chk_value = [];//定义一个数组
        $("input[name='positionManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要取消该记录的置顶？")){
                var url = "updatePositionManagementCancelPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }
    function insertPositionManagement(){
        var dg = new $.dialog({
            title:'添加',
            id:'positionManagement_new',
            width:360,
            height:270,
            iconTitle:false,
            cover:true,
            maxBtn:false,
            xButton:true,
            resize:false,
            page:'insertPositionManagement.html'
        });
        dg.ShowDialog();
    }

    function updatePositionManagement() {
        var chk_value = [];//定义一个数组
        $("input[name='positionManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'positionManagement_edit',
                width:360,
                height:350,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updatePositionManagement.html?id='+id
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
