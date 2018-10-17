<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/8/22
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Test</title>
    <link type="text/css" rel="stylesheet" href="../css/main.css"/>
</head>
<body>

    <form action="/student.html" method="post" name="studentForm" id="studentForm">
        <div class="search_div">
            学生学号:<input type="text" name="sno" value="${student.sno}" size="15"/>
            学生姓名:<input type="text" name="name" value="${student.name}" size="15"/>
            学生年龄:<input type="text" name="age" value="${student.age}" size="15"/>
            学生性别:<select name="gender" id="gender" style="vertical-align: middle;">
                <option value="">请选择</option>
               <c:forEach items="${genderList}" var="gender">
                   <option>${gender}</option>
               </c:forEach>
            </select>
            学生班级:<select name="grade" id="grade" style="vertical-align: middle;">
            <option value="">请选择</option>
            <c:forEach items="${gradeList}" var="grade">
                <option>${grade}</option>
            </c:forEach>
        </select>
            学生身份证号:<input type="text" name="idNum" value="${student.idNum}" size="15"/>
            <a href="javascript:search();" class="myBtn"><em>查询</em></a>
        </div>
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table">
            <tr class="main_head" style="font-size: 15px">
                <th><input type="checkbox" name="sltAll" id="sltAll" onclick="sltAllStudent()"/></th>
                <th>序号</th>
                <th>学生照片</th>
                <th>学生学号</th>
                <th>学生姓名</th>
                <th>学生年龄</th>
                <th>学生性别</th>
                <th>学生班级</th>
                <th>身份证号</th>
                <th>操作</th>
            </tr>
            <c:choose>
                <c:when test="${not empty selectStudent}">
                    <c:forEach items="${selectStudent}" var="student" varStatus="vs">
                        <tr class="main_info">
                            <td><input type="checkbox" name="studentIds" id="studentIds${student.id}" value="${student.id}"/></td>
                            <td>${vs.index+1}</td>
                            <td><img src="${student.portrait}" style="width: 30px;height: 30px"></td>
                            <td>${student.sno}</td>
                            <td>${student.name}</td>
                            <td>${student.age}</td>
                            <td>${student.gender}</td>
                            <td>${student.grade}</td>
                            <td>${student.idNum}</td>
                            <td style="font-size: 15px"><a href="javascript:editStudent(${student.id});">修改</a> | <a href="javascript:delStudent(${student.id});">删除</a> | <a href="javascript:delPortrait(${student.id});">删除照片</a></td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr class="main_info">
                        <td colspan="7">没有相关数据</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </table>
        <div class="page_and_btn">
            <div>
                <a href="javascript:addStudent();" class="myBtn"><em>新增</em></a>
            </div>
                ${student.page.pageStr}
        </div>
    </form>

    <script type="text/javascript" src="../js/jquery-1.5.1.min.js"></script>
    <script type="text/javascript" src="../js/datePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="../js/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $(".main_info:even").addClass("main_table_even");
        });
        function sltAllStudent(){
            if($("#sltAll").attr("checked")){
                $("input[name='studentIds']").attr("checked",true);
            }else{
                $("input[name='studentIds']").attr("checked",false);
            }
        }
        
        
        function addStudent() {
            var dg = new $.dialog({
                title:'新增学生信息',
                id:'student_new',
                width:330,
                height:400,
                iconTitle:false,
                cover:true,
                maxBtn:false,
                xButton:true,
                resize:false,
                page:'student/insertStudent.html'
            });
            dg.ShowDialog();
        }

        function delStudent(id){
            if(confirm("确定要删除该记录？")){
                var url = "student/deleteStudent.html?id="+id;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
        function delPortrait(id) {
            if(confirm("确定要删除此人照片？")){
                var url = "student/deletePortrait.html?id="+id;
                $.get(url,function(data){
                    if(data=="success"){
                        document.location.reload();
                    }
                });
            }
        }
       function editStudent(id) {
           var dg = new $.dialog({
               title:'修改用户',
               id:'user_edit',
               width:330,
               height:400,
               iconTitle:false,
               cover:true,
               maxBtn:false,
               resize:false,
               page:'student/updateStudent.html?id='+id
           });
           dg.ShowDialog();
       }

        function search(){
            $("#studentForm").submit();
        }


    </script>
</body>
</html>
