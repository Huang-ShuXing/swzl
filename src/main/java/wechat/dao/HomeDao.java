package wechat.dao;



import java.util.HashMap;
import java.util.List;

import wechat.model.Home;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午8:55:00
 */
public interface HomeDao {
	/**
	 * 获取全部的镇 home_up_id = null
	 * @author Huang_Shuxing
	 * 2016年6月27日 下午8:55:58
	 * @return
	 */
	public List<Home> getHomeTown();
	/**
	 * 根据镇id获取 该镇的村，街道等。
	 * home_up_id 
	 * @author Huang_Shuxing
	 * 2016年6月27日 下午8:56:33
	 * @return
	 */
	public List<Home> getHomeVillage(String homeUpId);
	/**
	 * 判断这个镇在不在数据库里
	 * @author Huang_Shuxing
	 * 2016年7月2日 下午12:47:06
	 * @param hoemName
	 * @return
	 */
	public String isExistTheTown(String hoemName);
	/**
	 * 插入一条home记录
	 * @author Huang_Shuxing
	 * 2016年7月3日 下午10:03:53
	 * @param home
	 * @return
	 */
	public int insert(Home home);
	/**
	 * 判断home_name = village 和hoem_up_id = homeUpId 的数据存在不
	 * @author Huang_Shuxing
	 * 2016年7月3日 下午10:16:33
	 * @param map
	 *        village
	 *        homeUpId
	 * @return
	 */
	public String isExistInTown(HashMap<String, String> map);
	/**
	 * 批量插入home
	 * @author Huang_Shuxing
	 * 2016年7月3日 下午10:27:43
	 * @param home
	 * @return
	 */
	public int insertList(List<Home> list);
}
