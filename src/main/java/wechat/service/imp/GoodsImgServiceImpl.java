package wechat.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wechat.common.Constant;
import wechat.dao.GoodsImgDao;
import wechat.model.GoodsImg;
import wechat.service.IGoodsImgService;
import wechat.util.MyStringUtil;

/**
 *@author Huang_Shuxing
 *2017年1月21日 下午3:33:39
 */
@Service("goodsImgService")
public class GoodsImgServiceImpl implements IGoodsImgService {
	@Autowired
	private GoodsImgDao goodsImgDao ;
	@Override
	public  String insert(String imgUrl ) {
	    GoodsImg gImg = new GoodsImg();
	    if(MyStringUtil.isEmpty(imgUrl)){
	    	return null ;
	    }
	    gImg.setId(java.util.UUID.randomUUID().toString().replace("-",""));
	    gImg.setImgUrl(imgUrl);
	    gImg.setUpdateTime(new Date());
	    gImg.setState(GoodsImg.noUse);
		return goodsImgDao.insert(gImg) > 0  ? gImg.getId() :null; 
	}

	@Override
	public List<GoodsImg> getListByGoodsId(String goodsId) {
		return goodsImgDao.getListByGoodsId(goodsId);
	}

	@Override
	public  int updateById (String goodsId,String goodsImgId){
		if(MyStringUtil.isEmpty(goodsImgId) || MyStringUtil.isEmpty(goodsImgId)){
			return -1;
		}
		GoodsImg goodsImg = new GoodsImg();
		goodsImg.setId(goodsImgId);
		goodsImg.setGoodsId(goodsId);
		goodsImg.setState(Constant.success);
		return goodsImgDao.updateOne(goodsImg);
		
	}

}
