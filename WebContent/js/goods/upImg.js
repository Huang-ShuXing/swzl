$(document).ready(function(){
	var imgStrid = [];
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
			    			imgStrid.push(data.imgId);
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