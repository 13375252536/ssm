function ellipsis(str, length) {
    return str.length <= length ? str : (str.substr(0, length) + '...');
}
$(function(){
    $.ajax({
        type: "post",
        data: "",
        url: 'http://localhost:8080/front/selectAllRegionList.html',
        dataType: "json",
        success: function(rs) {
        	var html = "";
        	$.each(rs,function (index, item) {
				html += '<option value = "'+item.id+'">'+item.name+'</option>';
            });
        	$(".query .province").append(html);
		}
	});

	layui.use('laypage', function(){
		var laypage = layui.laypage;
		var batch_change = "";
		var type_change = "";
		window.jidikuRequest = function() {
            var areaId = $(".query .province option:selected").val();
            var baseName = $("#baseName").val();
            $.ajax({
                type: "post",
                data: "",
                url: 'http://localhost:8080/front/selectJiDiKuDongTaiXingXi.html?pageNum=1&pageSize=10&type=' + type_change + '&batch=' + batch_change + '&areaId=' + areaId + '&baseName=' + baseName +'',
                dataType: "json",
                beforeSend: function (xhr) {
                    $('#jidiku-news-list-ul').empty();
                    $('#jidiku-fenye').show();
                },
                success: function (rs) {
                    var html1 = "";
                    var html2 = "";
                    if (rs.length == 1) {
                        $('#jidiku-news-list-ul').append('<div style="text-align:center;margin-top:30px;padding-bottom:30px;"><p>没有相关数据</p></div>');
                        $('#jidiku-fenye').hide();
                        return;
                    }
                    var pici;
                    var leixing;
                    for (var i = 0; i < rs.length - 1; i++) {
                        var shortContent = ellipsis(rs[i][0].firstContent, 65);
                        pici = rs[i][0].batch;
                        leixing = rs[i][0].type;
                        html1 = '<li>' +
                            '<div class="left">' +
                            '<a href="" target="_blank">' +
                            '<div class="img-wrapper"><img src="' + rs[i][0].fileURL + '" onload="imgCenter(this)"></div>' +
                            '<div class="article">' +
                            '<p class="p1">' + rs[i][0].name + '</p>' +
                            '<p class="p2">' + shortContent + '</p>' +
                            '<p class="p3"><span class="org">' + pici + '</span><span class="b-blue">' + leixing + '</span></p>' +
                            '</div>' +
                            '</a>' +
                            '</div>' +
                            '<div class="right">' +
                            '<p class="title">最新动态</p>' +
                            '<ul class="jidiku-list-zuixin">' +
                            '</ul>' +
                            '</div>' +
                            '</li>';
                        $('#jidiku-news-list-ul').append(html1);
                        var dynamicList = rs[i][1].dynamicList;
                        for (var j = 0; j < dynamicList.length; j++) {
                            var title = ellipsis(dynamicList[j].name, 35);

                            html2 = '<li>' +
                                '<a href="" target="_blank"><label style="color:#29d659;">【动态】</label>' + dynamicList[j].name + '</a>' +
                                '<span>' + dynamicList[j].date + '</span>' +
                                '</li>';

                            $('.jidiku-list-zuixin').eq(i).append(html2);
                        }
                    }
                    ;
                    var pc = rs[rs.length - 1];
                    //执行一个laypage实例
                    laypage.render({
                        elem: 'jidiku-fenye', //注意，这里的 test1 是 ID，不用加 # 号
                        count: pc, //数据总数，从服务端得到
                        limit: 10,
                        theme: '#2d6393',
                        jump: function (obj, first) {
                            //obj包含了当前分页的所有参数，比如：
                            //console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                            //console.log(obj.limit); //得到每页显示的条数

                            //首次不执行
                            if (!first) {
                                $.ajax({
                                    type: "post",
                                    data: "",
                                    url: 'http://localhost:8080/front/selectJiDiKuDongTaiXingXi.html?pageNum=' + obj.curr + '&pageSize=' + obj.limit + '&type=' + type_change + '&batch=' + batch_change + '&areaId=' + areaId +'&baseName=' + baseName +'',
                                    dataType: "json",
                                    timeout: 10000,
                                    beforeSend: function (xhr) {
                                        $('#jidiku-news-list-ul').empty();
                                    },
                                    success: function (rs) {
                                        var html1 = "";
                                        var html2 = "";
                                        if (rs.length == 1) {
                                            $('#jidiku-news-list-ul').append('<div style="text-align:center;margin-top:30px;padding-bottom:30px;"><p>没有相关数据</p></div>');
                                            $('#jidiku-fenye').hide();
                                            return;
                                        }
                                        var pici;
                                        var leixing;
                                        for (var i = 0; i < rs.length - 1; i++) {
                                            var shortContent = ellipsis(rs[i][0].firstContent, 50);

                                            if (rs[i][0].batch == '首批') {
                                                pici = "首批";
                                            } else {
                                                pici = "第二批";
                                            }
                                            ;
                                            if (rs[i][0].type == '区域示范基地') {
                                                leixing = "区域示范基地";
                                            } else if (rs[i][0].type == '高校和科研院所示范基地') {
                                                leixing = "高校和科研院所示范基地";
                                            } else {
                                                leixing = "企业示范基地";
                                            }
                                            ;
                                            html1 = '<li>' +
                                                '<div class="left">' +
                                                '<a href="" target="_blank">' +
                                                '<div class="img-wrapper"><img src="' + rs[i][0].fileURL + '" onload="imgCenter(this)"></div>' +
                                                '<div class="article">' +
                                                '<p class="p1">' + rs[i][0].name + '</p>' +
                                                '<p class="p2">' + shortContent + '</p>' +
                                                '<p class="p3"><span class="org">' + pici + '</span><span class="b-blue">' + leixing + '</span></p>' +
                                                '</div>' +
                                                '</a>' +
                                                '</div>' +
                                                '<div class="right">' +
                                                '<p class="title">最新动态</p>' +
                                                '<ul class="jidiku-list-zuixin">' +
                                                '</ul>' +
                                                '</div>' +
                                                '</li>';
                                            $('#jidiku-news-list-ul').append(html1);
                                            var dynamicList = rs[i][1].dynamicList;
                                            for (var j = 0; j < dynamicList.length; j++) {
                                                var title = ellipsis(dynamicList[j].name, 35);

                                                html2 = '<li>' +
                                                    '<a href="" target="_blank"><label style="color:#29d659;">【动态】</label>' + dynamicList[j].name + '</a>' +
                                                    '<span>' + dynamicList[j].date + '</span>' +
                                                    '</li>';

                                                $('.jidiku-list-zuixin').eq(i).append(html2);
                                            }
                                        }

                                    }
                                })
                            }
                        }
                    });
                }
            });
        };
		//页面加载时ajax请求
		jidikuRequest();
		//点击全部
		$('#quanbu').on('click',function(){
			batch_change = "";
			type_change = "";
			jidikuRequest();
		});
        //点击批次
        $('#quanbu-pici').on('click',function(){
			batch_change = "";
			jidikuRequest();
		});
        //点击首批
        $('#shoupi').on('click',function(){
			batch_change = "1";
			jidikuRequest();
		});
        //点击第二批
        $('#dierpi').on('click',function(){
			batch_change = "2";
			jidikuRequest();
		});
        //点击类型
		$('#quanbu-leixing').on('click',function(){
			type_change = "";
			jidikuRequest();
		});
		//区域示范基地
		$('#type00').on('click',function(){
			type_change = "00";
			jidikuRequest();
		});
        //高校和科研院所示范基地
		$('#type01').on('click',function(){
			type_change = "01";
			jidikuRequest();
		});
        //企业示范基地
		$('#type02').on('click',function(){
			type_change = "02";
			jidikuRequest();
		});
	});
    //右侧动效
    $('#quanbu').on('click',function(){
    	$(this).addClass('active').siblings().removeClass('active');
    	$('.hangbiao').eq(0).addClass('active').siblings('.hangbiao').removeClass('active');
    })
    $('.jidiku-pici').each(function(){
    	$(this).on('click',function(){
    		$(this).addClass('active').siblings('.jidiku-pici').removeClass('active');
    		$('#quanbu').removeClass('active');
    		$('.hangbiao').eq(0).removeClass('active');
    		$('.hangbiao').eq(1).addClass('active');
    	})
    });
    $('.jidiku-leixing').each(function(){
    	$(this).on('click',function(){
    		$(this).addClass('active').siblings('.jidiku-leixing').removeClass('active');
    		$('#quanbu').removeClass('active');
    		$('.hangbiao').eq(0).removeClass('active');
    		$('.hangbiao').eq(2).addClass('active');
    	})
    })
});