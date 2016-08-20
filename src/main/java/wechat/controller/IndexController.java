package wechat.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import wechat.model.Wechat;
import wechat.service.IWechatService;

/**
 *@author Huang_Shuxing
 *2016年7月9日 下午5:02:18
 */
@Controller
@SessionAttributes("wechat")
public class IndexController {
	@Resource
	private IWechatService wechatService;
	@RequestMapping("/index")
	public String index(Model model,String openId){
		
		Wechat wechat =  new Wechat();
		wechat = wechatService.getByOpenId(openId);
		model.addAttribute("wechat", wechat);
		//return "contact/mmenu.html";
		/*return "index.html";*/
		return "new_index.html";
		
	}
	@RequestMapping("/testDate")
	public String testDate(){
		return "test_date.html";
	}
	
	@RequestMapping("/{openId}/index")
	public String indexShowURL(Model model,@PathVariable(value="openId")String openId){
		
		Wechat wechat =  new Wechat();
		wechat = wechatService.getByOpenId(openId);
		model.addAttribute("wechat", wechat);
		//return "contact/mmenu.html";
		/*return "index.html";*/
		return "new_index.html";
		
	}
	
	
	
	
	
	
}
