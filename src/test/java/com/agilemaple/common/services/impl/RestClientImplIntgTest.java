package com.agilemaple.common.services.impl;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.agilemaple.common.entity.Contact;
import com.agilemaple.common.services.ContactService;
import com.agilemaple.common.services.RestClient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/test-dispatcher-servlet.xml"})
public class RestClientImplIntgTest {
	
	@Autowired
	private RestClient restClient;

	@Test
	public void consumingWebServicesTest(){
		String contacts=restClient.consumingWebServices("http://localhost:8080/AgilemapleTraining/tutor/open/account/contactsusingGson");
		Assert.assertNotNull(contacts);
	}
	
	
	
}
