package wechat.model;

import java.util.Date;

/**
 *@author Huang_Shuxing
 *2016年8月21日 下午3:51:33
 */
public class ShareResource {

	private String id ;
	private String title;
	private String url;
	private String password;
	private String userinfoId;
	private int state; 
	private int disableNum;
	private Date updateTime;
	
	private Type type;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserinfoId() {
		return userinfoId;
	}
	public void setUserinfoId(String userinfoId) {
		this.userinfoId = userinfoId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getDisableNum() {
		return disableNum;
	}
	public void setDisableNum(int disableNum) {
		this.disableNum = disableNum;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	
}
