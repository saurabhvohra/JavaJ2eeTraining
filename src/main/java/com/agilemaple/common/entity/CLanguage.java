package com.agilemaple.common.entity;


import java.util.Set;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

import javax.persistence.Table;



@Entity
@Table(name="web_c_language")
public class CLanguage{
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="languageName")
	private String languageName;
    
    
    @ManyToMany(mappedBy="clanguages")
    private Set<Cities> cities;


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


	public Set<Cities> getCities() {
		return cities;
	}


	public void setCities(Set<Cities> cities) {
		this.cities = cities;
	}


    
}

    
	
    