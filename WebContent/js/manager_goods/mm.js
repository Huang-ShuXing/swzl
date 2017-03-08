var mm = {
 
		deleteRecord :function(goodsId,name){
			if(!confirm("确认删除【"+name+"】的数据吗?")){
				return false;
			}
			var  goods = {};
			goods.id = goodsId;
			var param = JSON.stringify(goods);			
			 $.ajax({
		         url: "/ssm_wechat/goods/deleteGoods.do",
		         async:false,
		         type: "POST",
		         contentType : 'application/json;charset=utf-8', //设置请求头信息
		         dataType:"json",
		         data:param ,    //将Json对象序列化成Json字符串，JSON.stringify()原生态方法
		         success: function(data){
		        	 alert(data.msg);
		        	 $("#sr_btn_search").click();
		        	/* if(data.state == 1){
		     			location.href=turnUrl;
		        	 }*/
		         },
	             error: function(res){
	                 //alert(res.responseText);
	                 alert("服务忙");
	             }
		 });
			 
			 
		},
		finishRecord :function(goodsId,name){
			if(!confirm("确认完成【"+name+"】的数据吗?")){
				return false;
			}
			var  goods = {};
			goods.id = goodsId;
			var param = JSON.stringify(goods);
			 $.ajax({
		         url: "/ssm_wechat/goods/finishGoods.do",
		         async:false,
		         type: "POST",
		         contentType : 'application/json;charset=utf-8', //设置请求头信息
		         dataType:"json",
		         data:param ,    //将Json对象序列化成Json字符串，JSON.stringify()原生态方法
		         success: function(data){
		        	 alert(data.msg);
		        	 $("#sr_btn_search").click();
		         },
		         error: function(res){
		             //alert(res.responseText);
		             alert("服务忙");
		         }
		 });
		},
		backRecord :function(goodsId,method,name){
			if(!confirm("确认将【"+name+"】从找到状态设置为未找到吗?")){
				return false;
			}
			var  goods = {};
			goods.id = goodsId;
			goods.method=method;
			var param = JSON.stringify(goods);
			 $.ajax({
		         url: "/ssm_wechat/goods/backGoods.do",
		         async:false,
		         type: "POST",
		         contentType : 'application/json;charset=utf-8', //设置请求头信息
		         dataType:"json",
		         data:param ,    //将Json对象序列化成Json字符串，JSON.stringify()原生态方法
		         success: function(data){
		        	 alert(data.msg);
		        	 $("#sr_btn_search").click();
		         },
		         error: function(res){
		             //alert(res.responseText);
		             alert("服务忙");
		         }
		 });
			
		}
};