package com.learnspring.contactapp.service;

import java.util.List;

import com.learnspring.contactapp.domain.Contact;

public interface ContactService {

	void addContact(Contact contact);
	List<Contact> getAllContacts();
	Contact getContact(Long id);	
}
