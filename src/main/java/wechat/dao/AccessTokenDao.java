package wechat.dao;

import wechat.model.AccessToken;

/**
 * 
 * @author Huang_Shuxing
 * 2016年6月27日 下午12:04:33
 */
public interface AccessTokenDao {
	
	/**
	 * 获取最新的token
	 * 有没有效未可知，程序自己判断
	 * @author Huang_Shuxing
	 * 2016年6月27日 下午12:09:52
	 * @return
	 */
	public AccessToken getBestNewToken();
	
	/**
	 * 插入一条token
	 * @author Huang_Shuxing
	 * 2016年6月28日 上午11:28:03
	 * @param token
	 * @return
	 */
	public int insert(AccessToken token);
	
}
