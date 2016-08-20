package wechat.service.imp;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wechat.common.Page;
import wechat.dao.UserInfoDao;
import wechat.model.UserInfo;
import wechat.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserInfoDao dao;

	@Override
	public void insertUser(UserInfo user) {
		dao.insert(user);
	}

	@Override
	public UserInfo getUserByOpenId(String openId) {
		return dao.getUserInfo(openId);
	}

	
	private List<UserInfo> getList(HashMap<String, Object> map) {
		/**
		 * 名字模糊 name 学院查询 instituteId
		 */
		// map.get("name");
		// map.get(" institute");
		Object name = map.get("name");
		if (!"".equals(name) && name != null) {

			char[] chars = name.toString().toCharArray();
			StringBuffer s = new StringBuffer("%");
			for (int i = 0; i < chars.length; i++) {
				s.append(chars[i]);
				s.append("%");
				
			}
			map.put("name", s.toString());
			System.out.println("name:"+s.toString());
		}
		return dao.getList(map);
	}

	@Override
	public boolean isAll(String openId) {
		UserInfo user = dao.getUserInfo(openId);
		if(user.getUserName()!=null&&!"".equals(user.getUserName())&&user.getInstitute().getInstituteName()!=null&&!"".equals(user.getInstitute().getInstituteName())){
			return true;
		}else {
			return false;
		}
			
		
	}

	@Override
	public Page<UserInfo> getPage(HashMap<String, Object> map, Page<UserInfo> page) {
		page.setDateList(null);
		/*获取总页数*/
		Integer totalRow = dao.getCount(map);
		if(totalRow ==null){
			page.setTotalRow(0);
			return page;				
		}
		map.put("startIndex", Page.getStartIndex(page));
		map.put("pageSize", page.getPageSize());
		List<UserInfo> list = this.getList(map);
		
		page.setTotalRow(totalRow);
		page.setDateList(list);
		return  page;
		
	}

}
