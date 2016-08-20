package wechat.service;

import java.util.List;

import wechat.model.Major;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午11:07:32
 */
public interface IMajorService {
	/**
	 * 获取某个学院的全部专业
	 * @author Huang_Shuxing
	 * 2016年6月27日 下午11:08:08
	 * @param InstituteId
	 * @return
	 */
	public List<Major> getMajorByInstituteId(String instituteId);
}
