package wechat.service;

import java.util.List;

import wechat.model.Institute;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午10:54:14
 */
public interface IInstituteService {
	/**
	 * 获取全部的学院信息
	 * @author Huang_Shuxing
	 * 2016年6月27日 下午10:56:16
	 * @return
	 */
	public List<Institute> getAllListInstitute();
}
