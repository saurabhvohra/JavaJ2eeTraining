package com.agilemaple.common.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="authors")
public class Authors {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	@OneToOne(mappedBy="author", cascade=CascadeType.ALL)
	
	private Biography biography;

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

	public Biography getBiography() {
		return biography;
	}

	public void setBiography(Biography biography) {
		this.biography = biography;
	}
}
