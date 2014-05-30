package com.agilemaple.common.services.impl;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.agilemaple.common.dao.CitiesLanguagesDAO;


import com.agilemaple.common.entity.Cities;
import com.agilemaple.common.entity.Provinces;



import com.agilemaple.common.services.CitiesLanguagesService;

import java.util.*;




@Service
public class CitiesLanguagesServiceImpl implements CitiesLanguagesService{
	
	@Autowired
	private CitiesLanguagesDAO citiesLanguagesDAO;
	// get log4j handler
	

	@Transactional
	public Cities saveCitiesService(Set<Cities> cities ,Provinces provinces) {
		provinces.setCities(cities);
		 citiesLanguagesDAO.saveProvinces(provinces);
		Cities savedCity= null;
		for(Cities city : cities){
			savedCity = citiesLanguagesDAO.saveCities(city);
		
		}
		return savedCity;
	}
}
	
