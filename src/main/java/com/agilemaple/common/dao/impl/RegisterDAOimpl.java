package com.agilemaple.common.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.agilemaple.common.dao.RegisterDAO;
import com.agilemaple.common.dto.userDetails;

@Repository
public class RegisterDAOimpl implements RegisterDAO{

	@Override
	public boolean register(List<String> values) {
		if(values.isEmpty()){
			return false;
		}
		return true;
	}

	@Override
	public Map<String, String> getUserDetails(int id) {
		Map<String,String> userDetails = new HashMap<String,String>();
	if(id==20){
    userDetails.put("C1","Saurabh");
    userDetails.put("C2","vohra");
    userDetails.put("C3","abc");
    userDetails.put("C4","Quebec");
    userDetails.put("C5","canada");
    userDetails.put("C6","h3h2r7");
    userDetails.put("C7","vohra@gmail.com"); 
		return userDetails;
	}
    return userDetails;
}

	@Override
	public userDetails getAccountDetails(int id) {
		userDetails userDetail = new userDetails();
		userDetail.setFirstName("saurabh");
		userDetail.setLastName("vohra");
		userDetail.setAddress("abc");
		userDetail.setPostalCode("h3h2r7");
		userDetail.setProvince("Quebec");
		userDetail.setCountry("canada");
		userDetail.setPhoneNumber("123");
		userDetail.setEmail("@gmail.com");
		return userDetail;
	}
	
	
	
}
