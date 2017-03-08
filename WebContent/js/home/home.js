$(document).ready(function(){

		
		
	/**
	 * 
	 * @param select     选择器
	 * @param url	     后台返回的url
	 * @param homeId     父类homeId
	 * @param tagName    数据list名
	 */
	ajaxAddress =function(select,url,homeId,tagName){
		$(select).load("/ssm_wechat/home/ajaxGetVillage.do",
	  			{
				"homeUpId":homeId,
				"url":url,
				"tagName": tagName
	  			});
	};
	
	
	
	$("#townSelect").change(function(){
		var homeId = $("#townSelect").val();
		
		myAjax("#villageSelect","/ssm_wechat/home/ajaxGetVillage.do",{"homeUpId":homeId},"village","contact/updateContact.html#ajaxVillage");

		
	});
	$("#addHome").submit(function(e){
		e.preventDefault();
		var homeTown = $("#homeTown").val();
		var homeVillage = $("#homeVillage").val();
		
		myAjax("#townSelect","/ssm_wechat/home/ajaxGetNewHome.do",{"homeTown":homeTown,"homeVillage":homeVillage},"town","contact/updateContact.html#ajaxTown");
		
		$("#addHomeModel").modal('hide');
	  });
	
});