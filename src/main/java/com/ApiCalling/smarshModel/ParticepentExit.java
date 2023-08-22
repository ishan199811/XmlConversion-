package com.ApiCalling.smarshModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ApiCalling.iConnectionModel.RequestFileDump;




@Entity
public class ParticepentExit {
	
	public Long getParticipentExitId() {
		return participentExitId;
	}

	public void setParticipentExitId(Long participentExitId) {
		this.participentExitId = participentExitId;
	}

	

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long participentExitId;

	Date dateTimeUtc;
	
	Boolean internalFlag;
	
	String corporateEmailId ;
String conversionId;
	public Date getDateTimeUtc() {
	return dateTimeUtc;
}

public void setDateTimeUtc(Date dateTimeUtc) {
	this.dateTimeUtc = dateTimeUtc;
}

public Boolean getInternalFlag() {
	return internalFlag;
}

public void setInternalFlag(Boolean internalFlag) {
	this.internalFlag = internalFlag;
}

public String getCorporateEmailId() {
	return corporateEmailId;
}

public void setCorporateEmailId(String corporateEmailId) {
	this.corporateEmailId = corporateEmailId;
}

public String getConversionId() {
	return conversionId;
}

public void setConversionId(String conversionId) {
	this.conversionId = conversionId;
}

	String loginName;


}
