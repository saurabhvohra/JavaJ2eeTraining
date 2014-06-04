package com.agilemaple.common.services;


import com.agilemaple.common.entity.Cities;
import com.agilemaple.common.entity.Property;
import com.agilemaple.common.entity.PropertyItems;
import com.agilemaple.common.entity.PropertyType;
import com.agilemaple.common.entity.Provinces;

import java.util.*;


public interface PropertyTypeandPropertyItemsService {
	/**
	 * Returns a Set of PropertyType which is been saved in DAO layer
	 * In this case we made a association OneToMany between Property Type 
	 * and Property Items 
	 *
	 * @param  url  an absolute URL giving the base location of the image
	 * @param  name the location of the image, relative to the url argument
	 * @return   Set of PropertyType   
	 * @see         Image
	 */
	public Set<PropertyType> savePropertyTypeService(Set<PropertyItems> propertyItems,Set<PropertyType> propertyType,Property property);
	
}
