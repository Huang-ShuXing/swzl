package wechat.dao;

import java.util.List;
import java.util.Map;

import wechat.model.SwzlLostGoods;

/**
 * Created by Administrator on 2016/11/14.
 */
public interface SwzlLostGoodsDao {
	public int getCount(Map params);	
    public List<SwzlLostGoods> getList(Map params);
    public int insertGoods(SwzlLostGoods goods);
    public int updateByKey(SwzlLostGoods goods);
	public int finishGoods(String goodsId);
	public int deleteGoods(String goodsId);
}
