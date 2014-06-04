package com.agilemaple.common.dao;



import org.springframework.stereotype.Service;

import com.agilemaple.common.entity.PropertyType;




@Service
public interface PropertyTypeandPropertyItemsDAO {
	public PropertyType savePropertyType(PropertyType propertyType);
}
