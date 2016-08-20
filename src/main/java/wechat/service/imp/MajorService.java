package wechat.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import wechat.dao.MajorDao;
import wechat.model.Major;
import wechat.service.IMajorService;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午11:09:31
 */
@Service("majorService")
public class MajorService implements IMajorService {

	@Resource
	private MajorDao majorDao;
	@Override
	public List<Major> getMajorByInstituteId(String instituteId) {
		return majorDao.getMajorByInstituteId(instituteId);
	}

}
