package com.microsys.app.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.microsys.app.common.exception.ApplicationException;
import com.microsys.app.delegate.service.ICompanyService;
import com.microsys.app.model.dto.company.CompanyDto;
import com.microsys.app.service.test.fixture.CompanyFixture;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
@TransactionConfiguration(defaultRollback=false)
public class CompanyServiceTest {

	@Autowired
	private ICompanyService compService;
	
	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveCompany() throws ApplicationException{
		
		CompanyDto createCompany = CompanyFixture.createCompany();
		compService.saveCompany(createCompany, null);
		
		
	}
	
}
