package com.agilemaple.common.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agilemaple.common.dao.AuthorDAO;
import com.agilemaple.common.dao.ContactDAO;
import com.agilemaple.common.entity.Authors;
import com.agilemaple.common.entity.Biography;
import com.agilemaple.common.entity.Contact;
import com.agilemaple.common.services.AuthorService;
import com.agilemaple.common.services.ContactService;


@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDAO authorDAO;

	@Transactional
	public Authors createAuthorBiographyOneToOne(Authors author, Biography biography) {
	//	authorDAO.persistAuthor(author);
		author.setBiography(biography);
		biography.setAuthor(author);
		
		authorDAO.saveAuthor(author);
		return author;
	}
	
	
}
