<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/8/29
  Time: 9:36
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
    <form action="listPageImageManagement.html" method="post" id="imageManagementForm" name="imageManagementForm">
        <div style="margin-top: 10px">（1）图片的大小为1920×400，除了首页，其余的Banner图片只会在前台展示排序最小的那一张。（2）前台首页展示的是已置顶的排序值最小的几条数据。（3）排序值越小，显示越靠前。</div>
        <div class="search_div">
            <span class="label">名称：</span>
            <input type="text" name="name" value="${ImageManagement.name}"/>
            <a href="javascript:search();" class="myBtn"><em>查询</em></a>
        </div>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table" style="font-size: 12px;table-layout:fixed">
            <tr class="main_head">
                <th style="width: 30px"><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllImageManagement()"/></th>
                <th style="width: 30px">序号</th>
                <th style="width: 40px">名称</th>
                <th>类型</th>
                <th>链接</th>
                <th>发布人</th>
                <th>发布时间</th>
                <th>修改人</th>
                <th>修改时间</th>
                <th>排序</th>
                <th>置顶</th>
            </tr>
            <c:choose>
                <c:when test="${not empty listPageImageManagement}">
                    <c:forEach items="${listPageImageManagement}" var="imageManagement" varStatus="vs">
                        <tr class="main_info">
                            <td><input type="checkbox" name="imageManagementIds" id="imageManagementIds${imageManagement.id}" value="${imageManagement.id}"/></td>
                            <td>${vs.index+1}</td>
                            <td>${imageManagement.name}</td>
                            <td>${imageManagement.type}</td>
                            <td width = 300px>${imageManagement.link}</td>
                            <td>${imageManagement.releasePeople}</td>
                            <td><fmt:formatDate value="${imageManagement.releaseTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td>${imageManagement.modifier}</td>
                            <td><fmt:formatDate value="${imageManagement.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td>${imageManagement.sorting}</td>
                            <td><c:if test="${imageManagement.placedTop=='0'}">未置顶</c:if><c:if test="${imageManagement.placedTop=='1'}">已置顶</c:if></td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr class="main_info">
                        <td colspan="13">没有相关数据</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </table>

        <div class="page_and_btn">
            <div>
                <a href="javascript:insertImageManagement();" class="myBtn"><em>新增</em></a>
                <a href="javascript:deleteImageManagement();" class="myBtn" id="delete"><em>删除</em></a>
                <a href="javascript:updateImageManagement();" class="myBtn"><em>修改</em></a>
                <a href="javascript:placedTopImageManagement();" class="myBtn"><em>置顶</em></a>
                <a href="javascript:cancelTopImageManagement();" class="myBtn"><em>取消置顶</em></a>
            </div>
            ${ImageManagement.page.pageStr}
        </div>
    </form>


    <script>
        $(document).ready(function(){
            $(".main_info:even").addClass("main_table_even");
        });

        function sltAllImageManagement(){
            if($("#sltAll").attr("checked")){
                $("input[name='imageManagementIds']").attr("checked",true);
            }else{
                $("input[name='imageManagementIds']").attr("checked",false);
            }
        }

        function search(){
            $("#imageManagementForm").submit();
        }

        function insertImageManagement() {
            var dg = new $.dialog({
                title:'新增图片管理信息',
                id:'imageManagement_new',
                width:360,
                height:390,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                xButton:true,
                resize:false,
                page:'insertImageManagement.html'
            });
            dg.ShowDialog();
        }


        function updateImageManagement() {
            var chk_value = [];//定义一个数组
            $("input[name='imageManagementIds']:checked").each(function () {
                //将选中额数据存到数组里
                chk_value.push($(this).val());
            });
            var id = chk_value[0];
            if(chk_value.length==1){
                var dg = new $.dialog({
                    title:'修改图片管理信息',
                    id:'imageManagement_edit',
                    width:360,
                    height:490,
                    iconTitle:false,
                    cover:true,
                    maxBtn:false,
                    resize:false,
                    page:'updateImageManagement.html?id='+id
                });
                dg.ShowDialog();
            }else {
                alert("请选择一条记录!")
            }
        }


        function deleteImageManagement() {
            var chk_value = [];//定义一个数组
            $("input[name='imageManagementIds']:checked").each(function () {
                //将选中额数据存到数组里
                chk_value.push($(this).val());
            });
            if (chk_value.length == 0) {
                alert("你还没有选择任何内容！");
            }
            if (chk_value.length > 0) {
                console.log(chk_value);
                if(confirm("确定要删除该记录？")){
                    var url = "deleteImageManagement.html?chk_value=" + chk_value;
                    $.get(url,function(data){
                        if(data=="success"){
                            document.location.reload();
                        }
                    });
                }
            }
        }



        function placedTopImageManagement() {
            var chk_value = [];//定义一个数组
            $("input[name='imageManagementIds']:checked").each(function () {
                //将选中额数据存到数组里
                chk_value.push($(this).val());
            });
            if (chk_value.length == 0) {
                alert("你还没有选择任何内容！");
            }
            if (chk_value.length > 0) {
                console.log(chk_value);
                if(confirm("确定要置顶该记录？")){
                    var url = "updateImageManagementPlacedTop.html?chk_value=" + chk_value;
                    $.get(url,function(data){
                        if(data=="success"){
                            document.location.reload();
                        }
                    });
                }
            }
        }


        function cancelTopImageManagement() {
            var chk_value = [];//定义一个数组
            $("input[name='imageManagementIds']:checked").each(function () {
                //将选中额数据存到数组里
                chk_value.push($(this).val());
            });
            if (chk_value.length == 0) {
                alert("你还没有选择任何内容！");
            }
            if (chk_value.length > 0) {
                console.log(chk_value);
                if(confirm("确定要取消该记录的置顶？")){
                    var url = "updateImageManagementCancelPlacedTop.html?chk_value=" + chk_value;
                    $.get(url,function(data){
                        if(data=="success"){
                            document.location.reload();
                        }
                    });
                }
            }
        }

        $('.main_info td').css({"white-space": "nowrap","text-overflow": "ellipsis","overflow": "hidden"});

    </script>

</body>
</html>
