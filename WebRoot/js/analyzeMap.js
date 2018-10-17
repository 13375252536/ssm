$(function(){
//年度最热政策
$.ajax({
 	type: "post",
	data: "",
	url: 'getPolicyAnalysisInfo.html?limit=3&type=0',
	dataType: "json",
	success: function(res) {
	//	console.log(res);
			var data = res.data;
			var year = '';
			if (data.length == 0) {
				year = '<img class="noData" src="/imgs/no_data_icon2.png" />';
			}	
			for(var i = 0; i < data.length; i++) {
				year+='<li><i></i><p><a href="skipPolicyDetails.html?id='+data[i].id+'" target="_blank">'+ data[i].name +'</a></p></li>'
		  	}
		  	$("#yearHotPolicyList").html(year);
	},
	beforeSend:function(){
		//加载中 xhj
	},
	error:function(){
		//加载异常 xhj
	}
});  

//季度最热政策
$.ajax({
 	type: "post",
	data: "",
	url: 'getPolicyAnalysisInfo.html?limit=3&type=1',
	dataType: "json",
	success: function(res) {
	//	console.log(res);
			var data = res.data;
			var quarter = '';
			if (data.length == 0) {
				quarter = '<img class="noData" src="/imgs/no_data_icon2.png" />';
			}			
			for(var i = 0; i < data.length; i++) {
				quarter+='<li><i></i><p><a href="skipPolicyDetails.html?id='+data[i].id+'" target="_blank">'+ data[i].name +'</a></p></li>'
		  	}
		  	$("#quarterHotPolicyList").html(quarter);
	},
	beforeSend:function(){
		//加载中 xhj
	},
	error:function(){
		//加载异常 xhj
	}
}); 

//月度最热政策
$.ajax({
 	type: "post",
	data: "",
	url: 'getPolicyAnalysisInfo.html?limit=3&type=2',
	dataType: "json",
	success: function(res) {
	//	console.log(res);
			var data = res.data;
			var mon = '';
			if (data.length == 0) {
				mon = '<img class="noData" src="/imgs/no_data_icon2.png" />';
			}
			for(var i = 0; i < data.length; i++) {
				mon+='<li><i></i><p><a href="skipPolicyDetails.html?id='+data[i].id+'" target="_blank">'+ data[i].name +'</a></p></li>'
		  	}
		  	$("#monthHotPolicyList").html(mon);			    
	},
	beforeSend:function(){
		//加载中 xhj
	},
	error:function(){
		//加载异常 xhj
	}
}); 

//周度最热政策
$.ajax({
 	type: "post",
	data: "",
	url: 'getPolicyAnalysisInfo.html?limit=3&type=3',
	dataType: "json",
	success: function(res) {
	//	console.log(res);
			var data = res.data;
			var week = '';
			if (data.length == 0) {
				week = '<img class="noData" src="/imgs/no_data_icon2.png" />';
			}
			for(var i = 0; i < data.length; i++) {
				week+='<li><i></i><p><a href="skipPolicyDetails.html?id='+data[i].id+'" target="_blank">'+ data[i].name +'</a></p></li>'
		  	}
		  	$("#weekHotPolicyList").html(week);			    
	},
	beforeSend:function(){
		//加载中 xhj
	},
	error:function(){
		//加载异常 xhj
	}
}); 

});



 