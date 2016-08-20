package wechat.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wechat.common.ReturnResult;
import wechat.model.Home;
import wechat.service.IHomeService;

/**
 *@author Huang_Shuxing
 *2016年7月2日 下午12:41:39
 */
@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Resource
	private IHomeService homeService;
	
	@RequestMapping("/addHome")
	public @ResponseBody ReturnResult addHome(String homeTown,String homeVal){
		ReturnResult result = new ReturnResult();
		homeTown = (homeTown.replace("镇", ""));
		String townId = homeService.isExistTheTown(homeTown);
		System.out.println(townId);
		homeVal = (homeVal.replace("村", ""));
		String valId = homeService.isExistInTown(homeVal, townId);
		System.out.println(valId);
		result.setState(1);
		return result;
	}
	/**
	 * ajax根据父类homeId获取子类home
	 * @author Huang_Shuxing
	 * 2016年7月3日 下午7:41:14
	 * @param homeUpId        父类homeid
	 * @param model           model
	 * @param url			  beetl异步返回url
	 * @param tagName         加载的tagName
	 * @return
	 */
	@RequestMapping("/ajaxGetVillage")
	public String ajaxGetVillage(String homeUpId,Model model,String returnUrl,String tagName){
		System.out.println("ajaxGetVillage："+homeUpId+"-"+returnUrl+"-"+tagName+"-");
		List<Home> homeList = homeService.getHomeVillage(homeUpId);
		model.addAttribute(tagName, homeList);
		return returnUrl;
	}
	
	@RequestMapping("/ajaxGetNewHome")
	public String ajaxAddAndGet(Model model,String homeTown,String homeVillage,String returnUrl,String tagName) throws UnsupportedEncodingException{
		System.out.println("town:"+homeTown+" village:"+homeVillage);
		homeTown = (homeTown.replace("镇", ""));
		String townId = homeService.isExistTheTown(homeTown);
		if(townId==null){
			System.out.println("数据库没有这个镇");
			Home homeTownModel = new Home(UUID.randomUUID().toString().replaceAll("-", ""), null, homeTown, new Date());
			Home homeVillageModel = new Home(UUID.randomUUID().toString().replaceAll("-", ""), homeTownModel.getId(), homeVillage, homeTownModel.getUpdateTime());
			List<Home> list = new ArrayList<Home>();
			list.add(homeTownModel);
			list.add(homeVillageModel);
			homeService.insertList(list);
			
		}else {
			System.out.println("数据库有这个镇");
			homeVillage = (homeVillage.replace("村", ""));
			String valId = homeService.isExistInTown(homeVillage, townId);
			System.out.println("valId"+valId);
			if(valId==null){
				System.out.println("valId为null");
				Home homeVillageModel = new Home(UUID.randomUUID().toString().replaceAll("-", ""),townId, homeVillage, new Date());
				homeService.insert(homeVillageModel);
			}
		}
		
		List<Home> homeList = homeService.getHomeTown();
		model.addAttribute(tagName, homeList);

		return returnUrl;
	}
}
