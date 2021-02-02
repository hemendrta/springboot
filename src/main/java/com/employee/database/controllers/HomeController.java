package com.employee.database.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.employee.database.entities.Company;
import com.employee.database.repositories.CompanyRepository;
import com.employee.database.service.CompanyService;
import com.employee.database.utilities.Message;

@Controller
public class HomeController {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

//	hanlder for home page

	@GetMapping("/")
	public ModelAndView getHomePage() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;

	}

//	handler for displaying sign up page

	@GetMapping("/signup")
	public ModelAndView signUp() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("company", new Company());
		modelAndView.setViewName("signup");
		return modelAndView;

	}

//	handler for company registration

	@PostMapping("/companyregistration")
	public ModelAndView addCompany(@Valid @ModelAttribute("company") Company company,
			@RequestParam(value = "acceptTerms", defaultValue = "false") Boolean acceptTerms,
			BindingResult bindingResult) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("signup");

		company.setAcceptTerms(acceptTerms);
		company.setRole("ROLE_company");
		company.setPassword(bCryptPasswordEncoder.encode(company.getPassword()));

		try {

			if (!acceptTerms) {

				modelAndView.addObject("message", new Message("Please accept terms and conditions", "alert-danger"));

			} else {

				companyService.addCompany(company);
				modelAndView.addObject("message", new Message("Details added successfully!!!", "alert-success"));

			}

		} catch (Exception e) {
			modelAndView.addObject("message", new Message(e.getMessage(), "alert-danger"));
		}


		return modelAndView;
	}

}
