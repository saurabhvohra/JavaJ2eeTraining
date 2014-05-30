package com.agilemaple.common.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.agilemaple.common.dao.ProvincesLanguagesDAO;


import com.agilemaple.common.entity.Provinces;


import com.agilemaple.common.services.ProvincesLanguagesService;

import java.util.*;

import javax.xml.soap.Detail;



@Service
public class ProvincesLanguagesServiceImpl implements ProvincesLanguagesService{
	
	@Autowired
	private ProvincesLanguagesDAO provincesLanguagesDAO;
	// get log4j handler
	

	@Transactional
	public Provinces saveProvincesService(Set<Provinces> provinces) {
		Provinces savedProvince= null;
		for(Provinces province : provinces){
		savedProvince = provincesLanguagesDAO.saveProvinces(province);
		
		}
		return savedProvince;
	}
	
}
	
	
	
	
	   
		


