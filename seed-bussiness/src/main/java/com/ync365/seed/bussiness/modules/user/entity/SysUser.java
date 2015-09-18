package com.ync365.seed.bussiness.modules.user.entity;

import java.util.Date;

public class SysUser {

	private String userNum;

	private String userLoginName;

	private String userPassword;

	private String userMobile;

	private Integer state;

	private Date createTime;

	private Date updateTime;

	private String lastOptName;

	private Boolean isDel;

	private Boolean isFrozen;

	private Boolean isAuthentication;


	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum == null ? null : userNum.trim();
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName == null ? null : userLoginName.trim();
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword == null ? null : userPassword.trim();
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile == null ? null : userMobile.trim();
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getLastOptName() {
		return lastOptName;
	}

	public void setLastOptName(String lastOptName) {
		this.lastOptName = lastOptName == null ? null : lastOptName.trim();
	}

	public Boolean getIsDel() {
		return isDel;
	}

	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}

	public Boolean getIsFrozen() {
		return isFrozen;
	}

	public void setIsFrozen(Boolean isFrozen) {
		this.isFrozen = isFrozen;
	}

	public Boolean getIsAuthentication() {
		return isAuthentication;
	}

	public void setIsAuthentication(Boolean isAuthentication) {
		this.isAuthentication = isAuthentication;
	}
}