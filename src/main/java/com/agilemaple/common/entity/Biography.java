package com.agilemaple.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="biographies")
public class Biography {
	
	@Id
	@Column(name="author_id")
	
	private Integer authorId;
	
	private String information;
	
	
	
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
}
