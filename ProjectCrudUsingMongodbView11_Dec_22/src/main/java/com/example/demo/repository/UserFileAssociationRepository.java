package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.api.response.BaseResponse;
import com.example.demo.domain.UserFileAssociation;
import com.example.demo.dto.UserFileAssociationDto;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface UserFileAssociationRepository extends MongoRepository<UserFileAssociation, String>{

	UserFileAssociation findByFiles_InternalFileName(String internalFileName);

	//List<UserFileAssociation> findByUserName(String userName);

	//UserFileAssociation findByInternalFileName(String internalFileName);

}
