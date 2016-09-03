package wechat.dao;

import java.util.HashMap;
import java.util.List;

import wechat.common.Page;
import wechat.model.ShareResource;
import wechat.model.UserInfo;

/**
 *@author Huang_Shuxing
 *2016年8月21日 下午3:53:30
 */
public interface ShareResourceDao {
	/**
	 * 插入一条百度云资源记录
	 * @author Huang_Shuxing
	 * 2016年8月21日 下午3:54:44
	 * @param resource
	 * @return
	 */
	public int insert(ShareResource resource);
	/**
	 * 按条件先查询总记录数
	 * @author Huang_Shuxing
	 * 2016年8月22日 下午9:17:52
	 * @param params
	 * @return
	 */
	public Integer getCount(HashMap<String, Object> params);
	/**
	 * 根据page的条件获取list
	 * @author Huang_Shuxing
	 * 2016年8月22日 下午9:18:20
	 * @param page
	 * @return
	 */
	public List<ShareResource> getList(HashMap<String, Object> params);
	/**
	 * 
	 * @author Huang_Shuxing
	 * 2016年8月24日 下午10:27:20
	 * @param page
	 * @return
	 */
	/*public List<ShareResource> getListByCondition(Page<ShareResource> page);*/
}
