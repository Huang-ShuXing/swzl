package wechat.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import wechat.common.Page;
import wechat.model.Dorm;
import wechat.model.Home;
import wechat.model.Institute;
import wechat.model.Major;
import wechat.model.UserInfo;
import wechat.model.Wechat;
import wechat.service.IAccessTokenService;
import wechat.service.ICoreService;
import wechat.service.IDormService;
import wechat.service.IHomeService;
import wechat.service.IInstituteService;
import wechat.service.IMajorService;
import wechat.service.IUserService;
import wechat.service.IWechatService;
import wechat.util.DateUtil;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午9:01:36
 */
@Controller
@RequestMapping("/contact")
@SessionAttributes("wechat")
public class ContactController {
	
	@Resource
	private IUserService userService;
	
	@Resource
	private IHomeService homeService;
	
	@Resource
	private IDormService dormService;
	
	@Resource
	private IInstituteService instituteService;
	
	@Resource
	private IMajorService majorService;
	
	@Resource
	private IWechatService wechatService;
	
	@Resource
	private ICoreService coreService;
	
	@Resource
	private IAccessTokenService accessTokenService;
	
	@RequestMapping("/getUser")
	public String userInfo(){
		System.out.println("saasas");
		return "mmenu.html";
	}
	
	@RequestMapping(value= "/updateContact" )
	public ModelAndView toUpdateView(String openId){
		
/*		
		UserInfo user = new UserInfo(UUID.randomUUID().toString().replace("-", ""),
				"名字", (short)0,"222323", "321321", "龙山中学","金厢镇",
				"洲渚村", new Date(2012-1900,9,1),new Date(2016-1900,9,1),
				"13560415805", "头像地址", (short) 1, "住深圳", "B14",
				"424",new Date(),UUID.randomUUID().toString().replace("-", ""),"1206100166" );

		userService.insertUser(user);
		
		
		
		测试镇村-start
		System.out.println("测试镇村-start");
		List<Home> town = homeService.getHomeTown();
		System.out.println(town.size());
		for(int k=0;k<town.size();k++){
		List<Home> village = homeService.getHomeVillage(town.get(k).getId());
		for(int i=0;i<village.size();i++){
			System.out.println(village.get(i).getHomeName());
		}
		}
		System.out.println("测试镇村-end");
		测试镇村-end
		
		
		测试楼栋-start
		System.out.println("测试楼栋-start");
		List<Dorm> dorm = dormService.getListAllDorm();
		System.out.println(town.size());
		for(int k=0;k<dorm.size();k++){
			System.out.println(dorm.get(k).getDormName());
		}
		System.out.println("测试楼栋-end");
		测试楼栋-end
		
		
		测试学院和专业-start
		System.out.println("测试学院-start");
		List<Institute> institute = instituteService.getAllListInstitute();
		System.out.println(town.size());
		for(int k=0;k<institute.size();k++){
			System.out.println(institute.get(k).getInstituteName());
			List<Major> major = majorService.getMajorByInstituteId(institute.get(k).getId());
			for(int x= 0;x<major.size();x++){
				System.out.print("该学院对应专业"+major.get(x).getId()+",");
				System.out.println(major.get(x).getMajorName());
			}
		}
		System.out.println("测试学院-end");
		测试学院院和专业-end
		
		
		System.out.println("测试插入wechat信息-start");
		Wechat wechat = new Wechat();
		wechat.setId(UUID.randomUUID().toString().replace("-", ""));
		wechat.setUpdateTime(new Date());
		wechat.setWechatOpenId(UUID.randomUUID().toString().replace("-", ""));
		wechat.setWechatUserinfoId(UUID.randomUUID().toString().replace("-", ""));
		wechatService.insertWechat(wechat);
		System.out.println("测试插入wechat信息-end");
		
		System.out.println("测试插入accessToken信息-start");
		AccessToken accessToken = new AccessToken();
		accessToken.setId(UUID.randomUUID().toString().replace("-", ""));
		accessToken.setToken(UUID.randomUUID().toString().replace("-", ""));
		accessToken.setUpdateTime(new Date());
		accessToken.setValidTime(new Date());
		if(accessTokenService.insertToken(accessToken)){
			System.out.println("插入成功");
		}else {
			System.out.println("插入失败");
		}
		System.out.println("测试插入accessToken信息-end");*/
		/*Wechat wechat = new Wechat("1", 1, "2", "2", 0, "", "", "", "", "", "", "", "", "", new Date());
		coreService.insertOrUpdateWechat("oekNDwlKZhE_ra6bToEjZiCehqls");*/
		
		ModelAndView mav = new ModelAndView();
		/*用户信息*/
		UserInfo user = new UserInfo();
		user = userService.getUserByOpenId(openId);
		//System.out.println("user:"+user.getUserName());
		
		if(user!=null){mav.addObject("user", user);}
		
		/* 城镇 */
		List<Home> town = homeService.getHomeTown();
		mav.addObject("town", town);
		if(user!=null &&!"".equals(user.getUserHomeTownId())){
			List<Home> village = homeService.getHomeVillage(user.getUserHomeTownId());
			mav.addObject("village", village);
		}
		
		/*学院 专业*/
		List<Institute> instituteList = instituteService.getAllListInstitute();
		mav.addObject("instituteList", instituteList);		
		if(user!=null &&!"".equals(user.getUserInstituteId())){
			List<Major> majorList = majorService.getMajorByInstituteId(user.getUserInstituteId());
			mav.addObject("majorList", majorList);
		}
		
		
		mav.addObject("wechatOpenId", openId);
		/*mav.setViewName("index.html");*/
		mav.setViewName("contact/updateContact.html");
		
		/*入学毕业时间*/
		mav.addObject("inDateList",DateUtil.getInUniversityDateList());
		mav.addObject("outDateList", DateUtil.getOutUniversityDateList());
		
		/*宿舍楼*/
		List<Dorm> dormList = dormService.getListAllDorm();
		mav.addObject("dormList", dormList);
		
		
		return mav;
	}
	@RequestMapping("/contactIndex")
	public String index(@ModelAttribute("wechat")Wechat wechat,Model model ,Page<UserInfo> page){
		List<Institute> instituteList = instituteService.getAllListInstitute();
		model.addAttribute("instituteList", instituteList);
		HashMap<String,Object>  map = new HashMap<String,Object>();
		
		Page<UserInfo> userPage = userService.getPage(map, page);
		/*List<UserInfo> userList = userService.getList(map);*/
	    /*System.out.println("size:"+userList.size());*/
		model.addAttribute("userPage", userPage);
		return ("contact/contact_index.html");
	}
	@RequestMapping("/getImgUrl")
	@ResponseBody
	public String getImgUrl(String openId){
		String url =wechatService.getImgUrl(openId) ;
		System.out.println(url);
		return url;
		
	}
	
