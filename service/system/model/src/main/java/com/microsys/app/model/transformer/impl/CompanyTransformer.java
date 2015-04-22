package com.microsys.app.model.transformer.impl;

import java.util.ArrayList;
import java.util.List;

import com.microsys.app.common.customenum.CustCompEnum;
import com.microsys.app.common.customenum.RecordStatusEnum;
import com.microsys.app.common.exception.ApplicationException;
import com.microsys.app.common.util.StringUtils;
import com.microsys.app.model.dto.AddressDto;
import com.microsys.app.model.dto.EmailDto;
import com.microsys.app.model.dto.PhoneDto;
import com.microsys.app.model.dto.company.CompanyDto;
import com.microsys.app.model.entity.MicAddress;
import com.microsys.app.model.entity.MicCompany;
import com.microsys.app.model.entity.common.MicEmailComp;
import com.microsys.app.model.entity.common.MicPhoneComp;

public class CompanyTransformer extends BaseTransformer<CompanyDto, MicCompany> {

	private AddressTransformer addrTrans = new AddressTransformer();
	
	
	
	@Override
	public MicCompany syncToDomain(CompanyDto dto, MicCompany domain) throws ApplicationException {
		final CompPhoneTransformer phoneTrans = new CompPhoneTransformer(domain);
		final CompEmailTransformer emailTrans = new CompEmailTransformer(domain);
		domain.setCompName(dto.getCompName());
		domain.setContPerson(dto.getContPerson());
		domain.setInvFormat(dto.getInvFormat());
		domain.setOwnerName(dto.getOwnerName());
		final MicAddress micAddress = new MicAddress();
		addrTrans.syncToDomain(dto.getAddress(), micAddress);
		domain.setMicAddress(micAddress);
		micAddress.setCompany(domain);
		
		final List<MicPhoneComp> micPhoneComp = new ArrayList<MicPhoneComp>(2);
		phoneTrans.syncToDomain(dto.getPhone(), micPhoneComp);
		domain.setCompPhone(micPhoneComp);
		
		final List<MicEmailComp> micEmailComp = new ArrayList<MicEmailComp>(2);
		emailTrans.syncToDomain(dto.getEmail(), micEmailComp);
		domain.setCompEmail(micEmailComp);
		domain.setStatus(RecordStatusEnum.Active);
		return domain;
	}

	@Override
	public CompanyDto syncToDto(MicCompany domain, CompanyDto dto) throws ApplicationException {
		final CompPhoneTransformer phoneTrans = new CompPhoneTransformer(domain);
		final CompEmailTransformer emailTrans = new CompEmailTransformer(domain);
		dto.setCompName(domain.getCompName());
		dto.setContPerson(domain.getContPerson());
		dto.setInvFormat(domain.getInvFormat());
		dto.setOwnerName(domain.getOwnerName());
		final AddressDto addressDto = new AddressDto();
		addrTrans.syncToDto(domain.getMicAddress(), addressDto);
		addressDto.setType(CustCompEnum.Company);
		dto.setAddress(addressDto);
		final List<PhoneDto> phones = new ArrayList<PhoneDto>();
		phoneTrans.syncToDto(domain.getCompPhone(), phones);
		dto.setPhone(phones);
		
		final List<EmailDto> emails = new ArrayList<EmailDto>();
		emailTrans.syncToDto(domain.getCompEmail(), emails);
		dto.setEmail(emails);
		
		return dto;
	}

	@Override
	protected void preDomainDeletion(MicCompany domain) throws ApplicationException {
		domain.setCompEmail(null);
		domain.setCompPhone(null);
		domain.setMicAddress(null);
	}

	@Override
	public boolean similar(CompanyDto dto, MicCompany domain) {
		return StringUtils.getHashCode(dto.getCompName())+StringUtils.getHashCode(dto.getOwnerName()) == StringUtils.getHashCode(domain.getCompName()) + StringUtils.getHashCode(domain.getOwnerName());
	}

}
