package com.agilemaple.common.dao.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.agilemaple.common.dao.CountryDAO;
import com.agilemaple.common.dao.RestClientDAO;
import com.agilemaple.common.entity.Contact;
import com.agilemaple.common.entity.Country;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
@Repository
public class CountryDAOImpl implements CountryDAO{
	@Autowired
	RestTemplate restTemplate;
	@Autowired 
    private SessionFactory sessionFactory;
	
	
	
	
	public List<Country> addCountryWebServices(String url) {
		String stringCountry =restTemplate.getForObject(url, String.class);
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<Country>>() {
        }.getType();
        
		List<Country> country = gson.fromJson(stringCountry, listType);
		return country;
		//sessionFactory.getCurrentSession().save(country);
		
		
	}
	

}
