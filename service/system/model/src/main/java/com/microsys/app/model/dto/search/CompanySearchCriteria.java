package com.microsys.app.model.dto.search;

import com.microsys.app.common.customenum.RecordStatusEnum;

public class CompanySearchCriteria {

	private String companyName;
	private String ownerName;
	private RecordStatusEnum status;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public RecordStatusEnum getStatus() {
		return status;
	}

	public void setStatus(RecordStatusEnum status) {
		this.status = status;
	}

}
