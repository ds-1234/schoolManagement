package com.project.school.management.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.entity.StudentEntity;
import com.project.school.management.request.AddStudentRequest;
import com.project.school.management.request.LoginRequest;
import com.project.school.management.request.UserRequest;
import com.project.school.management.service.UserService;

import jakarta.websocket.server.PathParam;

@RestController
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/test")
	public String test(){
				return "welcome";	
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<Object> saveUser(@RequestBody UserRequest userRequest) throws IOException{
		log.info("******  API Start For save user******");
				return userService.saveUserDetail(userRequest);	
	}
	
	@GetMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) throws IOException{
		log.info("******  API Start For get user******");
				return userService.login(loginRequest);	
	}
	
	@PostMapping("/saveStudent")
	public ResponseEntity<Object> saveStudent(@RequestBody AddStudentRequest studentRequest) throws IOException{
		log.info("******  API Start For save student******");
				return userService.saveStudentDetail(studentRequest);	
	}
	
	@GetMapping("/getStudent")
	public ResponseEntity<Object> getStudent() throws IOException{
		log.info("******  API Start For get student******");
				return userService.getStudent();	
	}
	
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Object> getStudentById(@PathVariable Integer id) throws IOException{
		log.info("******  API Start For get student by id******");
				return userService.getStudent(id);	
	}

}
