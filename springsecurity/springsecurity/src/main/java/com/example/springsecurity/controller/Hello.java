package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Hello {

	@GetMapping("/hello")
	public String hello() {
		return"Hello world";
	}
	
	/*@GetMapping("/")
	public String home() {
		return "Home page";
	}
	*/
	
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		return "Home page"+request.getSession().getId();
	}
	@GetMapping("/about")
	public String aboutus() {
		return "i am balaji";
	}
	
	@GetMapping("/public/demo")
	public String demo() {
		return"public page Demo code";
	}
}
