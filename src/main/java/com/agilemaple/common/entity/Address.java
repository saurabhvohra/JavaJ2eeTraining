package com.agilemaple.common.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name="web_address")
public class Address {
	
	/*@Id
	@GeneratedValue
	private Integer id;*/
	
	private Integer number;
	
	private String street;
	
	private String city;
	
	private String province;
	
	private String zip;
	
	private String country;
	
	@Id
	@Column(name="propertyItems_id")
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen",strategy="foreign",parameters=@Parameter(name="property",value="propertyItems"))
	private Integer propertyItemsId;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private PropertyItems propertyItems;
	
	
/*	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}*/


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Integer getPropertyItemsId() {
		return propertyItemsId;
	}


	public void setPropertyItemsId(Integer propertyItemsId) {
		this.propertyItemsId = propertyItemsId;
	}


	public PropertyItems getPropertyItems() {
		return propertyItems;
	}


	public void setPropertyItems(PropertyItems propertyItems) {
		this.propertyItems = propertyItems;
	}


	
	


}