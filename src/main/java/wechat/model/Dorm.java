package wechat.model;

import java.io.Serializable;
import java.util.Date;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午10:11:34
 *宿舍楼
 */
public class Dorm  implements Serializable {
	/**
	 * @author Huang_Shuxing
	 * 2016年7月10日 下午6:44:03
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String dormName;
	private Date updateTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDormName() {
		return dormName;
	}
	public void setDormName(String dormName) {
		this.dormName = dormName;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Dorm(String id, String dormName, Date updateTime) {
		super();
		this.id = id;
		this.dormName = dormName;
		this.updateTime = updateTime;
	}
	public Dorm() {
		super();
	}
	
}
