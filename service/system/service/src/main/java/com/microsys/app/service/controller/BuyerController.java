package com.microsys.app.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BuyerController {

	@RequestMapping("/addBuyer")
	public String addBuyer(Model model){
		
		return "admin.addBuyer";
	}
}
