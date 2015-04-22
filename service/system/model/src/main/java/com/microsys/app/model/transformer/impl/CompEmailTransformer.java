package com.microsys.app.model.transformer.impl;

import com.microsys.app.common.customenum.CustCompEnum;
import com.microsys.app.common.customenum.EmailTypeEnum;
import com.microsys.app.common.customenum.RecordStatusEnum;
import com.microsys.app.common.exception.ApplicationException;
import com.microsys.app.model.dto.EmailDto;
import com.microsys.app.model.entity.MicCompany;
import com.microsys.app.model.entity.common.MicEmailComp;

public class CompEmailTransformer  extends BaseTransformer<EmailDto, MicEmailComp> {

	final MicCompany micComp;
	public CompEmailTransformer(MicCompany micComp) {
		this.micComp = micComp;
	}
	
	@Override
	public MicEmailComp syncToDomain(EmailDto dto, MicEmailComp domain) throws ApplicationException {
		domain.setEmailDetl(dto.getEmailDetl());
		domain.setEmailType(EmailTypeEnum.getEmailTypeByUiCode(dto.getEmailType()));
		domain.setType(CustCompEnum.Company);
		domain.setStatus(RecordStatusEnum.Active);
		domain.setCompany(this.micComp);
		return domain;
	}

	@Override
	public EmailDto syncToDto(MicEmailComp domain, EmailDto dto) throws ApplicationException {
		dto.setEmailDetl(domain.getEmailDetl());
		dto.setEmailType(domain.getEmailType().getUiCode());
		dto.setType(domain.getType());
		dto.setStatus(domain.getStatus().getUiCode());
		return dto;
	}

	@Override
	protected void preDomainDeletion(MicEmailComp domain) throws ApplicationException {
			domain.setCompany(null);
	}

	@Override
	public boolean similar(EmailDto dto, MicEmailComp domain) {
		return (dto.hashCode() == domain.hashCode());
	}

}
