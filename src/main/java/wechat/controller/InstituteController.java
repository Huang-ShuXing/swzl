package wechat.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import wechat.service.IInstituteService;



/**
 * 学院信息
 *@author Huang_Shuxing
 *2016年7月3日 下午8:30:06
 */
@Controller
public class InstituteController {
	@Resource
	private IInstituteService instituteService;
	
}
