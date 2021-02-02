package com.employee.database.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/company")
public class CompanyController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView companyDashboard() {
		System.out.println("Control here!!!");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/company/company_dashboard");
		return modelAndView;

	}
	
	@ExceptionHandler
	public void handlerExceptions(Exception exception) {
		
		System.out.println(exception.getMessage());
	}

}
