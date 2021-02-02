package com.employee.database.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class CompanyConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {

		return new CompanyDetailsService();

	}

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {

		return new BCryptPasswordEncoder();

	}

	public DaoAuthenticationProvider daoAuthenticationProvider() {

		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(this.bCryptPasswordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.userDetailsService());
		return daoAuthenticationProvider;

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)  {
		// TODO Auto-generated method stub
		try {
			auth.authenticationProvider(this.daoAuthenticationProvider());
			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	protected void configure(HttpSecurity http) {
		// TODO Auto-generated method stub
		
		try {
		http.authorizeRequests().antMatchers("/company/index/**").hasRole("company").antMatchers("/**").permitAll().and()
				.formLogin().and().csrf().disable();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
