package com.agilemaple.common.services.impl;

import java.util.List;
import java.util.Map;

import com.agilemaple.common.dao.RegisterDAO;
import com.agilemaple.common.dao.impl.RegisterDAOimpl;
import com.agilemaple.common.dto.userDetails;
import com.agilemaple.common.services.Register;

public class RegisterImpl implements Register{

	@Override
	public boolean register(List<String> values) {
		
		RegisterDAO registerDAO = new RegisterDAOimpl();
		boolean status = registerDAO.register(values);
        return status;
	}

	@Override
	public Map<String, String> getUserDetails(int id) {
		RegisterDAO registerDAO = new RegisterDAOimpl();
		Map<String,String> userDetail = registerDAO.getUserDetails(id);
		
		return userDetail;
	}

	@Override
	public userDetails getAccountDetails(int id) {
		RegisterDAOimpl registerDAO = new RegisterDAOimpl();
		userDetails userDetail = registerDAO.getAccountDetails(id);
		return userDetail;
	}
}
