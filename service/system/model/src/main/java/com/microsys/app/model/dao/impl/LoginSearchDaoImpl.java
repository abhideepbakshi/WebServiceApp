package com.microsys.app.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.microsys.app.common.customenum.RecordStatusEnum;
import com.microsys.app.common.util.CollectionUtils;
import com.microsys.app.model.dao.ILoginSearchDao;
import com.microsys.app.model.dao.framework.impl.GenericSearchDaoImpl;
import com.microsys.app.model.dto.LoginDto;
import com.microsys.app.model.entity.MicLogin;

@Repository
public class LoginSearchDaoImpl extends GenericSearchDaoImpl<MicLogin> implements ILoginSearchDao {

	@Override
	public boolean validateLogin(LoginDto login) {
		
		final CriteriaBuilder cb = getCriteriaBuilder();
		final CriteriaQuery<MicLogin> createQuery = cb.createQuery(MicLogin.class);
		final Root<MicLogin> root = createQuery.from(MicLogin.class);
		final List<Predicate> pList = new ArrayList<Predicate>();
		pList.add(cb.equal(root.get("userName"), login.getUserName()));
		pList.add(cb.equal(root.get("password"), login.getUserName()));
		pList.add(cb.equal(root.get("status"), RecordStatusEnum.Active.getDbCode()));
		createQuery.where(cb.and(pList.toArray(new Predicate[0])));
		final TypedQuery<MicLogin> finalQuery = getEntityManager().createQuery(createQuery);
		List<MicLogin> resultList = finalQuery.getResultList();
		return CollectionUtils.isNotEmpty(resultList);
	}

	
}
