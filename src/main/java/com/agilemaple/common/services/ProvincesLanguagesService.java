package com.agilemaple.common.services;



import com.agilemaple.common.entity.Provinces;
import java.util.*;


public interface ProvincesLanguagesService {
	/**
	 * Returns an object Provinces which is been saved in DAO layer
	 * In this case we made a association OneToMany between Provinces and Cities
	 * and MantToMany between Provinces and Languages 
	 * and PropertyType 
	 *
	 * @param  url  an absolute URL giving the base location of the image
	 * @param  name the location of the image, relative to the url argument
	 * @return   Provinces   
	 * @see         Image
	 */
	public Provinces saveProvincesService(Set<Provinces> provinces);
}
