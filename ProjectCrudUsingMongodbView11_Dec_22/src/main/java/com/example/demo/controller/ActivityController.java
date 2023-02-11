package com.example.demo.controller;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    @ApiOperation(value = " To  Create Activity ",
            notes = "To  create activity  by passing below  info! ", response = ActivityDto.class)
    @RequestMapping(value = ActivityUrls.V1.Post.ACTIVITY_CREATE, method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ActivityDto createActivity(@RequestBody ActivityDto activityDto)
            {

      /*  Map<String, String> activityMap = new HashMap<String, String>();
        ObjectMapper m = new ObjectMapper();

        activityMap = m.readValue(activityParams.get("activity"), HashMap.class);
        Activity newActivity = this.activityCreateLogic.createActivity(activityMap);
        if(Objects.nonNull(newActivity.getStartDate())
                && Objects.nonNull(newActivity.getEndDate())) {
            this.activityProcessDatesLogic.processParentPathsForDateChange(newActivity);
            this.activityProcessDatesLogic.processParentPathsForActualStartDates(newActivity);
        }
        return this.activityConversionService.toDto(newActivity,
                2, 0, this.getDtoCache());
*/
		return activityConversionService.toDto(activityLogic.createActivity(activityDto));
    }
	
	
}
