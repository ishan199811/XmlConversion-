package com.ApiCalling.smarshModel;





import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ApiCalling.iConnectionModel.RequestFileDump;

@Entity
public class ParticepentEntered {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long participentEnterId;

String corporateId ;

String loginName;

Date dateTimeUtc;

boolean internalFlag;

String conversionId;

String corporateEmailid;

	public Long getParticipentEnterId() {
		return participentEnterId;
	}

	public void setParticipentEnterId(Long participentEnterId) {
		this.participentEnterId = participentEnterId;
	}

	public String getCorporateId() {
		return corporateId;
	}

	public void setCorporateId(String corporateId) {
		this.corporateId = corporateId;
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

public void setDateTimeUtc(java.util.Date date) {
	this.dateTimeUtc = date;
}

public boolean isInternalFlag() {
	return internalFlag;
}

public void setInternalFlag(boolean internalFlag) {
	this.internalFlag = internalFlag;
}

public String getConversionId() {
	return conversionId;
}

public void setConversionId(String conversionId) {
	this.conversionId = conversionId;
}

public String getCorporateEmailid() {
	return corporateEmailid;
}

public void setCorporateEmailid(String corporateEmailid) {
	this.corporateEmailid = corporateEmailid;
}
	

	
	

}
