package com.agilemaple.common.services;


import com.agilemaple.common.entity.Cities;
import com.agilemaple.common.entity.Provinces;

import java.util.*;


public interface CitiesLanguagesService {
	
	public Cities saveCitiesService(Set<Cities> cities,Provinces provinces);
	
}
