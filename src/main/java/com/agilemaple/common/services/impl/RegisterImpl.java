package com.agilemaple.common.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.agilemaple.common.dao.RegisterDAO;
import com.agilemaple.common.dao.impl.RegisterDAOimpl;
import com.agilemaple.common.dto.userDetails;
import com.agilemaple.common.services.Register;

@Component
public class RegisterImpl implements Register {

	@Autowired
	private RegisterDAO registerDAO;

	@Override
	public boolean register(List<String> values) {

		boolean status = registerDAO.register(values);
		return status;
	}

	@Override
	public Map<String, String> getUserDetails(int id) {
		Map<String, String> userDetail = registerDAO.getUserDetails(id);

		return userDetail;
	}

	@Override
	public userDetails getAccountDetails(int id) {
		userDetails userDetail = registerDAO.getAccountDetails(id);
		return userDetail;
	}
}
