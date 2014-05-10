package com.agilemaple.common.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.agilemaple.common.dto.userDetails;

@Service
public interface Register {

	public boolean register(List<String> values);
	public Map<String,String> getUserDetails(int id);
	public userDetails getAccountDetails(int id);
	public Map<String,String> validateLogin(Map<String,String> inputs); 
	
}
