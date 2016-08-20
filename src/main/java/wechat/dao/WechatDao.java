package wechat.dao;

import wechat.model.Wechat;

/**
 *@author Huang_Shuxing
 *2016年6月28日 上午11:03:21
 */
public interface WechatDao {
	/**
	 * 插入一条Wechat记录
	 * @author Huang_Shuxing
	 * 2016年6月28日 上午11:03:50
	 * @param wechat
	 * @return
	 */
	public int insertOrUpdate(Wechat wechat);
	/**
	 * 根据openId获取用户wechat信息
	 * @author Huang_Shuxing
	 * 2016年7月9日 下午8:00:03
	 * @param openId
	 * @return
	 */
	public Wechat getByOpenId(String openId);
	/**
	 * 根据openId获取头像地址
	 * @author Huang_Shuxing
	 * 2016年7月9日 下午10:09:44
	 * @param openId
	 * @return
	 */
	public String getImgUrl(String openId);
	
	
}
