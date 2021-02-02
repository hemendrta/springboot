package com.employee.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.database.entities.Company;
import com.employee.database.repositories.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	public boolean addCompany(Company company) {

		boolean status = false;

		if ((companyRepository.findByRegistrationIgnoreCase(company.getRegistration()) == null)
				&& (companyRepository.findByEmailIgnoreCase(company.getEmail()) == null)
				&& (companyRepository.findByContact(company.getContact()) == null)) {

			companyRepository.save(company);
			status = true;
		}

		return status;

	}

	public Company getCompany(String email) {

		Company company;
		company = companyRepository.findByEmailIgnoreCase(email);
		return company;

	}

}
