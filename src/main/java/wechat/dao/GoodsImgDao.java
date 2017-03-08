package wechat.dao;

import java.util.HashMap;
import java.util.List;

import wechat.model.GoodsImg;

/**
 *@author Huang_Shuxing
 *2017年1月21日 下午3:24:02
 */
public interface GoodsImgDao {
	
	public int insert(GoodsImg gImg);
	
	public List<GoodsImg> getListByGoodsId(String goodsId);
	
	public int updateOne(GoodsImg gImg);
	
	public int updateMore(HashMap map);
}
