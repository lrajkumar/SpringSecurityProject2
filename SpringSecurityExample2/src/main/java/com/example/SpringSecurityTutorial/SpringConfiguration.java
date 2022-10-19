package com.example.SpringSecurityTutorial;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AndRequestMatcher;


@EnableWebSecurity
public class SpringConfiguration extends WebSecurityConfigurerAdapter  {
       @Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
    	   auth.inMemoryAuthentication()
    	   .withUser("raj")
    	   .password("Strong")
    	   .roles("USER")
    	   .and()
    	   .withUser("santhosh")
    	   .password("MyPasswordIsStrong")
    	   .roles("ADMIN");
   
       }
       @Bean
       public PasswordEncoder getPasswordEncoder() {
    	   return NoOpPasswordEncoder.getInstance();
       }
	
       @Override
       protected void configure(HttpSecurity http) throws Exception {
    	   http.authorizeHttpRequests()
    	   .antMatchers("/").permitAll()
    	   .antMatchers("/**").hasAnyRole("ADMIN")
    	   .and().formLogin();
       }
       
       
}
