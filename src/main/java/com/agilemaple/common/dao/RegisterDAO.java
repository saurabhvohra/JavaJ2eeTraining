package com.agilemaple.common.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.agilemaple.common.dto.userDetails;

@Service
public interface RegisterDAO {

	public boolean register(List<String> values);
	public Map<String,String> getUserDetails(int id);
	public userDetails getAccountDetails(int id);
	
	
}
