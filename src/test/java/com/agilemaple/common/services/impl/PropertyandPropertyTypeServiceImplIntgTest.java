package com.agilemaple.common.services.impl;
/********************************************************************************
 *        Phase 2 - Properties/PropertyType/PropertyItems/Address
           
 * *********Making OnetoMany/ManytoOne  RelationShip Between Property/PropertyType********
 *              
 *********************************************************************************/
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.agilemaple.common.entity.Cities;

import com.agilemaple.common.entity.CLanguage;
import com.agilemaple.common.entity.Property;
import com.agilemaple.common.entity.PropertyType;
import com.agilemaple.common.entity.Provinces;

import com.agilemaple.common.services.CitiesLanguagesService;
import com.agilemaple.common.services.PropertyandPropertyTypeService;

import com.agilemaple.common.services.ProvincesLanguagesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/test-dispatcher-servlet.xml"})
public class PropertyandPropertyTypeServiceImplIntgTest{

	
	@Autowired
	private PropertyandPropertyTypeService propertyandPropertyTypeService;
	@Test
	public void savePropertyServiceTest(){
/*************************************************************
        Intializing Property (Such as Apartments,Shops etc)
  *************************************************************/
        Property property = new Property();
        property.setName("Apartments");
        
/************************************************************************************
        Intializing PropertyType (Such as Apartments are threeRoomSet and fourRoomSet )
**********************************************************************************/           
        Set<PropertyType> propertyType = new HashSet<PropertyType>();
        PropertyType threeRoomSet = new PropertyType();
        threeRoomSet.setName("threeRoomSet");
        threeRoomSet.setProperty(property);
        PropertyType fourRoomSet = new PropertyType();
        fourRoomSet.setName("fourRoomSet");
        fourRoomSet.setProperty(property);
        
/***********************************************************************
         *                  adding to list of PropertyType
* ********************************************************************/       
        propertyType.add(threeRoomSet);
        propertyType.add(fourRoomSet);
        
 /***********************************************************************
         *           calling  Service method
         * 
 * ********************************************************************/         
        Property savedProperty = propertyandPropertyTypeService.savePropertyService(propertyType, property);
		Assert.assertEquals(false, savedProperty.getPropertyType().isEmpty());
	}	
}
