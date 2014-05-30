package com.agilemaple.common.entity;


import java.util.Set;




import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


import javax.persistence.JoinColumn;
import javax.persistence.Table;



@Entity
@Table(name="webcity")
public class Cities{
	@Id
	@GeneratedValue
	private Integer id;
	
    @Column(name="cityname")
	private String cityname;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="web_city_language",joinColumns={@JoinColumn(name="cities_id")},
                inverseJoinColumns={@JoinColumn(name="languages_id")})
    private Set<CLanguage> clanguages;
  
    @ManyToOne  
    @JoinColumn(name = "pr_id")  
    private Provinces provinces; 
   

	public Provinces getProvinces() {
		return provinces;
	}

	public void setProvinces(Provinces provinces) {
		this.provinces = provinces;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public Set<CLanguage> getClanguages() {
		return clanguages;
	}

	public void setClanguages(Set<CLanguage> clanguages) {
		this.clanguages = clanguages;
	}
    
  
    
	
	
}