package com.microsys.app.delegate.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.microsys.app.common.util.ValidationUtils;
import com.microsys.app.model.dto.LoginDto;

@Component
public class LoginValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		final LoginDto login = (LoginDto) target;
		
		if (!ValidationUtils.userName(login.getUserName())) {
			errors.reject("com.microsys.label.login.username.error");
		}
		
		if (!ValidationUtils.password(login.getPassword())) {
			errors.reject("com.microsys.label.login.password.error");
		}
	}

}
