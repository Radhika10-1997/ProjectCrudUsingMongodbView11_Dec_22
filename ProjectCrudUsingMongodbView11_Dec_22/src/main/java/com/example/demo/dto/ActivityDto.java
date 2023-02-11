package com.example.demo.dto;

import java.util.List;

public class ActivityDto {

	    private String name;

	    private String description;

	    private String activitySafety;

	    private long createdAt;

	    private long updatedAt;

	    private Long startDate;

	    private Long endDate;

	    private Integer activityPriority;

	    private String locationGuid;

	    private String activityLocation;

	    private boolean hasChildren;

	    private String parentGuid;

	    private String projectGuid;

	    private Integer status;

	    private List<ActivityDto> children;

	    private ActorDto owner;

	    private ActorDto responsibleActor;

	    private String activityType;

	    private TradeDto activityTrade;
	    	    
	    private String activityTaskId;
	    	   
	    public String getName() {

	        return name;
	    }

	    public void setName(String name) {

	        this.name = name;
	    }

	    public String getDescription() {

	        return description;
	    }

	    public void setDescription(String description) {

	        this.description = description;
	    }

	    public long getCreatedAt() {

	        return createdAt;
	    }

	    public void setCreatedAt(long createdAt) {

	        this.createdAt = createdAt;
	    }

	    public long getUpdatedAt() {

	        return updatedAt;
	    }

	    public void setUpdatedAt(long updatedAt) {

	        this.updatedAt = updatedAt;
	    }

	    public Long getStartDate() {

	        return startDate;
	    }

	    public void setStartDate(Long startDate) {

	        this.startDate = startDate;
	    }

	    public Long getEndDate() {

	        return endDate;
	    }

	    public void setEndDate(Long endDate) {

	        this.endDate = endDate;
	    }

	    

	    public Integer getActivityPriority() {

	        return activityPriority;
	    }

	    public void setActivityPriority(Integer activityPriority) {

	        this.activityPriority = activityPriority;
	    }

	    public String getParentGuid() {

	        return parentGuid;
	    }

	    public void setParentGuid(String parentGuid) {

	        this.parentGuid = parentGuid;
	    }

	    public Integer getStatus() {

	        return status;
	    }

	    public void setStatus(Integer status) {

	        this.status = status;
	    }

	    public String getActivityType() {

	        return this.activityType;
	    }

	    public void setActivityType(String activityType) {

	        this.activityType = activityType;
	    }

	    public List<ActivityDto> getChildren() {

	        return children;
	    }

	    public void setChildren(List<ActivityDto> children) {

	        this.children = children;
	    }

	    public ActorDto getOwner() {

	        return owner;
	    }

	    public void setOwner(ActorDto owner) {

	        this.owner = owner;
	    }

	    public ActorDto getResponsibleActor() {

	        return responsibleActor;
	    }

	    public void setResponsibleActor(ActorDto responsibleActor) {

	        this.responsibleActor = responsibleActor;
	    }

	    public String getProjectGuid() {

	        return this.projectGuid;
	    }

	    public void setProjectGuid(String projectGuid) {

	        this.projectGuid = projectGuid;
	    }

	    public boolean getHasChildren() {

	        return this.hasChildren;
	    }

	    public void setHasChildren(boolean hasChildren) {

	        this.hasChildren = hasChildren;
	    }
	    
	    public String getLocationGuid() {

	        return locationGuid;
	    }

	    public void setLocationGuid(String locationGuid) {

	        this.locationGuid = locationGuid;
	    }

	    public String getActivityLocation() {

	        return activityLocation;
	    }

	    public void setActivityLocation(String activityLocation) {

	        this.activityLocation = activityLocation;
	    }

	    public String getActivitySafety() {

	        return activitySafety;
	    }

	    public void setActivitySafety(String activitySafety) {

	        this.activitySafety = activitySafety;
	    }

	    public TradeDto getActivityTrade() {

	        return activityTrade;
	    }

	    public void setActivityTrade(TradeDto activityTrade) {

	        this.activityTrade = activityTrade;

	    }
	    
	    @Override
	    public String toString() {

	        return "ActivityDto [name=" + name + ", activityType=" + activityType + ", activityTrade="
	                + activityTrade + "]";
	    }

	    
	    public String getActivityTaskId() {

	        return activityTaskId;
	    }

	    public void setActivityTaskId(String activityTaskId) {

	        this.activityTaskId = activityTaskId;
	    }

		
	    
}
