package com.learnspring.contactapp.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.learnspring.contactapp.domain.Contact;
import com.learnspring.contactapp.repository.ContactRepository;
import com.learnspring.contactapp.service.ContactService;

@Service
@Transactional(readOnly=true)
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	private final Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);

	@Transactional
	public void addContact(Contact contact) {
		Assert.notNull(contact, "The contact must not be null");
		logger.debug("Add new contact. " + contact.toString());		
		contactRepository.save(contact);
	}

	public List<Contact> getAllContacts() {
		return contactRepository.findAllContact();
	}

	public Contact getContact(Long id) {
		return contactRepository.findOne(id);
	}

}
