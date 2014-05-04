package com.agilemaple.common.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agilemaple.common.entity.Contact;

@Service
public interface ContactDAO {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
	public Contact findContact(String firstname, String lastname);
}
