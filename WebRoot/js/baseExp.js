//轮播图
$(function () {
    function ellipsis(str, length) {
        return str.length <= length ? str : (str.substr(0, length) + '...');
    };

    function slider(m, y, tt) {
        // 滑动特效
        var startX = 0, startY = 0; //触摸开始时手势横纵坐标
        var temPos; //滚动元素当前位置
        var iCurr = 0; //当前滚动屏幕数
        var oPosition = {}; //触点位置
        var num = 2;
        var clone = m.children('li').first().clone();
        var ww = parseInt(m.children('li').css('width'));
        m.append(clone);
        var size = m.children('li').size();

        //左滑
        function move_left() {
            iCurr++;
            if (iCurr == size) {
                m.css({left: 0});
                iCurr = 1;
            }
            m.stop().animate({left: -iCurr * ww}, 820);
            if (iCurr == size - 1) {
                y.eq(0).addClass("on").siblings().removeClass("on");
                tt.eq(0).addClass("active").siblings().removeClass("active");
            }
            else {
                y.eq(iCurr).addClass("on").siblings().removeClass("on");
                tt.eq(iCurr).addClass("active").siblings().removeClass("active");
            }
        }

        // 右滑
        function move_right() {
            iCurr--;
            if (iCurr == -1) {
                m.css({left: -(size - 1) * ww});
                iCurr = size - 2;
            }
            m.stop().animate({left: -iCurr * ww}, 820);
            y.eq(iCurr).addClass("on").siblings().removeClass("on");
            tt.eq(iCurr).addClass("active").siblings().removeClass("active");
        }

        var t = setInterval(move_left, 3800);
        if (m.selector == '.erweima-wrap .list-wrap') {
            clearInterval(t);
        }
        m.hover(function () {
            clearInterval(t);
        }, function () {
            t = setInterval(move_left, 3800);
            if (m.selector == '.erweima-wrap .list-wrap') {
                clearInterval(t);
            }
        });
        // 划入小圆点
        y.hover(function () {
            m.stop().animate({left: -($(this).index()) * ww}, 820);
            $(this).addClass('on').siblings().removeClass('on');
            tt.eq($(this).index()).addClass("active").siblings().removeClass("active");
            clearInterval(t);
        }, function () {
            t = setInterval(move_left, 3800);
            if (m.selector == '.erweima-wrap .list-wrap') {
                clearInterval(t);
            }
        });
        // 划入按钮
        $('#cxzg-prev').hover(function () {
            clearInterval(t);
        }, function () {
            t = setInterval(move_left, 3800);
        });
        $('#cxzg-next').hover(function () {
            clearInterval(t);
        }, function () {
            t = setInterval(move_left, 3800);
        });
        //按钮点击
        $('#cxzg-prev').on('click', function () {
            move_right();
        });
        $('#cxzg-next').on('click', function () {
            move_left();
        })
    }

    //ajax 轮播
    $.support.cors = true;
    $.ajax({
        type: "post",
        data: "",
        url: 'http://localhost:8080/front/selectJiDiLunBoTu.html?limit=3',
        dataType: "json",
        beforeSend: function (xhr) {
        },
        success: function (rs) {
            var html1 = '';
            var html2 = '';
            var html3 = '';
            $.each(rs, function (index, item) {
                var shortContent = ellipsis(item.firstContent, 80);
                var title = ellipsis(item.name, 36);
                html1 += '<li><a href="" target="_blank"><img src=' + item.fileURL + ' class="lunbotu" onload="imgCenter(this)"></a></li>';
                html2 += '<li style="height:100%;"><b>' + title + '</b><p class="sc">' + shortContent + '</p><a href="" target="_blank">查看详情>></a></li>';
                html3 += '<span class="on">' + '</span>'
            });
            $('#cxzg-slider-body').append(html1);
            $('#cxzg-title-ul').append(html2);
            $("#cxzg-focus").append(html3);
            $('#cxzg-title-ul li').eq(0).addClass('active');
            slider($('#cxzg-slider-body'), $('#cxzg-focus span'), $('#cxzg-title-ul li'));
        }
    });


    //分页 基地库基地列表
    layui.use('laypage', function () {
        var laypage = layui.laypage;
        var pageCounts;
        var batch = "";
        var type = "";
        var activity = "";
        window.jidikuRequest = function () {
            $.ajax({
                type: "post",
                data: "",
                url: 'http://localhost:8080/front/selectJiDiDongTaiXingXi.html?pageNum=1&pageSize=10&batch=' + batch + '&type=' + type + '&basesActivityFlag=' + activity + '',
                dataType: "json",
                beforeSend: function (xhr) {
                    $('#dtlist').empty();
                    $('#page').show();
                },
                success: function (data) {
                    var html = "";
                    if (data.length == 1) {
                        $('#dtlist').append('<div style="text-align:center;margin-top:30px;padding-bottom:30px;"><p>没有相关数据</p></div>');
                        $('#page').hide();
                        return;
                    }
                    var flag;
                    for (var i = 0; i < data.length-1; i++) {
                        var shortContent = ellipsis(data[i].introduction, 220);
                        if (data[i].fileURL == "") {
                            flag = "";
                        } else {
                            flag = '<a href="skipDynamicDetails.html?id='+data[i].id+'" target="_blank"><img src="' + data[i].fileURL + '"></a>';
                        }
                        html =
                            '<div class="listBox">' +
                            '<a href="skipDynamicDetails.html?id='+data[i].id+'" target="_blank">' + data[i].name + '</a>' +
                            '<div class="detailAll">' +
                            '' + flag + '' +
                            '<div class="listDetail">' +
                            '<p class="shortContent">' + shortContent + '</p>' +
                            '<em>发布时间：' + data[i].reportDate + '</em><span>来源：<i>' + data[i].source + '</i></span>' +
                            '</div>' +
                            '</div>' +
                            '</div>';
                        $('#dtlist').append(html);
                    }

                    pageCounts = data[data.length-1].allCounts;
                    //执行一个laypage实例
                    laypage.render({
                        elem: 'page', //注意，这里的 page 是 ID，不用加 # 号
                        count: pageCounts, //数据总数，从服务端得到
                        limit: 10,
                        theme: '#2d6393',
                        jump: function (obj, first) {
                            //obj包含了当前分页的所有参数，比如：
                            ////(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                            // //(obj.limit); //得到每页显示的条数
                            //首次不执行
                            if (!first) {
                                $.ajax({
                                    type: "post",
                                    data: "",
                                    url: 'http://localhost:8080/front/selectJiDiDongTaiXingXi.html?pageNum=' + obj.curr + '&pageSize=' + obj.limit + '&batch=' + batch + '&type=' + type + '&basesActivityFlag=' + activity + '',
                                    dataType: "json",
                                    beforeSend: function (xhr) {
                                        $('#dtlist').empty();
                                    },
                                    success: function (data) {
                                        var html = "";
                                        if (data.length == 1) {
                                            $('#dtlist').append('<div style="text-align:center;margin-top:30px;padding-bottom:30px;"><p>没有相关数据</p></div>');
                                            $('#page').hide();
                                            return;
                                        }
                                        var flag;
                                        for (var i = 0; i < data.length-1; i++) {
                                            var shortContent = ellipsis(data[i].introduction, 220);
                                            if (data[i].fileURL == "") {
                                                flag = "";
                                            } else {
                                                flag = '<a href="skipDynamicDetails.html?id='+data[i].id+'" target="_blank"><img src="' + data[i].fileURL + '"></a>';
                                            }
                                            html =
                                                '<div class="listBox">' +
                                                '<a href="skipDynamicDetails.html?id='+data[i].id+'" target="_blank">' + data[i].name + '</a>' +
                                                '<div class="detailAll">' +
                                                '' + flag + '' +
                                                '<div class="listDetail">' +
                                                '<p class="shortContent">' + shortContent + '</p>' +
                                                '<em>发布时间：' + data[i].reportDate + '</em><span>来源：<i>' + data[i].source + '</i></span>' +
                                                '</div>' +
                                                '</div>' +
                                                '</div>';
                                            $('#dtlist').append(html);
                                        }

                                    }
                                });
                            }
                        }
                    });
                }
            });
        };
        //页面加载时显示全部
        jidikuRequest();
        //全部
        $('#quanbu').on('click', function () {
            $('#pici-text').text('批次');
            $('#leixing-text').text('类型');
            $(this).addClass('current');
            $('#pici-quanbu,#leixing-quanbu').removeClass('current');
            batch = "";
            type = "";
            jidikuRequest();
        });

        //批次item
        $('#shoupi,#dierpi,#buxian').on('click', function (e) {
            if (e && e.stopPropagation) {
                e.stopPropagation();
            }
            $('#quanbu').removeClass('current');
            $(this).parents('#pici-quanbu').addClass('current');
            $(this).addClass('on').siblings().removeClass('on');
            batch = $(this).attr('data-value');
            jidikuRequest();
        });
        $('#buxian').click(function () {
            $(this).parents('#pici-quanbu').removeClass('current');
        });
        //示范基地item
        $('#type00,#type02,#type01,#typebuxian').on('click', function (e) {
            if (e && e.stopPropagation) {
                e.stopPropagation();
            }
            $('#quanbu').removeClass('current');
            $(this).parents('#leixing-quanbu').addClass('current');
            $(this).addClass('on').siblings().removeClass('on');
            type = $(this).attr('data-value');
            jidikuRequest();
        });
        $('#typebuxian').click(function () {
            $(this).parents('#leixing-quanbu').removeClass('current');
        })
    });

});
//动态切换
$(function () {
    //tab下拉菜单
    $(".tabs li div b").on('click', function () {
        $(this).parents(".pici").children().children('em').text($(this).text());
        $(this).parents(".leixing").children().children('em').text($(this).text());
    });

    $('#typebuxian').click(function () {
        $('#leixing-text').text('类型');
    });
    $('#buxian').click(function () {
        $('#pici-text').text('批次');
    })

});


