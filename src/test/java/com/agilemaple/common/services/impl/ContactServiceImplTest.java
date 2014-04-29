package com.agilemaple.common.services.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agilemaple.common.entity.Contact;
import com.agilemaple.common.services.ContactService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/test-dispatcher-servlet.xml"})
public class ContactServiceImplTest {
	
	@Autowired
	private ContactService contactService;
	
	@Test
	public void registerTest(){
		Contact contact = new Contact();
		contact.setEmail("as@g.com");
		contact.setFirstname("S");
		contact.setLastname("V");
		contact.setTelephone("5149636381");
		contactService.addContact(contact);
	}
}
