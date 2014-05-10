package com.agilemaple.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="biographies")
public class Biography {
	
	@Id
	@Column(name="author_id")
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen",strategy="foreign",parameters=@Parameter(name="property",value="author"))
	private Integer authorId;
	
	private String information;
	
	public Authors getAuthor() {
		return author;
	}
	public void setAuthor(Authors author) {
		this.author = author;
	}
	@OneToOne
	@PrimaryKeyJoinColumn
	private Authors author;
	
	
	
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
