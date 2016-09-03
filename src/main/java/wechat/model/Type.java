package wechat.model;

import java.io.Serializable;
import java.util.Date;

/**
 *@author Huang_Shuxing
 *2016年9月1日 下午10:30:46
 */
public class Type implements Serializable{
	private String id;
	private String name;
	private String preTypeId;
	private Date updateTime;
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
	public String getPreTypeId() {
		return preTypeId;
	}
	public void setPreTypeId(String preTypeId) {
		this.preTypeId = preTypeId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Type(String id, String name, String preTypeId, Date updateTime) {
		super();
		this.id = id;
		this.name = name;
		this.preTypeId = preTypeId;
		this.updateTime = updateTime;
	}
	public Type() {
		super();
	}

	
}
