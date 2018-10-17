document.write('<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>');
var ua;
var cip;
var cname;
var sb_type;
var searchCriteria;
$(function(){

	ua = navigator.userAgent;
    cip = returnCitySN['cip'];
    cname = returnCitySN['cname'];
   
	if ((navigator.userAgent.match(/(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i))) {
	    sb_type = '01';
	}else {
	    sb_type = '02';
	}

	$("div.headNav div").find("a")[0].href = yuming;
	
$('#gozcdt').click(function(e){
	e = e || window.event;
    if(e.preventDefault) {
      e.preventDefault();
    }else{
      e.returnValue = false;
    }
	window.location.href = 'policyKu.html';
});
$('#gozck').click(function(e){
	e = e || window.event;
    if(e.preventDefault) {
      e.preventDefault();
    }else{
      e.returnValue = false;
    }
	window.location.href = 'zhengceku.html';
});
$('#gojddt').click(function(e){
	e = e || window.event;
    if(e.preventDefault) {
      e.preventDefault();
    }else{
      e.returnValue = false;
    }
	window.location.href = 'baseExp.html';
});
$('#jdk').click(function(e){
	e = e || window.event;
    if(e.preventDefault) {
      e.preventDefault();
    }else{
      e.returnValue = false;
    }
	window.location.href = 'jidiku.html';
});

//页头ajax   end
  function getValue(){
  	var value = $.trim($('#search-input').val());
  	searchCriteria = value;
    if (value=='') {
    	alert("请输入搜索内容");
    	return;
    }
 //    _encode = encodeURI('search.html?keyword='+ value +'');
 //    _encode = encodeURI(_encode);
	// window.location.href = _encode;
	
  }
  $('#search-btn').click(function(e){
  		e = e || window.event;
	    if(e.preventDefault) {
	      e.preventDefault();
	    }else{
	      e.returnValue = false;
	    };
	    getValue();
	    $.ajax({
	        async:true,
	        type: "POST",
	        contentType:'application/json;charset=utf-8',
	        data: JSON.stringify({
	        	'userLocation': cname,
	        	'ip': cip,
	        	'userSystem': ua,
	        	'searchContent': '00',
	        	'searchMethod': '00',
	        	'searchCriteria': searchCriteria,
	        	'searchType': '',
	        	'customerType': sb_type
	        }),
	        url: yuming + '/accessReport/saveSearchReport',
	        dataType: "json",
	        beforeSend: function(xhr) {

	        },
	        success: function(res) {
	 			window.location.href = 'search.html?keyword='+ searchCriteria +'';
	        },
	        error: function(xhr) {

	            
	        },
	        complete: function (xhr) {

	            
	        }
	    });
	    
  })
  //回车事件
  $('#search-input').keyup(function(e){
  	  e = e || window.event;  	  
	  if(e.keyCode ==13){
	    getValue();
	    $.ajax({
	        async:true,
	        type: "POST",
	        contentType:'application/json;charset=utf-8',
	        data: JSON.stringify({
	        	'userLocation': cname,
	        	'ip': cip,
	        	'userSystem': ua,
	        	'searchContent': '00',
	        	'searchMethod': '00',
	        	'searchCriteria': searchCriteria,
	        	'searchType': '',
	        	'customerType': sb_type
	        }),
	        url: yuming + '/accessReport/saveSearchReport',
	        dataType: "json",
	        beforeSend: function(xhr) {

	        },
	        success: function(res) {
	 			window.location.href = 'search.html?keyword='+ searchCriteria +'';
	        },
	        error: function(xhr) {

	            
	        },
	        complete: function (xhr) {

	            
	        }
	    });	   
	  }
	});
   
	function getQueryVariable(variable){
        var query = window.location.search.substring(1);
        var vars = query.split("&");
        for (var i=0;i<vars.length;i++) {
            var pair = vars[i].split("=");
            if(pair[0] == variable){return pair[1];}
        }
       return('');
	};
	var keyword = decodeURI(getQueryVariable('keyword'));
	$('#search-input').val(keyword);
});
function getUserMessage(sc,sm,st){
 	$.ajax({
        async:true,
        type: "POST",
        contentType:'application/json;charset=utf-8',
        data: JSON.stringify({
        	'userLocation': cname,
        	'ip': cip,
        	'userSystem': ua,
        	'searchContent': sc,
        	'searchMethod': sm,
        	'searchCriteria': searchCriteria,
        	'searchType': st,
        	'customerType': sb_type
        }),
        url: yuming + '/accessReport/saveSearchReport',
        dataType: "json",
        beforeSend: function(xhr) {

        },
        success: function(res) {
 			
        },
        error: function(xhr) {

            
        },
        complete: function (xhr) {

            
        }
    });
 }  