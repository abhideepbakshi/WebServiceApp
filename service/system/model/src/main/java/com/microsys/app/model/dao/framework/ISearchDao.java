package com.microsys.app.model.dao.framework;


public interface ISearchDao<E extends IIdentityObject<?>> {

	<T> T find(long id, Class<? extends T> clazz);
	
}
