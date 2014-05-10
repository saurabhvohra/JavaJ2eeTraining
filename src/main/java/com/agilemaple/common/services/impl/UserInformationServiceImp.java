package com.agilemaple.common.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agilemaple.common.dao.UserInformationDAO;
import com.agilemaple.common.dto.UserInformationVO;
import com.agilemaple.common.entity.UserInformation;
import com.agilemaple.common.services.UserInformationService;

@Service
public class UserInformationServiceImp implements UserInformationService {

	@Autowired
	private UserInformationDAO userinformationDAO;
	
	@Override
	public void addUser(UserInformation user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(UserInformation user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserInformation user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public UserInformationVO  readUsers(int page){
		return userinformationDAO.readUsers(page);
	}

}
