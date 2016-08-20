package wechat.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Huang_Shuxing 2016年6月28日 上午9:43:22
 */
public class Wechat implements Serializable {
	/**
	 * 未验证
	 */
	public static final int NO_ATTESTATION  = 0;
	/**
	 * 验证审核中
	 */
	public static final int ATTESTATION_ING  = 1;
	/**
	 * 已验证
	 */
	public static final int HAS_ATTESTATION  = 2;
	/**
	 * 未通过验证
	 */
	public static final int DONT_THROUGH_ATTESTATION  = 3;
	
	
	private String id;
	private int subscribe;
	private String openid;
	private String nickname;
	private int sex;
	private String city;
	private String country;
	private String province;
	private String language;
	private String headimgurl;
	private String subscribe_time;
	private String unionid;
	private String remark;
	private String groupId;
	private Date updateTime;
	private int isAttestation;
	
	public Wechat(String id, int subscribe, String openid, String nickname, int sex, String city, String country,
			String province, String language, String headimgurl, String subscribe_time, String unionid, String remark,
			String groupId, Date updateTime,int isAttestation) {
		super();
		this.id = id;
		this.subscribe = subscribe;
		this.openid = openid;
		this.nickname = nickname;
		this.sex = sex;
		this.city = city;
		this.country = country;
		this.province = province;
		this.language = language;
		this.headimgurl = headimgurl;
		this.subscribe_time = subscribe_time;
		this.unionid = unionid;
		this.remark = remark;
		this.groupId = groupId;
		this.updateTime = updateTime;
		this.isAttestation = isAttestation;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(int subscribe) {
		this.subscribe = subscribe;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getSubscribe_time() {
		return subscribe_time;
	}
	public void setSubscribe_time(String subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public int getIsAttestation() {
		return isAttestation;
	}
	public void setIsAttestation(int isAttestation) {
		this.isAttestation = isAttestation;
	}
	public Wechat() {
		super();
	}

}
