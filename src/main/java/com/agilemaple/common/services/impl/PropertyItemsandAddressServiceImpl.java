package com.agilemaple.common.services.impl;

import org.apache.log4j.Logger;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.agilemaple.common.dao.CitiesLanguagesDAO;
import com.agilemaple.common.dao.PropertyItemsandAddressDAO;
import com.agilemaple.common.dao.PropertyTypeandPropertyItemsDAO;
import com.agilemaple.common.dao.PropertyandPropertyTypeDAO;
import com.agilemaple.common.entity.Address;
import com.agilemaple.common.entity.Property;
import com.agilemaple.common.entity.PropertyItems;
import com.agilemaple.common.entity.PropertyType;






import com.agilemaple.common.services.CitiesLanguagesService;
import com.agilemaple.common.services.PropertyItemsandAddressService;
import com.agilemaple.common.services.PropertyTypeandPropertyItemsService;

import com.agilemaple.common.services.PropertyandPropertyTypeService;

import java.util.*;




@Service
public class PropertyItemsandAddressServiceImpl implements PropertyItemsandAddressService{
	
	@Autowired
	private PropertyItemsandAddressDAO propertyItemsandAddressDAO;
	@Autowired
	private PropertyTypeandPropertyItemsDAO propertyTypeandPropertyItemsDAO;
	@Autowired
	private PropertyandPropertyTypeDAO propertyandPropertyTypeDAO;
	@Autowired
	private PropertyandPropertyTypeService PropertyandPropertyTypeService;
	@Autowired
	private PropertyTypeandPropertyItemsService propertyTypeandPropertyItemsService;


	@Transactional
	public Set<PropertyType> savePropertyItemsService(List<Address> address,Set<PropertyItems> propertyItems, Set<PropertyType> propertyType,Property property) {
		Set<PropertyType> savedPropertyTypes= new LinkedHashSet<PropertyType>();
		PropertyandPropertyTypeService.savePropertyService(propertyType, property);
		int i = 0;
		for(PropertyItems propertyItem:propertyItems){
			propertyItem.setAddress(address.get(i));
			(address.get(i)).setPropertyItems(propertyItem);
			i++;
			propertyItemsandAddressDAO.savePropertyItems(propertyItem);
			}
		for(PropertyType eachPropertyType :propertyType){
		    eachPropertyType.setPropertyItems(propertyItems);
		    PropertyType savedPropertyType = propertyTypeandPropertyItemsDAO.savePropertyType(eachPropertyType);
		    
		    savedPropertyTypes.add(savedPropertyType);
		}
		return savedPropertyTypes;
	}


}

	
