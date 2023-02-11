package com.example.demo.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.data.document.ContactRepository;
import com.example.demo.domain.Contact;
import com.example.demo.domain.User;
@Service
public class ContactLogic {
	@Autowired
	private ContactRepository contactRepository;

	public Contact getContactById(int id) {		
		return contactRepository.findContactById(id);
	}

	public Contact createContact(Contact domain) {
		return contactRepository.save(domain);
	}

	public List<Contact> getAllContact() {
		return contactRepository.findAll();
	}
	
	public boolean deleteContact(int id) {
		contactRepository.deleteById(id);
		return true;
	}

	public Contact UpdateContact(Contact domain) {
		Contact c= contactRepository.findContactById(domain.getId());
		c.setId(domain.getId());
		c.setUserName(domain.getUserName());
		c.setPhoneNumber(domain.getPhoneNumber());
		contactRepository.save(c);
		return c;
	}
	
	public Contact UpdateContact(int id) {
		Contact c= contactRepository.findContactById(id);
		Contact cObj = new Contact();
	//	Prerequisite newPrerequisiteObj=VisiLeanGraphObjectFactory.createNodeObjectInstance(Prerequisite.class);
		Contact c1=contactRepository.save(cObj);
		c1.setId(c.getId());
		c1.setUserName(c.getUserName());
		c1.setPhoneNumber(c.getPhoneNumber());
		
		return contactRepository.save(c1);
	}
}
