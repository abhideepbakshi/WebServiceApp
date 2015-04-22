package com.microsys.app.delegate.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.microsys.app.common.customenum.RecordStatusEnum;
import com.microsys.app.common.exception.ApplicationException;
import com.microsys.app.common.util.CollectionUtils;
import com.microsys.app.delegate.service.ICompanyService;
import com.microsys.app.model.dao.ICompanyDao;
import com.microsys.app.model.dao.ICompanySearchDao;
import com.microsys.app.model.dto.AddressDto;
import com.microsys.app.model.dto.EmailDto;
import com.microsys.app.model.dto.PhoneDto;
import com.microsys.app.model.dto.company.CompanyDto;
import com.microsys.app.model.dto.search.CompanySearchCriteria;
import com.microsys.app.model.entity.MicCompany;
import com.microsys.app.model.transformer.impl.CompanyTransformer;

@Service
public class CompanyServiceImpl implements ICompanyService{

	private CompanyTransformer trans = new CompanyTransformer();
	
	@Autowired
	private ICompanyDao compDao;
	
	@Autowired
	private ICompanySearchDao compSearchDao;
	
	@Override
	public CompanyDto addCompany() {
		CompanyDto companyDto = new CompanyDto();
		companyDto.setAddress(new AddressDto());
		companyDto.setPhone(new ArrayList<PhoneDto>(2));
		companyDto.setEmail(new ArrayList<EmailDto>(1));
		return companyDto;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<CompanyDto> updateCompany(CompanyDto company) throws ApplicationException {
		final CompanySearchCriteria compSearch = new CompanySearchCriteria();
		compSearch.setCompanyName(company.getCompName());
		compSearch.setOwnerName(company.getOwnerName());
		compSearch.setStatus(RecordStatusEnum.Active);
		MicCompany searchCriteria = CollectionUtils.first(compSearchDao.searchCriteria(compSearch));
		trans.syncToDomain(company, searchCriteria);
		compDao.save(searchCriteria);
		return searchCompany(company,null);
	}

	@Override
	public CompanyDto deleteCompany(CompanyDto company) {
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<CompanyDto> searchCompany(CompanyDto company, BindingResult result) throws ApplicationException {
		final CompanySearchCriteria compSearch = new CompanySearchCriteria();
		compSearch.setCompanyName(company.getCompName());
		compSearch.setOwnerName(company.getOwnerName());
		compSearch.setStatus(RecordStatusEnum.Active);
		List<MicCompany> searchCriteria = compSearchDao.searchCriteria(compSearch);
		return (List<CompanyDto>) trans.syncToDto(searchCriteria, new ArrayList<CompanyDto>());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<CompanyDto> saveCompany(CompanyDto company, BindingResult result) throws ApplicationException {
		MicCompany micCompany = new MicCompany();
		trans.syncToDomain(company, micCompany);
		compDao.save(micCompany);
		return null;//searchCompany(company,result);
	}


	
	
	
}
