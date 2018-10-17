<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/10
  Time: 15:29
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
<form action="listPageMediaManagement.html" method="post" id="MediaManagementForm" name="MediaManagementForm">
    <div style="margin-top: 10px">关于媒体的上传需要注意的有：（1）所上传的文件全部为预览图，必须为图片。（2）所上传图片的尺寸为500×290！（3）视频只有展示顺序最小的那个会在前台播放！（4）前台首页展示的是已置顶的排序值最小的几条数据。（5）排序值越小，显示越靠前。</div>
    <div class="search_div">
        <span class="label">媒体名称:</span>
        <input type="text" name="name" value="${mediaManagement.name}"/>
        <a href="javascript:search();" class="myBtn"><em>查询</em></a>
    </div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table"  style="font-size: 12px;table-layout:fixed">
        <tr class="main_head">
            <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllMediaManagement()"/></th>
            <th>序号</th>
            <th>媒体名称</th>
            <th>业务类型</th>
            <th>媒体类型</th>
            <th>链接</th>
            <th>排序</th>
            <th>置顶</th>
        </tr>
        <c:choose>
            <c:when test="${not empty listPageMediaManagement}">
                <c:forEach items="${listPageMediaManagement}" var="mediaManagement" varStatus="vs">
                    <tr class="main_info">
                        <td><input type="checkbox" name="mediaManagementIds" id="mediaManagementIds${mediaManagement.id }" value="${mediaManagement.id }"/></td>
                        <td>${vs.index+1}</td>
                        <td>${mediaManagement.name}</td>
                        <td>${mediaManagement.businessTypes}</td>
                        <td>${mediaManagement.mediaType}</td>
                        <td>${mediaManagement.link}</td>
                        <td>${mediaManagement.sorting}</td>
                        <td><c:if test="${mediaManagement.placedTop==0}">未置顶</c:if><c:if test="${mediaManagement.placedTop==1}">已置顶</c:if></td>
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
            <a href="javascript:insertMediaManagement();" class="myBtn"><em>新增</em></a>
            <a href="javascript:deleteMediaManagement();" class="myBtn" id="delete"><em>删除</em></a>
            <a href="javascript:updateMediaManagement();" class="myBtn"><em>修改</em></a>
            <a href="javascript:updateMediaManagementplacedTop();" class="myBtn"><em>置顶</em></a>
            <a href="javascript:updateMediaManagementCancelPlacedTop();" class="myBtn"><em>取消置顶</em></a>
        </div>
        ${mediaManagement.page.pageStr}
    </div>
</form>
<script>
    function search(){
        $("#MediaManagementForm").submit();
    }
    $(document).ready(function(){
        $(".main_info:even").addClass("main_table_even");
    });
    function sltAllMediaManagement(){
        if($("#sltAll").attr("checked")){
            $("input[name='mediaManagementIds']").attr("checked",true);
        }else{
            $("input[name='mediaManagementIds']").attr("checked",false);
        }
    }
    function deleteMediaManagement(){
        var chk_value = [];//定义一个数组
        $("input[name='mediaManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要删除该记录？")){
                var url = "deleteMediaManagement.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }


    function updateMediaManagementplacedTop(){
        var chk_value = [];//定义一个数组
        $("input[name='mediaManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要将该记录置顶？")){
                var url = "updateMediaManagementPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }


    function updateMediaManagementCancelPlacedTop(){
        var chk_value = [];//定义一个数组
        $("input[name='mediaManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        if (chk_value.length == 0) {
            alert("你还没有选择任何内容！");
        }
        if (chk_value.length > 0) {
            if(confirm("确定要将该记录取消置顶？")){
                var url = "updateMediaManagementCancelPlacedTop.html?chk_value=" + chk_value;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
    }


    function insertMediaManagement(){
        var dg = new $.dialog({
            title:'添加',
            id:'mediaManagement_new',
            width:360,
            height:450,
            iconTitle:false,
            cover:true,
            maxBtn:false,
            xButton:true,
            resize:false,
            page:'insertMediaManagement.html'
        });
        dg.ShowDialog();
    }

    function updateMediaManagement() {
        var chk_value = [];//定义一个数组
        $("input[name='mediaManagementIds']:checked").each(function () {
            //将选中额数据存到数组里
            chk_value.push($(this).val());
        });
        var id = chk_value[0];
        if(chk_value.length==1){
            var dg = new $.dialog({
                title:'修改',
                id:'mediaManagement_edit',
                width:360,
                height:490,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                resize:false,
                page:'updateMediaManagement.html?id='+id
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
