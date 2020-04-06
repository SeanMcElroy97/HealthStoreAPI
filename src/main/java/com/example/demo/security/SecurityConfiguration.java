package com.example.demo.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailsService;

	//Authentication method
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		//No out of the box for JPA authentication
	}

	
	//Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//ADMIN can access customer methods
		http.authorizeRequests()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/user").hasAnyRole("ADMIN", "CUSTOMER")
			.antMatchers("/").permitAll()
			.and().formLogin();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance();}

	
}
