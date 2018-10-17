<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/10
  Time: 11:22
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
<form action="listPageSubjectClassificationMaintenance.html" method="post" id="SubjectClassificationMaintenanceForm" name="SubjectClassificationMaintenanceForm">
    <div style="margin-top: 10px"></div>
    <div class="search_div">
        <span class="label">主题分类名称:</span>
        <input type="text" name="name" value="${subjectClassificationMaintenance.name}"/>
        <a href="javascript:search();" class="myBtn"><em>查询</em></a>
    </div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table"  style="font-size: 12px;table-layout:fixed">
        <tr class="main_head">
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllSubjectClassificationMaintenance()"/></th>
            <th>序号</th>
            <th>主题分类名称</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPageSubjectClassificationMaintenance}">
                <c:forEach items="${listPageSubjectClassificationMaintenance}" var="subjectClassificationMaintenance" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="subjectClassificationMaintenanceIds" id="subjectClassificationMaintenanceIds${subjectClassificationMaintenance.id }" value="${subjectClassificationMaintenance.id }"/></td>
                        <td>${vs.index+1}</td>
                        <td>${subjectClassificationMaintenance.name}</td>
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
            <a href="javascript:insertSubjectClassificationMaintenance();" class="myBtn"><em>新增</em></a>
            <a href="javascript:deleteSubjectClassificationMaintenance();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updateSubjectClassificationMaintenance();" class="myBtn"><em>修改</em></a>
         </div>
        ${subjectClassificationMaintenance.page.pageStr}
    </div>
</form>
<script>
    function search(){
        $("#SubjectClassificationMaintenanceForm").submit();
    }
    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });
    function sltAllSubjectClassificationMaintenance(){
        if($("#sltAll").attr("checked")){
            $("input[name='subjectClassificationMaintenanceIds']").attr("checked",true);
        }else{
            $("input[name='subjectClassificationMaintenanceIds']").attr("checked",false);
        }
    }
    function deleteSubjectClassificationMaintenance(){
        var chk_value = [];//定义一个数组
        $("input[name='subjectClassificationMaintenanceIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            console.log(chk_value);
            if(confirm("确定要删除该记录？")){
                var url = "deleteSubjectClassificationMaintenance.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }

    function insertSubjectClassificationMaintenance(){
        var dg = new $.dialog({
            title:'添加',
            id:'subjectClassificationMaintenance_new',
            width:360,
            height:130,
            iconTitle:false,
            cover:true,
            maxBtn:false,
            xButton:true,
            resize:false,
            page:'insertSubjectClassificationMaintenance.html'
        });
        dg.ShowDialog();
    }

    function updateSubjectClassificationMaintenance() {
        var chk_value = [];//定义一个数组
        $("input[name='subjectClassificationMaintenanceIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'subjectClassificationMaintenance_edit',
                width:360,
                height:130,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updateSubjectClassificationMaintenance.html?id='+id
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
