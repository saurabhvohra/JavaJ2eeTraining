package com.agilemaple.common.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agilemaple.common.dao.RegisterDAO;
import com.agilemaple.common.services.Register;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/test-dispatcher-servlet.xml"})
public class RegisterImplTest {
	
	@Mock
	private RegisterDAO registerDAO;
	
	@InjectMocks
	@Autowired
	private Register register;

	@Before
    public void setup() {
		 // Process mock annotations
        MockitoAnnotations.initMocks(this);		
	}
	
	@Test
	public void registerTest(){
		
		List<String> values = new ArrayList<String>();
		
		//Mock register method of DAO and return false if values list is empty
		Mockito.when(registerDAO.register(values)).thenReturn(false);	
		
		boolean registerStatus = register.register(values);
		
		//verify that returned value is boolean false
		Assert.assertFalse(registerStatus);
		
		values.add("Arvind");
		
		//Mock register method of DAO and return true if values list is not empty
		Mockito.when(registerDAO.register(values)).thenReturn(true);	
				
		registerStatus = register.register(values);
		
		//verify that returned value is boolean true
		Assert.assertTrue(registerStatus);		
		
	}
	
	@Test
	public void getUserDetailsTest(){
		int id = 10;
		
		Map<String,String> userStatus = new HashMap<String, String>();
		Mockito.when(registerDAO.getUserDetails(id)).thenReturn(userStatus);
		Map<String,String> userStat = register.getUserDetails(id);
		Assert.assertEquals(userStat.size(), 0);
		
		id=20;
		userStatus.put("test", "Virat");
		Mockito.when(registerDAO.getUserDetails(id)).thenReturn(userStatus);
		Map<String,String> user = register.getUserDetails(id);
		Assert.assertEquals(user.get("test"),"Virat");
		
		
	}
}
