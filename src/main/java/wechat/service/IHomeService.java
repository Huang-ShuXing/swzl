package wechat.service;

import java.util.List;

import wechat.model.Home;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午8:57:47
 */
public interface IHomeService {
	/**
	 * 获取镇
	 * @author Huang_Shuxing
	 * 2016年6月27日 下午8:58:38
	 * @return
	 */
	public List<Home> getHomeTown();
	/**
	 * 根据镇id获取村，街道
	 * @author Huang_Shuxing
	 * 2016年6月27日 下午8:58:50
	 * @param homeUpId
	 * @return
	 */
	public List<Home> getHomeVillage(String homeUpId);
	/**
	 * 根据名字获取镇id
	 * @author Huang_Shuxing
	 * 2016年7月2日 下午1:25:02
	 * @param homeName
	 * @return
	 */
	public String isExistTheTown(String homeName);
	/**
	 * 判断homeUpId下有没有对应的村/街道 
	 * @author Huang_Shuxing
	 * 2016年7月3日 下午10:15:17
	 * @param village   村/街道
	 * @param homeUpId  上级镇id
	 * @return
	 */
	public String isExistInTown(String village,String homeUpId);
	
	/**
	 * 插入一条home数据
	 * @author Huang_Shuxing
	 * 2016年7月3日 下午10:03:13
	 * @param home
	 * @return
	 */
	public boolean insert(Home home);
	
	
	public int insertList(List<Home> home);
}
