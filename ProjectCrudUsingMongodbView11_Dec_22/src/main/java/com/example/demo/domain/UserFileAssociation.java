package com.example.demo.domain;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.embeded.dto.UserFileMetaData;

import lombok.Data;

@Document
//@Data
public class UserFileAssociation {

	 @Id 
	 private String id;
	 private String userName;
	 public List<UserFileMetaData> files;
	 private boolean isUsed;
	 private DateTime createdAt;		
	 private DateTime updatedAt;
	public String getId() {
		return id;
	}
	public boolean isUsed() {
		return isUsed;
	}
	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
	public DateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}
	public DateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(DateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<UserFileMetaData> getFiles() {
		return files;
	}
	public void setFiles(List<UserFileMetaData> files) {
		this.files = files;
	}
	
}
