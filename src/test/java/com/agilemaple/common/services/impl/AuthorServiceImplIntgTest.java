package com.agilemaple.common.services.impl;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.agilemaple.common.entity.Authors;
import com.agilemaple.common.entity.Biography;
import com.agilemaple.common.entity.Contact;
import com.agilemaple.common.services.AuthorService;
import com.agilemaple.common.services.ContactService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/test-dispatcher-servlet.xml"})
public class AuthorServiceImplIntgTest {
	
	@Autowired
	private AuthorService authorService;
	@Test
	public void createAuthorBiographyOneToOneTest(){
		Authors author = new Authors();
		author.setName("Chamkila");
		Biography biography = new Biography();
		biography.setInformation("Kan kar gal sun mitra");
		Authors persistedAuthor = authorService.createAuthorBiographyOneToOne(author, biography);
		Assert.assertEquals("Chamkila", persistedAuthor.getName());
		Assert.assertEquals("Kan kar gal sun mitra", persistedAuthor.getBiography().getInformation());
	}
	

	
}
