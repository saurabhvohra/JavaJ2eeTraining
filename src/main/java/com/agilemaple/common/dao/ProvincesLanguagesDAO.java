package com.agilemaple.common.dao;



import org.springframework.stereotype.Service;


import com.agilemaple.common.entity.Provinces;

@Service
public interface ProvincesLanguagesDAO {
	public Provinces saveProvinces(Provinces provinces);
}
