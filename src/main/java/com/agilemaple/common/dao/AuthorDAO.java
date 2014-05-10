package com.agilemaple.common.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agilemaple.common.entity.Authors;
import com.agilemaple.common.entity.Contact;

@Service
public interface AuthorDAO {
	
	public Authors persistAuthor(Authors authors);
	public Authors saveAuthor(Authors authors);
	
}
