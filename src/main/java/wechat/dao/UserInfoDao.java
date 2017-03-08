package wechat.dao;

import java.util.HashMap;
import java.util.List;

import wechat.model.UserInfo;

public interface UserInfoDao {
	/**
	 * 插入一条新的数据
	 * @author Huang_Shuxing
	 * 2016年6月27日 下午4:38:50
	 * @param user
	 */
	public void insert(UserInfo user);
	/**
	 * 更新一条用户信息
	 * 如果用户信息存在，则更新sql，不存在就插入
	 * @author Huang_Shuxing
	 * 2016年6月27日 下午4:41:14
	 * @param user
	 * @return
	 */
	public boolean update(UserInfo user);
	
	public UserInfo getUserInfo(String openId);
	/**
	 * 名字模糊 name
	 * 学院查询 instituteId
	 * @author Huang_Shuxing
	 * 2016年7月9日 下午10:18:12
	 * @param map
	 * @return
	 */
	public List<UserInfo> getList(HashMap<String, Object> map);
	
	/**
	 * 分页查询总数
	 * 名字模糊 name
	 * 学院查询 instituteId
	 * @author Huang_Shuxing
	 * 2016年7月9日 下午10:18:12
	 * @param map
	 * @return
	 */
	public Integer getCount(HashMap<String, Object> map);
	/**
	 * 查询所有的年级
	 * 
	 * @author Huang_Shuxing
	 * 2016年9月11日 上午9:03:51
	 * @return
	 */
	public List<String> getYearInList();
	
}
