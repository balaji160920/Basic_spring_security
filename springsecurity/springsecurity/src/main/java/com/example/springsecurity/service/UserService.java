package com.example.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springsecurity.model.Users;
import com.example.springsecurity.repository.UserDetailsRepo;

@Service
public class UserService {
	
	//@Autowired
	//BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder(12);
	
	  @Autowired
	    private PasswordEncoder passwordEncoder;
	@Autowired
	UserDetailsRepo repo;

	public void addUser(Users user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		repo.save(user);
	}

	

}
