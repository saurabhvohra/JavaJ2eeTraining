package com.agilemaple.common.services;

import java.util.List;

import com.agilemaple.common.entity.Country;

public interface CountryRestClient {
	public List<Country> consumingWebServices(String url);

}
