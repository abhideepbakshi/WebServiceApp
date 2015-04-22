package com.microsys.app.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

	@RequestMapping("/addProduct")
	public String addProduct(Model model){
		
		return "admin.addProduct";
	}
}
