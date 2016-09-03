package wechat.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wechat.dao.AccessTokenDao;
import wechat.model.AccessToken;
import wechat.service.IAccessTokenService;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午1:00:11
 */
@Service("accessTokenService")
public class AccessTokenServiceImpl implements IAccessTokenService {
	@Autowired
	private AccessTokenDao accesstokenDao;
	@Override
	public AccessToken getToken() {
		return accesstokenDao.getBestNewToken();
		/*AccessToken accessToken = AccessToken.getAccessToken();
		Date now = new Date();
		if(now.before(accessToken.getValidTime())){//这now时间是否在截至之前  
			//有效
			return accessToken;
		}else {
			//数据库获取
			accessToken =  accesstokenDao.getBestNewToken();
			if(now.before(accessToken.getValidTime())){//有效
				return accessToken;
			}else {
				//去微信端获取最新的token
				return null;
			}
		}*/
		/*return accesstokenDao.getBestNewToken();*/
	}
	@Override
	public boolean insertToken(AccessToken token) {
		return accesstokenDao.insert(token)>0;
	}

}
