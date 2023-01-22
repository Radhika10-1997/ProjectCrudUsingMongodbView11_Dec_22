package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<Object> addUpdateUserFiles(@RequestParam String data, @RequestParam List<MultipartFile> files)
			throws JsonMappingException, JsonProcessingException {
		ObjectMapper obj = new ObjectMapper();
		UserFileAssociationDto userFileAssociationDto = obj.readValue(data, UserFileAssociationDto.class);
		BaseResponse response = new BaseResponse(
				userFileAssociationLogic.addUpdateUserFiles(userFileAssociationDto, files));
		return new ResponseEntity<Object>(response, HttpStatus.OK);
		// return userFileAssociationLogic.addUpdateUserFiles(userFileAssociationDto,
		// files);
	}																
	
	@PostMapping(value = ActivityUrls.V1.Post.ADD_UPDATE_SINGLE_USERFILE)
	public ResponseEntity<Object> handleFileUpload(@RequestParam(value = "data", required = true) String data,
			@RequestParam("file") MultipartFile file) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		UserFileAssociationDto userFileAssociationDto = mapper.readValue(data, UserFileAssociationDto.class);

		BaseResponse response = new BaseResponse(
				userFileAssociationLogic.addUpdateUserFiles(userFileAssociationDto, List.of(file)));
		return new ResponseEntity<Object>(response, HttpStatus.OK);

	}
	
	@GetMapping(value = ActivityUrls.V1.Get.GET_USER_FILES)
	public ResponseEntity<Object> loadUserFiles(@RequestParam String globalId) {
		BaseResponse response = new BaseResponse(userFileAssociationLogic.loadUserFiles(globalId));
		return new ResponseEntity<Object>(response, HttpStatus.OK);

	}

	// "628E417A-3B6B-583A-9175-0716C5602FD9" "023E066D-CDA2-F675-F2E0-9734CEF6DF08"
	@GetMapping(value = ActivityUrls.V1.Get.GET_ALL_USER_FILES)
	public ResponseEntity<Object> getUserFileAssociationList() {
		BaseResponse response = new BaseResponse(userFileAssociationLogic.getUserFileAssociationList());
		return new ResponseEntity<Object>(response, HttpStatus.OK);

	}

	@DeleteMapping(value = ActivityUrls.V1.Delete.DELETE_USER_FILES)
	public ResponseEntity<Object> handleRemoveCheckListFile(@RequestParam String serverName) throws Exception {

		BaseResponse response = new BaseResponse(this.userFileAssociationLogic.removeCheckListFile(serverName));
		return new ResponseEntity<Object>(response, HttpStatus.OK);

	}
}
