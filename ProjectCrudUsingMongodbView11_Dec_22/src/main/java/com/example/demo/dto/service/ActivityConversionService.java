package com.example.demo.dto.service;

import org.springframework.stereotype.Component;
import com.example.demo.dto.ActivityDto;

import com.example.demo.domain.Activity;

@Component
public class ActivityConversionService {

	public ActivityDto toDto(Activity createActivity) {
ActivityDto act = new ActivityDto();
act.setActivityTaskId(createActivity.getGuid());
act.setName(createActivity.getName());
return act;
	}

}
