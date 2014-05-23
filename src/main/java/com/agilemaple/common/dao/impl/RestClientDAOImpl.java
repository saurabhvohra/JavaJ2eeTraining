package com.agilemaple.common.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.agilemaple.common.dao.RestClientDAO;
import com.agilemaple.common.entity.Contact;
import com.google.gson.Gson;
@Repository
public class RestClientDAOImpl implements RestClientDAO{
	@Autowired
	RestTemplate restTemplate;
	
	public  String consumingWebServices(String url) {
	String contacts =restTemplate.getForObject(url, String.class);
	Gson gson = new Gson();
	List<Contact> obj = gson.fromJson(contacts, List.class);
	return contacts;
}
	
	
	
	
}
