package com.learnspring.contactapp.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.learnspring.contactapp.domain.Contact;
import com.learnspring.contactapp.service.ContactService;

@Controller
@RequestMapping(value = "contacts")
public class ContactController {

	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	private ContactService contactService;
	
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
//	            dateFormat, false));
//	}
	
	// contacts
	@RequestMapping(method = RequestMethod.GET)
	public String contacts(Locale locale, Model model) {
		logger.info("Show contacts, locale is "+ locale.toString());
		
		List<Contact> contacts = contactService.getAllContacts();
		
		model.addAttribute("contacts", contacts );
		
		return "contacts";
	}
	
	// contacts?form
	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String addFormt(Model model, RedirectAttributes redirectAttrs, Locale locale) {
		model.addAttribute("contact", new Contact());
		return "contact";
	}
	
	// contacts?form
	@RequestMapping(params = "form", method = RequestMethod.POST)
	public String add(@ModelAttribute("contact") Contact contact, BindingResult result, 								
			 				Model model, RedirectAttributes redirectAttrs, Locale locale) {
		logger.info("Adding new contact. " + contact.toString());
		contactService.addContact(contact);
		return "redirect:contacts";
	}
}
