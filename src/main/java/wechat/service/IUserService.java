package wechat.service;

import java.util.HashMap;
import java.util.List;

import wechat.common.Page;
import wechat.model.UserInfo;

public interface IUserService {
	public void insertUser(UserInfo user);
	/**
	 * 获取用户基本信息
	 * 可以获取到用户学院类专业类
	 * @author Huang_Shuxing
	 * 2016年7月14日 上午12:01:52
	 * @param openId
	 * @return
	 */
	public UserInfo getUserByOpenId(String openId);
	/**
	 * 根据条件查找
	 * 名字模糊 name
	 * 学院查询 instituteId
	 * @author Huang_Shuxing
	 * 2016年7月9日 下午10:16:20
	 * @param map
	 * @return
	 */
	/*public List<UserInfo> getList(HashMap<String, String> map);*/
	
	/**
	 * 
	 * 分页根据条件查找
	 * 名字模糊 name
	 * 学院查询 instituteId
	 * @author Huang_Shuxing
	 * 2016年7月9日 下午10:16:20
	 * @param map
	 * @return
	 */
	public Page<UserInfo> getPage(HashMap<String, Object> map,Page<UserInfo> page);
	
	/**
	 * openId 的用户信息是否允许通过验证
	 * @author Huang_Shuxing
	 * 2016年7月19日 上午12:10:59
	 * @param openId
	 * @return
	 */
	public boolean isAll(String openId);
	 /**
	  * 获取web中所有的年级
	  * @author Huang_Shuxing
	  * 2016年9月11日 上午9:09:30
	  * @return
	  */
	public List<String> getYearInList();
	
}
