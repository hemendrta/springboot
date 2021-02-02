package com.employee.database.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(unique = true)
	private String registration;

	@NotBlank(message = "Company name should not be empty/blank.")
	@Size(min = 3, max = 50, message = "Company name should be between 3-50 characters.")
	private String name;

	@Column(unique = true)
	private String email;

	@Column(unique = true)
	private Long contact;

	private String role;
	private String logo;
	private boolean acceptTerms;

	@Override
	public String toString() {
		return "Company [id=" + id + ", registration=" + registration + ", name=" + name + ", email=" + email
				+ ", contact=" + contact + ", logo=" + logo + ", acceptTerms=" + acceptTerms + ", password=" + password
				+ ", employeesList=" + employeesList + "]";
	}

	private String password;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
	private List<Employee> employeesList = new ArrayList<Employee>();

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public boolean isAcceptTerms() {
		return acceptTerms;
	}

	public void setAcceptTerms(boolean acceptTerms) {
		this.acceptTerms = acceptTerms;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Employee> getEmployeesList() {
		return employeesList;
	}

	public void setEmployeesList(List<Employee> employeesList) {
		this.employeesList = employeesList;
	}

}
