package com.microsys.app.delegate.service;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.microsys.app.model.dto.LoginDto;

public interface ILoginService {

	void validateLogin(Model model,LoginDto login,BindingResult result) throws ApplicationException;
	void logout() throws ApplicationException;
	
}
