package com.agilemaple.common.entity;


import java.util.Set;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import javax.persistence.JoinColumn;
import javax.persistence.Table;



@Entity
@Table(name="webprovince")
public class Provinces{
	@Id
	@GeneratedValue
	private Integer id;
	
    @Column(name="provinceName")
	private String provinceName;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="web_province_language",joinColumns={@JoinColumn(name="province_id")},
                inverseJoinColumns={@JoinColumn(name="languages_id")})
    private Set<PLanguage> planguages;

    @OneToMany(mappedBy="provinces", cascade=CascadeType.ALL)  
    private Set<Cities> cities; 
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Set<PLanguage> getPlanguages() {
		return planguages;
	}

	public void setPlanguages(Set<PLanguage> planguages) {
		this.planguages = planguages;
	}

	public Set<Cities> getCities() {
		return cities;
	}

	public void setCities(Set<Cities> cities) {
		this.cities = cities;
	}

}