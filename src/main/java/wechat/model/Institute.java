package wechat.model;

import java.io.Serializable;
import java.util.Date;

/**
 *@author Huang_Shuxing
 *2016年6月27日 下午10:49:07
 *学院
 */
public class Institute  implements Serializable {
	/**
	 * @author Huang_Shuxing
	 * 2016年7月10日 下午6:44:19
	 */
	private static final long serialVersionUID = 1L;
	private String  id ;
	private String instituteName;
	private Date updateTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Institute(String id, String instituteName, Date updateTime) {
		super();
		this.id = id;
		this.instituteName = instituteName;
		this.updateTime = updateTime;
	}
	public Institute() {
		super();
	}
	
}
