package com.agilemaple.common.dao;



import org.springframework.stereotype.Service;

import com.agilemaple.common.entity.PropertyItems;
import com.agilemaple.common.entity.PropertyType;




@Service
public interface PropertyItemsandAddressDAO {
	public PropertyItems savePropertyItems(PropertyItems propertyItems);
}
