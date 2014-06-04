package com.agilemaple.common.services.impl;

import org.apache.log4j.Logger;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.agilemaple.common.dao.CitiesLanguagesDAO;
import com.agilemaple.common.dao.PropertyTypeandPropertyItemsDAO;
import com.agilemaple.common.dao.PropertyandPropertyTypeDAO;
import com.agilemaple.common.entity.Property;
import com.agilemaple.common.entity.PropertyItems;
import com.agilemaple.common.entity.PropertyType;






import com.agilemaple.common.services.CitiesLanguagesService;
import com.agilemaple.common.services.PropertyTypeandPropertyItemsService;

import com.agilemaple.common.services.PropertyandPropertyTypeService;

import java.util.*;




@Service
public class PropertyTypeandPropertyItemsServiceImpl implements PropertyTypeandPropertyItemsService{
	
	@Autowired
	private PropertyTypeandPropertyItemsDAO propertyTypeandPropertyItemsDAO;
	@Autowired
	private PropertyandPropertyTypeDAO propertyandPropertyTypeDAO;
	@Autowired
	private PropertyandPropertyTypeService PropertyandPropertyTypeService;
	
	// get log4j handler
	
	

	@Transactional
	public Set<PropertyType> savePropertyTypeService(Set<PropertyItems> propertyItems, Set<PropertyType> propertyType,
			                                    Property property) {
		Set<PropertyType> savedPropertyTypes= new LinkedHashSet<PropertyType>();
		PropertyandPropertyTypeService.savePropertyService(propertyType, property);

		for(PropertyType eachPropertyType :propertyType){
		    eachPropertyType.setPropertyItems(propertyItems);
		    PropertyType savedPropertyType = propertyTypeandPropertyItemsDAO.savePropertyType(eachPropertyType);
		    
		    savedPropertyTypes.add(savedPropertyType);
		}
		return savedPropertyTypes;
	}
}
	
