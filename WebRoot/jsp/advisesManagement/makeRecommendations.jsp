<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/22
  Time: 18:34
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
<form action="listPageMakeRecommendations.html" method="post" id="MakeRecommendationsForm" name="MakeRecommendationsForm">
    <div style="margin-top: 10px">审核之前，请先选择一条记录。</div>
    <div class="search_div">
        <span class="label">状态:</span>
        <select name="state" id="state" style="vertical-align: middle;">
            <option value="3">请选择</option>
            <option value="1">审核通过</option>
            <option value="0">未审核</option>
            <option value="2">审核未通过</option>
        </select>
        <a href="javascript:search();" class="myBtn"><em>查询</em></a>
    </div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table"  style="font-size: 12px;table-layout:fixed">
        <tr class="main_head">
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllMakeRecommendations()"/></th>
            <th>序号</th>
            <th>姓名</th>
            <th>单位</th>
            <th>电话</th>
            <th>邮箱</th>
            <th>标题</th>
            <th>时间</th>
            <th>状态</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPageMakeRecommendations}">
                <c:forEach items="${listPageMakeRecommendations}" var="makeRecommendations" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="makeRecommendationsIds" id="makeRecommendationsIds${makeRecommendations.id }" value="${makeRecommendations.id }"/></td>
                        <td>${vs.index+1}</td>
                        <td>${makeRecommendations.name}</td>
                        <td>${makeRecommendations.unit}</td>
                        <td>${makeRecommendations.telNum}</td>
                        <td>${makeRecommendations.email}</td>
                        <td>${makeRecommendations.title}</td>
                        <td><fmt:formatDate value="${makeRecommendations.time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><c:if test="${makeRecommendations.state==0}">未审核</c:if><c:if test="${makeRecommendations.state==1}">审核通过</c:if><c:if test="${makeRecommendations.state==2}">审核未通过</c:if></td>
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
            <a href="javascript:deleteMakeRecommendations();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updateMakeRecommendationsState();" class="myBtn"><em>审核</em></a>
        </div>
        ${makeRecommendations.page.pageStr}
    </div>
</form>
<script>
    function search(){
        $("#MakeRecommendationsForm").submit();
    }

    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });
    function sltAllMakeRecommendations(){
        if($("#sltAll").attr("checked")){
            $("input[name='makeRecommendationsIds']").attr("checked",true);
        }else{
            $("input[name='makeRecommendationsIds']").attr("checked",false);
        }
    }
    function deleteMakeRecommendations(){
        var chk_value = [];//定义一个数组
        $("input[name='makeRecommendationsIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要删除该记录？")){
                var url = "deleteMakeRecommendations.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }
    
    function updateMakeRecommendationsState() {
        var chk_value = [];//定义一个数组
        $("input[name='makeRecommendationsIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'makeRecommendations_edit',
                width:450,
                height:490,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updateMakeRecommendationsState.html?id='+id
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
