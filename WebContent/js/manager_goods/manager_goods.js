$(document).ready(function(){
	
	var imgStrid = [];
	
	var date = new Date();
	var month = date.getMonth(); 
	var day = date.getDate();
	month=(month+1);
	if(month<10){
		month = "0"+month;
	}
	
	if(day<10){
		day = "0"+day;
	}

	var dateString = date.getFullYear() +"-"+month+"-" + day;  
	$("#goods_happendTime").val(dateString);

	$("#btn_add_goods").click(function(){
		
		$(this).attr("disabled","disabled");
		
		var aa =$("[id^='goods_']") ;
		var goods ={};
		goods.imgUrlArr = imgStrid;
		
		// 获取值
		 for(var i=0;i<aa.length;i++){
	            goods[$(aa[i]).attr("id").substr(6)]=$(aa[i]).val();
	     }		
		//检查值
		 var goodsStype = goods.goodsStype ; 
		 if(goodsStype == '1'){
			 // 一卡通
			 if(goods.studentInstituteName ==''){
				 alert("选择一卡通学院");
				 $(this).removeAttr("disabled");
				 return ;
			 }
			 if(goods.studentCard ==''){
				 alert("请输入一卡通学号");
				 $(this).removeAttr("disabled");
				 return ;
			 }
			 if(goods.studentName ==''){
				 alert("请输入一卡通学生姓名");
				 $(this).removeAttr("disabled");
				 return ;
			 }
		 }else if(goodsStype == '2'){
			 //银行卡
			 if(goods.bankName ==''){
				 alert("请输入银行名称");
				 $(this).removeAttr("disabled");
				 return ;
			 }
			 if(goods.bankCard ==''){
				 alert("请输入卡号");
				 $(this).removeAttr("disabled");
				 return ;
			 }
		 }else {
			 //其他
			 if(goods.name==''){
				 alert("请输入物品名称");
				 $(this).removeAttr("disabled");
				 return ;
			 }
		 }
		 
		 //联系人信息验证
		 if(goods.peopleName==''){
			 alert("请输入您的姓名");
			 $(this).removeAttr("disabled");
			 return ;
		 }
		 if(goods.peopleContact==''){
			 alert("请输入您的联系方式");
			 $(this).removeAttr("disabled");
			 return ;
		 }
		 
		var param = JSON.stringify(goods);
		$("#submit").show();
		var data = ajaxPostData("/ssm_wechat/goods/saveGoods.do",param,"/ssm_wechat/goods/goodsIndex.do");
		if(data.state == 1){
			$("#submit").hide();
			$("#toIndex").show();
			setTimeout(function(){location.href="/ssm_wechat/goods/goodsIndex.do";}, 1500);
			
		}else {
			$("#submit").hide();
			$("#failed").show(1000);
			$(this).removeAttr("disabled");
			
		}
		
		
	});
	
	$("body").delegate(".btn-check", "click", function(){
		var txt = $('#collapse_type_label').find('input:checked');
		var type ="";
		for (var i = 0; i < txt.length; i++) {
			var t = txt.eq(i);
			type += t.val()+",";
			//alert(t.val());//checked 的type 
		}
		
		if(type.length>0){
			type = type.substring(0,type.length-1);
		}
		var name = $("#sr_condition_name").val();
		
		
		 var curPage = $("#bdy_curPage").val();
		 var totalPage = $("#bdy_totalPage").val();
		 if(curPage >= totalPage){
			 alert("后面已经没有数据了");
			 $(this).remove();
			 return false;
		 }
		curPage = Number(curPage)+1;
		$("#bdy_curPage,#bdy_totalPage").remove();
		
		myAsyncAjaxAppend("#sr_content","/ssm_wechat/goods/managerGoods.do",{"method":$('.choose').attr("data-val"),"name":name,"typeIds":type,"curPage":curPage},"page","goods/manager_goods.html#ajaxBDyunList",$(this));
		$(this).remove();
		});
	
	$("#sr_btn_search").click(function(){
		
		var txt = $('#collapse_type_label').find('input:checked');
		var type ="";
		for (var i = 0; i < txt.length; i++) {
			var t = txt.eq(i);
			type += t.val()+",";
			//alert(t.val());//checked 的type 
		}
		
		if(type.length>0){
			type = type.substring(0,type.length-1);
		}
		
		$("#bdy_curPage").val(1);
		var name = $("#sr_condition_name").val();
		/*var instituteId = $("#condition_instituteId").val();*/
		 $("#myAlert").show();
		
		 myAsyncAjax("#sr_content","/ssm_wechat/goods/managerGoods.do",{"method":$('.choose').attr("data-val"),"name":name,"typeIds":type},"page","goods/manager_goods.html#ajaxBDyunList");
		
	});
	
	/*$('#model_bdyun_label').on('hide.bs.modal', function () {
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
			
	});*/
	$("#div_new_by_label .div_lebel").click(function(){
		//var now = $(this).find(":checkbox").prop("checked");//判断是不是要取消当前的选择
		
		$("[name = goods_goodsStype]:checkbox").removeAttr("checked");
		var xx =$("[name = goods_goodsStype]:checkbox").parent();
		
		xx.removeClass("border_1_solid");
		xx.children("input").attr("id","");
		
/*		$("[name = goods_goodsStype]:checkbox").children("div").children("span").removeClass("border_1_solid");
		if(!now){}*/ 
			var  c  =$(this).children("div").children("span");
			c.addClass("border_1_solid");
			var cc =c.children("input"); 
			cc.attr("id",cc.attr("name"));
			var b =$(this).find(":checkbox"); 
			b.prop("checked","checked");
			
			
			$("#div_student").hide(100);
			$("#div_bank").hide(100);
			$("#div_name").hide(100);
			//获取type类型
			var type = cc.val();
			if(type == 1){//一卡通
				$("#div_student").show(200);
			}else if(type ==2){//银行卡
				$("#div_bank").show(200);
			}else{
				$("#div_name").show(100);
			}
			
		
		 
	});
	$("#div_label_content .div_lebel").click(function(){
	/*$("body").delegate("#div_label_content .div_lebel", "click", function(){*/
		var checkBox = $(this).find(":input");
		var value = checkBox.val();		
		
		var flag = checkBox.prop("checked");
		if(flag){
			//$(this).removeClass("bg_green");
			$(this).removeClass("border_1_solid");//.children("div").children("span")
			checkBox.removeAttr("checked");
		}else {
			//$(this).addClass("bg_green");
			$(this).addClass("border_1_solid");
			checkBox.prop("checked",true);
			
		}
		//复制点击查询事件
		var txt = $('#collapse_type_label').find('input:checked');
		var type ="";
		for (var i = 0; i < txt.length; i++) {
			var t = txt.eq(i);
			type += t.val()+",";
			//alert(t.val());//checked 的type 
		}
		
		if(type.length>0){
			type = type.substring(0,type.length-1);
		}
		
		$("#bdy_curPage").val(1);
		var name = $("#sr_condition_name").val();
		/*var instituteId = $("#condition_instituteId").val();*/
		myAjax("#sr_content","/ssm_wechat/goods/managerGoods.do",{"method":$('.choose').attr("data-val"),"name":name,"typeIds":type},"page","goods/manager_goods.html#ajaxBDyunList");
	});
	
	$(".table_panel a").click(function(){
			var aArr = $('.table_panel').find('a');
			for(var i=0;i<aArr.length;i++){
				var t = aArr.eq(i);
				$(t).removeClass("choose");
			}
			$(this).addClass("choose");
			
			//复制点击查询事件
			var txt = $('#collapse_type_label').find('input:checked');
			var type ="";
			for (var i = 0; i < txt.length; i++) {
				var t = txt.eq(i);
				type += t.val()+",";
				//alert(t.val());//checked 的type 
			}
			
			if(type.length>0){
				type = type.substring(0,type.length-1);
			}

			$("#bdy_curPage").val(1);
			var name = $("#sr_condition_name").val();
			/*var instituteId = $("#condition_instituteId").val();*/
			myAjax("#sr_content","/ssm_wechat/goods/managerGoods.do",{"method":$('.choose').attr("data-val"),"name":name,"typeIds":type},"page","goods/manager_goods.html#ajaxBDyunList");
			
			
	});
	
	
	
	
	/*$("#a_select_type").click(function(){
		alert("选择某种标签查询");
	});*/
	
	

	$("#file_upload").change(function() {
		var $file = $(this);
		var fileObj = $file[0];
		var windowURL = window.URL || window.webkitURL;
		var dataURL;
		if(fileObj && fileObj.files && fileObj.files[0]){
		dataURL = windowURL.createObjectURL(fileObj.files[0]);

		var image = new Image();
	     image.src = dataURL;
	     var height = image.height;
	     var width = image.width;
	     var $img ;
	     if(height > width){
	    	 var $img = $("<img  class='img_width '  width='60'  height='60' >");
	     }else {
	    	 var $img = $("<img  class=' img_height'  width='60'  height='60' >");
	     }
         var $li_1 = $("<li class='li_cover' style='position: relative;' ></li>");
		 var $parent = $("#id_ul_img");        // 获取<ul>节点。<li>的父节点
		 $li_1.append($img);
		 $parent.prepend($li_1);        // 添加到<ul>节点中，使之能在网页中显示
	     $img.attr('src',dataURL);
		}else{
		//没用
		dataURL = $file.val();
		var imgObj = $img;//$("#preview");
		// 两个坑:
		// 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
		// 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
		imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
		imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
		}
		$("#uploadForm").submit();
		$("#file_upload").val("");
		});
	
	$("#uploadForm").validator({
		valid:function(form){
			//form.submit();
			$("#uploadForm").ajaxSubmit({
				type: "POST",
				async:true,
				url:"/ssm_wechat/img/updateImg.do",
				dataType: "json",
				data: { file: $("#file_upload").val()},
			    success: function(data){
			    	if(data.state==1){
			    			imgStrid.push(data.data.imgId);
			    		 //location.reload() ;
			    		//location.href = "/FYYL/user/userCenter?index=0";
			    	}else {
			    		alert("图片上传失败");
			    	}
				}
			});			 
		}
	});
	
	
	
});