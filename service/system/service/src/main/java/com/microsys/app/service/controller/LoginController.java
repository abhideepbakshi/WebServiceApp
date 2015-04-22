package com.microsys.app.service.controller;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microsys.app.delegate.service.ILoginService;
import com.microsys.app.model.dto.LoginDto;

@Controller
public class LoginController {

	@Autowired
	private ILoginService loginService;
	
	@RequestMapping("/login")
	public String loginAction(Model model){
		
		final LoginDto login = new LoginDto();
		model.addAttribute("login", login);
		return "login";
	}
	
	@RequestMapping("/validateUser")
	public String validateLogin(Model model,@ModelAttribute("login") LoginDto login,BindingResult result){
	
		try{
			loginService.validateLogin(model, login, result);
			if(result.hasErrors()){
				return "login";
			}else{
				return "admin.dashboard";
			}
		} catch(ApplicationException e){
			
		}
		return "admin.error";
	}
}
