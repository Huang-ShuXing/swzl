package wechat.service;

import wechat.model.Wechat;

/**
 *@author Huang_Shuxing
 *2016年6月28日 上午11:06:05
 */
public interface IWechatService {
	/**
	 * 插入一条数据
	 * @author Huang_Shuxing
	 * 2016年6月28日 上午11:06:48
	 * @param wechat
	 * @return
	 */
	public boolean insertWechat(Wechat wechat);
	
	/**
	 * 根据openId获取用户微信资料的信息
	 * @author Huang_Shuxing
	 * 2016年7月9日 下午7:59:08
	 * @param openId
	 * @return
	 */
	public Wechat getByOpenId(String openId);
	/**
	 * 根据用户的openId获取头像地址
	 * @author Huang_Shuxing
	 * 2016年7月9日 下午10:08:59
	 * @param openId
	 * @return
	 */
	public String getImgUrl(String openId);
	/**
	 * 更新wechat
	 * @author Huang_Shuxing
	 * 2016年7月21日 上午12:59:42
	 * @param wechat
	 */
	public boolean update(Wechat wechat);
	
	
	/*W*/
}
