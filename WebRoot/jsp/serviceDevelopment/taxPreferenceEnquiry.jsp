<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/25
  Time: 14:34
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
<form action="listPageTaxPreferenceEnquiry.html" method="post" id="TaxPreferenceEnquiryForm" name="TaxPreferenceEnquiryForm">
    <div style="margin-top: 10px"></div>
    <div class="search_div">
        <span class="label">税收标题:</span>
        <input type="text" name="name" value="${taxPreferenceEnquiry.name}"/>
        <span class="label">税收阶段:</span>
        <select name="phase" id="phase" style="vertical-align: middle;">
            <option value="0">请选择</option>
            <option value="1">初创期</option>
            <option value="2">成长期</option>
            <option value="3">成熟期</option>
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
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllTaxPreferenceEnquiry()"/></th>
            <th>序号</th>
            <th>税收标题</th>
            <th>税收阶段</th>
            <th>税收类别</th>
            <th>发布人</th>
            <th>发布时间</th>
            <th>更新人</th>
            <th>更新时间</th>
            <th>发布标识</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPageTaxPreferenceEnquiry}">
                <c:forEach items="${listPageTaxPreferenceEnquiry}" var="taxPreferenceEnquiry" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="taxPreferenceEnquiryIds" id="taxPreferenceEnquiryIds${taxPreferenceEnquiry.id }" value="${taxPreferenceEnquiry.id }"/></td>
                        <td>${vs.index+1}</td>
                        <td>${taxPreferenceEnquiry.name}</td>
                        <td><c:if test="${taxPreferenceEnquiry.phase==1}">初创期</c:if><c:if test="${taxPreferenceEnquiry.phase==2}">成熟期</c:if><c:if test="${taxPreferenceEnquiry.phase==3}">成长期</c:if></td>
                        <td><c:if test="${taxPreferenceEnquiry.type==1}">小微企业税收优惠</c:if><c:if test="${taxPreferenceEnquiry.type==2}">重点群体创业就业税收优惠</c:if><c:if test="${taxPreferenceEnquiry.type==3}">创业就业平台税收优惠</c:if><c:if test="${taxPreferenceEnquiry.type==4}">对提供资金、非货币性资产投资助力的创投企业、金融机构等给予税收优惠</c:if></td>
                        <td>${taxPreferenceEnquiry.reportPeople}</td>
                        <td><fmt:formatDate value="${taxPreferenceEnquiry.reportTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${taxPreferenceEnquiry.modifier}</td>
                        <td><fmt:formatDate value="${taxPreferenceEnquiry.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><c:if test="${taxPreferenceEnquiry.reportMarks==0}">未发布</c:if><c:if test="${taxPreferenceEnquiry.reportMarks==1}">已发布</c:if></td>

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
            <a href="javascript:insertTaxPreferenceEnquiry();" class="myBtn"><em>发布</em></a>
            <a href="javascript:deleteTaxPreferenceEnquiry();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updateTaxPreferenceEnquiry();" class="myBtn"><em>修改</em></a>
            <a href="javascript:updateTaxPreferenceEnquiryCancelReportMarks();" class="myBtn"><em>撤回</em></a>
        </div>
        ${taxPreferenceEnquiry.page.pageStr}
    </div>
</form>
<script>
    function search(){
        $("#TaxPreferenceEnquiryForm").submit();
    }

    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });
    function sltAllTaxPreferenceEnquiry(){
        if($("#sltAll").attr("checked")){
            $("input[name='taxPreferenceEnquiryIds']").attr("checked",true);
        }else{
            $("input[name='taxPreferenceEnquiryIds']").attr("checked",false);
        }
    }
    function deleteTaxPreferenceEnquiry(){
        var chk_value = [];//定义一个数组
        $("input[name='taxPreferenceEnquiryIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要删除该记录？")){
                var url = "deleteTaxPreferenceEnquiry.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function updateTaxPreferenceEnquiryCancelReportMarks(){
        var chk_value = [];//定义一个数组
        $("input[name='taxPreferenceEnquiryIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要撤回该记录？")){
                var url = "updateTaxPreferenceEnquiryCancelReportMarks.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }


    function insertTaxPreferenceEnquiry(){
        var dg = new $.dialog({
            title:'添加',
            id:'taxPreferenceEnquiry_new',
            width:530,
            height:490,
            iconTitle:false,
            cover:true,
            maxBtn:false,
            xButton:true,
            resize:false,
            page:'insertTaxPreferenceEnquiry.html'
        });
        dg.ShowDialog();
    }

    function updateTaxPreferenceEnquiry() {
        var chk_value = [];//定义一个数组
        $("input[name='taxPreferenceEnquiryIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'taxPreferenceEnquiry_edit',
                width:530,
                height:490,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updateTaxPreferenceEnquiry.html?id='+id
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
