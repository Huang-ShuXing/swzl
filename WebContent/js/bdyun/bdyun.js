$(document).ready(function(){
	
	$("#btn_add_resource").click(function(){
		
		var title = $("#sr_title").val();
		var url = $("#sr_url").val();
		var password = $("#sr_password").val();
		
		if(title == ""){
			alert("请输入标题");
			return false;
		}
		
		if(url == ""){
			alert("请输入网络地址");
			return false;
		}
		
		if(password!="" && password.length > 6){
				alert("密码长度仅限于6位哦")
				return false;
		}
		
		reg=/^http:\/\/[a-zA-Z0-9]+\.[a-zA-Z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/;  
		//var isUrl = /^http://[a-zA-Z0-9]+.[a-zA-Z0-9]+[/=?%-&_~`@[]':+!]*([^<>""])*$/ ;
		if(!reg.test(url)){
			alert("请输入正确的网络地址");
			return false;
		}
		
		params ={"title":title,"url":url,"password":password};
		var data = ajaxGetData("/ssm_wechat/bdyun/add.do",params);
		if(data.state == 1){
			alert("您的分享已被发布");
			location.href="/ssm_wechat/bdyun/bdyunIndex.do";
		}else {
			alert(data.msg);
		}
	});
	
	$("body").delegate(".btn-check", "click", function(){
		 var curPage = $("#bdy_curPage").val();
		 var totalPage = $("#bdy_totalPage").val();
		 if(curPage >= totalPage){
			 alert("后面已经没有数据了");
			 $(this).remove();
			 return false;
		 }
		curPage = Number(curPage)+1;
		$("#bdy_curPage,#bdy_totalPage").remove();
		myAsyncAjaxAppend("#sr_content","/ssm_wechat/bdyun/bdyunIndex.do",{"curPage":curPage},"page","bdyun/bdyun_index.html#ajaxBDyunList",$(this));
		$(this).remove();
		});
	
	$("#sr_btn_search").click(function(){
		alert("选择的标签目前还没有加入到选择的条件中");
		$("#bdy_curPage").val(1);
		var title = $("#sr_condition_name").val();
		/*var instituteId = $("#condition_instituteId").val();*/
		 $("#myAlert").show();
		 
		 myAsyncAjax("#sr_content","/ssm_wechat/bdyun/bdyunIndex.do",{"title":title},"page","bdyun/bdyun_index.html#ajaxBDyunList");
		
	});
	
	$('#model_bdyun_label').on('hide.bs.modal', function () {
		  var hh ="";
		  var txt = $('#model_bdyun_label').find('input:checked'); // 获取所有文本框
			for (var i = 0; i < txt.length; i++) {
				var t = txt.eq(i);
				var qq = $(t).parent().next();
				//alert (qq.text());
				hh += "<div class='div_lebel'>" +
				" <span class='label label-success ' style='font-size: 90%;' >"+qq.text() +
			    " <span class='btn delete_type' >x</span> "+
			    " <input type='hidden' value='"+txt.eq(i).val()+"'/>"+
			    " </span> " + 
			    " </div>";
			}
			hh +=" <div class='div_lebel'>" +
				 " <span class='label label-info ' style='font-size: 90%;' >" +
				 " <a id ='a_select_type' class='btn' style=' padding:2px;'> "+
				 " <span class='glyphicon glyphicon-plus' data-toggle='modal' data-target='#model_bdyun_label' ></span> "+
				 " </a> </span>	</div> ";	
				
			$("#div_label_content").html(hh);
			
	});
	
	$("body").delegate(".delete_type", "click", function(){
		  var value = $(this).next().val();
		  $(this).parent().parent().remove();
		  var txt = $('#model_bdyun_label').find('input:checked'); // 获取所有文本框
		  for (var i = 0; i < txt.length; i++) {
				var t = txt.eq(i);
				if(t.val()==value){
					t.attr("checked", false);
				}
			}
		 
	});
	
	
	/*$("#a_select_type").click(function(){
		alert("选择某种标签查询");
	});*/
	
});