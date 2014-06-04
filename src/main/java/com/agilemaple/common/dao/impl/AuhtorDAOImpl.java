package com.agilemaple.common.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agilemaple.common.dao.AuthorDAO;
import com.agilemaple.common.dao.ContactDAO;
import com.agilemaple.common.entity.Authors;
import com.agilemaple.common.entity.Contact;

@Repository
public class AuhtorDAOImpl implements AuthorDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Authors persistAuthor(Authors authors) {
		
		sessionFactory.getCurrentSession().persist(authors);
		return authors;
	}


	@Override
	public Authors saveAuthor(Authors authors) {
		sessionFactory.getCurrentSession().save(authors);
		return authors;
	}
}
