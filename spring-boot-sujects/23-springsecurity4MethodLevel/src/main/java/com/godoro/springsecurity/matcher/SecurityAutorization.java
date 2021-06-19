package com.godoro.springsecurity.matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityAutorization extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http
		    	.authorizeRequests()
		    	.antMatchers("/", "home").permitAll() //herkes
		    	.antMatchers("/low").hasRole("USER") // sadece userlar
		    	.antMatchers("/high").hasRole("ADMIN") // sadece adminler
				.anyRequest()
				.authenticated() 
				.and()
			.formLogin()
				.and()
		    .httpBasic();

	}
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//kendimize giris saglatacak bir kullanici tanimladik
		auth
				.inMemoryAuthentication()
				.withUser("mucahit") // hem user hem admin yetkisine sahip
				.password("{noop}java")
				.roles("USER","ADMIN")
				.and()
			.withUser("yusuf") // sadece user yetkisine sahip
				.password("{noop}spring")
				.roles("USER");
	}
	
}
