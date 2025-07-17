package com.example.springsecurity.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

	List<Student> students=new ArrayList<>(
			Arrays.asList(
					new Student(1,"balaji","software"),
					new Student(1,"balaji","software")
					));
	
	@GetMapping("/students")
	public List<Student> getStudent(){
		return students;
	}	
	
	@PostMapping("/csrf-token")
	public CsrfToken getCsrfTOken(HttpServletRequest request)
	{
		return (CsrfToken) request.getAttribute("_csrf");
	}
	@PostMapping("/admin/students")
	public void addStudent(@RequestBody Student student) {
		students.add(student);
	}
}
