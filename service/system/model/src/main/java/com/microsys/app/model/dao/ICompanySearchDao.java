package com.microsys.app.model.dao;

import java.util.List;

import com.microsys.app.model.dao.framework.ISearchDao;
import com.microsys.app.model.dto.search.CompanySearchCriteria;
import com.microsys.app.model.entity.MicCompany;

public interface ICompanySearchDao extends ISearchDao<MicCompany> {

	public List<MicCompany> searchCriteria(CompanySearchCriteria searchCri);
	
}
