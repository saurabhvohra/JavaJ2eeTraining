package com.agilemaple.common.services.impl;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.agilemaple.common.entity.Contact;
import com.agilemaple.common.entity.Country;
import com.agilemaple.common.services.ContactService;
import com.agilemaple.common.services.CountryRestClient;
import com.agilemaple.common.services.RestClient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/test-dispatcher-servlet.xml"})
public class CountryRestClientImplIntgTest {
	
	@Autowired
	private CountryRestClient countryrestClient;

	@Test
	public void consumingWebServicesTest(){
		String s = null;
		List<Country> country = countryrestClient.consumingWebServices("http://restcountries.eu/rest/v1");
		for(Country c :country){
			s = c.getName(); 
		}
		
		Assert.assertEquals(251, country.size());
		
	}
	
	
	
}
