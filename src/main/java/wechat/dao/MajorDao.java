package wechat.dao;

import java.util.List;

import wechat.model.Major;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午11:05:43
 */
public interface MajorDao {
	/**
	 * 根据majorInstituteId获取该学院的专业list
	 * @author Huang_Shuxing
	 * 2016年6月27日 下午11:07:05
	 * @param majorInstituteId
	 * @return
	 */
	public List<Major> getMajorByInstituteId(String majorInstituteId);
}
