<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/7
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
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
<form action="listPageDynamicManagement.html" method="post" id="dynamicManagementForm" name="dynamicManagementForm">
    <div style="margin-top: 10px">双创动态管理：插入数据时上传图片，系统会自动截取第一张图片作为缩略图。缩略图大小为：500*290,200*90;如果没有图片的话请不要置顶展示在首页，否则会影响首页排版！
        搜索完成之后请记得清空搜索框内容!</div>
    <div class="search_div">
        <span class="label">标题：</span>
        <input type="text" name="name" value="${dynamicManagement.name}"/>
        <span class="label">发布标识：</span>
        <select name="releaseMarks" id="releaseMarks" style="vertical-align: middle;">
            <option value="2">请选择</option>
            <option value="0">未发布</option>
            <option value="1">已发布</option>
        </select>
        <span class="label">是否置顶：</span>
        <select name="placedTop" id="placedTop" style="vertical-align: middle;">
            <option value="2">请选择</option>
            <option value="0">未置顶</option>
            <option value="1">已置顶</option>
        </select>
        <span class="label">创建时间：</span>
        <input type="text" name="lastLoginStart" value="<fmt:formatDate value="${dynamicManagement.releaseTimeStart}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker()" readonly="readonly" style="width:75px;"/> -
        <input type="text" name="lastLoginEnd" value="<fmt:formatDate value="${dynamicManagement.releaseTimeEnd}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker()" readonly="readonly" style="width:75px;"/>
        <a href="javascript:search();" class="myBtn"><em>查询</em></a>
    </div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table"  style="font-size: 12px;table-layout:fixed">
        <tr class="main_head">
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllDynamicManagement()"/></th>
            <th>序号</th>
            <th>标题</th>
            <th>简介</th>
            <th>发布单位</th>
            <th>发布时间</th>
            <th>创建时间</th>
            <th>排序</th>
            <th>发布标识</th>
            <th>置顶</th>
            <th>领导标记</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPageDynamicManagement}">
                <c:forEach items="${listPageDynamicManagement}" var="dynamicManagement" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="dynamicManagementIds" id="dynamicManagementIds${dynamicManagement.id}" value="${dynamicManagement.id}"/></td>
                        <td>${vs.index+1}</td>
                        <td>${dynamicManagement.name}</td>
                        <td>${dynamicManagement.introduction}</td>
                        <td>${dynamicManagement.releaseUnitName}</td>
                        <td><fmt:formatDate value="${dynamicManagement.reportDate}" pattern="yyyy-MM-dd"/></td>
                        <td><fmt:formatDate value="${dynamicManagement.releaseTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${dynamicManagement.sorting}</td>
                        <td><c:if test="${dynamicManagement.releaseMarks=='0'}">未发布</c:if><c:if test="${dynamicManagement.releaseMarks=='1'}">已发布</c:if></td>
                        <td><c:if test="${dynamicManagement.placedTop=='0'}">未置顶</c:if><c:if test="${dynamicManagement.placedTop=='1'}">已置顶</c:if></td>
                        <td>${dynamicManagement.leadershipTag}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr class="main_info">
                    <td colspan="13">没有相关数据</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>

    <div class="page_and_btn">
        <div>
            <a href="javascript:insertDynamicManagement();" class="myBtn"><em>新增</em></a>
            <a href="javascript:deleteDynamicManagement();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updateDynamicManagement();" class="myBtn"><em>修改</em></a>
            <a href="javascript:updateDynamicManagementPlacedTop();" class="myBtn"><em>置顶</em></a>
            <a href="javascript:updateDynamicManagementCancelPlacedTop();" class="myBtn"><em>取消置顶</em></a>
            <a href="javascript:updateDynamicManagementReleaseMarks();" class="myBtn"><em>发布</em></a>
            <a href="javascript:updateDynamicManagementCancelReleaseMarks();" class="myBtn"><em>撤销发布</em></a>
        </div>
        ${dynamicManagement.page.pageStr}
    </div>
</form>


<script>
    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });

    function sltAllDynamicManagement(){
        if($("#sltAll").attr("checked")){
            $("input[name='dynamicManagementIds']").attr("checked",true);
        }else{
            $("input[name='dynamicManagementIds']").attr("checked",false);
        }
    }

    function search(){
        $("#dynamicManagementForm").submit();
    }

    function insertDynamicManagement() {
        var dg = new $.dialog({
            title:'添加',
            id:'dynamicManagement_new',
            width:630,
            height:490,
            iconTitle:false,
            cover:true,
            maxBtn:false,
            xButton:true,
            resize:false,
            page:'insertDynamicManagement.html'
        });
        dg.ShowDialog();
    }


    function updateDynamicManagement() {
        var chk_value = [];//定义一个数组
        $("input[name='dynamicManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'dynamicManagement_edit',
                width:630,
                height:490,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updateDynamicManagement.html?id='+id
            });
            dg.ShowDialog();
        }else {
            alert("请选择一条记录!")
        }
    }


    function deleteDynamicManagement() {
        var chk_value = [];//定义一个数组
        $("input[name='dynamicManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要删除该记录？")){
                var url = "deleteDynamicManagement.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }



    function updateDynamicManagementPlacedTop() {
        var chk_value = [];//定义一个数组
        $("input[name='dynamicManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要置顶该记录？")){
                var url = "updateDynamicManagementPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function updateDynamicManagementReleaseMarks() {
        var chk_value = [];//定义一个数组
        $("input[name='dynamicManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容!");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要发布该信息？")){
                var url = "updateDynamicManagementReleaseMarks.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }


    function updateDynamicManagementCancelReleaseMarks() {
        var chk_value = [];//定义一个数组
        $("input[name='dynamicManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容!");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要将该信息撤销发布？")){
                var url = "updateDynamicManagementCancelReleaseMarks.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }




    function updateDynamicManagementCancelPlacedTop() {
        var chk_value = [];//定义一个数组
        $("input[name='dynamicManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容!");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要取消该记录的置顶？")){
                var url = "updateDynamicManagementCancelPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    $('.main_info td').css({"white-space": "nowrap","text-overflow": "ellipsis","overflow": "hidden"});

</script>


</body>
</html>
