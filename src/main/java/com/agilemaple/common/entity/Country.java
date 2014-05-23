package com.agilemaple.common.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="CONTACTS")
public class Country{
	
	/*@Id
	@Column(name="ID")
	@GeneratedValue*/
	private String name;
	
	/*@Column(name="FIRSTNAME")*/
	private String capital;

	/*@Column(name="LASTNAME")*/
	private List<String> languages;

	/*@Column(name="EMAIL")*/
	private List<String> currencies;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public List<String> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<String> currencies) {
		this.currencies = currencies;
	}
	
	
}
