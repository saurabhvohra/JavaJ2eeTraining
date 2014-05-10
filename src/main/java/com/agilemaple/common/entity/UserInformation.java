package com.agilemaple.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="USERINFORMATION")
public class UserInformation{
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="number")
	private String number;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}