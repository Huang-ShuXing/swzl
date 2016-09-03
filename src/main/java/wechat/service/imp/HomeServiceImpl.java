package wechat.service.imp;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import wechat.dao.HomeDao;
import wechat.model.Home;
import wechat.service.IHomeService;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午8:59:22
 */
@Service("homeService")
public class HomeServiceImpl implements IHomeService {

	@Resource
	private HomeDao homeDao;
	@Override
	public List<Home> getHomeTown() {
		return homeDao.getHomeTown();
	}

	@Override
	public List<Home> getHomeVillage(String homeUpId) {
		if("".equals(homeUpId)){
			return null;
		}
		return homeDao.getHomeVillage(homeUpId);
		
	}

	@Override
	public String isExistTheTown(String homeName) {
		return homeDao.isExistTheTown(homeName);
	}

	@Override
	public boolean insert(Home home) {
		return homeDao.insert(home)>0;
	}

	@Override
	public String isExistInTown(String village, String homeUpId) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("village", village);
		map.put("homeUpId", homeUpId);
		return homeDao.isExistInTown(map);
	}

	@Override
	public int insertList(List<Home> home) {
		return homeDao.insertList(home);
	}

}
