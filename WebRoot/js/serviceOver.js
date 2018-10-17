function ellipsis(str, length) {
    return str.length <= length ? str : (str.substr(0, length) + '...');
};
var yuming = 'http://localhost:8080';
//查询双创时间轴列表
$(function() {
    $.ajax({
        type: "post",
        data: "",
        url: 'http://localhost:8080/front/selectTimeLineInfo.html',
        dataType: "json",
        beforeSend: function(xhr) {},
        success: function(rs) {
            // console.log(rs)
            var html = "";
            for (var i = 0; i < rs.length; i++) {
                html += '<a href="" class="soBanner' + (i + 1) + '" >' + rs[i].name + '</a>';
            }
            $('#soBanner').append(html);
        }
    });
});
//查询办事指南列表
$(function() {
    var type = "1";
    getInfo(type);
});
function changeType(newType){
    type = newType;
}
//查询小微企业扶持政策id

$(function() {
        $('.list').click(function(){
            $(".zcservice").html('')
            $(".sertit>b").html("创业者服务")
            for (var i = 0; i < 2; i++) {
                $('.list1').removeClass('over');
                $('.list').removeClass('over');
            }
            $('.list').addClass('over');
            var html = '<a href="">' + '<img src="/imgs/shuishou.png">' + '</a>' + '<a href="javascript:;" id="xiaoweiqiye">' + '<img src="/imgs/xwqy.png">' + '</a>' + '<a href="">' + '<img src="/imgs/jijin.png">' + '</a>'
            $(".zcservice").html(html);
            $(".soBanner").show(0)
            $(".sertit2L").show(0)
            changeType("1");
            // var type = JSON.stringify(cyzfw);
            getInfo(type);
            $("#cyzfw").show().siblings("ul").hide();
            $("#cyzfw").empty();
            $("#loading-1").show().siblings("#loading-2").hide();
        });
        $('.list1').click(function() {
            $(".zcservice").html('')
            $(".sertit>b").html("孵化器及众创空间服务")
            for (var i = 0; i < 2; i++) {
                $('.list1').removeClass('over');
                $('.list').removeClass('over');
            }
            $('.list1').addClass('over');
            var html = '<a href="serviceAppr.html">' + '<img src="/imgs/fuhuaqi.png">' + '</a>'
            $(".zcservice").html(html)
            $(".soBanner").hide(0)
            $(".sertit2L").hide(0)
            changeType("2");
            getInfo(type);
            $("#fhq").show().siblings("ul").hide();
            $("#fhq").empty();
            $("#loading-2").show().siblings("#loading-1").hide();
        })
        
    });
function getInfo(type){
    $.ajax({
        type: "post",
        data: "",
        dataType:"json",
        url: 'http://localhost:8080/front/selectGuideManagementInfo.html?type1='+type,
        success: function(rs) {
            console.log(rs);
            var html = "";
            for (var i = 0; i < rs.length; i++) {
                var shortContent = ellipsis(rs[i].introduction, 220);
                html += '<li class="listCon">' + '<div class="listBox">' + '<a href="" target="_blank"><span></span>' + rs[i].name + '</a>' + '<div class="detailAll">' + '<div class="listDetail">' + '<p>' + shortContent + '</p>' + '<em>发布时间：' + rs[i].reportDate + '</em><span>来源：<i>' + rs[i].source + '</i></span>' + '</div>' + '</div>' + '</div>' + ' </li>';
            }
            if (type==1){
                $('#cyzfw').append(html);
            } else {
                $('#fhq').append(html);
            }

          
            for (var i = 0; i < $(".listCon").length; i++) {
                if (i <9) {
                    $(".listCon:nth-child(" + ~~(i + 1) + ")>.listBox>a>span").html(~~(i + 1) + ".")
                } else {
                    $(".listCon:nth-child(" + ~~(i + 1) + ")>.listBox>a>span").css({
                        "left": "-26px"
                    });
                    $(".listCon:nth-child(" + ~~(i + 1) + ")>.listBox>a>span").html(~~(i + 1) + ".");
                }
            }
        },
        error:function(){
            console.log("error");
        },
        complete:function () {
            console.log("finish");
        }
    });
}
/*function get_fhq(url, type){
    $.ajax({
        type: "post",
        data: {"type":type},
        url: 'http://localhost:8080/front/selectGuideManagementInfo.html?pageNum=1&pageSize=10',
        dataType: "json",
        beforeSend: function(xhr) {},
        success: function(rs) {
            var html = "";
            for (var i = 0; i < rs.length; i++) {
                var shortContent = ellipsis(rs[i].introduction, 220);
                html += '<li class="listCon">' + '<div class="listBox">' + '<a href="" target="_blank"><span></span>' + rs[i].name + '</a>' + '<div class="detailAll">' + '<div class="listDetail">' + '<p>' + shortContent + '</p>' + '<em>发布时间：' + rs[i].reportDate + '</em><span>来源：<i>' + rs[i].source + '</i></span>' + '</div>' + '</div>' + '</div>' + '</li>';
            };
            $('#fhq').append(html);
            for (var i = 0; i < $(".listCon").length; i++) {
                if (i <9) {
                    $(".listCon:nth-child(" + ~~(i + 1) + ")>.listBox>a>span").html(~~(i + 1) + ".")
                } else {
                    $(".listCon:nth-child(" + ~~(i + 1) + ")>.listBox>a>span").css({
                        "left": "-26px"
                    });
                    $(".listCon:nth-child(" + ~~(i + 1) + ")>.listBox>a>span").html(~~(i + 1) + ".")
                }
            }
        }
    });
}*/
