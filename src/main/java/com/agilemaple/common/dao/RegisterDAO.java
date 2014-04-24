package com.agilemaple.common.dao;

import java.util.*;

import com.agilemaple.common.dto.userDetails;

public interface RegisterDAO {

	public boolean register(List<String> values);
	public Map<String,String> getUserDetails(int id);
	public userDetails getAccountDetails(int id);
	
	
}
