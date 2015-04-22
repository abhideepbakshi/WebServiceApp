package com.microsys.app.model.transformer.impl;

import com.microsys.app.common.customenum.CustCompEnum;
import com.microsys.app.common.customenum.EmailTypeEnum;
import com.microsys.app.common.customenum.RecordStatusEnum;
import com.microsys.app.common.exception.ApplicationException;
import com.microsys.app.model.dto.EmailDto;
import com.microsys.app.model.entity.MicCustomer;
import com.microsys.app.model.entity.common.MicEmailCust;

public class CustEmailTransformer extends BaseTransformer<EmailDto, MicEmailCust>  {

	private final MicCustomer micCust;
	public CustEmailTransformer(MicCustomer micCust) {
		this.micCust = micCust;
	}
	
	@Override
	public MicEmailCust syncToDomain(EmailDto dto, MicEmailCust domain) throws ApplicationException {
		domain.setEmailDetl(dto.getEmailDetl());
		domain.setEmailType(EmailTypeEnum.getEmailTypeByUiCode(dto.getEmailType()));
		domain.setType(CustCompEnum.Customer);
		domain.setStatus(RecordStatusEnum.Active);
		domain.setCustomer(this.micCust );
		return domain;
	}

	@Override
	public EmailDto syncToDto(MicEmailCust domain, EmailDto dto) throws ApplicationException {
		dto.setEmailDetl(domain.getEmailDetl());
		dto.setEmailType(domain.getEmailType().getUiCode());
		dto.setType(domain.getType());
		dto.setStatus(domain.getStatus().getUiCode());
		return dto;
	}

	@Override
	protected void preDomainDeletion(MicEmailCust domain) throws ApplicationException {
		// TODO Auto-generated method stub
		domain.setCustomer(null);
		
	}

	@Override
	public boolean similar(EmailDto dto, MicEmailCust domain) {
		return (dto.hashCode() == domain.hashCode());
	}

}
