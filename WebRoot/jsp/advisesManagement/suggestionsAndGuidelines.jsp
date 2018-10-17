<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/22
  Time: 20:35
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
<form action="listPageSuggestionsAndGuidelines.html" method="post" id="SuggestionsAndGuidelinesForm" name="SuggestionsAndGuidelinesForm">
    <div style="margin-top: 10px">编辑之前，请先选择一条记录。</div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table"  style="font-size: 12px">
        <tr class="main_head">
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllSuggestionsAndGuidelines()"/></th>
            <th>序号</th>
            <th>留言须知</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPageSuggestionsAndGuidelines}">
                <c:forEach items="${listPageSuggestionsAndGuidelines}" var="suggestionsAndGuidelines" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="suggestionsAndGuidelinesIds" id="suggestionsAndGuidelinesIds${suggestionsAndGuidelines.id }" value="${suggestionsAndGuidelines.id }"/></td>
                        <td style="width: 100px">${vs.index+1}</td>
                        <td><div style="text-align:center;word-wrap:break-word;word-break:break-all;white-space:normal;max-width:950px;">${suggestionsAndGuidelines.content}</div></td>
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
            <a href="javascript:updateSuggestionsAndGuidelines();" class="myBtn"><em>编辑</em></a>
        </div>
        ${suggestionsAndGuidelines.page.pageStr}
    </div>
</form>
<script>
    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });
    function sltAllSuggestionsAndGuidelines(){
        if($("#sltAll").attr("checked")){
            $("input[name='suggestionsAndGuidelinesIds']").attr("checked",true);
        }else{
            $("input[name='suggestionsAndGuidelinesIds']").attr("checked",false);
        }
    }

    function updateSuggestionsAndGuidelines() {
        var chk_value = [];//定义一个数组
        $("input[name='suggestionsAndGuidelinesIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'suggestionsAndGuidelines_edit',
                width:450,
                height:490,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updateSuggestionsAndGuidelines.html'
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
