package com.example.demo.dto.service;

import org.springframework.stereotype.Component;
import com.example.demo.dto.ActivityDto;
import com.example.demo.enums.ActivityStatus;
import com.example.demo.enums.ActivityType;
import com.example.demo.common.ProjectTimeZone;
import com.example.demo.data.graph.VisiLeanGraphObjectFactory;
import com.example.demo.domain.Activity;

@Component
public class ActivityConversionService {

	public ActivityDto toDto(Activity createActivity) {
		ActivityDto actDto = new ActivityDto();
		actDto.setId(createActivity.getGuid());
		actDto.setName(createActivity.getName());
		actDto.setActivityPriority(createActivity.getActivityPriority());
		actDto.setActivitySafety(createActivity.getActivitySafety());
		actDto.setActivityType(this.setStatusToDto(createActivity.getActivityType()));
		actDto.setDescription(createActivity.getDescription());
		actDto.setStartDate(Long.valueOf(createActivity.getStartDate()));
		actDto.setEndDate(Long.valueOf(createActivity.getEndDate()));
		actDto.setCreatedAt(ProjectTimeZone.getProjectTimeZoneCurrentMillis());
		actDto.setUpdatedAt(ProjectTimeZone.getProjectTimeZoneCurrentMillis());
		return actDto;
	}

	public Activity toDomain(ActivityDto activityDto) {
		Activity newActivity = VisiLeanGraphObjectFactory.createNodeObjectInstance(Activity.class);
		newActivity.setName(activityDto.getName());
		newActivity.setActivityPriority(activityDto.getActivityPriority());
		newActivity.setActivitySafety(activityDto.getActivitySafety());
		newActivity.setActivityType(this.setStatus(activityDto.getActivityType()));
		newActivity.setDescription(activityDto.getDescription());
		newActivity.setStartDate(ProjectTimeZone.getProjectTimeZoneCurrentMillis());
		newActivity.setEndDate(ProjectTimeZone.getProjectTimeZoneCurrentMillis());
		newActivity.setCreatedAt(ProjectTimeZone.getProjectTimeZoneCurrentMillis());
		newActivity.setUpdatedAt(ProjectTimeZone.getProjectTimeZoneCurrentMillis());
		newActivity.setStatus(activityDto.getStatus());
		return newActivity;
	}

	@SuppressWarnings("unlikely-arg-type")
	private String setStatusToDto(ActivityType type) {

		if (type.equals(ActivityType.DESIGN)) {
			return ActivityType.DESIGN.toString();

		} else if (type.equals(ActivityType.CONSTRUCTION)) {
			return ActivityType.CONSTRUCTION.toString();

		} else if (type.equals(ActivityType.START_MILESTONE)) {
			return ActivityType.START_MILESTONE.toString();

		} else {
			return ActivityType.END_MILESTONE.toString();
		}
	}

	private ActivityType setStatus(String type) {

		if (type.equals("Design")) {
			return ActivityType.DESIGN;

		} else if (type.equals("Construction")) {
			return ActivityType.CONSTRUCTION;

		} else if (type.equals("Start milestone")) {
			return ActivityType.START_MILESTONE;

		} else {
			return ActivityType.END_MILESTONE;
		}
	}
}