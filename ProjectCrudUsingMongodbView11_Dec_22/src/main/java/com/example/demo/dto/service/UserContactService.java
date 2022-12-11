package com.example.demo.dto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Contact;
import com.example.demo.domain.User;
import com.example.demo.dto.UserContactDto;
@Component
public class UserContactService implements UserContactInterface{

	@Override
	public List<UserContactDto> toDtos(List<User> userList, Map<Integer, Contact> contactMap) {
		List<UserContactDto> userContactDto = new ArrayList<>();	
		//userContactDto.add(contactList.stream().forEach(l->);
		//contactList.forEach(l->{setDto(l,userContactDto);});
		userList.forEach(l->{userContactDto.add(setDto(l,contactMap));});
		return userContactDto;
	}

	private UserContactDto setDto(User l, Map<Integer, Contact> contactMap) {
		UserContactDto uc = new UserContactDto();
		uc.setId(l.getId());
		uc.setUserName(l.getUserName());
		uc.setPassword(l.getPassword());
		//contactMap.get(l.getId()).getPhoneNumber();
		if(Objects.nonNull(contactMap.get(l.getId()))){
		uc.setPhoneNumber(contactMap.get(l.getId()).getPhoneNumber());
		}
		return uc;
	}

	@Override
	public UserContactDto toDto(User u, Contact c) {
		UserContactDto uc = new UserContactDto();
		uc.setId(u.getId());
		uc.setUserName(u.getUserName());
		uc.setPassword(u.getPassword());
		if (Objects.nonNull(c)) {
			uc.setPhoneNumber(c.getPhoneNumber());
		}
		return uc;
	}

	
	
}
