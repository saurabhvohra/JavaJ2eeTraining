package com.agilemaple.common.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.agilemaple.common.dao.AuthorDAO;
import com.agilemaple.common.dao.CountryDAO;
import com.agilemaple.common.dao.RestClientDAO;
import com.agilemaple.common.entity.Country;
import com.agilemaple.common.services.CountryRestClient;
import com.agilemaple.common.services.RestClient;

@Service
public class CountryRestClientImpl implements CountryRestClient{

	@Autowired
	private CountryDAO countryDAO;
	@Override
	public List<Country> consumingWebServices(String url) {
		
		return countryDAO.addCountryWebServices(url);
		
	}

}
