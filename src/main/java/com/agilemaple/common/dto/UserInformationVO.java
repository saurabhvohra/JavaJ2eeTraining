package com.agilemaple.common.dto;

import java.util.List;

import com.agilemaple.common.entity.UserInformation;

public class UserInformationVO {
	private List<UserInformation> userInformation;
	private long totalUsers;
	public List<UserInformation> getUserInformation() {
		return userInformation;
	}
	public void setUserInformation(List<UserInformation> userInformation) {
		this.userInformation = userInformation;
	}
	public long getTotalUsers() {
		return totalUsers;
	}
	public void setTotalUsers(long totalUsers) {
		this.totalUsers = totalUsers;
	}
}
