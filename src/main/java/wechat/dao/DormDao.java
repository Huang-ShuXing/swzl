package wechat.dao;

import java.util.List;

import wechat.model.Dorm;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午10:14:35
 */
public interface DormDao {
	/**
	 * 楼栋
	 * @author Huang_Shuxing
	 * 2016年7月12日 上午12:37:34
	 * @return
	 */
	public List<Dorm> getListAllDorm();
}
