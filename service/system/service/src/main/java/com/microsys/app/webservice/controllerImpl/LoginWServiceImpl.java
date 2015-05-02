package com.microsys.app.webservice.controllerImpl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.microsys.app.common.exception.ApplicationException;
import com.microsys.app.delegate.service.ILoginService;
import com.microsys.app.model.dto.LoginDto;
import com.microsys.app.webservice.common.WebServiceNameSpace;
import com.microsys.app.webservice.controller.LoginWService;

@WebService(serviceName = "LoginService", endpointInterface = "com.microsys.app.webservice.controller.LoginWService", portName = "LoginWService", targetNamespace = WebServiceNameSpace.LoginWService)
public class LoginWServiceImpl implements LoginWService {

	@Autowired
	private ILoginService loginService;

	@Override
	@WebMethod(action = "Post", operationName = "validateLogin")
	public String validateLogin(@WebParam(name = "login") LoginDto loginDto) {

		try {
			loginService.validateLoginWs(loginDto);
		} catch (ApplicationException e) {

		}
		return "admin.error";
	}
	
	

}
