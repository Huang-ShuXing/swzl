package wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *@author Huang_Shuxing
 *2016年8月17日 下午9:58:53
 */
@Controller
@RequestMapping("bdyun")
@SessionAttributes("wechat")
public class BaiDuYunController {
	
	@RequestMapping("bdyunIndex")
	public String BDYunIndex(){
		return ("bdyun/bdyun_index.html");
		
	}
}
