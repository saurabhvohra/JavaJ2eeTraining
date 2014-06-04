package com.agilemaple.common.services;


import com.agilemaple.common.entity.Cities;
import com.agilemaple.common.entity.Provinces;

import java.util.*;


public interface CitiesLanguagesService {
	/**
	 * Returns an object Cities which is been saved in DAO layer
	 * In this case we made a association OneToMany/ManyToOne between Provinces and Cities
	 * and MantToMany between Cities and Languages 
	 * and PropertyType 
	 *
	 * @param  url  an absolute URL giving the base location of the image
	 * @param  name the location of the image, relative to the url argument
	 * @return   Cities   
	 * @see         Image
	 */
	public Cities saveCitiesService(Set<Cities> cities,Provinces provinces);
	
}
