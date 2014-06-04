package com.agilemaple.common.services.impl;

/********************************************************************************
 *        Phase 2 - Properties/PropertyType/PropertyItems/Address

 *              
 * *********Making One to One RelationShip Between PropertyItems/Address********
 *              
 *********************************************************************************/

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.agilemaple.common.entity.Address;
import com.agilemaple.common.entity.Property;
import com.agilemaple.common.entity.PropertyItems;
import com.agilemaple.common.entity.PropertyType;
import com.agilemaple.common.services.PropertyItemsandAddressService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/test-dispatcher-servlet.xml"})
public class PropertyItemsandAddressServiceImplIntgTest{

	
	@Autowired
	private PropertyItemsandAddressService propertyItemsandAddressService;
	@Test
	public void savePropertyItemsServiceTest(){
		
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
		
 /************************************************************************************
        Intializing PropertyItems (Such as how many threeRoomSet and fourRoomSet are in apartments )
        Here: We have 2 apartments which are ThreeRoomSet and FourRoomSet respectively
         with all the appartments with there respective Addresses
  *****************************************************************************************/       
        Set<PropertyItems> propertyItemsofthreeRoomSet = new LinkedHashSet<PropertyItems>();
        

        PropertyItems apartmentOneofthreeRoomSet = new PropertyItems();
        apartmentOneofthreeRoomSet.setName("apartmentOne");
        apartmentOneofthreeRoomSet.setPropertyType(threeRoomSet);
        
        Address addressOfAppartmentOne = new Address();
        addressOfAppartmentOne.setNumber(214);
        addressOfAppartmentOne.setStreet("De Maisonneuve");
        addressOfAppartmentOne.setCity("Montreal");
        addressOfAppartmentOne.setProvince("Quebec");
        addressOfAppartmentOne.setZip("H2H-2N3");
        addressOfAppartmentOne.setCountry("Canada");
        
        
       
        PropertyItems apartmentTwoofthreeRoomSet = new PropertyItems();
        apartmentTwoofthreeRoomSet.setName("apartmentTwo");
        apartmentTwoofthreeRoomSet.setPropertyType(threeRoomSet);
        
        Address addressOfAppartmentTwo = new Address();
        addressOfAppartmentTwo.setNumber(215);
        addressOfAppartmentTwo.setStreet("De Maisonneuve");
        addressOfAppartmentTwo.setCity("Montreal");
        addressOfAppartmentTwo.setProvince("Quebec");
        addressOfAppartmentTwo.setZip("H2H-2N3");
        addressOfAppartmentTwo.setCountry("Canada");
        
       
       
        PropertyItems apartmentOneoffourRoomSet = new PropertyItems();
        apartmentOneoffourRoomSet.setName("apartmentOne");
        apartmentOneoffourRoomSet.setPropertyType(fourRoomSet);
        
        List<Address> address = new ArrayList<Address>();
        Address addressOfAppartmentOne4R = new Address();
        addressOfAppartmentOne4R.setNumber(216);
        addressOfAppartmentOne4R.setStreet("De Maisonneuve");
        addressOfAppartmentOne4R.setCity("Montreal");
        addressOfAppartmentOne4R.setProvince("Quebec");
        addressOfAppartmentOne4R.setZip("H2H-2N3");
        addressOfAppartmentOne4R.setCountry("Canada");
        
       
        
        
        PropertyItems apartmentTwooffourRoomSet = new PropertyItems();
        apartmentTwooffourRoomSet.setName("apartmentTwo");
        apartmentTwooffourRoomSet.setPropertyType(fourRoomSet);
       
        Address addressOfAppartmentTwo4R = new Address();
        addressOfAppartmentTwo4R.setNumber(217);
        addressOfAppartmentTwo4R.setStreet("De Maisonneuve");
        addressOfAppartmentTwo4R.setCity("Montreal");
        addressOfAppartmentTwo4R.setProvince("Quebec");
        addressOfAppartmentTwo4R.setZip("H2H-2N3");
        addressOfAppartmentTwo4R.setCountry("Canada");
        
        
       
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
         *           adding set of Addresses
         * 
 * ********************************************************************/  
        
        address.add(addressOfAppartmentOne);
        address.add(addressOfAppartmentTwo);
        address.add(addressOfAppartmentOne4R);
        address.add(addressOfAppartmentTwo4R);
        
 /***********************************************************************
         *           calling Address Service
         * 
 * ********************************************************************/     
    Set<PropertyType> savedPropertyType = propertyItemsandAddressService.savePropertyItemsService(address, propertyItemsofthreeRoomSet, propertyType, property);
       
    
    Assert.assertEquals(false, savedPropertyType.isEmpty());
		
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
 
