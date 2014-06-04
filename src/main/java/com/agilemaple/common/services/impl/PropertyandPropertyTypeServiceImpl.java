package com.agilemaple.common.services.impl;

import org.apache.log4j.Logger;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.agilemaple.common.dao.CitiesLanguagesDAO;
import com.agilemaple.common.dao.PropertyandPropertyTypeDAO;
import com.agilemaple.common.entity.Property;
import com.agilemaple.common.entity.PropertyType;






import com.agilemaple.common.services.CitiesLanguagesService;
import com.agilemaple.common.services.PropertyandPropertyTypeService;


import java.util.*;




@Service
public class PropertyandPropertyTypeServiceImpl implements PropertyandPropertyTypeService{
	
	@Autowired
	private PropertyandPropertyTypeDAO propertyandPropertyTypeDAO;
	// get log4j handler
	
	@Transactional
	public Property savePropertyService(Set<PropertyType> propertyType,
			Property property) {
		property.setPropertyType(propertyType);
		Property savedProperty = propertyandPropertyTypeDAO.saveProperty(property);
		return savedProperty;
	}
}
	
