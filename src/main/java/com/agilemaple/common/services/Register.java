package com.agilemaple.common.services;

import java.util.*;

import com.agilemaple.common.dto.userDetails;

public interface Register {

	public boolean register(List<String> values);
	public Map<String,String> getUserDetails(int id);
	public userDetails getAccountDetails(int id);
	
}
