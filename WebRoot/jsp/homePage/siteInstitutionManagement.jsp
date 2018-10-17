<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/5
  Time: 11:56
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
<form action="listPageSiteInstitutionManagement.html" method="post" id="SiteInstitutionManagementForm" name="SiteInstitutionManagementForm">
    <div style="margin-top: 10px"></div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table"  style="font-size: 12px;table-layout:fixed">
        <tr class="main_head">
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllSiteInstitutionManagement()"/></th>
            <th>序号</th>
            <th>名称</th>
            <th>链接</th>
            <th>路径</th>
            <th>排序</th>
            <th>类别</th>
            <th>置顶</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPageSiteInstitutionManagement}">
                <c:forEach items="${listPageSiteInstitutionManagement}" var="siteInstitutionManagement" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="siteInstitutionManagementIds" id="siteInstitutionManagementIds${siteInstitutionManagement.id }" value="${siteInstitutionManagement.id }"/></td>
                        <td>${vs.index+1}</td>
                        <td>${siteInstitutionManagement.name}</td>
                        <td>${siteInstitutionManagement.link}</td>
                        <td>${siteInstitutionManagement.fileURL}</td>
                        <td>${siteInstitutionManagement.sorting}</td>
                        <td>${siteInstitutionManagement.type}</td>
                        <td><c:if test="${siteInstitutionManagement.placedTop==0}">未置顶</c:if><c:if test="${siteInstitutionManagement.placedTop==1}">已置顶</c:if></td>
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
            <a href="javascript:insertSiteInstitutionManagement();" class="myBtn"><em>新增</em></a>
            <a href="javascript:deleteSiteInstitutionManagement();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updateSiteInstitutionManagement();" class="myBtn"><em>修改</em></a>
            <a href="javascript:updateSiteInstitutionManagementPlacedTop();" class="myBtn"><em>置顶</em></a>
            <a href="javascript:updateSiteInstitutionManagementCancelPlacedTop();" class="myBtn"><em>取消置顶</em></a>
        </div>
        ${siteInstitutionManagement.page.pageStr}
    </div>
</form>
<script>
    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });
    function sltAllSiteInstitutionManagement(){
        if($("#sltAll").attr("checked")){
            $("input[name='siteInstitutionManagementIds']").attr("checked",true);
        }else{
            $("input[name='siteInstitutionManagementIds']").attr("checked",false);
        }
    }
    function deleteSiteInstitutionManagement(){
        var chk_value = [];//定义一个数组
        $("input[name='siteInstitutionManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要删除该记录？")){
                var url = "deleteSiteInstitutionManagement.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }
    function updateSiteInstitutionManagementPlacedTop() {
        var chk_value = [];//定义一个数组
        $("input[name='siteInstitutionManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要置顶该记录？")){
                var url = "updateSiteInstitutionManagementPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function updateSiteInstitutionManagementCancelPlacedTop() {
        var chk_value = [];//定义一个数组
        $("input[name='siteInstitutionManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要取消该记录的置顶？")){
                var url = "updateSiteInstitutionManagementCancelPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }
    function insertSiteInstitutionManagement(){
        var dg = new $.dialog({
            title:'添加',
            id:'siteInstitutionManagement_new',
            width:360,
            height:270,
            iconTitle:false,
            cover:true,
            maxBtn:false,
            xButton:true,
            resize:false,
            page:'insertSiteInstitutionManagement.html'
        });
        dg.ShowDialog();
    }

    function updateSiteInstitutionManagement() {
        var chk_value = [];//定义一个数组
        $("input[name='siteInstitutionManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'siteInstitutionManagement_edit',
                width:360,
                height:360,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updateSiteInstitutionManagement.html?id='+id
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
