package wechat.dao;

import wechat.model.ResourceType;

/**
 *@author Huang_Shuxing
 *2016年9月3日 下午10:47:00
 */
public interface ResourceTypeDao {
	/**
	 * 插入资源-类型关系表
	 * @author Huang_Shuxing
	 * 2016年9月3日 下午10:47:20
	 * @param rt
	 * @return
	 */
	public int insert(ResourceType rt);
}
