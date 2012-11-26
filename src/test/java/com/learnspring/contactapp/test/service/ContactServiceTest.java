package com.learnspring.contactapp.test.service;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.learnspring.contactapp.domain.Contact;
import com.learnspring.contactapp.repository.ContactRepository;
import com.learnspring.contactapp.service.ContactService;
import com.learnspring.contactapp.service.impl.ContactServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:contact-app-jpa-test.xml"})
public class ContactServiceTest {

	private ContactService contactService;
	
	@Before
	public void setUp() {
		contactService = new ContactServiceImpl();		
	}
	
	@Test
	public void getContact() {
		ContactRepository repository = createMock(ContactRepository.class);
		ReflectionTestUtils.setField(contactService, "contactRepository", repository);
		
		final Calendar calendar = Calendar.getInstance();
		
		List<Contact> contacts = new ArrayList<Contact>() {{
			
			add(new Contact("Test", "Test", calendar.getTime()));
			add(new Contact("Test2", "Test2", calendar.getTime()));
		
		}};
		
		expect(repository.findAllContact()).andReturn(contacts).times(1);
		
		replay(repository);
		
		Assert.assertEquals(contacts.size(), contactService.getAllContacts().size());
		
		verify(repository);
		
	}
		
}
