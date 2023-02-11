package com.example.demo.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

import com.example.demo.data.graph.AbstractGraphNodeEntity;
import com.example.demo.enums.ActivityType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Activity extends AbstractGraphNodeEntity {

	private Integer taskId;

	private String externalId;

	private String name;

	private String description;

	private String activitySafety;

	private long createdAt;

	private long updatedAt;

	private Long startDate;

	private Long endDate;

	private Integer activityPriority = 1;

	private String locationGuid;

	private boolean hasChildren;

	private String parentGuid;

	private Integer status;

	private ActivityType activityType;

	private String locationName;
	
    private String tradeGuid;

	@Relationship(type = "PARENT_OF", direction = Direction.OUTGOING)
	private Set<Activity> children;

	@Relationship(type = "OWNER_OF", direction = Direction.INCOMING)
	private Actor owner;

	@Relationship(type = "RESPONSIBLE_ACTOR", direction = Direction.INCOMING)
	private Actor responsibleActor;

	@Relationship(type = "TRADE_OF", direction = Direction.INCOMING)
	private Trade activityTrade;

	public Activity() {
		super();
		this.children = new HashSet<Activity>();
	}
	public String getTradeGuid() {

        return tradeGuid;
    }
	
    public void setTradeGuid(String tradeGuid) {

        this.tradeGuid = tradeGuid;
    }
	 public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

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

	public String getActivitySafety() {
		return activitySafety;
	}

	public void setActivitySafety(String activitySafety) {
		this.activitySafety = activitySafety;
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

	public String getLocationGuid() {
		return locationGuid;
	}

	public void setLocationGuid(String locationGuid) {
		this.locationGuid = locationGuid;
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
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

	public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Set<Activity> getChildren() {
		return children;
	}

	public void setChildren(Set<Activity> children) {
		this.children = children;
	}

	public Actor getOwner() {
		return owner;
	}

	public void setOwner(Actor owner) {
		this.owner = owner;
	}

	public Actor getResponsibleActor() {
		return responsibleActor;
	}

	public void setResponsibleActor(Actor responsibleActor) {
		this.responsibleActor = responsibleActor;
	}

	public Trade getActivityTrade() {
		return activityTrade;
	}

	public void setActivityTrade(Trade activityTrade) {
		this.activityTrade = activityTrade;
	}

	public void addChild(Activity child) {

	        child.setParentGuid(this.getGuid());
	        this.children.add(child);
	        this.hasChildren = !this.children.isEmpty();
	    }

	    public void removeChild(Activity child) {

	        if(this.children.remove(child)) {
	            child.setParentGuid(null);
	        }
	        this.hasChildren = !this.children.isEmpty();
	    }

}
