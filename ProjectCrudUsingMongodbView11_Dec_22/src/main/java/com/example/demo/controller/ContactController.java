package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.response.BaseResponse;
import com.example.demo.business.ContactLogic;
import com.example.demo.domain.Contact;
import com.example.demo.dto.ContactDto;
import com.example.demo.dto.service.ContactConservationService;
import com.example.demo.url.ActivityUrls;

@RestController
@RequestMapping("/api")
public class ContactController {

	@Autowired
	private ContactLogic contactService;
	
	@Autowired
	private ContactConservationService contactConservationService;
	
	@PostMapping(value = ActivityUrls.V1.Post.CREATE_CONTACT)
	public @ResponseBody ResponseEntity<Object> saveContact(@RequestBody ContactDto contactDto) {
		 BaseResponse res = new BaseResponse(contactConservationService.toDto(contactService.createContact(contactConservationService.toDomain(contactDto))));
	        return new ResponseEntity<>(res, HttpStatus.OK);
		
	}
	@GetMapping(value = ActivityUrls.V1.Get.CONTACT_BY_ID)
	public @ResponseBody Contact getContactById(@PathVariable("contactId") int id) {
		return contactService.getContactById(id);
	}

	@GetMapping(value = ActivityUrls.V1.Get.GET_ALL_CONTACT)
	public @ResponseBody ResponseEntity<Object>  getAllContact() {
		BaseResponse res =  new BaseResponse(contactConservationService.toDtos(contactService.getAllContact()));	
		return new ResponseEntity(res, HttpStatus.OK);
	}
		
	@DeleteMapping(value = ActivityUrls.V1.Delete.DELETE_CONTACT)
	public @ResponseBody ResponseEntity<Object> deleteContact(@PathVariable("contactId") int id){
		BaseResponse res = new BaseResponse(contactService.deleteContact(id));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@PutMapping(value = ActivityUrls.V1.Put.UPDATE_CONTACT)
	public @ResponseBody ResponseEntity<Object> updateContaxt(@RequestBody ContactDto contactDto ){
		BaseResponse res = new BaseResponse(contactConservationService.toDto(contactService.UpdateContact(contactConservationService.toDomain(contactDto))));
		return new ResponseEntity<>(res, HttpStatus.OK);
		
	}
	@PostMapping(value = ActivityUrls.V1.Post.COPY_CONTACT)
	public @ResponseBody ResponseEntity<Object> copyContaxt(@RequestBody ContactDto contactDto ){
		BaseResponse res = new BaseResponse(contactConservationService.toDto(contactService.UpdateContact(contactConservationService.toDomain(contactDto))));
		return new ResponseEntity<>(res, HttpStatus.OK);
		
	}
	
}
