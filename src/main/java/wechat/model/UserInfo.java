package wechat.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserInfo implements Serializable{
	public UserInfo() {
		super();
	}

	

	public UserInfo(String id, String userName, short userSex, String userQq, String userWechatName,
			String userInstituteId, String userMajorId, String userHighSchool, String userHomeTownId,
			String userHomeVillageId, String userInUniversityDate, String userGraduateUniversityDate, String userContact,
			String userHead, short userDegree, String userAddress, String userDormBuilding, String userDormFloor,
			Date updateTime, String userWechatOpenId, String userStudentNo) {
		super();
		this.id = id;
		this.userName = userName;
		this.userSex = userSex;
		this.userQq = userQq;
		this.userWechatName = userWechatName;
		this.userInstituteId = userInstituteId;
		this.userMajorId = userMajorId;
		this.userHighSchool = userHighSchool;
		this.userHomeTownId = userHomeTownId;
		this.userHomeVillageId = userHomeVillageId;
		this.userInUniversityDate = userInUniversityDate;
		this.userGraduateUniversityDate = userGraduateUniversityDate;
		this.userContact = userContact;
		this.userHead = userHead;
		this.userDegree = userDegree;
		this.userAddress = userAddress;
		this.userDormBuilding = userDormBuilding;
		this.userDormFloor = userDormFloor;
		this.updateTime = updateTime;
		this.userWechatOpenId = userWechatOpenId;
		this.userStudentNo = userStudentNo;
	}



	public UserInfo(String id, String userName, short userSex,Date userBirthday, String userQq, String userWechatName,
			String userInstituteId, String userMajorId, String userHighSchool, String userHomeTownId,
			String userHomeVillageId, String userInUniversityDate, String userGraduateUniversityDate, String userContact,
			String userHead, short userDegree, String userAddress, String userDormBuilding, String userDormFloor,
			Date updateTime, Wechat wechat, String userStudentNo) {
		super();
		this.id = id;
		this.userName = userName;
		this.userSex = userSex;
		this.userBirthday = userBirthday;
		this.userQq = userQq;
		this.userWechatName = userWechatName;
		this.userInstituteId = userInstituteId;
		this.userMajorId = userMajorId;
		this.userHighSchool = userHighSchool;
		this.userHomeTownId = userHomeTownId;
		this.userHomeVillageId = userHomeVillageId;
		this.userInUniversityDate = userInUniversityDate;
		this.userGraduateUniversityDate = userGraduateUniversityDate;
		this.userContact = userContact;
		this.userHead = userHead;
		this.userDegree = userDegree;
		this.userAddress = userAddress;
		this.userDormBuilding = userDormBuilding;
		this.userDormFloor = userDormFloor;
		this.updateTime = updateTime;
		this.wechat = wechat;
		this.userStudentNo = userStudentNo;
	}



	private String id;
	private String userName;
	private short userSex;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date userBirthday;
	
	private String userQq;
	private String userWechatName;
	private String userInstituteId;
	private Institute institute;
	private String userMajorId;
	private Major major;

	private String userHighSchool;
	private String userHomeTownId;
	private String userHomeVillageId;
	
	private String userInUniversityDate;
	
	private String userGraduateUniversityDate;
	private String userContact;
	private String userHead;
	private short userDegree;
	private String userAddress;
	private String userDormBuilding;
	private String userDormFloor;
	private Date updateTime;
	private String userWechatOpenId;
	private Wechat wechat;
	private String userStudentNo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public short getUserSex() {
		return userSex;
	}

	public void setUserSex(short userSex) {
		this.userSex = userSex;
	}
	
	public Date getUserBirthday() {
		return userBirthday;
	}


	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}



	public String getUserQq() {
		return userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}

	public String getUserWechatName() {
		return userWechatName;
	}

	public void setUserWechatName(String userWechatName) {
		this.userWechatName = userWechatName;
	}

	public String getUserInstituteId() {
		return userInstituteId;
	}

	public void setUserInstituteId(String userInstituteId) {
		this.userInstituteId = userInstituteId;
	}

	public String getUserMajorId() {
		return userMajorId;
	}

	public void setUserMajorId(String userMajorId) {
		this.userMajorId = userMajorId;
	}

	public String getUserHighSchool() {
		return userHighSchool;
	}

	public void setUserHighSchool(String userHighSchool) {
		this.userHighSchool = userHighSchool;
	}



	public String getUserHomeTownId() {
		return userHomeTownId;
	}



	public void setUserHomeTownId(String userHomeTownId) {
		this.userHomeTownId = userHomeTownId;
	}



	public String getUserHomeVillageId() {
		return userHomeVillageId;
	}



	public void setUserHomeVillageId(String userHomeVillageId) {
		this.userHomeVillageId = userHomeVillageId;
	}



	public String getUserInUniversityDate() {
		return userInUniversityDate;
	}

	public void setUserInUniversityDate(String userInUniversityDate) {
		this.userInUniversityDate = userInUniversityDate;
	}

	public String getUserGraduateUniversityDate() {
		return userGraduateUniversityDate;
	}

	public void setUserGraduateUniversityDate(String userGraduateUniversityDate) {
		this.userGraduateUniversityDate = userGraduateUniversityDate;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getUserHead() {
		return userHead;
	}

	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}

	public short getUserDegree() {
		return userDegree;
	}

	public void setUserDegree(short userDegree) {
		this.userDegree = userDegree;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserDormBuilding() {
		return userDormBuilding;
	}

	public void setUserDormBuilding(String userDormBuilding) {
		this.userDormBuilding = userDormBuilding;
	}

	public String getUserDormFloor() {
		return userDormFloor;
	}

	public void setUserDormFloor(String userDormFloor) {
		this.userDormFloor = userDormFloor;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Wechat getWechat() {
		return wechat;
	}



	public void setWechat(Wechat wechat) {
		this.wechat = wechat;
	}
	public String getUserWechatOpenId() {
		return userWechatOpenId;
	}

	public void setUserWechatOpenId(String userWechatOpenId) {
		this.userWechatOpenId = userWechatOpenId;
	}

	public String getUserStudentNo() {
		return userStudentNo;
	}

	public void setUserStudentNo(String userStudentNo) {
		this.userStudentNo = userStudentNo;
	}
	
	public Institute getInstitute() {
		return institute;
	}



	public void setInstitute(Institute institute) {
		this.institute = institute;
	}



	public Major getMajor() {
		return major;
	}



	public void setMajor(Major major) {
		this.major = major;
	}

}
