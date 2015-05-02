package com.microsys.app.delegate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.microsys.app.common.exception.ApplicationException;
import com.microsys.app.delegate.service.ILoginService;
import com.microsys.app.delegate.validator.LoginValidation;
import com.microsys.app.model.dao.ILoginSearchDao;
import com.microsys.app.model.dto.LoginDto;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private LoginValidation loginValidation;

	@Autowired
	private ILoginSearchDao loginSearch;

	@Override
	public void validateLogin(Model model, LoginDto login, BindingResult result) throws ApplicationException {

		loginValidation.validate(login, result);
		if (result.hasErrors()) {
			return;
		} else {
			if (!checkCredential(login)) {
				result.reject("com.microsys.label.login.error");
			}
		}

	}
	
	@Override
	public boolean validateLoginWs(LoginDto login) throws ApplicationException{
		if (!checkCredential(login)) {
			return true;
		}else{
			return false;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private boolean checkCredential(LoginDto login) {
		return loginSearch.validateLogin(login);
	}

	@Override
	public void logout() throws ApplicationException {
		// TODO Auto-generated method stub

	}

}
