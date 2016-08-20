package wechat.service;

import wechat.model.AccessToken;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午12:59:34
 */
public interface IAccessTokenService {

	/**
	 * 获取当前有效的token
	 * 1.获取static 的accessToken 有并且有效则返回token
	 * 2.如果staticaccessToken没有或者失效 则去数据库查询最新的，
	 *   否则去微信端获取最新的accessToken然后赋值给static 并插入数据库
	 * @author Huang_Shuxing
	 * 2016年6月27日 下午2:15:58
	 * @return
	 */
	public AccessToken getToken();
	
	/**
	 * 插入一个从微信段获取的新的token
	 * @author Huang_Shuxing
	 * 2016年6月27日 下午2:17:01
	 * @return
	 */
	public boolean insertToken(AccessToken token);
	
	
	
	
}
