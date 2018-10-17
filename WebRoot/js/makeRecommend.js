    $(function() {
        changeCode();
        $("#changeCode").bind("click", changeCode);
        $("#codeImg").bind("click", changeCode);
        $.ajax({
            url : 'http://localhost:8080/front/selectSuggestionsAndGuidelines.html',
            type : "POST",
            dataType : "json",
            success : function(data) {
                var html="";
                for (var i = 0; i < data.length; i++) {
                    var arr = data[i].content.replace(/\n/g, "<br/>").split("<br/>");
                    html+="<dd class=\"welcome\">"+ arr[0]+"</dd>";
                    for (var int = 1; int < arr.length; int++) {
                        html+="<dd>"+arr[int]+"</dd>";
                    }
                }
                $("#message1").append(html);
            }
        });
    });
//校验
function check() {
    if($("#name").val()==""){
		alert("姓名不得为空")
		$("#name").focus();
		return false;
	}else if($("#name").val().length>20){
		alert("姓名长度不得超过20字符");
		$("#name").focus();
		return false;
	}

	if($("#phone").val()==""){
	    alert("联系电话不能为空");
		$("#phone").focus();
		return false;
	}else {
        var phone = $("#phone").val();
        if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(phone))){
         alert("手机号码格式不正确");
            $("#phone").focus();
            return false;
        }
	}
    if($("#email").val()==""){
		alert("邮箱不得为空");
		$("#email").focus();
		return false;
	}else {
    	var email = $("#email").val();
        var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        res= reg.test(email );
        if (!res) {
           alert("邮箱格式不正确");
            $("#email").focus();
            return false;
        }
	}
	if($("#title").val()==""){
		alert("标题不得为空");
		$("#title").focus();
		return false;
	}else if($("#title").val()!=""){
		if($("#title").val().length>25){
			alert("标题长度不得超过25");
			$("#title").focus();
	 		return false;
		}
	}
	if($("#content").val()==""){
		alert("内容不得为空");
    $("#content").focus();
		return false;
	}else if($("#content").val().length>500){
			alert("内容长度不得超过500");
			$("#content").focus();
	 		return false;
	}
    var code = $("#code").val();
    if (code == "") {
        alert("验证码不得为空");
        $("#code").focus();
        return false;
    }else{
        $.ajax({
            type: "POST",
            url: 'http://localhost:8080/code/checkCode.html',
            data: {"code": code},
            dataType: 'json',
            cache: false,
            success: function (data) {
                if ("success" == data.msg) {
                    var arr = $('#adviceForm').serialize();
                    $.ajax({
                        type: "POST",
                        url: 'http://localhost:8080/front/saveMakeRecommendations.html',
                        data: arr,
                        cache: false,
                        success: function (rs) {
                            alert("建言献策提交成功！");
                            window.location.reload();
                        }
                    });
                } else {
                    alert("验证码错误");
                    $("#code").val("");
                    $("#code").focus();
                    return false;
                }
            }
        });
    }
}

function reWrite(){
    if(confirm("确定要重置信息吗？")){
        window.location.reload();
        }
}

function changeCode() {
    $("#codeImg").attr("src", "http://localhost:8080/code/getCode.html?t="+genTimestamp());
}
function genTimestamp() {
    var time = new Date();
    return time.getTime();
}
