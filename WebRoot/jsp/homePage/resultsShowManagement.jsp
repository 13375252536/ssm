<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/6
  Time: 12:56
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
<form action="listPageResultsShowManagement.html" method="post" id="resultsShowManagementForm" name="resultsShowManagementForm">
    <div style="margin-top: 10px">成果展示管理：添加成果展示需要上传图片，程序会自动截取第一张图片作为置顶到首页时展示的图片，且图片大小一定要符合235*90的倍数！</div>
    <div class="search_div">
        <span class="label">标题：</span>
        <input type="text" name="name" value="${resultsShowManagement.name}"/>
        <select name="releaseMarksId" id="releaseMarks" style="vertical-align: middle;">
            <option>请选择</option>
            <option>未发布</option>
            <option>已发布</option>
        </select>
        <select name="placedTopId" id="placedTop" style="vertical-align: middle;">
            <option>请选择</option>
            <option>未置顶</option>
            <option>已置顶</option>
        </select>
        <a href="javascript:search();" class="myBtn"><em>查询</em></a>
    </div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table"  style="font-size: 12px;table-layout:fixed">
        <tr class="main_head">
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllResultsShowManagement()"/></th>
            <th>序号</th>
            <th>标题</th>
            <th>发布时间</th>
            <th>创建时间</th>
            <th>排序</th>
            <th>发布标识</th>
            <th>置顶</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPageResultsShowManagement}">
                <c:forEach items="${listPageResultsShowManagement}" var="resultsShowManagement" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="resultsShowManagementIds" id="resultsShowManagementIds${resultsShowManagement.id}" value="${resultsShowManagement.id}"/></td>
                        <td>${vs.index+1}</td>
                        <td>${resultsShowManagement.name}</td>
                        <td><fmt:formatDate value="${resultsShowManagement.reportTime}" pattern="yyyy-MM-dd"/></td>
                        <td><fmt:formatDate value="${resultsShowManagement.releaseTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${resultsShowManagement.sorting}</td>
                        <td><c:if test="${resultsShowManagement.releaseMarks=='0'}">未发布</c:if><c:if test="${resultsShowManagement.releaseMarks=='1'}">已发布</c:if></td>
                        <td><c:if test="${resultsShowManagement.placedTop=='0'}">未置顶</c:if><c:if test="${resultsShowManagement.placedTop=='1'}">已置顶</c:if></td>
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
            <a href="javascript:insertResultsShowManagement();" class="myBtn"><em>新增</em></a>
            <a href="javascript:deleteResultsShowManagement();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updateResultsShowManagement();" class="myBtn"><em>修改</em></a>
            <a href="javascript:updateResultsShowManagementPlacedTop();" class="myBtn"><em>置顶</em></a>
            <a href="javascript:updateResultsShowManagementCancelPlacedTop();" class="myBtn"><em>取消置顶</em></a>
            <a href="javascript:updateResultsShowManagementReleaseMarks();" class="myBtn"><em>发布</em></a>
            <a href="javascript:updateResultsShowManagementCancelReleaseMarks();" class="myBtn"><em>撤销发布</em></a>
        </div>
        ${resultsShowManagement.page.pageStr}
    </div>
</form>


<script>
    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });

    function sltAllResultsShowManagement(){
        if($("#sltAll").attr("checked")){
            $("input[name='resultsShowManagementIds']").attr("checked",true);
        }else{
            $("input[name='resultsShowManagementIds']").attr("checked",false);
        }
    }

    function search(){
        $("#resultsShowManagementForm").submit();
    }

    function insertResultsShowManagement() {
        var dg = new $.dialog({
            title:'添加',
            id:'resultsShowManagement_new',
            width:630,
            height:490,
            iconTitle:false,
            cover:true,
            maxBtn:false,
            xButton:true,
            resize:false,
            page:'insertResultsShowManagement.html'
        });
        dg.ShowDialog();
    }


    function updateResultsShowManagement() {
        var chk_value = [];//定义一个数组
        $("input[name='resultsShowManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'resultsShowManagement_edit',
                width:630,
                height:490,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updateResultsShowManagement.html?id='+id
            });
            dg.ShowDialog();
        }else {
            alert("请选择一条记录!")
        }
    }


    function deleteResultsShowManagement() {
        var chk_value = [];//定义一个数组
        $("input[name='resultsShowManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要删除该记录？")){
                var url = "deleteResultsShowManagement.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }



    function updateResultsShowManagementPlacedTop() {
        var chk_value = [];//定义一个数组
        $("input[name='resultsShowManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要置顶该记录？")){
                var url = "updateResultsShowManagementPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function updateResultsShowManagementReleaseMarks() {
        var chk_value = [];//定义一个数组
        $("input[name='resultsShowManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容!");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要发布该信息？")){
                var url = "updateResultsShowManagementReleaseMarks.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }


    function updateResultsShowManagementCancelReleaseMarks() {
        var chk_value = [];//定义一个数组
        $("input[name='resultsShowManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容!");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要将该信息撤销发布？")){
                var url = "updateResultsShowManagementCancelReleaseMarks.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }




    function updateResultsShowManagementCancelPlacedTop() {
        var chk_value = [];//定义一个数组
        $("input[name='resultsShowManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容!");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要取消该记录的置顶？")){
                var url = "updateResultsShowManagementCancelPlacedTop.html?chk_value=" + chk_value;
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
