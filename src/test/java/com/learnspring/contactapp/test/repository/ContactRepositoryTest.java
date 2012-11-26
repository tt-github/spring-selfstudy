package com.learnspring.contactapp.test.repository;

import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.learnspring.contactapp.domain.Contact;
import com.learnspring.contactapp.repository.ContactRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:contact-app-jpa-test.xml"})
@Transactional
public class ContactRepositoryTest {
	
	@Autowired
	ContactRepository contactRepository;
	
	@Test
	@Rollback
	public void retrieveData() {
		Calendar calendar = Calendar.getInstance();
		Contact contact = new Contact("Test", "User", calendar.getTime());		
		contactRepository.save(contact);
		
		Assert.assertEquals(1, contactRepository.count());
	}
	
	@Test
	@Rollback
	public void filterUsersByBirthDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(1988, 02, 25);
		Contact contact = new Contact("Test", "User", calendar.getTime());		
		contactRepository.save(contact);
				
		calendar.set(1966, 01, 01);
		contact = new Contact("Test2", "User", calendar.getTime());		
		contactRepository.save(contact);
		
		calendar.set(1988, 01, 01);
		Assert.assertEquals(1, contactRepository.findAllContactOlderThan(calendar.getTime()).size());
	}	
}
