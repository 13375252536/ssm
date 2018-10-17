$(function() {
//----头部----------------------------
    var header = '<div class="headAll"><div class="header">'
        + '<a class="iBlock" href="home.html"><img src="/imgs/logo.png"></a>'
        + '<div class="searchBox fr">'
        + '<form class="search" action="" method="post">'
        + '<input class="sWord" type="text" placeholder="站内搜索" id="search-input"/>'
        + '<input class="sBtn" name="Submit" value="" id="search-btn"/>'
        + '</form>'
        + '<ul class="fix">'
        + '<li class="mobile"><img src="/imgs/mobileMa.png"></li>'
        + '<li class="weixin"></li>'
        + '<li class="sina"></li>'
        + '</ul>'
        + '</div>'
        + '</div>'
        + '</div>'
        + '<div class="headNav">'
        + '<div>'
        + '<a href="home.html">首页</a>'
        + '<a href="skipPolicyDynamic.html">政策库<i id="gozcdt">政策动态</i><i class="navindex2" id="gozck">政策查询</i></a>'
        + '<a href="skipPolicyAnalysis.html">政策分析</a>'
        + '<a href="demonstrationBase.html">示范基地<i id="gojddt">基地动态</i><i class="navindex2" id="jdk">基地库</i></a>'
        + '<a href="skipActivityTracking.html">活动跟踪</a>'
        + '<a href="skipServiceDevelopment.html">服务拓展</a>'
        + '<a class="navLineNo" href="insertMakeRecommendations.html">建言献策</a>'
        + '</div>'
        + '</div>';
    $('body').prepend(header);
//---底部---------------------------------------
    var foot =
        '<div>'
        +'<a class="TopBack">'
        +'<span>Top</span>'
        +'</a>'
        +'</div>'
        +'<div class="footAbout">'
        + '<div align="center" class="foot">'
        + '<img src="/imgs/party.png" style="left: 0;top:30px;">'
        + '<ul >'
        + '<li><a href="" style="border-left:0;">关于本网</a><a href="">网站声明</a><a href="">网站地图</a><a href="">联系我们</a></li>'
        + '<li>主办单位：中华人民共和国国家发展和改革委员会 京ICP备05052393号</li>'
        + '<li>技术支持：国家信息中心 国信优易数据有限公司</li>'
        + '<li>国家发展和改革委员会 版权所有，如需转载，请注明来源</li>'
        + '</ul>'
        + '<img src="/imgs/mobileMa.png" style="position: absolute;right: 0;top:15px;width:95px;">'
        + '</div>'
        + '</div>';
    $('body').append(foot);
//页头ajax   begin
    $.ajax({
        type: "post",
        url: 'http://localhost:8080/front/selectQrCode.html',
        dataType: "json",
        async: false,
        success: function (rs) {
            $(".weixin").append('<img src="' + rs.weixin + '" style="width: 120px;height: 120px">');
            $(".sina").append('<img src="' + rs.sina + '" style="width: 120px;height: 120px">');
        }
    });


    $('#gozcdt').click(function(e){
        e = e || window.event;
        if(e.preventDefault) {
            e.preventDefault();
        }else{
            e.returnValue = false;
        }
        window.location.href = 'http://localhost:8080/front/skipPolicyDynamic.html';
    });
    $('#gozck').click(function(e){
        e = e || window.event;
        if(e.preventDefault) {
            e.preventDefault();
        }else{
            e.returnValue = false;
        }
        window.location.href = 'http://localhost:8080/front/skipPolicyLibrary.html';
    });

    $('#gojddt').click(function(e){
        e = e || window.event;
        if(e.preventDefault) {
            e.preventDefault();
        }else{
            e.returnValue = false;
        }
        window.location.href = 'demonstrationBase.html';
    });
    $('#jdk').click(function(e){
        e = e || window.event;
        if(e.preventDefault) {
            e.preventDefault();
        }else{
            e.returnValue = false;
        }
        window.location.href = 'skipBaseLibrary.html';
    });
    //回到顶部
    $(".TopBack").click(function(){
        timer=setInterval(function(){
            var scrollTop=document.documentElement.scrollTop||document.body.scrollTop;
            var ispeed=Math.floor(-scrollTop/20);
            //console.log(ispeed)
            if(scrollTop==0){
                clearInterval(timer);
            }
            document.documentElement.scrollTop=document.body.scrollTop=scrollTop+ispeed;
        },20)
    });
});