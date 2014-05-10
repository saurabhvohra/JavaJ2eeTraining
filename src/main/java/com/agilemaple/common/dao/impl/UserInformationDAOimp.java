package com.agilemaple.common.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agilemaple.common.dao.UserInformationDAO;
import com.agilemaple.common.dto.UserInformationVO;
import com.agilemaple.common.entity.UserInformation;

@Repository
public class UserInformationDAOimp implements UserInformationDAO  {

	@Autowired
    private SessionFactory sessionFactory;
	
	
	
	
	@Override
	public void addUser(UserInformation user) {
		
		
	}

	@Override
	public void removeUser(UserInformation user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserInformation user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserInformationVO readUsers(int page) {
		 int pageSize=5;
         Session session = sessionFactory.getCurrentSession();
         Criteria cr = session.createCriteria(UserInformation.class);

      // To get total row count.
    /*  int totalCounts = cr.setProjection(Projections.rowCount());
		 Query query = session.createQuery("FROM UserInformation");
		 query.setFirstResult((page-1)*5);
		 query.setMaxResults(pageSize);	 
	*/	 
		 
		 Criteria criteria=session.createCriteria(UserInformation.class);
	
		   // criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		    int resultCount = criteria.list().size();

		    Long result= Long.valueOf(resultCount);
		    //criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	     criteria.setMaxResults(pageSize);
	     criteria.setFirstResult((page-1)*5);
	     
	     List<UserInformation> userInformationList = criteria.list();

	   
	    UserInformationVO userInfo = new UserInformationVO();
	    
		 //@SuppressWarnings("unchecked")
		//List<UserInformation> listofUsers =(List<UserInformation>)query.list();
		 userInfo.setUserInformation(userInformationList);
		 userInfo.setTotalUsers(result);
		 return userInfo;
	}

}
