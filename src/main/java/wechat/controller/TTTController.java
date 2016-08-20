package wechat.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import wechat.model.Home;
import wechat.service.IHomeService;

/**
 *@author Huang_Shuxing
 *2016年7月10日 下午6:32:55
 */
@Controller
@RequestMapping("/test")
public class TTTController {
	
	@Resource
	private IHomeService homeService;
	
	@RequestMapping("/test")
	public void test(){
		List<Home> list = homeService.getHomeTown();
		System.err.println(list.size());
		Home home  = new Home("ss", "", "测试", new Date());
		homeService.insert(home);
		List<Home> listsss= homeService.getHomeTown();
		System.err.println(listsss.size());
	}
}
