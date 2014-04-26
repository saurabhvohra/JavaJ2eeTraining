package com.agilemaple.common.dao.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agilemaple.common.dao.RegisterDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/test-dispatcher-servlet.xml"})
public class RegisterDAOimplTest {
	
	@Autowired
	private RegisterDAO registerDAO;

	@Before
    public void setup() {}
	
	@Test
	public void registerTest(){
		
		List<String> values = new ArrayList<String>();
		
		boolean registerStatus = registerDAO.register(values);
		
		//verify that returned value is boolean false
		Assert.assertFalse(registerStatus);
		
		values.add("Arvind");
		
		registerStatus = registerDAO.register(values);
		
		//verify that returned value is boolean true
		Assert.assertTrue(registerStatus);		
		
	}
}
