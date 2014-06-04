package com.agilemaple.common.dao;



import org.springframework.stereotype.Service;

import com.agilemaple.common.entity.Property;




@Service
public interface PropertyandPropertyTypeDAO {
	public Property  saveProperty(Property property);
}
