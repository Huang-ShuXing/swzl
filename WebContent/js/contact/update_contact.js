$(document).ready(function(){
	
	$('#userInfo_form').validator({
	    rules: {
	        // 自定义规则mobile，如果通过返回true，否则返回错误消息
	        date_required: function(element, param, field) {
	            return /(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)/.test(element.value) || '请检查日期格式(yyyy-MM-dd)';
	        }
	    },
	    fields: {
	    	userBirthday: 'required;date_required'
	    }
	});	

});

