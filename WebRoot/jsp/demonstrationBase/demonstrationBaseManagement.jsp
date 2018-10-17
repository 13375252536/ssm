<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/18
  Time: 11:01
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
<form action="listPageDemonstrationBaseManagement.html" method="post" id="DemonstrationBaseManagementForm" name="DemonstrationBaseManagementForm">
    <div style="margin-top: 10px">（1）编辑之前，请先选择一条记录。（2）示范基地名称不能重复。（3）请为每个示范基地上传3次图片，图片尺寸为1000×375，每次上传一张。（4）排序值越小，显示越靠前。</div>
    <div class="search_div">
        <span class="label">基地名称:</span>
        <input type="text" name="name" value="${demonstrationBaseManagement.name}"/>
        <span class="label">基地类型:</span>
        <select name="type" id="type" style="vertical-align: middle;">
            <option value="0">请选择</option>
            <option>区域示范基地</option>
            <option>高校和科研院所示范基地</option>
            <option>企业示范基地</option>
        </select>
        <span class="label">基地批次:</span>
        <select name="batch" id="batch" style="vertical-align: middle;">
            <option value="0">请选择</option>
            <option>首批</option>
            <option>第二批</option>
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
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllDemonstrationBaseManagement()"/></th>
            <th>序号</th>
            <th>基地名称</th>
            <th>基地类型</th>
            <th>基地批次</th>
            <th>区域</th>
            <th>发布单位</th>
            <th>创建人</th>
            <th>创建时间</th>
            <th>修改人</th>
            <th>修改时间</th>
            <th>排序</th>
            <th>置顶</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPageDemonstrationBaseManagement}">
                <c:forEach items="${listPageDemonstrationBaseManagement}" var="demonstrationBaseManagement" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="demonstrationBaseManagementIds" id="demonstrationBaseManagementIds${demonstrationBaseManagement.id }" value="${demonstrationBaseManagement.id }"/></td>
                        <td>${vs.index+1}</td>
                        <td>${demonstrationBaseManagement.name}</td>
                        <td>${demonstrationBaseManagement.type}</td>
                        <td>${demonstrationBaseManagement.batch}</td>
                        <td>${demonstrationBaseManagement.areaName}</td>
                        <td>${demonstrationBaseManagement.reportUnitName}</td>
                        <td>${demonstrationBaseManagement.releasePeople}</td>
                        <td><fmt:formatDate value="${demonstrationBaseManagement.releaseTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${demonstrationBaseManagement.modifier}</td>
                        <td><fmt:formatDate value="${demonstrationBaseManagement.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${demonstrationBaseManagement.sorting}</td>
                        <td><c:if test="${demonstrationBaseManagement.placedTop==0}">未置顶</c:if><c:if test="${demonstrationBaseManagement.placedTop==1}">已置顶</c:if></td>
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
            <a href="javascript:insertDemonstrationBaseManagement();" class="myBtn"><em>添加</em></a>
            <a href="javascript:deleteDemonstrationBaseManagement();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updateDemonstrationBaseManagement();" class="myBtn"><em>修改</em></a>
            <a href="javascript:updateDemonstrationBaseManagementPlacedTop();" class="myBtn"><em>置顶</em></a>
            <a href="javascript:updateDemonstrationBaseManagementCancelPlacedTop();" class="myBtn"><em>取消置顶</em></a>
        </div>
        ${demonstrationBaseManagement.page.pageStr}
    </div>
</form>
<script>
    function search(){
        $("#DemonstrationBaseManagementForm").submit();
    }

    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });
    function sltAllDemonstrationBaseManagement(){
        if($("#sltAll").attr("checked")){
            $("input[name='demonstrationBaseManagementIds']").attr("checked",true);
        }else{
            $("input[name='demonstrationBaseManagementIds']").attr("checked",false);
        }
    }
    function deleteDemonstrationBaseManagement(){
        var chk_value = [];//定义一个数组
        $("input[name='demonstrationBaseManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要删除该记录？")){
                var url = "deleteDemonstrationBaseManagement.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function updateDemonstrationBaseManagementPlacedTop(){
        var chk_value = [];//定义一个数组
        $("input[name='demonstrationBaseManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要将该记录置顶？")){
                var url = "updateDemonstrationBaseManagementPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }


    function updateDemonstrationBaseManagementCancelPlacedTop(){
        var chk_value = [];//定义一个数组
        $("input[name='demonstrationBaseManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要将该记录取消置顶？")){
                var url = "updateDemonstrationBaseManagementCancelPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }


    function insertDemonstrationBaseManagement(){
        var dg = new $.dialog({
            title:'添加',
            id:'demonstrationBaseManagement_new',
            width:630,
            height:490,
            iconTitle:false,
            cover:true,
            maxBtn:false,
            xButton:true,
            resize:false,
            page:'insertDemonstrationBaseManagement.html'
        });
        dg.ShowDialog();
    }

    function updateDemonstrationBaseManagement() {
        var chk_value = [];//定义一个数组
        $("input[name='demonstrationBaseManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'demonstrationBaseManagement_edit',
                width:630,
                height:490,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updateDemonstrationBaseManagement.html?id='+id
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
