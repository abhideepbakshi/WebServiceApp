package com.microsys.app.model.transformer.impl;

import com.microsys.app.common.customenum.CustCompEnum;
import com.microsys.app.common.customenum.PhoneTypeEnum;
import com.microsys.app.common.customenum.RecordStatusEnum;
import com.microsys.app.common.exception.ApplicationException;
import com.microsys.app.model.dto.PhoneDto;
import com.microsys.app.model.entity.MicCustomer;
import com.microsys.app.model.entity.common.MicPhoneCust;

public class CustPhoneTransformer extends BaseTransformer<PhoneDto, MicPhoneCust>{

	private final MicCustomer micCust;
	public CustPhoneTransformer(MicCustomer micCust) {
		this.micCust = micCust;
	}
	@Override
	public MicPhoneCust syncToDomain(PhoneDto dto, MicPhoneCust domain) throws ApplicationException {
		domain.setPhoneNo(dto.getPhoneNo());
		domain.setPhoneType(PhoneTypeEnum.getPhoneTypeByUiCode(dto.getPhoneType()));
		domain.setType(CustCompEnum.Customer);
		domain.setStatus(RecordStatusEnum.Active);
		domain.setCustomerPhone(this.micCust);
		return domain;
	}

	@Override
	public PhoneDto syncToDto(MicPhoneCust domain, PhoneDto dto) throws ApplicationException {
		dto.setPhoneNo(domain.getPhoneNo());
		dto.setPhoneType(domain.getPhoneType().getUiCode());
		dto.setType(domain.getType());
		dto.setStatus(RecordStatusEnum.Active.getUiCode());
		return dto;
	}

	@Override
	protected void preDomainDeletion(MicPhoneCust domain) throws ApplicationException {
		domain.setCustomerPhone(null);
		
	}

	@Override
	public boolean similar(PhoneDto dto, MicPhoneCust domain) {
		return (dto.hashCode() == domain.hashCode());
	}

}
