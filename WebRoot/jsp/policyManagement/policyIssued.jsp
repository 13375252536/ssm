<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%--
  Created by IntelliJ IDEA.
  User: lianglei
  Date: 2018/8/23
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Test</title>
    <link type="text/css" rel="stylesheet" href="/css/main.css"/>
<style>
    .search_div span{
        margin-left: 50px;
    }
</style>
</head>
<body>
<form action="listPagePolicyIssued.html" method="post" name="policyIssuedForm" id="policyIssuedForm">
    <div class="search_div" style="height: 100px;">
        <span class="label">标题:</span>
        <input type="text" name="name" value="${policyIssued.name}" style="width: 60px"/>
        <span class="label">文号:</span>
        <input type="text" name="postShopName" value="${policyIssued.postShopName}" style="width: 60px"/>
        <span class="label">区域:</span>
        <select name="region" id="region" style="vertical-align: middle;">
            <option value="">请选择</option>
            <c:forEach items="${selectRegion}" var="region">
                <option>${region.name}</option>
            </c:forEach>
        </select>
        <span class="label">置顶:</span>
        <select name="placedTop" id="placedTop" style="vertical-align: middle;">
            <option value="2">请选择</option>
            <option value="0">未置顶</option>
            <option value="1">已置顶</option>
        </select>
        <br>
        <span class="label">行业:</span>
        <select name="industry" id="industry" style="vertical-align: middle;">
        <option value="">请选择</option>
        <c:forEach items="${selectIndustry}" var="industry">
            <option>${industry.name}</option>
        </c:forEach>
    </select>
        <span class="label">主题分类:</span>
        <select name="policyTheme" id="policyTheme" style="vertical-align: middle;">
            <option value="">请选择</option>
            <c:forEach items="${selectPolicyTheme}" var="policyTheme">
                <option>${policyTheme.name}</option>
            </c:forEach>
        </select>
       <br> <span class="label">发布单位:</span>
        <select name="reportUnit" id="reportUnit" style="vertical-align: middle;">
            <option value="">请选择</option>
            <c:forEach items="${selectReportUnit}" var="reportUnit">
                <option>${reportUnit.organizationName}</option>
            </c:forEach>
        </select>
        <span class="label">发布标识:</span>
        <select name="reportMarks" id="reportMarks" style="vertical-align: middle;">
            <option value="2">请选择</option>
            <option value="1">已发布</option>
            <option value="0">未发布</option>
        </select>
        <span class="label">发布日期:</span>
        <input type="text" name="reportDateStart" value="<fmt:formatDate value="${policyIssued.reportDateStart}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker()" readonly="readonly" style="width:70px;"/> -
        <input type="text" name="reportDateEnd" value="<fmt:formatDate value="${policyIssued.reportDateEnd}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker()" readonly="readonly" style="width:70px;"/>
        <a href="javascript:search();" class="myBtn" style="margin-left: 40px"><em>查询</em></a>
    </div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table"
           style="font-size: 12px;table-layout:fixed;width: 1600px">
        <tr class="main_head">
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllPolicyIssued()"/></th>
            <th>序号</th>
            <th>标题</th>
            <th>发文字号</th>
            <th>发布机构</th>
            <th>发布人</th>
            <th>发布时间</th>
            <th>修改时间</th>
            <th>政策主题</th>
            <th>生态圈关键字</th>
            <th>时间轴阶段</th>
            <th>政策隶属</th>
            <th>区域</th>
            <th>创业人群</th>
            <th>创业服务</th>
            <th>行业</th>
            <th>政策排序</th>
            <th>政策置顶</th>
            <th>发布标记</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPagePolicyIssued}">
                <c:forEach items="${listPagePolicyIssued}" var="policyIssued" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="policyIssuedIds" id="policyIssuedIds${policyIssued.id }" value="${policyIssued.id}"/></td>
                        <td>${vs.index+1}</td>
                        <td>${policyIssued.name}</td>
                        <td>${policyIssued.postShopName}</td>
                        <td>${policyIssued.reportUnit}</td>
                        <td>${policyIssued.reportPeople}</td>
                        <td><fmt:formatDate value="${policyIssued.reportDate}" pattern="yyyy-MM-dd"/></td>
                        <td><fmt:formatDate value="${policyIssued.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${policyIssued.policyTheme}</td>
                        <td>${policyIssued.ecosphereKeyword}</td>
                        <td>${policyIssued.timelinePhase}</td>
                        <td><c:if test="${policyIssued.policyIs=='1'}">全部</c:if><c:if test="${policyIssued.policyIs=='2'}">国家政策</c:if><c:if test="${policyIssued.policyIs=='3'}">区域政策</c:if></td>
                        <td>${policyIssued.region}</td>
                        <td>${policyIssued.businessPeople}</td>
                        <td>${policyIssued.innovationService}</td>
                        <td>${policyIssued.industry}</td>
                        <td>${policyIssued.sorting}</td>
                        <td><c:if test="${policyIssued.placedTop=='0'}">未置顶</c:if><c:if test="${policyIssued.placedTop=='1'}">已置顶</c:if></td>
                        <td><c:if test="${policyIssued.reportMarks=='1'}">已发布</c:if><c:if test="${policyIssued.reportMarks=='0'}">未发布</c:if></td>
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
            <a href="javascript:insertPolicyIssued();" class="myBtn"><em>添加</em></a>
            <a href="javascript:deletePolicyIssued();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updatePolicyIssued();" class="myBtn"><em>修改</em></a>
            <a href="javascript:updatePolicyIssuedCancelReportMarks();" class="myBtn"><em>撤回</em></a>
            <a href="javascript:updatePolicyIssuedPlacedTop();" class="myBtn"><em>置顶</em></a>
            <a href="javascript:updatePolicyIssuedCancelPlacedTop();" class="myBtn"><em>取消置顶</em></a>
        </div>
        ${policyIssued.page.pageStr}
    </div>
