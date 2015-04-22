package com.microsys.app.delegate.service;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.microsys.app.common.exception.ApplicationException;
import com.microsys.app.model.dto.company.CompanyDto;

public interface ICompanyService {

	public CompanyDto addCompany() throws ApplicationException ;
	public List<CompanyDto> updateCompany(CompanyDto company) throws ApplicationException ;
	public CompanyDto deleteCompany(CompanyDto company) throws ApplicationException ;
	public List<CompanyDto> searchCompany(CompanyDto company, BindingResult result) throws ApplicationException ;
	public List<CompanyDto> saveCompany(CompanyDto company, BindingResult result) throws ApplicationException ;
	
}


