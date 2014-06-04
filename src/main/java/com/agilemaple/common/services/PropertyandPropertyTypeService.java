package com.agilemaple.common.services;


import com.agilemaple.common.entity.Cities;
import com.agilemaple.common.entity.Property;
import com.agilemaple.common.entity.PropertyType;
import com.agilemaple.common.entity.Provinces;

import java.util.*;


public interface PropertyandPropertyTypeService {
	/**
	 * Returns an object Property which is been saved in DAO layer
	 * In this case we made a association OneToMany between Property 
	 * and PropertyType 
	 *
	 * @param  url  an absolute URL giving the base location of the image
	 * @param  name the location of the image, relative to the url argument
	 * @return   Property   
	 * @see         Image
	 */
	public Property savePropertyService(Set<PropertyType> propertyType,Property property);
	
}
