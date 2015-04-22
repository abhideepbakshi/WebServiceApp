package com.microsys.app.model.dao.impl;

import org.springframework.stereotype.Repository;

import com.microsys.app.model.dao.ILoginDao;
import com.microsys.app.model.dao.framework.impl.GenericDaoImpl;
import com.microsys.app.model.entity.MicLogin;

@Repository
public class LoginDaoImpl extends GenericDaoImpl<MicLogin> implements ILoginDao {

	@Override
	protected String getEntityName() {
		return MicLogin.class.getName();
	}
}
