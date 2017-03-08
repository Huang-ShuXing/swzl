package wechat.service.imp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wechat.common.Constant;
import wechat.common.Page;
import wechat.dao.GoodsImgDao;
import wechat.dao.SwzlLostGoodsDao;
import wechat.model.ShareResource;
import wechat.model.SwzlLostGoods;
import wechat.service.ISwzlLostGoodsService;

/**
 *@author Huang_Shuxing
 *2016年11月15日 上午12:07:04
 */
@Service
public class SwzlLostGoodsServiceImpl implements ISwzlLostGoodsService{
	@Autowired
    private SwzlLostGoodsDao  goodsDao;
	@Autowired
	private GoodsImgDao goodsImdDao;
    public Page getPage(Map params,Page page){
    	/*获取总页数*/
		Integer totalRow = goodsDao.getCount(params);
		if(totalRow ==null){
			page.setTotalRow(0);
			return page;				
		}		
		
		params.put("startIndex", page.getStartIndex());
		params.put("pageSize", page.getPageSize());
		
		List<SwzlLostGoods> list = goodsDao.getList(params);
		page.setTotalRow(totalRow);
		page.setDataList(list);
		
		return  page;
    }
    
    public boolean saveGoods(SwzlLostGoods goods){
    	if("1".equals(goods.getGoodsStype())){
    		goods.setName("一卡通-"+goods.getStudentName());
    	}else if("2".equals(goods.getGoodsStype())){
    		goods.setName("银行卡");
    	}
    	//图片
    	String[] arr = goods.getImgUrlArr();
    	
    	if(null != arr && arr.length > 0){
    		HashMap map =new HashMap<>();
    		map.put("goodsId", goods.getId());
    		map.put("state", Constant.success);
    		map.put("ids",arr);
    		goodsImdDao.updateMore(map);    		
    	}
    	
    	return goodsDao.insertGoods(goods) > 0;
    	
    }
    
    public boolean updateGoods(SwzlLostGoods goods){
    	if(goods.getId()!=null){
    		goods.setUpdateTime(new Date());
    		return goodsDao.updateByKey(goods) > 0;
    	}
    	return false;
    }
    
    @Override
	public Page<SwzlLostGoods> page(HashMap<String, Object> params, Page<SwzlLostGoods> page) {
		page.setDataList(null);
		
		/*获取总页数*/
		Integer totalRow = goodsDao.getCount(params);
		if(totalRow ==null){
			page.setTotalRow(0);
			return page;				
		}
//		page.setAndGetStartIndex();

		List<SwzlLostGoods> list = goodsDao.getList(params);
		page.setTotalRow(totalRow);
		page.setDataList(list);
		
		return  page;
	}

	@Override
	public boolean finishGoods(String goodsId) {
		return goodsDao.finishGoods(goodsId) > 0;
	}

	@Override
	public boolean deleteGoods(String goodsId) {
		return goodsDao.deleteGoods(goodsId) > 0 ;
	}
    
    
}
