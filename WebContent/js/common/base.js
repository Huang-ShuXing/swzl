$(document).ready(function(){
	
	/**
	 * @param select     选择器
	 * @param url	     后台请求地址
	 * @param homeId     参数 json格式 例如 {"homeUpId":homeId}
	 * @param tagName    获取到的数据对象名
	 * @param returnUrl  后台返回到页面的地址
	 */
	myAjax = function(select,url,params,tagName,returnUrl){
		params["returnUrl"]= returnUrl;
		params["tagName"]= tagName;
		/*alert("myAjax");*/
		$(select).load(url,params);
	};
	
	myAsyncAjax = function(select,url,params,tagName,returnUrl){
		params["returnUrl"]= returnUrl;
		params["tagName"]= tagName;
		
		$(select).load(url,params,function(){$("#myAlert").hide(1000);});
	};
	
	
	
	
	myAjaxFun = function(select,url,params,tagName,returnUrl,fun){
		params["returnUrl"]= returnUrl;
		params["tagName"]= tagName;
		$(select).load(url,params,fun);
	};
	
	/**
	 * input 后面的x 可以清空input的内容
	 */
	$(".ui-icon-close").click(function(){
		$(this).prev("input").val("");
	});
	
	$("body").delegate("#menu_img", "click", function(){
		var openId = $(this).attr("data-val");
		location.href="/ssm_wechat/contact/updateContact.do?openId="+openId;
		/*myAjax("#ulAjaxDetail","/ssm_wechat/contact/ajaxGetUser.do",{"openId":openId},"detailUser","contact/contact_index.html#ajaxDetailUser");*/
	});
	
	isAttestation = function(ajax_url){
		var flag = false;
		$.ajax({
	        url: ajax_url,
	        async:false,
	        type: 'POST',
	        success: function(data){
	        	if(data.state==1){
	        		flag = true;	        		
	        	}else {
	        		flag =false;
	        	}
	        	alert(data.msg);
	        },
	        error: function (){
	        	alert("请从微信端打开网站");
	        	flag = false;
	        }
	    });
		return flag;
	};
	isAttestationNoAlert = function(ajax_url){
		var flag ;
		$.ajax({
	        url: ajax_url,
	        async:false,
	        type: 'POST',
	        success: function(data){
	        	flag = data;
	        },
	        error: function (){
	        	alert("请从微信端打开网站");
	        	flag = false;
	        }
	    });
		return flag;
	};
	
	 $("#a_to_attestation").click(function(){		 
		 var isAttestationVal = $(this).attr("data-val");
		 //0：未认证，1：等待审核，2:已认证，3:认证失败
		 if(isAttestationVal == 0){
			 var ajax_url = "/ssm_wechat/wechat/toAttestation.do";
			 var flag = isAttestation(ajax_url);
			 if(flag){
			 $(this).text("等待审核");
			 $(this).attr("data-val",1);
			 }
		 }else if(isAttestationVal ==1){
			 alert("您已经提交了身份认证，请等待管理员审核");
		 }else if(isAttestationVal ==2 ){
			 alert("您已经认证成功");
			 $(this).hide();
		 }else {
			 alert("您没有通过审核，请重新提交审核");
			 $(this).attr("data-val",0);
			 $(this).text("验证");
		 }
		 
		 
		
	 });
	
});