package com.shrinkme.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class EmployeeConfiguration extends WebSecurityConfigurerAdapter {

	/*
	 * WebSecurityConfigurerAdapter : One can override AuthenticationManager to get hold of users and role for authentication.
	 */
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		System.out.println("Encoded password : "+ encoder.encode("password"));
		auth.inMemoryAuthentication().withUser("user").password(encoder.encode("password")).roles("USER").and()
				.withUser("admin").password(encoder.encode("admin")).roles("USER", "ADMIN");
	}
	
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and()
//				.withUser("admin").password("admin").roles("USER", "ADMIN");
//	}

	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
//
//	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/v1/admin").hasRole("ADMIN")  //antMatcher -> most restricted first.
		.antMatchers("/v1/user").hasAnyRole("USER", "ADMIN")
		.antMatchers("/v1").permitAll()
		.and().httpBasic(); // RESTApi
//		.and().formLogin(); // when we have web pages.
	}
}