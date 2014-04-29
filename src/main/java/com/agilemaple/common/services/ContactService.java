package com.agilemaple.common.services;

import java.util.List;

import com.agilemaple.common.entity.Contact;


public interface ContactService {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
