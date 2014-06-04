package com.agilemaple.common.dao.impl;





import org.hibernate.SessionFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.agilemaple.common.dao.PropertyTypeandPropertyItemsDAO;
import com.agilemaple.common.dao.PropertyandPropertyTypeDAO;
import com.agilemaple.common.dao.ProvincesLanguagesDAO;
import com.agilemaple.common.entity.PropertyType;



@Repository
public class PropertyTypeandPropertyItemsDAOImpl implements PropertyTypeandPropertyItemsDAO{

	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	public PropertyType savePropertyType(PropertyType propertyType) {
		sessionFactory.getCurrentSession().save(propertyType);
		return propertyType;
	}
}
