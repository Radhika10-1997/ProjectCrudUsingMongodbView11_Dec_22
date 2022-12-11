package com.example.demo.dto.service;

import java.util.List;
import java.util.Map;

import com.example.demo.domain.Contact;
import com.example.demo.domain.User;
import com.example.demo.dto.UserContactDto;

public interface UserContactInterface {

	public List<UserContactDto> toDtos(List<User> userList, Map<Integer, Contact> contactMap);
	public UserContactDto toDto(User u, Contact c);
	
}
