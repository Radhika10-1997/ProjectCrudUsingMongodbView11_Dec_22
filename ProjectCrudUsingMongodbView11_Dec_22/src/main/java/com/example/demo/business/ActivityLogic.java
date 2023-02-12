package com.example.demo.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.graph.ActivityRepository;
import com.example.demo.data.graph.VisiLeanGraphObjectFactory;
import com.example.demo.domain.Activity;
import com.example.demo.dto.ActivityDto;

@Service
public class ActivityLogic {

	@Autowired
	private ActivityRepository activityRepository;

	public Activity createActivity(Activity activityDomain) {
		return activityRepository.save(activityDomain);		
	}
	
	
}
