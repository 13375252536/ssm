<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/8/30
  Time: 15:38
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
<form action="listPageEntrepreneurshipGroupMaintenance.html" method="post" id="entrepreneurshipGroupMaintenanceForm" name="entrepreneurshipGroupMaintenanceForm">
    <div style="margin-top: 10px">（1）所上传的文件全部为预览图，必须为图片。（2）所上传图片的尺寸为60×60！（3）前台首页展示的是已置顶的排序值最小的几条数据。（4）排序值越小，显示越靠前。</div>
    <div class="search_div">
        <span class="label">创业群体名称：</span>
        <input type="text" name="name" value="${entrepreneurshipGroupMaintenance.name}"/>
        <a href="javascript:search();" class="myBtn"><em>查询</em></a>
    </div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table"  style="font-size: 12px;table-layout:fixed">
        <tr class="main_head">
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllEntrepreneurshipGroupMaintenance()"/></th>
            <th>序号</th>
            <th>创业群体名称</th>
            <th>添加人</th>
            <th>添加时间</th>
            <th>修改人</th>
            <th>修改时间</th>
            <th>排序</th>
            <th>置顶</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPageEntrepreneurshipGroupMaintenance}">
                <c:forEach items="${listPageEntrepreneurshipGroupMaintenance}" var="entrepreneurshipGroupMaintenance" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="entrepreneurshipGroupMaintenanceIds" id="entrepreneurshipGroupMaintenanceIds${entrepreneurshipGroupMaintenance.id}" value="${entrepreneurshipGroupMaintenance.id}"/></td>
                        <td>${vs.index+1}</td>
                        <td>${entrepreneurshipGroupMaintenance.name}</td>
                        <td>${entrepreneurshipGroupMaintenance.releasePeople}</td>
                        <td><fmt:formatDate value="${entrepreneurshipGroupMaintenance.releaseTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${entrepreneurshipGroupMaintenance.modifier}</td>
                        <td><fmt:formatDate value="${entrepreneurshipGroupMaintenance.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${entrepreneurshipGroupMaintenance.sorting}</td>
                        <td><c:if test="${entrepreneurshipGroupMaintenance.placedTop=='0'}">未置顶</c:if><c:if test="${entrepreneurshipGroupMaintenance.placedTop=='1'}">已置顶</c:if></td>
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
            <a href="javascript:insertEntrepreneurshipGroupMaintenance();" class="myBtn"><em>新增</em></a>
            <a href="javascript:deleteEntrepreneurshipGroupMaintenance();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updateEntrepreneurshipGroupMaintenance();" class="myBtn"><em>修改</em></a>
            <a href="javascript:placedTopEntrepreneurshipGroupMaintenance();" class="myBtn"><em>置顶</em></a>
            <a href="javascript:cancelTopEntrepreneurshipGroupMaintenance();" class="myBtn"><em>取消置顶</em></a>
        </div>
        ${entrepreneurshipGroupMaintenance.page.pageStr}
    </div>
</form>

<script>
    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });
    function search(){
        $("#entrepreneurshipGroupMaintenanceForm").submit();
    }
    function sltAllEntrepreneurshipGroupMaintenance(){
        if($("#sltAll").attr("checked")){
            $("input[name='entrepreneurshipGroupMaintenanceIds']").attr("checked",true);
        }else{
            $("input[name='entrepreneurshipGroupMaintenanceIds']").attr("checked",false);
        }
    }
    function deleteEntrepreneurshipGroupMaintenance(){
        var chk_value = [];//定义一个数组
        $("input[name='entrepreneurshipGroupMaintenanceIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要删除该记录？")){
                var url = "deleteEntrepreneurshipGroupMaintenance.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function placedTopEntrepreneurshipGroupMaintenance(){
        var chk_value = [];//定义一个数组
        $("input[name='entrepreneurshipGroupMaintenanceIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要置顶该记录？")){
                var url = "updateEntrepreneurshipGroupMaintenancePlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function cancelTopEntrepreneurshipGroupMaintenance(){
        var chk_value = [];//定义一个数组
        $("input[name='entrepreneurshipGroupMaintenanceIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要取消该记录的置顶？")){
                var url = "updateEntrepreneurshipGroupMaintenanceCancelPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function insertEntrepreneurshipGroupMaintenance() {
        var dg = new $.dialog({
            title:'新增',
            id:'entrepreneurshipGroupMaintenance_new',
            width:360,
            height:390,
            iconTitle:false,
            cover:true,
            maxBtn:false,
            xButton:true,
            resize:false,
            page:'insertEntrepreneurshipGroupMaintenance.html'
        });
        dg.ShowDialog();
    }

    function updateEntrepreneurshipGroupMaintenance() {
        var chk_value = [];//定义一个数组
        $("input[name='entrepreneurshipGroupMaintenanceIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'entrepreneurshipGroupMaintenance_edit',
                width:360,
                height:490,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updateEntrepreneurshipGroupMaintenance.html?id='+id
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
