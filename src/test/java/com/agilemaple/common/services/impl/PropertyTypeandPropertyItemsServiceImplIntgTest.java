package com.agilemaple.common.services.impl;
/********************************************************************************
 *        Phase 2 - Properties/PropertyType/PropertyItems/Address
           
 * *********Making OnetoMany/ManytoOne  RelationShip Between PropertyType/PropertyItems********
 *              
 *********************************************************************************/
import java.util.HashSet;
import java.util.LinkedHashSet;
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
import com.agilemaple.common.entity.PropertyItems;
import com.agilemaple.common.entity.PropertyType;
import com.agilemaple.common.entity.Provinces;

import com.agilemaple.common.services.CitiesLanguagesService;
import com.agilemaple.common.services.PropertyTypeandPropertyItemsService;
import com.agilemaple.common.services.PropertyandPropertyTypeService;

import com.agilemaple.common.services.ProvincesLanguagesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/test-dispatcher-servlet.xml"})
public class PropertyTypeandPropertyItemsServiceImplIntgTest{

	
	@Autowired
	private PropertyTypeandPropertyItemsService propertyTypeandPropertyItemsService;
	@Test
	public void savePropertyTypeServiceTest(){
		
  /*************************************************************
        Intializing Property (Such as Apartments,Shops etc)
  *************************************************************/
		Property property = new Property();
        property.setName("Apartments");
        
  /************************************************************************************
        Intializing PropertyType (Such as Apartments are threeRoomSet and fourRoomSet )
  **********************************************************************************/       
        Set<PropertyType> propertyType = new LinkedHashSet<PropertyType>();
        PropertyType threeRoomSet = new PropertyType();
        threeRoomSet.setName("threeRoomSet");
        threeRoomSet.setProperty(property);
        
        PropertyType fourRoomSet = new PropertyType();
        fourRoomSet.setName("fourRoomSet");
        fourRoomSet.setProperty(property);
		
 /**********************************************************************************
        Intializing PropertyItems (Such as how many threeRoomSet and fourRoomSet are in apartments )
        Here: We have 2 apartments which are ThreeRoomSet and FourRoomSet respectively
         
  *****************************************************************************************/      
        
        Set<PropertyItems> propertyItemsofthreeRoomSet = new LinkedHashSet<PropertyItems>();
        PropertyItems apartmentOneofthreeRoomSet = new PropertyItems();
        apartmentOneofthreeRoomSet.setName("apartmentOne");
        apartmentOneofthreeRoomSet.setPropertyType(threeRoomSet);
       
        PropertyItems apartmentTwoofthreeRoomSet = new PropertyItems();
        apartmentTwoofthreeRoomSet.setName("apartmentTwo");
        apartmentTwoofthreeRoomSet.setPropertyType(threeRoomSet);
        
       
        PropertyItems apartmentOneoffourRoomSet = new PropertyItems();
        apartmentOneoffourRoomSet.setName("apartmentOne");
        apartmentOneoffourRoomSet.setPropertyType(fourRoomSet);
        
        PropertyItems apartmentTwooffourRoomSet = new PropertyItems();
        apartmentTwooffourRoomSet.setName("apartmentTwo");
        apartmentTwooffourRoomSet.setPropertyType(fourRoomSet);
       
  /***********************************************************************
         *                  adding to list of PropertyType
         * 
  * ********************************************************************/
        propertyType.add(threeRoomSet);
        propertyType.add(fourRoomSet);

 /***********************************************************************
         *           adding set of PropertyItems
         * 
 * ********************************************************************/ 
        propertyItemsofthreeRoomSet.add(apartmentOneofthreeRoomSet);
        propertyItemsofthreeRoomSet.add(apartmentTwoofthreeRoomSet);
        propertyItemsofthreeRoomSet.add(apartmentOneoffourRoomSet);
        propertyItemsofthreeRoomSet.add(apartmentTwooffourRoomSet);
        
 /***********************************************************************
         *           calling Service Method
         * 
 * ********************************************************************/         
        Set<PropertyType> savedPropertyType = propertyTypeandPropertyItemsService.savePropertyTypeService(propertyItemsofthreeRoomSet, propertyType ,property );
       
        Assert.assertEquals(false, savedPropertyType.isEmpty());
	}	
}
