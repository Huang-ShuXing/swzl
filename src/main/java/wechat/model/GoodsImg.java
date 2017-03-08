package wechat.model;

import java.io.Serializable;
import java.util.Date;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午8:31:46
 */
public class GoodsImg  {

	
	public static final  int isUse = 1;
	public static final  int noUse  = 0;
	
	private String id;
	private String imgUrl;
	private String goodsId;
	private Date updateTime;
	private Integer  state ;//0，不可用，1可用
	
	public GoodsImg() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}


	
}
