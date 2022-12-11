package com.example.demo.dto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.demo.domain.Contact;
import com.example.demo.domain.User;
import com.example.demo.dto.ContactDto;
import com.example.demo.dto.UserContactDto;
@Component
public class ContactConservationService implements IContactConversationService<ContactDto,Contact>{

	
	@Override
	public Contact toDomain(ContactDto tDto) {
		Contact contact = new Contact();	
		contact.setId(tDto.getId());
		contact.setUserName(tDto.getUserName());
		contact.setPhoneNumber(tDto.getPhoneNumber());
		return contact;
	}

	@Override
	public ContactDto toDto(Contact tDomain) {
		ContactDto cDto = new ContactDto();
		cDto.setId(tDomain.getId());
		cDto.setUserName(tDomain.getUserName());
		cDto.setPhoneNumber(tDomain.getPhoneNumber());
		return cDto;
	}

	@Override
	public List<ContactDto> toDtos(List<Contact> allContact) {
		List<ContactDto> cDtoList = new ArrayList<>();
		allContact.forEach(l-> {cDtoList.add(this.toDto(l));});
		return cDtoList;
	}

	

}
