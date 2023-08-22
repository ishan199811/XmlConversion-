package com.ApiCalling.model;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "User")  
@XmlType( propOrder = {  "id" , "title", "body", "userId" , "role"}) 
public class User {
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	Long id;

	
	String title;
	
	
	String body;
	

	int userId;
	
	Role role;
	
	@XmlElement(name = "Id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		id = id;
	}
	@XmlElement(name = "Title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@XmlElement(name = "Body")
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	@XmlElement(name = "UserId")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
