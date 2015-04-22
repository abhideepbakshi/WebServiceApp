package com.microsys.app.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.microsys.app.model.dao.ICompanySearchDao;
import com.microsys.app.model.dao.framework.impl.GenericSearchDaoImpl;
import com.microsys.app.model.dto.search.CompanySearchCriteria;
import com.microsys.app.model.entity.MicCompany;

@Repository
public class CompanySearchDaoImpl extends GenericSearchDaoImpl<MicCompany> implements ICompanySearchDao {

	@Override
	public List<MicCompany> searchCriteria(CompanySearchCriteria searchCri) {

		final CriteriaBuilder cb = getCriteriaBuilder();
		final CriteriaQuery<MicCompany> createQuery = cb.createQuery(MicCompany.class);
		final Root<MicCompany> root = createQuery.from(MicCompany.class);
		final List<Predicate> pList = new ArrayList<Predicate>();
		pList.add(cb.equal(root.get("compName"), searchCri.getCompanyName()));
		pList.add(cb.equal(root.get("ownerName"), searchCri.getOwnerName()));
		pList.add(cb.equal(root.get("status"), searchCri.getStatus()));
		
		createQuery.where(cb.and(pList.toArray(new Predicate[0])));
		final TypedQuery<MicCompany> finalQuery = getEntityManager().createQuery(createQuery);
		return (List<MicCompany>)finalQuery.getResultList();
	}

	
}
