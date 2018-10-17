//动态切换
function ellipsis(str, length) {
    return str.length <= length ? str : (str.substr(0, length) + '...');
};
var c;
$(function(){
   $(".listAll .listCon:first").show();
   $(".tabs li a").on('click',function(){
	   c =  $(this).parent().index();
	   $($(".listCon")[c]).siblings().hide();
	   $($(".listCon")[c]).fadeTo(200,1);
   });
   

})

//政策动态头条
$(function(){
    $.ajax({
        type: "post",
        data: "",
        url: 'selectDynamicManagementByTypeZCDT.html?limit=3',
        dataType: "json",
        beforeSend: function(xhr) {
          $('#zctt-list').append('<img src="/imgs/huanchong.gif" id="huanchong" style="width: 30px;height: 30px;position: absolute;top: 50%;margin-top: -15px;left: 50%;margin-left: -15px;">');
        },
        success: function(rs) {
               var html;
                for (var i = 0; i < rs.length; i++) {
                  var shortContent = ellipsis(rs[i].introduction,60);
                  if (i==1) {
                    html = '<li>'+                         
                              '<div class="content">'+
                               '<a href="skipDynamicDetails.html?id='+rs[i].id+'" target="_blank"><h3>'+rs[i].name+'</h3></a>'+
                                '<p>'+shortContent+'</p>'+
                              '</div>'+
                              '<div class="img-wrapper"><a href="skipDynamicDetails.html?id='+rs[i].id+'" target="_blank"><img src="'+rs[i].fileURL+'"></a></div>'+
                          '</li>';
                  }else{
                    html = '<li>'+         
                              '<div class="img-wrapper"><a href="skipDynamicDetails.html?id='+rs[i].id+'" target="_blank"><img src="'+rs[i].fileURL+'"></a></div>'+
                              '<div class="content">'+
                                '<a href="skipDynamicDetails.html?id='+rs[i].id+'" target="_blank"><h3>'+rs[i].name+'</h3></a>'+
                                '<p>'+shortContent+'</p>'+
                              '</div>'+          
                          '</li>';
                    }
                  $('#zctt-list').append(html);
                }
        },
        error: function(xhr) {
          
            
        },
        complete: function (xhr) {
          $('#huanchong').remove();
            
        }
    });
})
//加载地方动态列表
$(function(){
  //汉语拼音首字母排序的方法
  function pySegSort(arr,empty) {
      if(!String.prototype.localeCompare)
          return null;
       
       var letters ="*ABCDEFGHJKLMNOPQRSTWXYZ".split('');
         var zh ="阿把苍大峨发噶哈吉喀啦吗那哦爬祁然三他哇西呀咋".split('');
       
      var segs = [];
      var curr;
      $.each(letters, function(i){
          curr = {letter: this, data:[],letter_index: i};
          $.each(arr, function() {

              if((!zh[i-1] || zh[i-1].localeCompare(this.name,'zh') <= 0) && this.name.localeCompare(zh[i],'zh') == -1) {
                  curr.data.push(this);
                  // console.log(this)
              }else{
                if(i==23){
                  if((!zh[i-1] || zh[i-1].localeCompare(this.name,'zh') <= 0) && (this.name.localeCompare(zh[i],'zh') == -1 || this.name.localeCompare(zh[i],'zh') == 1)) {
                      curr.data.push(this);
                  }
                }
              }
          });
          if(empty || curr.data.length) {
              segs.push(curr);
              curr.data.sort(function(a,b){ 
                  return a.name.localeCompare(b.name,'zh');
              });
          }
      });
      return segs;
  };
  $.ajax({
      type: "post",
      data: "",
      url:'selectAllRegionList.html',
      dataType: "json",
      beforeSend: function(xhr) {

      },
      success: function(rs) {
        //console.log(res)
            var areaArray = [];
            for (var i = 0; i < rs.length; i++) {
              areaArray.push(rs[i]);
            };
            var newAreaArray = pySegSort(areaArray);          
            for (var i = 0; i < newAreaArray.length; i++) {
                $('#city-list').append('<li style="position:relative;padding-left:10px;text-align:left;"><label style="position:absolute;left:0;top:7px;font-weight:bold;color:#2d6393;font-size:14px;">'+ newAreaArray[i].letter +'</label></li>');
                for (var j = 0; j < newAreaArray[i].data.length; j++) {       
                  $('#city-list li').eq(i).append('<b id="'+ newAreaArray[i].data[j].id +'" class="filter-item-a">'+ newAreaArray[i].data[j].name +'</b>');               ;
                }
              };
          $('#city-list b').click(function(){
            areaId = $(this).attr('id');
            $('#leixing-all').children('a').removeClass('current');
            if($(this).text()=='不限'){
              areaFlag = '';
              $('#dfdt-text').text('地方动态');
              $('#difang-dt').children('a').removeClass('current');
            }else{
              areaFlag = 'Y';
              $('#dfdt-text').text($(this).text());
              $('#difang-dt').children('a').addClass('current');
            }
            $('#city-list').css('color','#2b2b2b');
            $('#city-list b').removeClass('on');
            $(this).addClass('on');
            dongtaiList();
          })
      },
      error: function(xhr) {
      },
      complete: function (xhr) {
      }
  });
});
var basesActivityFlag = '';
var pubDeptFlag = '';
var areaFlag = '';
var areaId = '';
var jidi_bl = true;
var buwei_bl = true;
layui.use('laypage', function(){
    var laypage = layui.laypage;  
    window.dongtaiList = function(){
      $.ajax({
            type: "post",
            data: "",
            url: 'http://localhost:8080/front/selectDynamicManagementByZCDTClick.html?basesActivityFlag='+ basesActivityFlag +'&category=1&pageNum=1&pageSize=10&areaId='+ areaId +'&pubDeptFlag='+ pubDeptFlag +'&areaFlag='+ areaFlag +'',
            dataType: "json",
            beforeSend: function(xhr) {
                $('#dtlist').empty();
                $('#dtlist').append('<img src="/imgs/huanchong.gif" id="huanchong" style="width: 30px;height: 30px;position: absolute;top: 50%;margin-top: -15px;left: 50%;margin-left: -15px;">');
                $('#page').show();
            },
            success: function(rs) {
                var data = rs.data;
                    if(data.length==0){
                      $('#dtlist').append('<div style="text-align:center;margin-top:30px;padding-bottom:30px;"><img src="/imgs/no_data_icon.png" style="display:inline-block;"></div>');
                      $('#page').hide();
                      return;
                    }
                    var html='';
                    var shortContent;
                    var flag;
                    for (var i = 0; i < data.length; i++) {
                      shortContent = ellipsis(data[i].introduction,200);
                      if(data[i].fileURL==''||data[i].fileURL==null){
                            flag = "";
                      }else{
                        flag = '<a href="skipDynamicDetails.html?id='+data[i].id+'" target="_blank" style="float:left;padding:0;"><img src="'+data[i].fileURL+'" width="139px" height="107px"></a>';
                      }
                      html += '<div class="listBox">'+
                              '<a href="skipDynamicDetails.html?id='+data[i].id+'" target="_blank" style="font-weight:bold;">'+ data[i].name +'</a>'+
                              '<div class="detailAll">'+
                                ''+ flag +''+
                                '<div class="listDetail">'+
                                  '<p>'+ shortContent +'</p>'+
                                  '<em>发布时间：'+ data[i].reportDate +'</em><span>来源：<i>'+ data[i].source +'</i></span>'+
                                '</div>'+
                              '</div>'+
                            '</div>';
                    };
                $('#dtlist').append(html);
                var allCounts = rs.allCounts;
                    //调用分页
                    laypage.render({
                    elem: 'page', //注意，这里的 test1 是 ID，不用加 # 号
                    count: allCounts, //数据总数，从服务端得到
                    limit: 10,
                    theme: '#2d6393',
                    jump: function(obj, first){
                      //obj包含了当前分页的所有参数，比如：
                     // console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                      //console.log(obj.limit); //得到每页显示的条数
                      
                      //首次不执行
                      if(!first){
                          $.ajax({
                            type: "post",
                            data: "",
                            url: 'http://localhost:8080/front/selectDynamicManagementByZCDTClick.html?basesActivityFlag='+ basesActivityFlag +'&category=1&pageNum='+ obj.curr +'&pageSize='+ obj.limit +'&areaId='+ areaId +'&pubDeptFlag='+ pubDeptFlag +'&areaFlag='+ areaFlag +'',
                            dataType: "json",
                            beforeSend: function(xhr) {
                              $('#dtlist').empty();
                              $('#dtlist').append('<img src="/imgs/huanchong.gif" id="huanchong" style="width: 30px;height: 30px;position: absolute;top: 50%;margin-top: -15px;left: 50%;margin-left: -15px;">');
                            },
                            success: function(rs) {
                                      var html = '';
                                      var shortContent = '';
                                      var flag = '';
                                      var data = rs.data;

                                      for (var i = 0; i < data.length; i++) {
                                          shortContent = ellipsis(data[i].introduction,200);
                                          if(data[i].fileURL==null || data[i].fileURL==''){
                                                flag = "";
                                          }else{
                                            flag = '<a href="skipDynamicDetails.html?id='+data[i].id+'" target="_blank" style="float:left;padding:0;"><img src="'+data[i].fileURL+'"  width="139px" height="107px"></a>';
                                          }
                                          html = '<div class="listBox">'+
                                                  '<a href="skipDynamicDetails.html?id='+data[i].id+'" target="_blank" style="font-weight:bold;">'+ data[i].name +'</a>'+
                                                  '<div class="detailAll">'+
                                                    ''+ flag +''+
                                                    '<div class="listDetail">'+
                                                      '<p>'+ shortContent +'</p>'+
                                                      '<em>发布时间：'+ data[i].reportDate +'</em><span>来源：<i>'+ data[i].source +'</i></span>'+
                                                    '</div>'+
                                                  '</div>'+
                                                '</div>';
                                            $('#dtlist').append(html);
                                      }
                      },
                      error: function(xhr) {
                      },
                      complete: function (xhr) {
                        $('#huanchong').remove();
                      }
                  });
                }
            }
          });
            },
            error: function(xhr) {
            },
            complete: function (xhr) {
                $('#huanchong').remove();   
            }
        });
    }
});
//页面初始化
$(function(){
  dongtaiList();
});

