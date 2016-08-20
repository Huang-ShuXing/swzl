package wechat.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import wechat.dao.DormDao;
import wechat.model.Dorm;
import wechat.service.IDormService;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午10:15:37
 */
@Service("dormService")
public class DormService implements IDormService {
	@Resource
	private DormDao dormDao;
	@Override
	public List<Dorm> getListAllDorm() {
		return dormDao.getListAllDorm();
		
	}

}
