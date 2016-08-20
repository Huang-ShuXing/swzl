package wechat.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@author Huang_Shuxing
 *2016年6月30日 上午12:35:10
 */
public interface ICoreService {
	/**
	 * 微信请求处理方法
	 * @author Huang_Shuxing
	 * 2016年6月30日 下午3:07:00
	 * @param request
	 * @return
	 */
	public String processRequest(HttpServletRequest request,HttpServletResponse response);
	/**
	 * 插入微信用户的基本信息
	 * 在开始关注的时候使用这个方法，包含更新和删除
	 * 后续增加一个到达指定时间的时候去更新
	 * @author Huang_Shuxing
	 * 2016年6月30日 下午3:07:15
	 * @param openId
	 */
	public void insertOrUpdateWechat(String openId);
}
