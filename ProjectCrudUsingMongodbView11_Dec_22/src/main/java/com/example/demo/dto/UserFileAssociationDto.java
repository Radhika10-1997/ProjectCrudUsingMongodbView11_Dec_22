package com.example.demo.dto;

import java.util.List;

import lombok.Data;

public class UserFileAssociationDto {

	public String globalId;

	public List<String> addedFiles;

	public List<String> removedFiles;
	
	public String getGlobalId() {
		return globalId;
	}

	public void setGlobalId(String globalId) {
		this.globalId = globalId;
	}

	public List<String> getAddedFiles() {
		return addedFiles;
	}

	public void setAddedFiles(List<String> addedFiles) {
		this.addedFiles = addedFiles;
	}

	public List<String> getRemovedFiles() {
		return removedFiles;
	}

	public void setRemovedFiles(List<String> removedFiles) {
		this.removedFiles = removedFiles;
	}
	
}
