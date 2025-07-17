package com.example.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.model.Users;
import com.example.springsecurity.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping("/admin/add-user")
	public void addUser(@RequestBody Users user) {
		service.addUser(user);
	}
}
