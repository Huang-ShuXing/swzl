package wechat.dao;

import java.util.List;

import wechat.model.Institute;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午10:52:34
 */
public interface InstituteDao {
	/**
	 * 获取全部的学院信息
	 * @author Huang_Shuxing
	 * 2016年6月27日 下午10:53:09
	 * @return
	 */
	public List<Institute> getListAllInstitute();
	
}
