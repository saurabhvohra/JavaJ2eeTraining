package com.agilemaple.common.dao.impl;





import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.agilemaple.common.dao.CitiesLanguagesDAO;
import com.agilemaple.common.dao.ProvincesLanguagesDAO;

import com.agilemaple.common.entity.Cities;
import com.agilemaple.common.entity.Provinces;

@Repository
public class CitiesLanguagesDAOImpl implements CitiesLanguagesDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Provinces saveProvinces(Provinces provinces) {
		sessionFactory.getCurrentSession().save(provinces);
		return provinces;
	}
	
	@Override
	public Cities saveCities(Cities cities) {
		sessionFactory.getCurrentSession().save(cities);
		return cities;
	}


	
}
