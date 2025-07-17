package com.example.springsecurity.cofiguration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	UserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		//1. csrf disable
		//same site strict
		//session- stateless
		//2. functional interface and lambda expression
		
		http.csrf(customizer -> customizer.disable());
        http.authorizeHttpRequests(request->request
        		
        		.requestMatchers("/admin/**").hasRole("ADMIN")
        		.requestMatchers("/user/**").hasAnyRole("ADMIN","USER")
        		.requestMatchers("/public/**").permitAll()
        		.anyRequest()
        		.authenticated())
      //formlogin is only for webpage not for postman
      //  http.formLogin(Customizer.withDefaults());
      //this is will applicable for  postman  
        .httpBasic(Customizer.withDefaults());
		//stateless with means session id will create in every request
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
	}
	
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
	
		DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
	//	provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	
	  @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
	/*working userdetails service code
	@Bean
	public UserDetailsService userDetailsService() {
		
		List<UserDetails> users=new ArrayList<>();
		UserDetails user1= User.withDefaultPasswordEncoder()
				.username("suba")
				.password("2404")
				.roles("USER")
				.build();
		
		UserDetails user2= User.withDefaultPasswordEncoder()
				.username("Dhanu")
				.password("2107")
				.roles("USER")
				.build();
		
		users.add(user1);
		users.add(user2);
		return new InMemoryUserDetailsManager(users);
		
		//return new InMemoryUserDetailsManager(user1,user2);//varags
	}
	 code end here*/
	
}
