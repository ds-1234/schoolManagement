package com.project.school.management.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.request.LoginRequest;
import com.project.school.management.request.UserRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.UserService;

import lombok.extern.java.Log;

@RestController
@RequestMapping("user")
@Log
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/test")
	public String test() {
		return "welcome";
	}

	@PostMapping("createUser")
	public ResponseEntity<Response> saveUser(@RequestBody UserRequest userRequest) {
		log.info("******  API Start For save user******");
		Response response = new Response();
		response.succeed();
		response.setData(userService.saveUserDetail(userRequest));
		return ResponseEntity.ok().body(response);
	}

	@PostMapping("login")
	public ResponseEntity<Response> login(@RequestBody LoginRequest loginRequest) {
		log.info("******  API Start For login******");
		Response response = new Response();
		response.succeed();
		response.setData(userService.login(loginRequest));
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getUserList")
	public ResponseEntity<Object> getUserList() throws IOException {
		log.info("******  API Start For get student******");
		Response response = new Response();
		response.succeed();
		response.setData(userService.getUserList());
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getUser/{id}")
	public ResponseEntity<Object> getUser(@PathVariable Integer id) {
		log.info("******  API Start For get student by id******");
		Response response = new Response();
		response.succeed();
		response.setData(userService.getUser(id));
		return ResponseEntity.ok().body(response);

	}

}
