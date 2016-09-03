package wechat.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import bsh.StringUtil;
import wechat.common.Page;
import wechat.common.ReturnResult;
import wechat.model.ShareResource;
import wechat.model.Wechat;
import wechat.service.IShareResourceService;
import wechat.service.ITypeService;
import wechat.util.MyStringUtil;

/**
 *@author Huang_Shuxing
 *2016年8月17日 下午9:58:53
 */
@Controller
@RequestMapping("bdyun")
@SessionAttributes({"wechat"})
public class BaiDuYunController {
	@Resource
	private IShareResourceService shareResourceService;
	@Resource
	private ITypeService typeService;
	
	@RequestMapping("bdyunIndex")
	public String BDYunIndex(Model model,String returnUrl,String tagName,String curPage,String title,String typeIds){
		HashMap<String,Object>   params = new HashMap<String, Object>();
			
		
		
		if(MyStringUtil.isEmpty(returnUrl)){
			returnUrl = "bdyun/bdyun_index.html";
		}
		if(MyStringUtil.isEmpty(tagName)){
			tagName = "page";
		}
		if(MyStringUtil.isEmpty(curPage)){
				curPage ="1";	
			
		}
		if(!MyStringUtil.isEmpty(title)){
			params.put("title", "%"+title+"%");
		}
		
		if(!MyStringUtil.isEmpty(typeIds)){
			String[] arrType = typeIds.split(",");
			params.put("typeIds", arrType);
		}
		
		
		Page<ShareResource> page = new Page<ShareResource>();
		page.setCurPage(Integer.valueOf(curPage));	
		
		params.put("curPage",page.getCurPage());
		params.put("startIndex", page.getStartIndex());
		params.put("pageSize", page.getPageSize());
		page = shareResourceService.page(params,page);
		model.addAttribute(tagName, page);
		//获取资源标签
		
		model.addAttribute("typeList", typeService.getListAllType());
		
		return returnUrl;
		
	}
	@RequestMapping("/add")
	@ResponseBody
	public ReturnResult add(@ModelAttribute("wechat")Wechat wechat,String title,String url,String password,String type,int[] types){
		ShareResource resource = new ShareResource();
		resource.setId(MyStringUtil.getId());
		resource.setUserinfoId(wechat.getId());
		resource.setTitle(title);
		resource.setUrl(url);
		resource.setPassword(password);
		
		return  shareResourceService.insertResource(resource,type);
	}
}
