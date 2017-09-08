package com.gst.model;

import java.util.List;

public class LoginInfo {

	private String loginPersonName;
	private List<String> accessGroupList;
	private String userName;
	private String loginMessage;
	private Boolean loginSuccess;

	public String getLoginPersonName() {
		return loginPersonName;
	}

	public void setLoginPersonName(String loginPersonName) {
		this.loginPersonName = loginPersonName;
	}

	public List<String> getAccessGroupList() {
		return accessGroupList;
	}

	public void setAccessGroupList(List<String> accessGroupList) {
		this.accessGroupList = accessGroupList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginMessage() {
		return loginMessage;
	}

	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}

	public Boolean getLoginSuccess() {
		return loginSuccess;
	}

	public void setLoginSuccess(Boolean loginSuccess) {
		this.loginSuccess = loginSuccess;
	}
}
