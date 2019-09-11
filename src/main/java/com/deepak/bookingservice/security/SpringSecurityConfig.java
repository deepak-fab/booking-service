package com.deepak.bookingservice.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER")
				.and().withUser("admin").password("{noop}root").roles("USER","ADMIN");

	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()      
                .antMatchers(HttpMethod.GET, "/bookHistory").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.POST, "/booking").permitAll()  
                .anyRequest().authenticated().and()
                .csrf().disable()
                .formLogin().disable();;
    }
}
