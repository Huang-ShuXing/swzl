package wechat.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wechat.model.Major;
import wechat.service.IMajorService;

/**
 *专业
 *@author Huang_Shuxing
 *2016年7月3日 下午9:24:21
 */
@Controller
@RequestMapping("major")
public class MajorController {
	@Resource
	private IMajorService majorService;
	
	@RequestMapping( "/ajaxGetMajorByInistute" )
	public String ajaxGetMajroByInistute(Model model,String tagName,String returnUrl,String instituteId){
		System.out.println("tagName:"+tagName+"returnUrl:"+returnUrl+"instituteId:"+instituteId);
		List<Major> majorList = majorService.getMajorByInstituteId(instituteId);
		model.addAttribute(tagName, majorList);		
		return returnUrl;
	}
	
}
