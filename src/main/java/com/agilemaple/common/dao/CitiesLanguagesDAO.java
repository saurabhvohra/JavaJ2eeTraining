package com.agilemaple.common.dao;



import org.springframework.stereotype.Service;
import com.agilemaple.common.entity.Cities;
import com.agilemaple.common.entity.Provinces;

@Service
public interface CitiesLanguagesDAO {
	public Cities saveCities(Cities cities);
	public Provinces saveProvinces(Provinces provinces);
}
