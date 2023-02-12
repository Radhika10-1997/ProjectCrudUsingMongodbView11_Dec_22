package com.example.demo.controller;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.response.BaseResponse;
import com.example.demo.business.ActivityLogic;
import com.example.demo.domain.Activity;
import com.example.demo.dto.ActivityDto;
import com.example.demo.dto.service.ActivityConversionService;
import com.example.demo.url.ActivityUrls;
import io.swagger.annotations.ApiOperation;

@RestController
public class ActivityController {

	@Autowired
	private ActivityLogic activityLogic;
	
	@Autowired
	private ActivityConversionService activityConversionService;
	
	@SuppressWarnings("unchecked")
	@ApiOperation(value = " To  Create Activity ", notes = "To  create activity  by passing below  info! ", response = ActivityDto.class)
	@RequestMapping(value = ActivityUrls.V1.Post.ACTIVITY_CREATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<Object> createActivity(@RequestBody ActivityDto activityDto) {

		BaseResponse res = new BaseResponse(activityConversionService
				.toDto(activityLogic.createActivity(activityConversionService.toDomain(activityDto))));
		return new ResponseEntity<>(res, HttpStatus.OK);

	}
	
}
