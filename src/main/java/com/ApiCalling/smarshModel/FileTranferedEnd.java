package com.ApiCalling.smarshModel;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FileTranferedEnd {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileTransferEndId;
	
	String loginName;
	
	Date dateTimeUtc;
	
	String userFileName;
	
	String fileName;
	
	String status;
	 
	public String getCorporateEmailId() {
		return corporateEmailId;
	}

	public void setCorporateEmailId(String corporateEmailId) {
		this.corporateEmailId = corporateEmailId;
	}


	
	String corporateEmailId;

	public Long getFileTransferEndId() {
		return fileTransferEndId;
	}

	public void setFileTransferEndId(Long fileTransferEndId) {
		this.fileTransferEndId = fileTransferEndId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	

	

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	

}
