package com.example.demo.data.document;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.domain.Contact;

public interface ContactRepository extends MongoRepository<Contact, Integer>{
	@Query("{'id':?0 , 'userName' : ?1}")
	Contact findContact(int id, String userName);

	Contact findContactById(int id);

	Contact findContactByUserName(String a);


}
