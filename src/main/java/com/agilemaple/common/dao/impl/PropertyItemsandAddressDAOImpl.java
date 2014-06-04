package com.agilemaple.common.dao.impl;





import org.hibernate.SessionFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.agilemaple.common.dao.PropertyItemsandAddressDAO;
import com.agilemaple.common.dao.PropertyTypeandPropertyItemsDAO;
import com.agilemaple.common.dao.PropertyandPropertyTypeDAO;
import com.agilemaple.common.dao.ProvincesLanguagesDAO;
import com.agilemaple.common.entity.PropertyItems;
import com.agilemaple.common.entity.PropertyType;



@Repository
public class PropertyItemsandAddressDAOImpl implements PropertyItemsandAddressDAO{

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public PropertyItems savePropertyItems(PropertyItems propertyItems) {
		sessionFactory.getCurrentSession().save(propertyItems);
		return propertyItems;
	}
}
