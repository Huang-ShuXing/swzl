package wechat.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import wechat.dao.WechatDao;
import wechat.model.Wechat;
import wechat.service.IWechatService;

/**
 *@author Huang_Shuxing
 *2016年6月28日 上午11:08:11
 */
@Service("wechatService")
public class WechatServiceImpl implements IWechatService {

	@Resource
	private WechatDao wechatDao;
	
	@Override
	public boolean insertWechat(Wechat wechat) {
		return wechatDao.insertOrUpdate(wechat) > 0 ;
	}

	@Override
	public Wechat getByOpenId(String openId) {
		return wechatDao.getByOpenId(openId) ;
	}

	@Override
	public String getImgUrl(String openId) {
		return wechatDao.getImgUrl(openId);
	}

	@Override
	public boolean update(Wechat wechat) {
		return wechatDao.insertOrUpdate(wechat)>0;
		
	}

}
