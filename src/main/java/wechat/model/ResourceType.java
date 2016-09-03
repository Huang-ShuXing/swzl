package wechat.model;

import java.util.Date;

/**
 *@author Huang_Shuxing
 *2016年9月3日 下午10:45:04
 */
public class ResourceType {
	private String id ;
	private String typeId;
	private String srId;
	private Date updateTime;

	public ResourceType() {
		super();
	}
	public ResourceType(String id, String typeId, String srId,Date updateTime) {
		super();
		this.id = id;
		this.typeId = typeId;
		this.srId = srId;
		this.updateTime =updateTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getSrId() {
		return srId;
	}
	public void setSrId(String srId) {
		this.srId = srId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
