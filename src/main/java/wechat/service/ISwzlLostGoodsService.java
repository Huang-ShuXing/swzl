package wechat.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import wechat.common.Page;
import wechat.model.ShareResource;
import wechat.model.SwzlLostGoods;

/**
 *@author Huang_Shuxing
 *2016年11月28日 下午11:45:29
 */
public interface ISwzlLostGoodsService {
		
	  	public Page getPage(Map params,Page page);
	    public boolean saveGoods(SwzlLostGoods goods);
	    public boolean updateGoods(SwzlLostGoods goods);
	    
		public Page<SwzlLostGoods> page(HashMap<String, Object> params, Page<SwzlLostGoods> page);
		public boolean finishGoods(String goodsId);
		public boolean deleteGoods(String goodsId);
	    
}
