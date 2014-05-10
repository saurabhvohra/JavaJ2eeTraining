package com.agilemaple.common.services;

import java.util.List;

import com.agilemaple.common.dto.UserInformationVO;
import com.agilemaple.common.entity.UserInformation;

    public interface UserInformationService  {
	public void addUser(UserInformation user);
	public void removeUser(UserInformation user);
	public void updateUser(UserInformation user);
	public UserInformationVO  readUsers(int page);

}
