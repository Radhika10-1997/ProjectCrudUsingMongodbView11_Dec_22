package com.example.demo.dto.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.demo.domain.UserFileAssociation;
import com.example.demo.dto.UserFileAssociationDto;
@Component
public class UserFileAssociationConversationService implements 
IUserFileAssociationConversationService<UserFileAssociationDto, UserFileAssociation>{

	@Override
	public UserFileAssociationDto toDto(UserFileAssociation domainObj) {
		System.out.println(domainObj+"LLLLLLLLLLLL");
		UserFileAssociationDto uFileDto = new UserFileAssociationDto();
		//uFileDto.setAddedFiles(domainObj.getFiles().g);
		return null;
	} 

	@Override
	public List<UserFileAssociationDto> toDtos(Collection<UserFileAssociation> domainList) {
		// TODO Auto-generated method stub
		System.out.println(domainList+"/////////////////////");
		return null;
	}

	@Override
	public UserFileAssociation toDomainObject(UserFileAssociationDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<UserFileAssociation> toDomainObjects(Collection<UserFileAssociationDto> dtos) {
		// TODO Auto-generated method stub
		return null;
	}

}
