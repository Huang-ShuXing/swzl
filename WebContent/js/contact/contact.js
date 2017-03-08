$(document).ready(function(){
	var countNum = 0;
	var openId =$("#ul-ajaxUserList a:first").attr("data-val");
	if(openId!=""){
	myAjax("#ulAjaxDetail","/ssm_wechat/contact/ajaxGetUser.do",{"openId":openId},"detailUser","contact/contact_index.html#ajaxDetailUser");
	}
	
	$("#condition_name,#condition_instituteId,#condition_yearIn").change(function(){
		 $("#userPage_curPage").val(1);
		var name = $("#condition_name").val();
		var instituteId = $("#condition_instituteId").val();
		var yearIn = $("#condition_yearIn").val();
		 $("#myAlert").show();
		 myAsyncAjax("#ul-ajaxUserList","/ssm_wechat/contact/ajaxUserList.do",{"name":name,"instituteId":instituteId,"yearIn":yearIn},"userPage","contact/contact_index.html#ajaxUserList");
		
	});
	
	$("body").delegate("#ul-ajaxUserList li", "click", function(){
		//先验证 然后再判断href
		var atag = $(this).next("a");
		var f = atag.attr("href");
		if(f!="#userinfo_menu"){
			var data = isAttestationNoAlert("/ssm_wechat/wechat/isAttestation.do");
			if(data.state == 1){
				atag.attr('href',"#userinfo_menu");
				$(this).click();
			}else {
				if(countNum == 0 ){
					alert(data.msg);
					countNum ++;
				}				
				atag.removeAttr('href');
			}
		}else {
			var openId = atag.attr("data-val");
			$("#ulAjaxDetail").find($("input")).val("");
			myAjax("#ulAjaxDetail","/ssm_wechat/contact/ajaxGetUser.do",{"openId":openId},"detailUser","contact/contact_index.html#ajaxDetailUser");
			atag.click();
		}
	});
	
	/*$("a").click(function(){
		alert("sss");
		var openId = $(this).attr("data-val");
		myAjax("#ulAjaxDetail","/ssm_wechat/userinfo/ajaxGetUser.do",{"openId":openId},"detailUser","contact/contact_index.html#ajaxDetailUser");
	});*/
	
	$("body").delegate(".btn-check", "click", function(){
		 var curPage = $("#userPage_curPage").val();
		 var totalPage = $("#userPage_totalPage").val();
		 if(curPage >= totalPage){
			 alert("后面已经没有数据了");
			 $(this).remove();
			 return false;
		 }
		
		curPage = Number(curPage)+1;
		$("#condition_name").val();
		var name = $("#condition_name").val();
		var instituteId = $("#condition_instituteId").val();
		$("#userPage_curPage,#userPage_totalPage").remove();
		myAsyncAjaxAppend("#ul-ajaxUserList","/ssm_wechat/contact/ajaxUserPage.do",{"name":name,"instituteId":instituteId,"curPage":curPage},"userPage","contact/contact_index.html#ajaxUserList",$(this));
		$(this).remove();
		});
	 	
	
	
});