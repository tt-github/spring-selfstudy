package com.learnspring.contactapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.learnspring.contactapp.domain.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

	@Query("select c from Contact c where c.birthDate > :date")
	List<Contact> findAllContactOlderThan(@Param("date") Date date);
	
	@Query("select c from Contact c")
	List<Contact> findAllContact();
}
