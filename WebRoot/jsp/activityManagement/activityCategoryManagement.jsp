<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/13
  Time: 14:25
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
<form action="listPageActivityCategoryManagement.html" method="post" id="ActivityCategoryManagementForm" name="ActivityCategoryManagementForm">
    <div style="margin-top: 10px">（1）请为每个活动上传一张预览图，必须为图片。（2）所上传图片的尺寸为292×163！（3）前台首页展示的是已发布已置顶的排序值最小的几条数据。（4）排序值越小，显示越靠前。</div>
    <div class="search_div">
        <span class="label">活动标题:</span>
        <input type="text" name="name" value="${activityCategoryManagement.name}"/>
        <span class="label">活动种类:</span>
        <select name="type" id="type" style="vertical-align: middle;">
            <option value="0">请选择</option>
            <option>地方活动</option>
            <option>基地活动</option>
            <option>部委活动</option>
            <option>社会团体</option>
        </select>
        <a href="javascript:search();" class="myBtn"><em>查询</em></a>
    </div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table"  style="font-size: 12px;table-layout:fixed">
        <tr class="main_head">
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllActivityCategoryManagement()"/></th>
            <th>序号</th>
            <th>活动标题</th>
            <th>活动类别</th>
            <th>活动简介</th>
            <th>发布人</th>
            <th>发布时间</th>
            <th>更新人</th>
            <th>更新时间</th>
            <th>启用状态</th>
            <th>参与方式跳转链接</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPageActivityCategoryManagement}">
                <c:forEach items="${listPageActivityCategoryManagement}" var="activityCategoryManagement" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="activityCategoryManagementIds" id="activityCategoryManagementIds${activityCategoryManagement.id }" value="${activityCategoryManagement.id }"/></td>
                        <td>${vs.index+1}</td>
                        <td>${activityCategoryManagement.name}</td>
                        <td>${activityCategoryManagement.type}</td>
                        <td>${activityCategoryManagement.introduction}</td>
                        <td>${activityCategoryManagement.reportPeople}</td>
                        <td><fmt:formatDate value="${activityCategoryManagement.reportTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${activityCategoryManagement.modifier}</td>
                        <td><fmt:formatDate value="${activityCategoryManagement.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><c:if test="${activityCategoryManagement.initiateMode==0}">未启用</c:if><c:if test="${activityCategoryManagement.initiateMode==1}">已启用</c:if></td>
                        <td>${activityCategoryManagement.link}</td>
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
            <a href="javascript:insertActivityCategoryManagement();" class="myBtn"><em>发布</em></a>
            <a href="javascript:deleteActivityCategoryManagement();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updateActivityCategoryManagement();" class="myBtn"><em>修改</em></a>
            <a href="javascript:updateActivityCategoryManagementInitiateMode();" class="myBtn"><em>启用</em></a>
            <a href="javascript:updateActivityCategoryManagementCancelInitiateMode();" class="myBtn"><em>停用</em></a>
        </div>
        ${activityCategoryManagement.page.pageStr}
    </div>
</form>
<script>
    function search(){
        $("#ActivityCategoryManagementForm").submit();
    }

    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });
    function sltAllActivityCategoryManagement(){
        if($("#sltAll").attr("checked")){
            $("input[name='activityCategoryManagementIds']").attr("checked",true);
        }else{
            $("input[name='activityCategoryManagementIds']").attr("checked",false);
        }
    }
    function deleteActivityCategoryManagement(){
        var chk_value = [];//定义一个数组
        $("input[name='activityCategoryManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要删除该记录？")){
                var url = "deleteActivityCategoryManagement.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }


    function updateActivityCategoryManagementInitiateMode(){
        var chk_value = [];//定义一个数组
        $("input[name='activityCategoryManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要启用该记录？")){
                var url = "updateActivityCategoryManagementInitiateMode.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }


    function updateActivityCategoryManagementCancelInitiateMode(){
        var chk_value = [];//定义一个数组
        $("input[name='activityCategoryManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要停用该记录？")){
                var url = "updateActivityCategoryManagementCancelInitiateMode.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }


    function insertActivityCategoryManagement(){
        var dg = new $.dialog({
            title:'添加',
            id:'activityCategoryManagement_new',
            width:690,
            height:490,
            iconTitle:false,
            cover:true,
            maxBtn:false,
            xButton:true,
            resize:false,
            page:'insertActivityCategoryManagement.html'
        });
        dg.ShowDialog();
    }

    function updateActivityCategoryManagement() {
        var chk_value = [];//定义一个数组
        $("input[name='activityCategoryManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'activityCategoryManagement_edit',
                width:690,
                height:490,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updateActivityCategoryManagement.html?id='+id
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