$(function(){
  //全部点击
  $('#leixing-all').click(function(){
    basesActivityFlag = '';
    pubDeptFlag = '';
    areaFlag = '';
    areaId = '';
    $('#dfdt-text').text('地方动态');
    $('#city-list b').removeClass('on');
    $('.filter-itm-a.buxian').addClass('on');
    $(this).children('a').addClass('current');
    $('#buwei-dt,#jidi-dt,#difang-dt').children('a').removeClass('current');
    if (buwei_bl) {}else{buwei_bl=!buwei_bl};
    if (jidi_bl) {}else{jidi_bl=!jidi_bl};
    dongtaiList();
  });
  //基地动态点击
  
  $('#jidi-dt').click(function(){
    $('#leixing-all').children('a').removeClass('current');
    if (jidi_bl) {      
      basesActivityFlag = '1';
      $(this).children('a').addClass('current');
    }else{
      basesActivityFlag = '';
      $(this).children('a').removeClass('current');
    }
    jidi_bl = !jidi_bl;
    dongtaiList();

  });
  //部委动态点击
  
  $('#buwei-dt').click(function(){
    $('#leixing-all').children('a').removeClass('current');
    if (buwei_bl) {
      pubDeptFlag = '1';
      $(this).children('a').addClass('current');
    }else{
      pubDeptFlag = '';
      $(this).children('a').removeClass('current');
    }
    buwei_bl = !buwei_bl;
    dongtaiList();
  });
});







