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
import org.springframework.transaction.annotation.Transactional;

import com.agilemaple.common.dao.ContactDAO;
import com.agilemaple.common.dao.RegisterDAO;
import com.agilemaple.common.entity.Contact;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/test-dispatcher-servlet.xml"})
public class ContactDAOImplTest {
	
	@Autowired
	private ContactDAO contactDAO;
	
	@Test
	@Transactional
	public void registerTest(){
		Contact contact = new Contact();
		contact.setEmail("as@g.com");
		contact.setFirstname("Arvind");
		contact.setLastname("Kashyap");
		contact.setTelephone("5149636381");
		contactDAO.addContact(contact);
	}
}
