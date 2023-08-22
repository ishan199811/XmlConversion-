package com.ApiCalling.smarshModel;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class FileTransferedStarted {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileTranferedId;
	 
	String loginName;
	
	Date dateTimeUtc;
	
	String userFileName;
	
	String fileName;
	
	
	
	

	public Date getDateTimeUtc() {
		return dateTimeUtc;
	}

	public void setDateTimeUtc(Date dateTimeUtc) {
		this.dateTimeUtc = dateTimeUtc;
	}

	public String getUserFileName() {
		return userFileName;
	}

	public void setUserFileName(String userFileName) {
		this.userFileName = userFileName;
	}

	
	
	
	public Long getFileTranferedId() {
		return fileTranferedId;
	}

	public void setFileTranferedId(Long fileTranferedId) {
		this.fileTranferedId = fileTranferedId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	

}
