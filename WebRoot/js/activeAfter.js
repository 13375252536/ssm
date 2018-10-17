$(function(){
	$('.right-nav-container li').click(function(){
		$(this).addClass('active').siblings().removeClass('active');
		$('.right-nav-container').removeClass('pa');
		$('.right-nav-container').css({'position':'fixed','top':'30px','margin-left':'1200px'})
	})
	$(window).scroll(function(){
		var wst = $(this).scrollTop();	
		if(wst<479){
			$('.right-nav-container').addClass('pa');
			$('.right-nav-container').css({'position':'absolute','margin-left':'0px','top':'64px'});
		}else{
			$('.right-nav-container').removeClass('pa');
			$('.right-nav-container').css({'position':'fixed','margin-left':'1200px','top':'30px'});
		}
		
	})
	$('.goTop').click(function(){
		$('.right-nav-container li').removeClass('active');
		  timer=setInterval(function(){
           var scrollTop=document.documentElement.scrollTop||document.body.scrollTop;
           var ispeed=Math.floor(-scrollTop/20);
           if(scrollTop==0){
               clearInterval(timer);
           }
           document.documentElement.scrollTop=document.body.scrollTop=scrollTop+ispeed;
       },20)
	})
//banner图
$.ajax({
 	type: "post",
	data: "",
	url: 'http://localhost:8080/front/selectHuoDongGenZongBanner.html?limit=1',
	dataType: "json",
	success: function(rs) {
        for(var i = 0; i < rs.length; i++) {
            $("#banner").html('<img src="'+rs[i].fileURL+'">');
        }

	},
	beforeSend:function(){
		//加载中 xhj
	},
	error:function(){
		//加载异常 xhj
	}
});   

//主要活动-创想中国  
  $.ajax({
 	type: "post",
	data: "",
	url: 'http://localhost:8080/front/selectHuoDongGengZongCXZG.html?limit=3',
	dataType: "json",
	success: function(rs) {
			var ccn = '';
			for(var i = 0; i < rs.length; i++) {
				ccn+='<li><a href="" target="_blank">'+ rs[i].name +'</a><p><em style="color:#6a6566">来源：<b>'+ rs[i].source +'</b></em><i style="color:rgb(140,140,140)">'+ rs[i].reportDate +'</i></p></li>'
		  	}
		  	$("#ccn").html(ccn);			    
	},
	beforeSend:function(){
		//加载中 xhj
	},
	error:function(){
		//加载异常 xhj
	 	}
});     

    //主要活动-双创活动周
	$.ajax({
	 	type: "post",
		data: "",
		url: 'http://localhost:8080/front/selectHuoDongGengZongSCZ.html?limit=3',
		dataType: "json",
		success: function(rs) {
				var scz = '';
				for(var i = 0; i < rs.length; i++) {
					scz+='<li><a href="" target="_blank">'+ rs[i].name +'</a><p><em style="color:#6a6566">来源：<b>'+ rs[i].source +'</b></em><i style="color:rgb(140,140,140)">'+ rs[i].reportDate +'</i></p></li>'
			  	} 			 
			  	$("#scz").html(scz);		     		    	    
		},
		beforeSend:function(){
			//加载中 xhj
		},
		error:function(){
			//加载异常 xhj
		}
	}); 
	function huodonggenzong(cg,pn,obj){
		$.ajax({
		 	type: "post",
			data: "",
			url: 'http://localhost:8080/front/selectActivityCategoryManagementByType.html?category='+ cg +'&pageNum='+ pn +'&pageSize=3',
			dataType: "json",
			success: function(rs) {
				var counts = rs.allCounts;
				var diqu = '';
				var list = rs.list;
                console.log(list.length);
                for(var i = 0; i < list.length; i ++) {
                	console.log("true")
					diqu += '<a href="" target="_blank"><img src="'+list[i].bannerPhotosURL+'"><p>'+list[i].name+'</p><div><em>'+ list[i].areaName +'</em><span>'+ list[i].source +'</span></div></a>';
				}
                obj.append(diqu);
                console.log(diqu);
                if (obj.children('a').length<counts) {
				obj.siblings('.load-more-wrapper').show();
				}else{
				obj.siblings('.load-more-wrapper').hide();
				}
		},
			beforeSend:function(){
				obj.siblings('.load-more-wrapper').append('<img src="/imgs/huanchong.gif" id="huanchong" style="width: 30px;height: 30px;position: absolute;top: 50%;margin-top: -15px;left: 50%;margin-left: -15px;">');
				obj.siblings('.load-more-wrapper').hide();
		        obj.append('<img src="/imgs/huanchong.gif" id="huanchong2" style="width: 30px;height: 30px;position: absolute;top: 50%;margin-top: -15px;left: 50%;margin-left: -15px;">');
			},
			error:function(){
				
			},
			complete:function(){
				$('#huanchong').remove();
				$('#huanchong2').remove();
			}
		});  
	}
	huodonggenzong(0,1,$("#buwei .ConBoxDet"));
	huodonggenzong(1,1,$("#diqu .ConBoxDet"));
	huodonggenzong(2,1,$("#jidi .ConBoxDet"));
	huodonggenzong(3,1,$("#tuanti .ConBoxDet"));
	var buwei_more_num = 1;
    var diqu_more_num = 1;
    var jidi_more_num = 1;
    var tuanti_more_num = 1;
	$('#buwei-more').click(function(){
	 	buwei_more_num++;
	 	huodonggenzong(0,buwei_more_num,$("#buwei .ConBoxDet"));
	});
	$('#difang-more').click(function(){
	 	diqu_more_num++;
	 	huodonggenzong(1,diqu_more_num,$("#diqu .ConBoxDet"));
	});
	$('#jidi-more').click(function(){
	 	jidi_more_num++;
	 	huodonggenzong(2,jidi_more_num,$("#jidi .ConBoxDet"));
	});
	$('#tuanti-more').click(function(){
	 	tuanti_more_num++;
	 	huodonggenzong(3,tuanti_more_num,$("#tuanti .ConBoxDet"));
	});
});
//监听滚动条位置       
	  window.addEventListener("scroll",function(e){
			var window =document.documentElement.scrollTop||document.body.scrollTop;
			var body = $(".actList").height();
			//console.log(body)
			if(window>0&&window<body*0.2){
			$(".right-nav-container").children("li").eq(0).addClass("active").siblings().removeClass("active")
			}
			if(window>body*0.2&&window<body*0.4){
				$(".right-nav-container").children("li").eq(1).addClass("active").siblings().removeClass("active")
			}
			if(window>body*0.4&&window<body*0.6){
				$(".right-nav-container").children("li").eq(2).addClass("active").siblings().removeClass("active")
			}
			if(window>body*0.6&&window<body*0.8){
				$(".right-nav-container").children("li").eq(3).addClass("active").siblings().removeClass("active")
			}
			if(window>body*0.8&&window<body*1){
				$(".right-nav-container").children("li").eq(4).addClass("active").siblings().removeClass("active")
			}
		});
