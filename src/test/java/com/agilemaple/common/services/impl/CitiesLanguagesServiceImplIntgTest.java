package com.agilemaple.common.services.impl;

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
import com.agilemaple.common.entity.Provinces;

import com.agilemaple.common.services.CitiesLanguagesService;

import com.agilemaple.common.services.ProvincesLanguagesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/test-dispatcher-servlet.xml"})
public class CitiesLanguagesServiceImplIntgTest{

	
	@Autowired
	private CitiesLanguagesService citiesLanguagesService;
	@Test
	public void saveProvincesServiceTest(){
		Provinces quebec = new Provinces();
		quebec.setProvinceName("Quebec");
		
		
		
		Cities montreal = new Cities();
		montreal.setCityname("Montreal");
		montreal.setProvinces(quebec);
		
		Cities quebecCity = new Cities();
		quebecCity.setCityname("QuebecCity");
		quebecCity.setProvinces(quebec);
		
		
	
		CLanguage english =new CLanguage();
		english.setLanguageName("english");
		CLanguage french =new CLanguage();
		french.setLanguageName("french");
		
		
		Set<CLanguage> differentLanguages = new HashSet<CLanguage>();
		differentLanguages.add(english);
		differentLanguages.add(french);
		
		
		montreal.setClanguages(differentLanguages);
		quebecCity.setClanguages(differentLanguages);
		
		Set<Cities> cities = new HashSet<Cities>();
		cities.add(montreal);
		cities.add(quebecCity);
		
		Cities savedCities =citiesLanguagesService.saveCitiesService(cities,quebec);
		Assert.assertEquals(false, savedCities.getClanguages().isEmpty());
		
		
	}	
}
