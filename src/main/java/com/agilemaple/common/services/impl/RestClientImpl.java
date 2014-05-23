package com.agilemaple.common.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.agilemaple.common.dao.AuthorDAO;
import com.agilemaple.common.dao.RestClientDAO;
import com.agilemaple.common.services.RestClient;

@Service
public class RestClientImpl implements RestClient{

	@Autowired
	private RestClientDAO restClientDAO;
	@Override
	public String consumingWebServices(String url) {
		return restClientDAO.consumingWebServices(url);
	}

}
