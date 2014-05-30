package com.agilemaple.common.services.impl;

import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



import com.agilemaple.common.entity.PLanguage;
import com.agilemaple.common.entity.Provinces;

import com.agilemaple.common.services.ProvincesLanguagesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/test-dispatcher-servlet.xml"})
public class ProvincesLanguagesServiceImplIntgTest{

	
	@Autowired
	private ProvincesLanguagesService provincesLanguagesService;
	@Test
	public void saveProvincesServiceTest(){
		PLanguage english = new PLanguage();
		english.setLanguageName("english");
		PLanguage french = new PLanguage();
		french.setLanguageName("french");
		
		Set<PLanguage> differentLanguages = new HashSet<PLanguage>();
		differentLanguages.add(english);
		differentLanguages.add(french);
		
		Set<PLanguage> differentLanguagesAlberta = new HashSet<PLanguage>();
		differentLanguagesAlberta.add(english);
		
		
		
		Provinces quebec = new Provinces();
		quebec.setProvinceName("Quebec");
		Provinces alberta = new Provinces();
		alberta.setProvinceName("Alberta");
		
	
		quebec.setPlanguages(differentLanguages);
		alberta.setPlanguages(differentLanguagesAlberta);
	
		Set<Provinces> provinces = new HashSet<Provinces>();
		provinces.add(quebec);
		provinces.add(alberta);
		
		Provinces savedProvince = provincesLanguagesService.saveProvincesService(provinces);
		Assert.assertEquals(false,savedProvince.getPlanguages().isEmpty());
		
	}
	

	
}
