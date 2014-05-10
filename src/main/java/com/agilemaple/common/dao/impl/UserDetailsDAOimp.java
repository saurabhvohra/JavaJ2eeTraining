package com.agilemaple.common.dao.impl;
import java.util.ArrayList;
import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agilemaple.common.dao.UserDetailsDAO;
import com.agilemaple.common.entity.Contact;
import com.agilemaple.common.entity.UserDetails;



@Repository
public class UserDetailsDAOimp implements UserDetailsDAO{
    @Autowired 
    private SessionFactory sessionFactory;
    
    
	
	@Override
	public void addUser(UserDetails user) {
	      sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void removeUser(Integer userid) {
		UserDetails userdetails = (UserDetails) sessionFactory.getCurrentSession().load(UserDetails.class, userid);
		if (null != userdetails){
			sessionFactory.getCurrentSession().delete(userdetails);
		}
	
		
	}

	@Override
	public int updateUser(String password , String username) {
		Session session = sessionFactory.getCurrentSession();
		 Query query = session.createQuery("update UserDetails set password = :password" +
    				"where username = :userName");
		 query.setParameter("username", username);
		 query.setParameter("password", password);
		 int result = query.executeUpdate();
		 return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserDetails readUsers(String userName,String password) {
	  UserDetails userDetail = null;
		  Session session = sessionFactory.getCurrentSession();
		  Criteria criteria = session.createCriteria(UserDetails.class);
		  criteria.add(Restrictions.eq("username", userName));
		  criteria.add(Restrictions.eq("password", password));
		  List<UserDetails> userData = (List<UserDetails>)criteria.list();
		  if(userData.size()>0){
			  userDetail  =  userData.get(0);	   
		   }
	return userDetail;
	}

	@Override
	public List<UserDetails> listUsers() {
		return sessionFactory.getCurrentSession().createQuery("from UserDetails").list();
	}
}


