package com.microsys.app.model.transformer.impl;

import com.microsys.app.common.customenum.CustCompEnum;
import com.microsys.app.common.customenum.PhoneTypeEnum;
import com.microsys.app.common.customenum.RecordStatusEnum;
import com.microsys.app.common.exception.ApplicationException;
import com.microsys.app.model.dto.PhoneDto;
import com.microsys.app.model.entity.MicCompany;
import com.microsys.app.model.entity.common.MicPhoneComp;

public class CompPhoneTransformer extends BaseTransformer<PhoneDto, MicPhoneComp> {

	final MicCompany micComp;
	public CompPhoneTransformer(MicCompany micComp) {
		this.micComp = micComp;
	}
	
	@Override
	public MicPhoneComp syncToDomain(PhoneDto dto, MicPhoneComp domain) throws ApplicationException {
		domain.setPhoneNo(dto.getPhoneNo());
		domain.setPhoneType(PhoneTypeEnum.getPhoneTypeByUiCode(dto.getPhoneType()));
		domain.setType(CustCompEnum.Company);
		domain.setStatus(RecordStatusEnum.Active);
		domain.setCompanyPhone(this.micComp);
		return domain;
	}

	@Override
	public PhoneDto syncToDto(MicPhoneComp domain, PhoneDto dto) throws ApplicationException {
		dto.setPhoneNo(domain.getPhoneNo());
		dto.setPhoneType(domain.getPhoneType().getUiCode());
		dto.setType(domain.getType());
		dto.setStatus(RecordStatusEnum.Active.getUiCode());
		return dto;
	}

	@Override
	protected void preDomainDeletion(MicPhoneComp domain) throws ApplicationException {
			domain.setCompanyPhone(null);
	}

	@Override
	public boolean similar(PhoneDto dto, MicPhoneComp domain) {
		return (dto.hashCode() == domain.hashCode());
	}

}
