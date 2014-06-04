package com.agilemaple.common.dao.impl;





import org.hibernate.SessionFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.agilemaple.common.dao.PropertyandPropertyTypeDAO;
import com.agilemaple.common.dao.ProvincesLanguagesDAO;
import com.agilemaple.common.entity.Property;



@Repository
public class PropertyandPropertyTypeDAOImpl implements PropertyandPropertyTypeDAO{

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public Property saveProperty(Property property) {
		sessionFactory.getCurrentSession().save(property);
		return property;
	}
}
