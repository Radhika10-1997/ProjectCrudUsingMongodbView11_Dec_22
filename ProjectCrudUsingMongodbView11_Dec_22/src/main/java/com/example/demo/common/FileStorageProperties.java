package com.example.demo.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "vlapi.filestorage")
	@Component
	public class FileStorageProperties {

	    private String profileImageDirectory;

	    private String activityFileDirectory;

	    private String customerFileDirectory;

	    private String logoImageDirectory;

	    private String constraintLogFileDirectory;

	    private String constraintLogFileDirectoryExport;

	    private String percentagePlanCompleteDirectory;

	    private String model3dThumbnail;

	    private String model2dThumbnail;

	    private String dailyProgressReportDirectory;

	    private String dailyProgressReportDirectoryExport;

	    private String activitiesOwnerAssignMigrationDirectory;

	    private String removeMultipleRoleRelationshipMigration;

	    private String updateHasChildrenMigration;

	    private String updateActivityStatusMigration;

	    private String customFieldAuditEvent;

	    private String locatonFileDirectoryExport;

	    private String locationFirstImage;

	    private String modelMigrationDirectoryExport;
	    
	    private String checklistFileDirectory;

	    public String getUserFileDirectory() {
			return userFileDirectory;
		}

		public void setUserFileDirectory(String userFileDirectory) {
			this.userFileDirectory = userFileDirectory;
		}

		private String userFileDirectory;
	    
	    public String getPercentagePlanCompleteDirectory() {

	        return percentagePlanCompleteDirectory;
	    }

	    public void setPercentagePlanCompleteDirectory(String percentagePlanCompleteDirectory) {

	        this.percentagePlanCompleteDirectory = percentagePlanCompleteDirectory;
	    }

	    public String getProfileImageDirectory() {

	        return this.profileImageDirectory;
	    }

	    public void setProfileImageDirectory(String profileImageDirectory) {

	        this.profileImageDirectory = profileImageDirectory;
	    }

	    public String getActivityFileDirectory() {

	        return this.activityFileDirectory;
	    }

	    public void setActivityFileDirectory(String activityFileDirectory) {

	        this.activityFileDirectory = activityFileDirectory;
	    }

	    public String getCustomerFileDirectory() {

	        return customerFileDirectory;
	    }

	    public void setCustomerFileDirectory(String customerFileDirectory) {

	        this.customerFileDirectory = customerFileDirectory;
	    }

	    public String getLogoImageDirectory() {

	        return logoImageDirectory;
	    }

	    public void setLogoImageDirectory(String logoImageDirectory) {

	        this.logoImageDirectory = logoImageDirectory;
	    }

	    public String getConstraintLogFileDirectory() {

	        return constraintLogFileDirectory;
	    }

	    public void setConstraintLogFileDirectory(String constraintLogFileDirectory) {

	        this.constraintLogFileDirectory = constraintLogFileDirectory;
	    }

	    public String getConstraintLogFileDirectoryExport() {

	        return constraintLogFileDirectoryExport;
	    }

	    public void setConstraintLogFileDirectoryExport(String constraintLogFileDirectoryExport) {

	        this.constraintLogFileDirectoryExport = constraintLogFileDirectoryExport;
	    }

	    public String getModel3dThumbnail() {

	        return model3dThumbnail;
	    }

	    public void setModel3dThumbnail(String model3dThumbnail) {

	        this.model3dThumbnail = model3dThumbnail;
	    }

	    public String getModel2dThumbnail() {

	        return model2dThumbnail;
	    }

	    public void setModel2dThumbnail(String model2dThumbnail) {

	        this.model2dThumbnail = model2dThumbnail;
	    }

	    public String getDailyProgressReportDirectory() {

	        return dailyProgressReportDirectory;
	    }

	    public void setDailyProgressReportDirectory(String dailyProgressReportDirectory) {

	        this.dailyProgressReportDirectory = dailyProgressReportDirectory;
	    }

	    public String getDailyProgressReportDirectoryExport() {

	        return dailyProgressReportDirectoryExport;
	    }

	    public void setDailyProgressReportDirectoryExport(String dailyProgressReportDirectoryExport) {

	        this.dailyProgressReportDirectoryExport = dailyProgressReportDirectoryExport;
	    }

	    public String getRemoveMultipleRoleRelationshipMigration() {

	        return removeMultipleRoleRelationshipMigration;
	    }

	    public String getActivitiesOwnerAssignMigrationDirectory() {

	        return activitiesOwnerAssignMigrationDirectory;
	    }

	    public void setActivitiesOwnerAssignMigrationDirectory(
	            String activitiesOwnerAssignMigrationDirectory) {

	        this.activitiesOwnerAssignMigrationDirectory = activitiesOwnerAssignMigrationDirectory;
	    }

	    public void setRemoveMultipleRoleRelationshipMigration(
	            String removeMultipleRoleRelationshipMigration) {

	        this.removeMultipleRoleRelationshipMigration = removeMultipleRoleRelationshipMigration;
	    }

	    public String getUpdateHasChildrenMigration() {

	        return updateHasChildrenMigration;
	    }

	    public void setUpdateHasChildrenMigration(String updateHasChildrenMigration) {

	        this.updateHasChildrenMigration = updateHasChildrenMigration;
	    }

	    public String getUpdateActivityStatusMigration() {

	        return updateActivityStatusMigration;
	    }

	    public void setUpdateActivityStatusMigration(String updateActivityStatusMigration) {

	        this.updateActivityStatusMigration = updateActivityStatusMigration;
	    }

	    public String getCustomFieldAuditEvent() {

	        return customFieldAuditEvent;
	    }

	    public void setCustomFieldAuditEvent(String customFieldAuditEvent) {

	        this.customFieldAuditEvent = customFieldAuditEvent;
	    }

	    public String getLocatonFileDirectoryExport() {

	        return locatonFileDirectoryExport;
	    }

	    public void setLocatonFileDirectoryExport(String locatonFileDirectoryExport) {

	        this.locatonFileDirectoryExport = locatonFileDirectoryExport;
	    }

	    public String getLocationFirstImage() {

	        return locationFirstImage;
	    }

	    public void setLocationFirstImage(String locationFirstImage) {

	        this.locationFirstImage = locationFirstImage;
	    }

	    public String getModelMigrationDirectoryExport() {

	        return modelMigrationDirectoryExport;
	    }

	    public void setModelMigrationDirectoryExport(String modelMigrationDirectoryExport) {

	        this.modelMigrationDirectoryExport = modelMigrationDirectoryExport;
	    }

		public String getChecklistFileDirectory() {
			return checklistFileDirectory;
		}

		public void setChecklistFileDirectory(String checklistFileDirectory) {
			this.checklistFileDirectory = checklistFileDirectory;
		}

}
