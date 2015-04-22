package com.microsys.app.model.dao;

import com.microsys.app.model.dao.framework.ISearchDao;
import com.microsys.app.model.dto.LoginDto;
import com.microsys.app.model.entity.MicLogin;

public interface ILoginSearchDao extends ISearchDao<MicLogin> {

	public boolean validateLogin(LoginDto login);
	
}
