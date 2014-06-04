package com.agilemaple.common.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="web_property_type")
public class PropertyType {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="property_id")
	private Property property;
	
	@OneToMany(mappedBy="propertyType", cascade=CascadeType.ALL)
	private Set<PropertyItems> propertyItems;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Set<PropertyItems> getPropertyItems() {
		return propertyItems;
	}

	public void setPropertyItems(Set<PropertyItems> propertyItems) {
		this.propertyItems = propertyItems;
	}
	
}