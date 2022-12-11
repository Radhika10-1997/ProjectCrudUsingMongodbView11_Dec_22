package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.api.response.BaseResponse;
import com.example.demo.business.UserFileAssociationLogic;
import com.example.demo.domain.UserFileAssociation;
import com.example.demo.dto.UserFileAssociationDto;
import com.example.demo.dto.service.UserFileAssociationConversationService;
import com.example.demo.url.ActivityUrls;
import com.example.demo.url.ActivityUrls.V1;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserFileController {

	@Autowired
	private UserFileAssociationConversationService userFileAssociationConversationService;
	
	@Autowired
	private UserFileAssociationLogic userFileAssociationLogic;
	
	@PostMapping(value = ActivityUrls.V1.Post.ADD_UPDATE_USERFILES)
	public UserFileAssociation addUpdateUserFiles(@RequestParam String data,@RequestParam List<MultipartFile> files) throws JsonMappingException, JsonProcessingException {
		ObjectMapper obj = new ObjectMapper();
		UserFileAssociationDto userFileAssociationDto= obj.readValue(data, UserFileAssociationDto.class);
		//BaseResponse response = new BaseResponse(userFileAssociationLogic.addUpdateUserFiles(userFileAssociationDto, files));
		//return new ResponseEntity<Object>(response, HttpStatus.OK);
		return userFileAssociationLogic.addUpdateUserFiles(userFileAssociationDto, files);
	}
	
}
