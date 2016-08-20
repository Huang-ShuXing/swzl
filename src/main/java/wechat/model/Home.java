package wechat.model;

import java.io.Serializable;
import java.util.Date;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午8:31:46
 */
public class Home implements Serializable {
	/**
	 * @author Huang_Shuxing
	 * 2016年7月10日 下午6:31:49
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String homeUpId;
	private String homeName;
	private Date updateTime;
	public Home() {
		super();
	}
	public Home(String id, String homeUpId, String homeName, Date updateTime) {
		super();
		this.id = id;
		this.homeUpId = homeUpId;
		this.homeName = homeName;
		this.updateTime = updateTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHomeUpId() {
		return homeUpId;
	}
	public void setHomeUpId(String homeUpId) {
		this.homeUpId = homeUpId;
	}
	public String getHomeName() {
		return homeName;
	}
	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
