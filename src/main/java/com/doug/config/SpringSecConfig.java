package com.doug.config;

import org.jasypt.springsecurity3.authentication.encoding.PasswordEncoder;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import java.util.List;

/**
 * Created by Doug on 10/30/16.
 */
@Configuration
public class SpringSecConfig extends WebSecurityConfigurerAdapter{

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/").permitAll();
//	}

	private AuthenticationProvider authenticationProvider;

	@Autowired
	@Qualifier("daoAuthenticationProvider")
	public void setAuthenticationProvider(AuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	}




	@Bean
	public PasswordEncoder passwordEncoder(StrongPasswordEncryptor passwordEncryptor){
		PasswordEncoder passwordEncoder = new PasswordEncoder();
		passwordEncoder.setPasswordEncryptor(passwordEncryptor);
		return passwordEncoder;
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider(PasswordEncoder passwordEncoder,
																				  UserDetailsService userDetailsService){

		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		return daoAuthenticationProvider;
	}

	@Autowired
	public void configureAuthManager(AuthenticationManagerBuilder authenticationManagerBuilder){
		authenticationManagerBuilder.authenticationProvider(authenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.formLogin().loginPage("/login").permitAll()
				  .and().authorizeRequests().antMatchers("/journal/new").permitAll()
//				  .and().authorizeRequests().antMatchers("/journal/paging").hasAnyAuthority("ADMIN")
				  .and().exceptionHandling().accessDeniedPage("/access_denied");

				  //.and().authorizeRequests().antMatchers("/journal/list").hasAnyAuthority("ADMIN")

//		http.csrf().ignoringAntMatchers("/h2-console").disable()
//				  http.authorizeRequests().antMatchers("/**/favicon.ico") .permitAll()
//				  http.authorizeRequests().antMatchers("/journals").permitAll()
//				  .and().authorizeRequests().antMatchers("/static/**").permitAll()
//				  .and().formLogin().loginPage("/login").permitAll()
//				  .and().authorizeRequests().antMatchers("/fragments/**").authenticated()
//				  .and().authorizeRequests().antMatchers("/secured").hasAnyAuthority("ADMIN")
//				  .and().exceptionHandling().accessDeniedPage("/access_denied");


	}

}
