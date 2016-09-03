package wechat.service.imp;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import wechat.common.Page;
import wechat.common.ReturnResult;
import wechat.dao.ResourceTypeDao;
import wechat.dao.ShareResourceDao;
import wechat.model.ResourceType;
import wechat.model.ShareResource;
import wechat.service.IShareResourceService;
import wechat.util.MyStringUtil;

/**
 *@author Huang_Shuxing
 *2016年8月21日 下午3:56:36
 */
@Service("shareResourceService")
public class ShareResourceServiceImpl implements IShareResourceService {
	
	@Resource
	private ShareResourceDao dao;
	@Resource
	private ResourceTypeDao rtDao;
	@Override
	public ReturnResult insertResource(ShareResource resource,String typeId) {
		ReturnResult rr = new ReturnResult();
		
		if(MyStringUtil.isEmpty(resource.getTitle())){
			rr.setMsg("请输入标题");
			return rr;
		}
		if(MyStringUtil.isEmpty(resource.getUrl())){
			rr.setMsg("请输入地址");
			return rr;
		}
		if(MyStringUtil.isEmpty(resource.getPassword())){
			resource.setPassword("无");
		}
		//插入类型
		ResourceType rt = new ResourceType(MyStringUtil.getId(),typeId,resource.getId(),null);
		
		if( rtDao.insert(rt)>0 && dao.insert(resource) > 0){
			rr.setMsg("添加成功");
			rr.setState(ReturnResult.SUCCESS);			
		}else{
			rr.setMsg("添加失败，请稍后再添加");
		}
		
		return rr;
	}
	@Override
	public Page<ShareResource> page(HashMap<String, Object> params, Page<ShareResource> page) {
		page.setDataList(null);
		
		/*获取总页数*/
		Integer totalRow = dao.getCount(params);
		if(totalRow ==null){
			page.setTotalRow(0);
			return page;				
		}
//		page.setAndGetStartIndex();

		
		List<ShareResource> list = dao.getList(params);
		page.setTotalRow(totalRow);
		page.setDataList(list);
		
		return  page;
	}

}
