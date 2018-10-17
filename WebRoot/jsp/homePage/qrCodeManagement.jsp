<%--
  Created by IntelliJ IDEA.
  Author: Mr.Chan
  Date: 2018/8/28
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Test</title>
    <style>

        img{
            width: 100px;
            height: auto;
        }
    </style>
</head>
<body>
<form action="saveQrCodeManagement.html" method="post"  name="qrCodeManagementForm" id="qrCodeManagementForm"  onsubmit="return checkInfo();"  enctype="multipart/form-data">
    <table align="center" style="border-collapse:separate; border-spacing:0px 10px;margin-top: 50px">
        <tr style="line-height: 50px">
            <td><label>请选择文件:</label></td>
            <td>
            <input type="file" name="file" id="file" accept="image/*"/>
            </td>
        </tr>
        <tr style="line-height: 50px">
            <td><label>二维码类型:</label></td>
            <td>
                <select name = "category" id="category">
                    <option>微博</option>
                    <option>微信</option>
                </select>
            </td>
        </tr>
        <tr style="line-height: 50px"> <td>图片预览:</td><td class="imgbox"></td></tr>
        <tr>
            <td>微博原图</td>
            <td><img src="${selectURLByWeiBo}"></td>
        </tr>
        <tr>
            <td>微信原图</td>
            <td><img src="${selectURLByWeiXin}"></td>
        </tr>
        <tr><td style="text-decoration: none;text-align:center"><button  id="submit" type="submit">提交</button></td></tr>
    </table>



</form>
<script type="text/javascript" src="../../js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="../../js/datePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../../js/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
<script>
    function checkInfo(){
            if ($('#file').val()==""||$('#file').val()==null) {
                alert("请上传二维码!");
                $("#file").focus();
                return false;
        }
    }

    $(function(){
        $('#file').change(function () {
            $('.imgBox').html("");
            var imgArr = []; //获取的图片地址
            var fileList = $(this)[0].files;   //或获取的图片文件
            var Length = fileList.length;
            for ( var i = 0; i < Length; i++ ) {
                var imgUrl = window.URL.createObjectURL(fileList[i]); //获取图片地址
                imgArr.push(imgUrl);
                console.log(imgArr);
                var $img = $("<img class='img'>");
                $('.imgBox').append($img);
                $img.attr('src', imgArr[i]);
            }
        });
    })


</script>
</body>
</html>
