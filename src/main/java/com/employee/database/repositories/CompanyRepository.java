package com.employee.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.database.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
	public Company findByRegistrationIgnoreCase(String registration);
	
	public Company findByEmailIgnoreCase(String email);
	
	public Company findByContact(Long contact);

}
