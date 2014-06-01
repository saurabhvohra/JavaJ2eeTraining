package com.agilemaple.common.entity;


import java.util.Set;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

import javax.persistence.Table;



@Entity
@Table(name="web_p_language")
public class PLanguage{
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="languageName")
	private String languageName;
    
    
    @ManyToMany(mappedBy="planguages")
    private Set<Provinces> provinces;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLanguageName() {
		return languageName;
	}


	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}


	public Set<Provinces> getProvinces() {
		return provinces;
	}


	public void setProvinces(Set<Provinces> provinces) {
		this.provinces = provinces;
	}
}

    /*@ManyToMany(mappedBy="languagesCities")
    private Set<Cities> cities;*/
	
    