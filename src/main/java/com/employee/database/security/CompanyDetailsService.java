package com.employee.database.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.employee.database.entities.Company;
import com.employee.database.service.CompanyService;

public class CompanyDetailsService implements UserDetailsService {

	@Autowired
	private CompanyService companyService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		Company company = companyService.getCompany(username);
		System.out.println(company.getEmail());
		CustomCompanyDetails customCompanyDetails = new CustomCompanyDetails(company);

		return customCompanyDetails;
	}

}
