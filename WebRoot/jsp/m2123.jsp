<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/9/18
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    $("#condition1").change(function(event){
        $.ajax({
            url:getRootPath()+"/df/data_append/select_condition1.do",
            data:{condition:condition_name},
            type:"POST",
            dataType:"json",
            timeout:5000,
            success:function(json){
                var select_option;
                $.each(json.selected_option_value,function(i, item){
                    select_option = item;
                });
                var options_str = "";
                $("#condition1").html("");
                $.each(json.options,function(i, item){
                    options_str += "<option value=\"" + item.value + "\" >" + item.label + "</option>";
                });
                $("#condition1").append(options_str);
            },
            error:function(xhr, status){
                alert("error");
            }
        })});
</script>
</body>
</html>
