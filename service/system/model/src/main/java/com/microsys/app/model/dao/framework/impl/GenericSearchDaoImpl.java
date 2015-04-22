package com.microsys.app.model.dao.framework.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

import com.microsys.app.model.dao.framework.IIdentityObject;
import com.microsys.app.model.dao.framework.ISearchDao;

public abstract class GenericSearchDaoImpl<E extends IIdentityObject<?>> implements ISearchDao<E> {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	protected CriteriaBuilder getCriteriaBuilder(){
		return entityManager.getCriteriaBuilder();
	}

	public <E> E find(long id, Class<? extends E> clazz){
		return entityManager.find(clazz, id);
	}
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
}
