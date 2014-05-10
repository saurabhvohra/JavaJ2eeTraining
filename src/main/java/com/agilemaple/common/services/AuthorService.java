package com.agilemaple.common.services;

import java.util.List;

import com.agilemaple.common.entity.Authors;
import com.agilemaple.common.entity.Biography;
import com.agilemaple.common.entity.Contact;


public interface AuthorService {
	
	public Authors createAuthorBiographyOneToOne(Authors author, Biography biography);
//	public Authors saveAuthor(Authors authors);
}
