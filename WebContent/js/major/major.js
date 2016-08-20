$(document).ready(function(){
	$("#instituteSelect").change(function(){
		var instituteId = $("#instituteSelect").val();
		
		myAjax("#majorSelect","/ssm_wechat/major/ajaxGetMajorByInistute.do",{"instituteId":instituteId},"majorList","contact/updateContact.html#ajaxMajorList");
		
		
		
	});
	
	
});