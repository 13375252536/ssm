<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/25
  Time: 11:42
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
<form action="listPageFundFeeEnquiry.html" method="post" id="FundFeeEnquiryForm" name="FundFeeEnquiryForm">
    <div style="margin-top: 10px">（1）请为每个活动上传一张预览图，必须为图片。（2）所上传图片的尺寸为292×163！（3）前台首页展示的是已发布已置顶的排序值最小的几条数据。（4）排序值越小，显示越靠前。</div>
    <div class="search_div">
        <span class="label">费用标题:</span>
        <input type="text" name="name" value="${fundFeeEnquiry.name}"/>
        <span class="label">费用类别:</span>
        <select name="type" id="type" style="vertical-align: middle;">
            <option value="0">请选择</option>
            <option value="1">中央设立政府性基金和行政事业性收费</option>
            <option value="2">省（区、市）设立行政事业性收费</option>
            <option value="3">省（区、市）设立涉企行政事业性收费</option>
        </select>
        <span class="label">发布标识:</span>
        <select name="reportMarks" id="reportMarks" style="vertical-align: middle;">
            <option value="2">请选择</option>
            <option value="0">未发布</option>
            <option value="1">已发布</option>
        </select>
        <a href="javascript:search();" class="myBtn"><em>查询</em></a>
    </div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table"  style="font-size: 12px;table-layout:fixed">
        <tr class="main_head">
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllFundFeeEnquiry()"/></th>
            <th>序号</th>
            <th>费用标题</th>
            <th>费用类别</th>
            <th>发布人</th>
            <th>发布时间</th>
            <th>更新人</th>
            <th>更新时间</th>
            <th>发布标识</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPageFundFeeEnquiry}">
                <c:forEach items="${listPageFundFeeEnquiry}" var="fundFeeEnquiry" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="fundFeeEnquiryIds" id="fundFeeEnquiryIds${fundFeeEnquiry.id }" value="${fundFeeEnquiry.id }"/></td>
                        <td>${vs.index+1}</td>
                        <td>${fundFeeEnquiry.name}</td>
                        <td><c:if test="${fundFeeEnquiry.type==1}">中央设立政府性基金和行政事业性收费</c:if><c:if test="${fundFeeEnquiry.type==2}">省（区、市）设立行政事业性收费</c:if><c:if test="${fundFeeEnquiry.type==3}">省（区、市）设立涉企行政事业性收费</c:if></td>
                        <td>${fundFeeEnquiry.reportPeople}</td>
                        <td><fmt:formatDate value="${fundFeeEnquiry.reportTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${fundFeeEnquiry.modifier}</td>
                        <td><fmt:formatDate value="${fundFeeEnquiry.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><c:if test="${fundFeeEnquiry.reportMarks==0}">未发布</c:if><c:if test="${fundFeeEnquiry.reportMarks==1}">已发布</c:if></td>
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
            <a href="javascript:insertFundFeeEnquiry();" class="myBtn"><em>发布</em></a>
            <a href="javascript:deleteFundFeeEnquiry();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updateFundFeeEnquiry();" class="myBtn"><em>修改</em></a>
            <a href="javascript:updateFundFeeEnquiryCancelReportMarks();" class="myBtn"><em>撤回</em></a>
        </div>
        ${fundFeeEnquiry.page.pageStr}
    </div>
</form>
<script>
    function search(){
        $("#FundFeeEnquiryForm").submit();
    }

    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });
    function sltAllFundFeeEnquiry(){
        if($("#sltAll").attr("checked")){
            $("input[name='fundFeeEnquiryIds']").attr("checked",true);
        }else{
            $("input[name='fundFeeEnquiryIds']").attr("checked",false);
        }
    }
    function deleteFundFeeEnquiry(){
        var chk_value = [];//定义一个数组
        $("input[name='fundFeeEnquiryIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要删除该记录？")){
                var url = "deleteFundFeeEnquiry.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function updateFundFeeEnquiryCancelReportMarks() {
        var chk_value = [];//定义一个数组
        $("input[name='fundFeeEnquiryIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要撤回该记录？")){
                var url = "updateFundFeeEnquiryCancelReportMarks.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function insertFundFeeEnquiry(){
        var dg = new $.dialog({
            title:'添加',
            id:'fundFeeEnquiry_new',
            width:430,
            height:360,
            iconTitle:false,
            cover:true,
            maxBtn:false,
            xButton:true,
            resize:false,
            page:'insertFundFeeEnquiry.html'
        });
        dg.ShowDialog();
    }

    function updateFundFeeEnquiry() {
        var chk_value = [];//定义一个数组
        $("input[name='fundFeeEnquiryIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'fundFeeEnquiry_edit',
                width:430,
                height:360,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updateFundFeeEnquiry.html?id='+id
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
