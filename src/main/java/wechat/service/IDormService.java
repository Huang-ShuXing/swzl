package wechat.service;

import java.util.List;

import wechat.model.Dorm;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午10:15:07
 */
public interface IDormService {
	/**
	 * 获取所有的楼栋
	 * @author Huang_Shuxing
	 * 2016年6月27日 下午10:29:42
	 * @return
	 */
	public List<Dorm> getListAllDorm();
}
