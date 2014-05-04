package com.agilemaple.common.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.agilemaple.common.dao.ContactDAO;
import com.agilemaple.common.entity.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addContact(Contact contact) {
		sessionFactory.getCurrentSession().save(contact);
	}	
	
	public List<Contact> listContact() {
		return sessionFactory.getCurrentSession().createQuery("from Contact").list();
	}
	
	public void removeContact(Integer id) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(
				Contact.class, id);
		if (null != contact) {
			sessionFactory.getCurrentSession().delete(contact);
		}

	}

	@Override
	public Contact findContact(String firstname, String lastname) {
		Contact contact = null;
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Contact.class);
		
		if(firstname!=null){
			criteria.add(Restrictions.eq("firstname",firstname));
		}
		if(lastname!=null){
			criteria.add(Restrictions.eq("lastname",lastname));
		}
		List<Contact> results = criteria.list();
		
		if(results.size()>0){
			contact = results.get(0);	
		}
		return contact;		
	}
}
