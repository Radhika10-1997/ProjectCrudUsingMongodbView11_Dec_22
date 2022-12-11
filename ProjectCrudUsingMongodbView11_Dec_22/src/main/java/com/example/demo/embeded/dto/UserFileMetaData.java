package com.example.demo.embeded.dto;

import org.joda.time.DateTime;

import com.example.demo.enums.UserAttachmentEnum;

import lombok.Data;

public class UserFileMetaData {
	
    private String fileName;
	
    private String internalFileName;
	
    private String fileUrl;
	
    private String mimeType;
	
    private long fileSize;
	
    private String userName;
	
    private DateTime uploadTime; 
	
    private UserAttachmentEnum userAttachmentEnum;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getInternalFileName() {
		return internalFileName;
	}

	public void setInternalFileName(String internalFileName) {
		this.internalFileName = internalFileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public DateTime getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(DateTime uploadTime) {
		this.uploadTime = uploadTime;
	}

	public UserAttachmentEnum getUserAttachmentEnum() {
		return userAttachmentEnum;
	}

	public void setUserAttachmentEnum(UserAttachmentEnum userAttachmentEnum) {
		this.userAttachmentEnum = userAttachmentEnum;
	}
    
}
