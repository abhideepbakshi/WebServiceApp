package com.microsys.app.webservice.controller;

import javax.jws.WebService;

import com.microsys.app.model.dto.LoginDto;


@WebService
public interface LoginWService {
	
	public String validateLogin(LoginDto loginDto);
}
