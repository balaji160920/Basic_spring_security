package com.example.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springsecurity.model.UserPrincipal;
import com.example.springsecurity.model.Users;
import com.example.springsecurity.repository.UserDetailsRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserDetailsRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	
		Users user= repo.getByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new UserPrincipal(user);
	}

}
