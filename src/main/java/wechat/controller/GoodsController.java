package wechat.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import wechat.common.Constant;
import wechat.common.Page;
import wechat.common.ReturnResult;
import wechat.model.Institute;
import wechat.model.SwzlLostGoods;
import wechat.service.IInstituteService;
import wechat.service.ISwzlLostGoodsService;
import wechat.service.ITypeService;
import wechat.util.MyStringUtil;

/**
 *@author Huang_Shuxing
 *2016年11月15日 上午12:09:48
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private ISwzlLostGoodsService goodsService;
	@Autowired
	private ITypeService  typeService;
	@Resource
	private IInstituteService instituteService;
	
	@RequestMapping("/getGoodsList")
	/**
	 * 根据条件获取失物列表
	 * @author Huang_Shuxing
	 * 2016年11月20日 上午12:00:04
	 * @return
	 */
	public String getGoodsList(@RequestParam(value="method", required=false)String method,@RequestParam(value="currentPage", required=false,defaultValue="1")Integer currentPage,Model model){
		Map paramMap = new HashMap<String,Object>();
		Page page = new  Page(); 
		page.setCurPage(currentPage);
		paramMap.put("method", method);		
		page = goodsService.getPage(paramMap,page);
		model.addAttribute("page", page);
		return "goods/index::goodsTable";
	}
	
	@RequestMapping("/saveGoods")
	@ResponseBody
	public ReturnResult saveGoods(@RequestBody SwzlLostGoods goods){
		
		ReturnResult rr = new ReturnResult();
		goods.setId(java.util.UUID.randomUUID().toString().replace("-",""));
		goods.setUpdateTime(new Date());
		if(goodsService.saveGoods(goods)){
			rr.setState(Constant.success);
			rr.setMsg("添加成功");		
			rr.setObj(goods);
		}
		return rr;
	}
	@RequestMapping("/getJson")
	@ResponseBody
	public ReturnResult getJson(SwzlLostGoods json){
		ReturnResult rr = new ReturnResult();
		rr.setState(Constant.success);
		rr.setMsg("操作成功");
		return rr;
	}
	
	
	@RequestMapping("/backGoods")
	@ResponseBody
	/**
	 * 设置为找到失主
	 * @author Huang_Shuxing
	 * 2016年11月24日 上午12:03:52
	 * @param goods
	 * @return
	 */
	public ReturnResult backGoods(@RequestBody SwzlLostGoods goods){
		//TODO  改个状态还有时间
		ReturnResult rr = new ReturnResult();
		if(goods.getId()!=null){
			//goods.setGoodsStatus(2);//已经还给主人
			if(goods.getMethod() ==0){
				//捡到
				goods.setGoodsStatus(0);
			}else if(goods.getMethod() ==1){
				//丢了
				goods.setGoodsStatus(1);
			}
			if(goodsService.updateGoods(goods)){
				rr.setState(Constant.success);
				rr.setMsg("操作成功");
				rr.setObj(goods);
			}
		}
		return rr ;
	}
	@RequestMapping("/updateGoods")
	@ResponseBody
	public ReturnResult updateGoods(SwzlLostGoods goods){
		ReturnResult rr = new ReturnResult();
		if(goodsService.updateGoods(goods)){
			rr.setState(Constant.success);
			rr.setMsg("更新成功");
			rr.setObj(goods);
		}
		return rr ;
	}
	@RequestMapping("goodsIndex")
	public String goodsIndex(Model model,String method,String returnUrl,String tagName,String curPage,String name,String typeIds){
		HashMap<String,Object>   params = new HashMap<String, Object>();
		model.addAttribute("isFirst", false);
		if("0".equals(method) || "1".equals(method)){
			params.put("method",method);
		}
		/*if(MyStringUtil.isEmpty(returnUrl)){
			returnUrl = "goods/goods_index.html";
		}*/
		if(MyStringUtil.isEmpty(tagName)){
			tagName = "page";
		}
		if(MyStringUtil.isEmpty(curPage)){
				curPage ="1";	
			
		}
		if(!MyStringUtil.isEmpty(name)){
			params.put("name", "%"+name+"%");
		}
		
		if(!MyStringUtil.isEmpty(typeIds)){
			String[] arrType = typeIds.split(",");
			params.put("typeIds", arrType);
		}
		
		
		Page<SwzlLostGoods> page = new Page<SwzlLostGoods>();
		page.setCurPage(Integer.valueOf(curPage));	
		
		params.put("curPage",page.getCurPage());
		params.put("startIndex", page.getStartIndex());
		params.put("pageSize", page.getPageSize());
		page = goodsService.page(params,page);
		if(MyStringUtil.isEmpty(returnUrl)){
			returnUrl = "goods/goods_index.html";
			page.getDataList().removeAll(page.getDataList());
			model.addAttribute("isFirst", true);
		}
		
		
		model.addAttribute(tagName, page);
		//获取资源标签
		model.addAttribute("typeList", typeService.getListAllType());
		
		
		
//		returnUrl ="goods/index.html";
		return returnUrl;
		
	}
	@RequestMapping("getGoods")
	public String getGoods(Model model,String method ){
		model.addAttribute("typeList", typeService.getListAllType());
		List<Institute> instituteList = instituteService.getAllListInstitute();
		model.addAttribute("instituteList", instituteList);
		model.addAttribute("method", method);
		return "goods/saveGoods.html";
		
		
		
	}
	
	

	@RequestMapping("managerGoods")
	public String managerGoods(Model model,String method,String returnUrl,String tagName,String curPage,String name,String typeIds){
		HashMap<String,Object>   params = new HashMap<String, Object>();
		model.addAttribute("isFirst", false);
		if("0".equals(method) || "1".equals(method)){
			params.put("method",method);
		}
		/*if(MyStringUtil.isEmpty(returnUrl)){
			returnUrl = "goods/goods_index.html";
		}*/
		if(MyStringUtil.isEmpty(tagName)){
			tagName = "page";
		}
		if(MyStringUtil.isEmpty(curPage)){
				curPage ="1";	
			
		}
		if(!MyStringUtil.isEmpty(name)){
			params.put("name", "%"+name+"%");
		}
		
		if(!MyStringUtil.isEmpty(typeIds)){
			String[] arrType = typeIds.split(",");
			params.put("typeIds", arrType);
		}
		
		
		Page<SwzlLostGoods> page = new Page<SwzlLostGoods>();
		page.setCurPage(Integer.valueOf(curPage));	
		
		params.put("curPage",page.getCurPage());
		params.put("startIndex", page.getStartIndex());
		params.put("pageSize", page.getPageSize());
		page = goodsService.page(params,page);
		if(MyStringUtil.isEmpty(returnUrl)){
			returnUrl = "goods/manager_goods.html";
			page.getDataList().removeAll(page.getDataList());
			model.addAttribute("isFirst", true);
		}
		
		
		model.addAttribute(tagName, page);
		//获取资源标签
		model.addAttribute("typeList", typeService.getListAllType());
		
//		returnUrl ="goods/index.html";
		return returnUrl;
		
	}
	
	
	@RequestMapping("/finishGoods")
	@ResponseBody
	public ReturnResult finishGoods(@RequestBody SwzlLostGoods goods){
		ReturnResult rr = new ReturnResult();
		if(goodsService.finishGoods(goods.getId())){
			rr.setState(Constant.success);
			rr.setMsg("更新成功");
		}
		return rr ;
	}
	
	@RequestMapping("/deleteGoods")
	@ResponseBody
	public ReturnResult deleteGoods(@RequestBody SwzlLostGoods goods){
		ReturnResult rr = new ReturnResult();
		if(goodsService.deleteGoods(goods.getId())){
			rr.setState(Constant.success);
			rr.setMsg("删除成功");
		}
		return rr ;
	}
}
