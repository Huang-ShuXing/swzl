package wechat.model;

import java.util.Date;
/**
 * 
 * @author Huang_Shuxing
 * 2016年6月27日 上午11:57:34
 */
public class AccessToken {
	private static AccessToken ACCESS_TOKEN = new AccessToken();
	
	public static AccessToken getAccessToken() {
		try {
			return (AccessToken) ACCESS_TOKEN.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("cloneNotSupportedException");
			return new AccessToken();//或者返回ACCESS_TOKEN
		}
	}
	
	public static void setAccessToken(AccessToken accessToken){
		ACCESS_TOKEN =  accessToken;
	}
	
	private String id;
	private String token;
	private Date validTime;
	private Date updateTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getValidTime() {
		return validTime;
	}
	public void setValidTime(Date validTime) {
		this.validTime = validTime;
	}
	public AccessToken(String id,String token, Date validTime,Date updateTime) {
		super();
		this.id = id;
		this.token = token;
		this.validTime = validTime;
		this.updateTime = updateTime;
	}
	public AccessToken() {
		super();
	}
	

}
