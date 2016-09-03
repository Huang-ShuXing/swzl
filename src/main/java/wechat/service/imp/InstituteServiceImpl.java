package wechat.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import wechat.dao.InstituteDao;
import wechat.model.Institute;
import wechat.service.IInstituteService;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午10:55:07
 */
@Service("instituteService")
public class InstituteServiceImpl implements IInstituteService{

	@Resource
	private InstituteDao instituteDao;
	@Override
	public List<Institute> getAllListInstitute() {
		// TODO Auto-generated method stub
		return instituteDao.getListAllInstitute();
	}

}
