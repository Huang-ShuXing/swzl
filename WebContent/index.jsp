<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../userinfo/save.do" method="post" >

		 姓名：<input type="text" id="userName" name="userName" value="" /><br/>
		 性别：<input type="radio"  name="userSex" value="0" checked="checked" /> 男   
		 	  <input type="radio"  name="userSex" value="1" />女
		 	  <br/>
		学号：<input type="text" name="userStudentNo"><br/>
		学院：
		<select name="userInstituteId">  
			<option>学院1</option>
			<option>学院2</option>
		</select>
		<br/>
		专业：
		<select name="userMajorId"> 
			<option>专业1</option>
			<option>专业2</option>
		</select> 
		<br/>
		高中：
		<input type="text" id="userHighSchool" name="userHighSchool" value="" /><br/> 
		籍贯<br/>
		镇：<select name="userHomeTown">
				<option>镇1</option>
				<option>镇2</option>
			</select>
		村/街道:<select name="userHomeVillage">
				<option>村</option>
				<option>街道</option>
			</select>
		<button> 添加一个镇还有街道 模态框</button>
		<br>
		
		入学时间：
		
		
		<select name="userInUniversityDate">
			<option>2012</option>
			<option>2013</option>
			<option>2014</option>
		</select>
		
		毕业时间：
		<select name="userGraduateUniversityDate">
			<option>2012</option>
			<option>2013</option>
			<option>2014</option>
		</select>
		<br/>
		联系方式:
		<input type="text" name="userContact">
		<br/>
		  
		头像：
		<input type="text" name="userHead"><br>
		学位：
		<select name="userDegree">
			<option value="0">本科</option>
			<option value="1">研究生</option>
		</select>
		<br/>
		宿舍：<select name="userDormBuilding">
				<option>B1</option>
				<option>B2</option>
			  </select>
			  
			  <select name="userDormFloor">
				<option>424</option>
				<option>423</option>
			  </select>
			  <br/>
		居住地:
		<input type="text" name="userAddress">
		 
		<input type="submit" value="提交">
		
	</form>
</body>
</html>