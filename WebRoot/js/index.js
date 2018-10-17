function ellipsis(str, length) {
    return str.length <= length ? str : (str.substr(0, length) + '...');
};
$(function(){
	function slider(m,y,tt){
        // 滑动特效
		var startX = 0, startY = 0; //触摸开始时手势横纵坐标
        var temPos; //滚动元素当前位置
        var iCurr = 0; //当前滚动屏幕数
        var oPosition = {}; //触点位置
        var num = 2;
        var clone=m.children('li').first().clone();
        var ww =  parseInt(m.children('li').css('width'));
        m.append(clone);
        var size =  m.children('li').size();
        //左滑
        function move_left(){
			iCurr++;
	        if(iCurr==size){
	           m.css({left:0});
	            iCurr=1;
	        }
	        m.stop().animate({left:-iCurr*ww},400);
	        if(iCurr==size-1){
	            y.eq(0).addClass("on").siblings().removeClass("on");
	            tt.eq(0).addClass("active").siblings().removeClass("active");
	        }
	        else{
	            y.eq(iCurr).addClass("on").siblings().removeClass("on");
	            tt.eq(iCurr).addClass("active").siblings().removeClass("active");
	        }
		}
		// 右滑
		function move_right(){
			iCurr--;
	        if(iCurr==-1){
	            m.css({left:-(size-1)*ww});
	            iCurr=size-2;
	        }
	        m.stop().animate({left:-iCurr*ww},400);
	        y.eq(iCurr).addClass("on").siblings().removeClass("on");
	        tt.eq(iCurr).addClass("active").siblings().removeClass("active");
		}
		var t = setInterval(move_left,3800);
		if (m.selector == '.erweima-wrap .list-wrap') {
			clearInterval(t);
		}
		m.hover(function(){
			clearInterval(t);
		},function(){
			t = setInterval(move_left,3800);
			if (m.selector == '.erweima-wrap .list-wrap') {
				clearInterval(t);
			}
		});
		// 划入小圆点
		y.hover(function(){
			m.stop().animate({left:-($(this).index())*ww},400);
			$(this).addClass('on').siblings().removeClass('on');
            tt.eq($(this).index()).addClass("active").siblings().removeClass("active");
			clearInterval(t);
		},function(){
			t = setInterval(move_left,3800);
			if (m.selector == '.erweima-wrap .list-wrap') {
				clearInterval(t);
			}
		});
		// 划入按钮
		$('#index-prev').hover(function(){
			clearInterval(t);
		},function(){
			t = setInterval(move_left,3800);
		});
		$('#index-next').hover(function(){
			clearInterval(t);
		},function(){
			t = setInterval(move_left,3800);
		});
		//按钮点击
		$('#index-prev').on('click',function(){
			move_right();
		});
		$('#index-next').on('click',function(){
			move_left();
		});
    }
    // 双创服务选项卡
    $('#fuwu-tab .tab-btn').each(function(){
    	$(this).on('click',function(){
    		$(this).addClass('active').siblings().removeClass('active');
    		$('#fuwu-content>div').eq($(this).index()).addClass('active').siblings().removeClass('active');
    	})
    });

    // 双创活动选项卡
    $('#schd-tab .tab-btn').each(function(){
    	$(this).on('click',function(){
    		$(this).addClass('active').siblings().removeClass('active');
    	})
    });
    lunboAjax();


    function lunboAjax(){

		$('#index-title-ul li').eq(0).addClass('active');
		slider($('#index-slider-body'),$('#index-focus span'),$('#index-title-ul li'));
    }

    shortContent();

    /**
     * 简写
     */
    function shortContent(){
    	var schdList = $("#schd-list p.content");
    	$(schdList).each(function(index,element){
    		var shortContent = CF.ellipsis(schdList[index].innerText,30);
    		schdList[index].innerText = shortContent;
    	});
    	var xinzhengList = $("#xinzheng-list p.p2");
    	$(xinzhengList).each(function(index,element){
    		var shortContent = CF.ellipsis(xinzhengList[index].innerText,80);
    		xinzhengList[index].innerText = shortContent;
    	});
    	var buweiList = $("#buwei-list p.p2");
    	$(buweiList).each(function(index,element){
    		var shortContent = CF.ellipsis(buweiList[index].innerText,60);
    		buweiList[index].innerText = shortContent;
    	});
    	var jidiList = $("#jidi-list p.p1");
    	$(jidiList).each(function(index,element){
    		var shortContent = CF.ellipsis(jidiList[index].innerText,25);
    		jidiList[index].innerText = shortContent;
    	});

    	var shttList = $("#shtt-list p.p1");
    	$(shttList).each(function(index,element){
    		var shortContent = CF.ellipsis(shttList[index].innerText,25);
    		shttList[index].innerText = shortContent;
    	});
    	var difangList = $("#difang-list p.p1");
    	$(difangList).each(function(index,element){
    		var shortContent = CF.ellipsis(difangList[index].innerText,25);
    		difangList[index].innerText = shortContent;
    	})
    }


    // 查询首页banner轮播图
  	$.ajax({
        type: "post",
        url:'http://localhost:8080/front/selectDynamicManagement.html?limit=4',
        dataType: "json",
        async:false,
        success: function(rs) {
 				var html1 = '';
 				var html2 = '';
 				var html3 = '';
                $.each(rs , function(index , item){
                    html1 += '<li><a href="skipDynamicDetails.html?id='+item.id+'" target="_blank"><img  src="'+item.fileURL+'" class="lunbotu" ></a></li>';
                    html2 += '<li><a href="skipDynamicDetails.html?id='+ item.id +'" target="_blank">'+ item.name +'</a></li>'
                    html3 += '<span class="on"></span>'
                });
 				$('#index-slider-body').append(html1);
 				$('#index-title-ul').append(html2);
 				$('#index-focus').append(html3);
 				$('#index-title-ul li').eq(0).addClass('active');
 				slider($('#index-slider-body'),$('#index-focus span'),$('#index-title-ul li'));

        }
    });

    //部委信息
	$.ajax({
		type: "post",
		url: 'http://localhost:8080/front/selectBuWei.html?limit=2',
		dataType: "json",
        async:false,
		success: function(rs) {
			var html = "";
			$.each(rs , function(index , item){
				var shortContent = ellipsis(item.introduction,50);
			   html += '<li>'+
                	'<a href="skipDynamicDetails.html?id='+item.id+'" target="_blank" >'+
                    '<div class="left">'+
                    '<img src="'+item.fileURL+'">'+
                    '</div>'+
                    '<div class="right">'+
                    '<p class="p1">'+item.name+'</p>'+
                    '<p class="p2">'+shortContent+'</p>'+
                	'<p class="p3">'+
                    '<label class="label1">来源：'+item.source+'</label>'+
					'<label class="label2">'+item.date+'</label>'+
					'</p>'+
					'</div>'+
					'</a>'+
					'</li>';
			});
			$('#buwei-list').append(html);
		}
	});


    $.ajax({
        type: "post",
        data: "",
        url: 'http://localhost:8080/front/weeklyCleaningAction.html',
        beforeSend: function(xhr) {
        },
        success: function(rs) {

        }
    });


    $.ajax({
        type: "post",
        data: "",
        url: 'http://localhost:8080/front/mouthlyCleaningAction.html',
        beforeSend: function(xhr) {
        },
        success: function(rs) {

        }
    });


    $.ajax({
        type: "post",
        data: "",
        url: 'http://localhost:8080/front/quarterCleaningAction.html',
        beforeSend: function(xhr) {
        },
        success: function(rs) {

        }
    });

    $.ajax({
        type: "post",
        data: "",
        url: 'http://localhost:8080/front/annualCleaningAction.html',
        beforeSend: function(xhr) {
        },
        success: function(rs) {

        }
    });

    $.ajax({
        type: "post",
        url: 'http://localhost:8080/front/selectShouLu.html',
        dataType: "json",
        async:false,
        success: function(rs) {
            var html = '<a href="'+rs.link+'"><img id="cover" alt="封面图" src="'+rs.fileURL+'" style="width: 100%;height: 100%;"></a>"';
            $('#shoulu-container').append(html);
        }
    });


    $.ajax({
        type: "post",
        url: 'http://localhost:8080/front/selectDiFang.html?limit=4',
        dataType: "json",
        async:false,
        success: function(rs) {
            var html1 = "";
            var html2 = "";
            $.each(rs , function(index , item){
				if (index == 0){
					html1 =
						'<div class="detail">'+
							'<a href="skipDynamicDetails.html?id='+item.id+'" target="_blank">'+
								'<div class="left">'+
								'<img src="'+item.fileURL+'">'+
								'</div>'+
								'<div class="right">'+
								'<p class="p1">'+item.name+'</p>'+
								'<p class="p2"><span>'+item.reportDate+'</span></p>'+
								'</div>'+
							'</a>'+
						'</div>'
				} else {
                    html2 +=
						'<li>'+
							 '<a href="skipDynamicDetails.html?id='+item.id+'" target="_blank">'+
								'<div class="img-wrapper">'+
								'<img src="/imgs/list_arrow_icon.png">'+
								'</div>'+
								'<p class="content">'+item.name+'</p>'+
								'<span class="date">'+item.reportDate+'</span>'+
							'</a>'+
                        '</li>'
				}
            });
            $('#difang-list').append(html1);
            $('#difang-list').append(html2);
        }
    });

    $.ajax({
        type: "post",
        url: 'http://localhost:8080/front/selectTuanTi.html?limit=4',
        dataType: "json",
        async:false,
        success: function(rs) {
            var html1 = "";
            var html2 = "";
            $.each(rs , function(index , item){
                if (index == 0){
                    html1 =
                        '<div class="detail">'+
                        '<a href="skipDynamicDetails.html?id='+item.id+'" target="_blank">'+
                        '<div class="left">'+
                        '<img src="'+item.fileURL+'">'+
                        '</div>'+
                        '<div class="right">'+
                        '<p class="p1">'+item.name+'</p>'+
                        '<p class="p2"><span>'+item.reportDate+'</span></p>'+
                        '</div>'+
                        '</a>'+
                        '</div>'
                } else {
                    html2 +=
                        '<li>'+
                        '<a href="skipDynamicDetails.html?id='+item.id+'" target="_blank">'+
                        '<div class="img-wrapper">'+
                        '<img src="/imgs/list_arrow_icon.png">'+
                        '</div>'+
                        '<p class="content">'+item.name+'</p>'+
                        '<span class="date">'+item.reportDate+'</span>'+
                        '</a>'+
                        '</li>'
                }
            });
            $('#shtt-list').append(html1);
            $('#shtt-list').append(html2);
        }
    });
    $.ajax({
        type: "post",
        url: 'http://localhost:8080/front/selectJiDi.html?limit=4',
        dataType: "json",
        async:false,
        success: function(rs) {
            var html1 = "";
            var html2 = "";
            $.each(rs , function(index , item){
                if (index == 0){
                    html1 =
                        '<div class="detail">'+
                        '<a href="skipDynamicDetails.html?id='+item.id+'" target="_blank">'+
                        '<div class="left">'+
                        '<img src="'+item.fileURL+'">'+
                        '</div>'+
                        '<div class="right">'+
                        '<p class="p1">'+item.name+'</p>'+
                        '<p class="p2"><span>'+item.reportDate+'</span></p>'+
                        '</div>'+
                        '</a>'+
                        '</div>'
                } else {
                    html2 +=
                        '<li>'+
                        '<a href="skipDynamicDetails.html?id='+item.id+'" target="_blank">'+
                        '<div class="img-wrapper">'+
                        '<img src="/imgs/list_arrow_icon.png">'+
                        '</div>'+
                        '<p class="content">'+item.name+'</p>'+
                        '<span class="date">'+item.reportDate+'</span>'+
                        '</a>'+
                        '</li>'
                }
            });
            $('#jidi-list').append(html1);
            $('#jidi-list').append(html2);
        }
    });




    $.ajax({
        type: "post",
        url: 'http://localhost:8080/front/selectChuangXinShiYan.html?limit=3',
        dataType: "json",
        async:false,
        success: function(rs) {
            var html = "";
            $.each(rs , function(index , item){
             	html +=
				'<li>'+
					'<a href="" target="_blank">'+
						'<span>●</span>'+item.name+
					'</a>'+
                '</li>'
            });
            $('#qcg-index').append(html);
        }
    });

    $.ajax({
        type: "post",
        url: 'http://localhost:8080/front/selectXinXingChanYe.html?limit=3',
        dataType: "json",
        async:false,
        success: function(rs) {
            var html = "";
            $.each(rs , function(index , item){
                html +=
                    '<li>'+
						'<a href="" target="_blank">'+
							'<span>●</span>'+item.name+
						'</a>'+
                    '</li>'
            });
            $('#zxx-index').append(html);
        }
    });

    $.ajax({
       type: "post",
       data: "",
       url: 'http://localhost:8080/front/selectHuoDongGengZong.html?limit=5&type=1',
       dataType: "json",
       success: function(rs) {
		   var html = '';
           $.each(rs , function(index , item){
               var shortContent = ellipsis(item.name,30);
               html +=
                   	'<li>'+
						'<a href="'+item.link+'">'+
							'<div class="img-wrapper">' +
								'<a href="" class="detail" target="_blank">' +
								'<img src="'+item.fileURL+'">' +
								'</a>' +
							'</div>'+
							'<a href="" class="detail" target="_blank">' +
						   		'<p class="content">'+ shortContent +'</p>' +
						   	'</a>'+
						'</a>'+
				   	'</li>';
           });
               $('#schd-list').append(html);
       }
   });
    //活动跟踪双创周
    $('#schd-scz').on('click',function(){
        $.ajax({
            type: "post",
            data: "",
            url: 'http://localhost:8080/front/selectHuoDongGengZong.html?limit=5&type=1',
            dataType: "json",
            beforeSend: function(xhr) {
                $('#schd-list').empty();
            },
            success: function(rs) {
                var html = '';
                $.each(rs , function(index , item){
                    var shortContent = ellipsis(item.name,30);
                    html +=
                        '<li>'+
                        '<a href="'+item.link+'">'+
                        '<div class="img-wrapper">' +
                        '<a href="" class="detail" target="_blank">' +
                        '<img src="'+item.fileURL+'">' +
                        '</a>' +
                        '</div>'+
                        '<a href="" class="detail" target="_blank">' +
                        '<p class="content">'+ shortContent +'</p>' +
                        '</a>'+
                        '</a>'+
                        '</li>';
                });
                $('#schd-list').append(html);
            }
        });
    });

    // //活动跟踪创想中国
    $('#schd-cxzg').on('click',function(){
        $.ajax({
            type: "post",
            data: "",
            url: 'http://localhost:8080/front/selectHuoDongGengZong.html?limit=5&type=2',
            dataType: "json",
            beforeSend: function(xhr) {
                $('#schd-list').empty();
            },
            success: function(rs) {
                var html = '';
                $.each(rs , function(index , item){
                    var shortContent = ellipsis(item.name,30);
                    html +=
                        '<li>'+
                        '<a href="'+item.link+'">'+
                        '<div class="img-wrapper">' +
                        '<a href="" class="detail" target="_blank">' +
                        '<img src="'+item.fileURL+'">' +
                        '</a>' +
                        '</div>'+
                        '<a href="" class="detail" target="_blank">' +
                        '<p class="content">'+ shortContent +'</p>' +
                        '</a>'+
                        '</a>'+
                        '</li>';
                });
                $('#schd-list').append(html);
            }
        });
    });





//最新政策部委点击
    $('#xinzheng-buwei').on('click',function(){
        $(this).addClass('active').siblings().removeClass('active');
        $.ajax({
            type: "post",
            data: "",
            url: 'http://localhost:8080/front/selectPolicyIssuedByReportUnit.html?limit=2',
            dataType: "json",
            beforeSend: function(xhr) {
                $('#xinzheng-list').empty();
            },
            success: function(rs) {
                var html = "";
                for (var i = 0; i < rs.length; i++) {
                    var shortContent = ellipsis(rs[i].policyIntroduction,80);
                    html += '<li>'+
                        '<a href="skipPolicyDetails.html?id='+rs[i].id+'" target="_blank">'+
                        '<div class="right">'+
                        '<p class="p1">'+ rs[i].name +'</p>'+
                        '<p class="p2">'+ shortContent +'</p>'+
                        '<p class="p3"><label class="label1">发布单位：'+ rs[i].reportUnit +'</label><label class="label2">'+ rs[i].reportDate +'</label></p>'+
                        '</div>'+
                        '</a>'+
                        '</li>';
                }
                $('#xinzheng-list').append(html);
            }
        });
    });
    //最新政策地方点击
    $('#xinzheng-difang').on('click',function(){
        $(this).addClass('active').siblings().removeClass('active');
        $.ajax({
            type: "post",
            data: "",
            url: 'http://localhost:8080/front/selectPolicyIssuedByRegion.html?limit=2',
            dataType: "json",
            beforeSend: function(xhr) {
                $('#xinzheng-list').empty();
            },
            success: function(rs) {
                var html = "";
                for (var i = 0; i < rs.length; i++) {
                    var shortContent = ellipsis(rs[i].policyIntroduction,80);
                    html +='<li>'+
                        '<a href="skipPolicyDetails.html?id='+rs[i].id+'" target="_blank">'+
                        '<div class="right">'+
                        '<p class="p1">'+ rs[i].name +'</p>'+
                        '<p class="p2">'+ shortContent +'</p>'+
                        '<p class="p3"><label class="label1">发布单位：'+ rs[i].reportUnit +'</label><label class="label2">'+ rs[i].reportDate +'</label></p>'+
                        '</div>'+
                        '</a>'+
                        '</li>';
                }
                $('#xinzheng-list').append(html);
            }
        });
    });
    //最新政策更多点击
});
//最新政策部委
$(function(){
    $.ajax({
        type: "post",
        data: "",
        url: 'http://localhost:8080/front/selectPolicyIssuedByReportUnit.html?limit=2',
        dataType: "json",
        beforeSend: function(xhr) {
        },
        success: function(rs) {
            var html = "";
            for (var i = 0; i < rs.length; i++) {
                var shortContent = ellipsis(rs[i].policyIntroduction,80);
                html += '<li>'+
                    '<a href="skipPolicyDetails.html?id='+rs[i].id+'" target="_blank">'+
                    '<div class="right">'+
                    '<p class="p1">'+ rs[i].name +'</p>'+
                    '<p class="p2">'+ shortContent +'</p>'+
                    '<p class="p3"><label class="label1">发布单位：'+ rs[i].reportUnit +'</label><label class="label2">'+ rs[i].reportDate +'</label></p>'+
                    '</div>'+
                    '</a>'+
                    '</li>';
            }
            $('#xinzheng-list').append(html);
        }
    });
});
//月度政策热点
$(function(){
    $.ajax({
        type: "post",
        data: "",
        url: 'http://localhost:8080/front/selectPolicyIssuedByPageView.html?limit=5',
        dataType: "json",
        beforeSend: function(xhr) {
        },
        success: function(rs) {
                var html;
                for (var i = 0; i < rs.length; i++) {
                    if (i==0) {
                        html = '<li>'+
                                    '<a href="skipPolicyDetails.html?id='+rs[i].id+'" target="_blank">'+
                                        '<div class="img-wrapper"><img src="/imgs/hot1.png"></div>'+
                                        '<p class="content">'+ rs[i].name +'</p>'+
                                    '</a>'+
                                '</li>';
                        $('#zhengce-hot-list').append(html);
                    }else if(i==1){
                        html = '<li>'+
                                    '<a href="skipPolicyDetails.html?id='+rs[i].id+'" target="_blank">'+
                                        '<div class="img-wrapper"><img src="/imgs/hot2.png"></div>'+
                                        '<p class="content">'+ rs[i].name +'</p>'+
                                    '</a>'+
                                '</li>';
                        $('#zhengce-hot-list').append(html);
                    }else if(i==2){
                        html = '<li>'+
                                    '<a href="skipPolicyDetails.html?id='+rs[i].id+'" target="_blank">'+
                                        '<div class="img-wrapper"><img src="/imgs/hot3.png"></div>'+
                                        '<p class="content">'+ rs[i].name +'</p>'+
                                    '</a>'+
                                '</li>';
                        $('#zhengce-hot-list').append(html);
                    }else{
                        html = '<li>'+
                                    '<a href="skipPolicyDetails.html?id='+rs[i].id+'" target="_blank">'+
                                        '<div class="img-text-wrapper">'+ (i+1) +'</div>'+
                                        '<p class="content">'+ rs[i].name +'</p>'+
                                    '</a>'+
                                '</li>';
                        $('#zhengce-hot-list').append(html);
                    }
                }

        }

    });
})