	@RequestMapping("/ajaxUserList")
	public String getResultList(Model model,String name,String instituteId,String returnUrl,String tagName){
		System.out.println("name:"+name+"url:"+returnUrl+"instituteId:"+instituteId+"tagName:"+tagName);
		HashMap<String,Object>  map = new HashMap<String,Object>();
		Page<UserInfo> page = new Page<>();
		map.put("name", name);
		map.put("instituteId", instituteId);
		Page<UserInfo> userPage = userService.getPage(map, page);
		/*List<UserInfo> userList = userService.getList(map);*/
		/*System.out.println("size:"+userList.size());*/
		model.addAttribute(tagName, userPage);
		return returnUrl;
	}
	
	@RequestMapping("/ajaxUserPage")
	public String getResultPage(Model model,String name,String instituteId,String returnUrl,String tagName,int curPage){
		System.out.println("name:"+name+"url:"+returnUrl+"instituteId:"+instituteId+"tagName:"+tagName);
		HashMap<String,Object>  map = new HashMap<String,Object>();
		Page<UserInfo> page = new Page<>();
		page.setCurPage(curPage);
		map.put("name", name);
		map.put("instituteId", instituteId);
		Page<UserInfo> userPage = userService.getPage(map, page);
		/*List<UserInfo> userList = userService.getList(map);*/
		/*System.out.println("size:"+userList.size());*/
		model.addAttribute(tagName, userPage);
		return returnUrl;
	}
	
	
	
	@RequestMapping(value ="/save",method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("wechat")Wechat wechat ,UserInfo userInfo){
		/*System.out.println("home"+userInfo.getUserHomeTownId());*/
		ModelAndView mav = new ModelAndView();
		/*System.out.println(userInfo.getUserBirthday());
		System.out.println(userInfo.getUserDormBuilding())*/;
		userInfo.setId(UUID.randomUUID().toString().replace("-", ""));
		userInfo.setUpdateTime(new Date());
		userInfo.setUserWechatOpenId(wechat.getOpenid());
		userInfo.setUserWechatName(wechat.getNickname());
		userService.insertUser(userInfo);
		mav.setViewName("redirect:../contact/contactIndex.do");
		return mav;
	}
	/**
	 * 
	 * @author Huang_Shuxing
	 * 2016年7月13日 下午11:19:52
	 * @param model
	 * @param openId     openId
	 * @param returnUrl  返回的url地址
	 * @param tagName    在页面中获取的参数名字
	 * @return
	 */	
	@RequestMapping("/ajaxGetUser")
	public String ajaxGetUser(@ModelAttribute("wechat")Wechat wechat,String openId,Model model,String returnUrl,String tagName){
		System.out.println("ajaxGetUser");
		UserInfo user = new UserInfo();
		if(wechat.getIsAttestation()!=2){
			//没有验证的 无法查看其他人的详细信息
			user.setInstitute(new Institute());
			user.setMajor(new Major());
			user.setUserName("无法查看详情");
			user.setUserQq("您还没有验证您的信息");
		}else{
			user = userService.getUserByOpenId(openId);
		}
		
		model.addAttribute(tagName, user);
		return returnUrl;
	}
	
	
}


