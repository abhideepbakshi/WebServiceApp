package com.microsys.app.model.dao.impl;

import org.springframework.stereotype.Repository;

import com.microsys.app.model.dao.ICompanyDao;
import com.microsys.app.model.dao.framework.impl.GenericDaoImpl;
import com.microsys.app.model.entity.MicCompany;

@Repository
public class CompanyDaoImpl extends GenericDaoImpl<MicCompany> implements ICompanyDao {

	@Override
	protected String getEntityName() {
		return MicCompany.class.getName();
	}

	
}
