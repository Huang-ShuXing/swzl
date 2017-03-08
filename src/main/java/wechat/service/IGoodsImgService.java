package wechat.service;

import java.util.List;

import wechat.model.GoodsImg;
import wechat.model.SwzlLostGoods;

/**
 *@author Huang_Shuxing
 *2017年1月21日 下午3:31:48
 */
public interface IGoodsImgService {
	public  String insert(String imgUrl );
	public  List<GoodsImg> getListByGoodsId(String goodsId);
	public  int updateById (String goodsId,String goodsImgId); 
}
