package com.example.demo.domain;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Contact {
	 @Id
	 private int id;
	 private String userName;
	 private String phoneNumber;
	 
	public Contact(int id, String userName, String phoneNumber) {
		super();
		this.id = id;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
	}

	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	    
}
