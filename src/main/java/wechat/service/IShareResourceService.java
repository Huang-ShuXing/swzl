package wechat.service;

import java.util.HashMap;

import wechat.common.Page;
import wechat.common.ReturnResult;
import wechat.model.ShareResource;

/**
 *@author Huang_Shuxing
 *2016年8月21日 下午3:55:24
 */
public interface IShareResourceService {
	/**
	 * 插入一条百度云记录
	 * @author Huang_Shuxing
	 * 2016年8月21日 下午3:56:00
	 * @param resource
	 * @param type
	 * @return
	 */
	public ReturnResult insertResource(ShareResource resource,String type);
	/**
	 * 分页查询百度云资源
	 * @author Huang_Shuxing
	 * 2016年8月22日 下午9:10:04
	 * @param params
	 * @param page
	 * @return
	 */
	public Page<ShareResource> page(HashMap<String, Object> params, Page<ShareResource> page);
}
