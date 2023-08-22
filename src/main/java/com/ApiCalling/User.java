package com.ApiCalling;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@Entity

@XmlRootElement(name = "User")  
@XmlType( propOrder = {  "id" , "title", "body", "userId" }) 
public class User {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	Long id;

	
	String title;
	
	
	String body;
	

	int userId;
	
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
