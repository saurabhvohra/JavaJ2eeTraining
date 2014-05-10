package com.agilemaple.common.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		
		// gettting contact using HQL
/*		String queryStringHQL = "FROM Contact c WHERE c.firstname = '"+firstname+"' AND c.lastname='"+lastname+"'"; 
		
		Query query = sessionFactory.getCurrentSession().createQuery(queryStringHQL);
		List<Contact> results = query.list();
		if(results.size()>0){
			contact = results.get(0);	
		}*/
		
		
		//getting contact using criteria query
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Contact.class);
		cr.add(Restrictions.eq("firstname", firstname));
		cr.add(Restrictions.eq("lastname", lastname));
		List<Contact> results = cr.list();
		if(results.size()>0){
			contact = results.get(0);
		}
		
/*		Contact contact = null;
		
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
<<<<<<< HEAD
		}
//Getting Contact using HQL		
/*		String queryStringHQL = "FROM Contact c WHERE c.firstname ='"+firstname+"' AND c.lastname='"+lastname+"'";
 

Contact contact = null;
    Query query =sessionFactory.getCurrentSession().createQuery(queryStringHQL);
    List<Contact> results= query.list(); 
    if(results.size()>0){
		contact = results.get(0);	
	}*/


//Getting Contact using Creteria query
/*Contact contact = null;
Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Contact.class);
criteria.add(Restrictions.eq("firstname", firstname));
criteria.add(Restrictions.eq("lastname", lastname));
List<Contact> results = criteria.list();    
if(results.size()>0){
	 contact  = results.get(0);	
}*/
return contact;		

	}
}
