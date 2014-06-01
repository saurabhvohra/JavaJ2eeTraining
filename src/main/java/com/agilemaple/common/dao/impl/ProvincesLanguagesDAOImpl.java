package com.agilemaple.common.dao.impl;





import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.agilemaple.common.dao.ProvincesLanguagesDAO;

import com.agilemaple.common.entity.Provinces;

@Repository
public class ProvincesLanguagesDAOImpl implements ProvincesLanguagesDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Provinces saveProvinces(Provinces provinces) {
		sessionFactory.getCurrentSession().save(provinces);
		return provinces;
	}
}
