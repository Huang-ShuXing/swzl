package wechat.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/11/14.
 */
public class SwzlLostGoods {
	
	SwzlLostGoods goods;
    private String id;
    private String name;
	private String studentInstituteName;
	private String studentName;
    private String studentCard;
    private String bankName;
    private String bankCard;
    private String memo;
    private Integer method;
    private Date happendTime;
    private String happendAddress;
    private String goodsStype;
    private String goodsComment;
    private Date updateTime;
    private Integer clickCount;
    private Integer goodsStatus;
    private String peopleName;
    private String peopleCollege;
    private String peopleContact;
    private String peopleQq;
    private String peopleWechat;

    private String[] imgUrlArr ;
   
    private List<GoodsImg> imgList;

    public List<GoodsImg> getImgList() {
		return imgList;
	}

	public void setImgList(List<GoodsImg> imgList) {
		this.imgList = imgList;
	}

	public String[] getImgUrlArr() {
		return imgUrlArr;
	}

	public void setImgUrlArr(String[] imgUrlArr) {
		this.imgUrlArr = imgUrlArr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getStudentInstituteName() {
		return studentInstituteName;
	}

	public void setStudentInstituteName(String studentInstituteName) {
		this.studentInstituteName = studentInstituteName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentCard() {
		return studentCard;
	}

	public void setStudentCard(String studentCard) {
		this.studentCard = studentCard;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankCard() {
		return bankCard;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Integer getMethod() {
        return method;
    }

    public void setMethod(Integer method) {
        this.method = method;
    }

    public Date getHappendTime() {
        return happendTime;
    }

    public void setHappendTime(Date happendTime) {
        this.happendTime = happendTime;
    }

    public String getHappendAddress() {
        return happendAddress;
    }

    public void setHappendAddress(String happendAddress) {
        this.happendAddress = happendAddress;
    }

    public String getGoodsStype() {
        return goodsStype;
    }

    public void setGoodsStype(String goodsStype) {
        this.goodsStype = goodsStype;
    }

    public String getGoodsComment() {
        return goodsComment;
    }

    public void setGoodsComment(String goodsComment) {
        this.goodsComment = goodsComment;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getPeopleCollege() {
        return peopleCollege;
    }

    public void setPeopleCollege(String peopleCollege) {
        this.peopleCollege = peopleCollege;
    }

    public String getPeopleContact() {
        return peopleContact;
    }

    public void setPeopleContact(String peopleContact) {
        this.peopleContact = peopleContact;
    }

    public String getPeopleQq() {
        return peopleQq;
    }

    public void setPeopleQq(String peopleQq) {
        this.peopleQq = peopleQq;
    }

    public String getPeopleWechat() {
        return peopleWechat;
    }

    public void setPeopleWechat(String peopleWechat) {
        this.peopleWechat = peopleWechat;
    }
}
