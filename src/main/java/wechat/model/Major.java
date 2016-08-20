package wechat.model;

import java.io.Serializable;
import java.util.Date;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午10:58:31
 */
public class Major  implements Serializable {
	/**
	 * @author Huang_Shuxing
	 * 2016年7月10日 下午6:44:22
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String majorName ;
	private String majorInstituteId;
	private Date updateTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getMajosInstituteId() {
		return majorInstituteId;
	}
	public void setMajosInstituteId(String majosInstituteId) {
		this.majorInstituteId = majosInstituteId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Major(String id, String majorName, String majosInstituteId, Date updateTime) {
		super();
		this.id = id;
		this.majorName = majorName;
		this.majorInstituteId = majosInstituteId;
		this.updateTime = updateTime;
	}
	public Major() {
		super();
	}
	
}
