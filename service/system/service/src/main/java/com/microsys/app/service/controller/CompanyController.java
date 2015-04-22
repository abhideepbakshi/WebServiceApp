package com.microsys.app.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microsys.app.common.exception.ApplicationException;
import com.microsys.app.delegate.service.ICompanyService;
import com.microsys.app.model.dto.company.CompanyDto;

@Controller
public class CompanyController {

	@Autowired
	private ICompanyService companyService;
	
	@RequestMapping("/addCompany")
	public String addCompany(Model model){
		
		try{
			CompanyDto addCompany = companyService.addCompany();
			model.addAttribute("CompanyMaster", addCompany);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "admin.addCompany";
	}
	
	@RequestMapping("/saveCompany")
	public String saveCompany(Model model, @ModelAttribute("CompanyMaster") CompanyDto companyDto, BindingResult result ){
		
		try {
			final List<CompanyDto> saveCompany = companyService.saveCompany(companyDto, result);
			model.addAttribute("CompanyMasterList", saveCompany);
			return "admin.viewCompany";
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		
		return "admin.error";
		
	}
	
}