</form>
<script type="text/javascript" src="../../js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="../../js/datePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../../js/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
<script type="text/javascript" src="../../js/common.js"></script>
<script type="text/javascript">
    function search(){
        $("#PolicyIssuedForm").submit();
    }

    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });
    function sltAllPolicyIssued(){
        if($("#sltAll").attr("checked")){
            $("input[name='policyIssuedIds']").attr("checked",true);
        }else{
            $("input[name='policyIssuedIds']").attr("checked",false);
        }
    }
    function deletePolicyIssued(){
        var chk_value = [];//定义一个数组
        $("input[name='policyIssuedIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要删除该记录？")){
                var url = "deletePolicyIssued.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }
    function updatePolicyIssuedCancelReportMarks(){
        var chk_value = [];//定义一个数组
        $("input[name='policyIssuedIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要撤回该记录？")){
                var url = "updatePolicyIssuedCancelReportMarks.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }
    function updatePolicyIssuedPlacedTop(){
        var chk_value = [];//定义一个数组
        $("input[name='policyIssuedIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要置顶该记录？")){
                var url = "updatePolicyIssuedPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }
    function updatePolicyIssuedCancelPlacedTop(){
        var chk_value = [];//定义一个数组
        $("input[name='policyIssuedIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要将该记录取消置顶？")){
                var url = "updatePolicyIssuedCancelPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }
    function insertPolicyIssued(){
        var dg = new $.dialog({
            title:'添加',
            id:'policyIssued_new',
            width:850,
            height:450,
            iconTitle:false,
            cover:true,
            maxBtn:false,
            xButton:true,
            resize:false,
            page:'insertPolicyIssued.html'
        });
        dg.ShowDialog();
    }

    function updatePolicyIssued() {
        var chk_value = [];//定义一个数组
        $("input[name='policyIssuedIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'policyIssued_edit',
                width:850,
                height:450,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updatePolicyIssued.html?id='+id
            });
            dg.ShowDialog();
        }else {
            alert("请选择一条记录!")
        }
    }

    $('.main_info td').css({"white-space": "nowrap", "text-overflow": "ellipsis", "overflow": "hidden"});
</script>
</body>
</html>
