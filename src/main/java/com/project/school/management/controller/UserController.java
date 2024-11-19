package com.project.school.management.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.request.AcademicDetailsRequest;
import com.project.school.management.request.HostelDetailsRequest;
import com.project.school.management.request.LoginRequest;
import com.project.school.management.request.OfficeDetailsRequest;
import com.project.school.management.request.PreviousSchoolDetailsRequest;
import com.project.school.management.request.StudentBasicDetailsRequest;
import com.project.school.management.request.StudentPromotionRequest;
import com.project.school.management.request.TransportDetailsRequest;
import com.project.school.management.request.UserRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/test")
	public String test() {
		return "welcome";
	}

	@PostMapping("createUser")
	public ResponseEntity<Response> saveUser(@RequestBody UserRequest userRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(userService.saveUserDetail(userRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("updateUser")
	public ResponseEntity<Response> updateUser(@RequestBody UserRequest userRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(userService.updateUser(userRequest));
		return ResponseEntity.ok().body(response);
	}

	@PostMapping("login")
	public ResponseEntity<Response> login(@RequestBody LoginRequest loginRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(userService.login(loginRequest));
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getUserList")
	public ResponseEntity<Object> getUserList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(userService.getUserList());
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getUser/{id}")
	public ResponseEntity<Object> getUser(@PathVariable Integer id) {
		Response response = new Response();
		response.succeed();
		response.setData(userService.getUser(id));
		return ResponseEntity.ok().body(response);

	}
	
	@PostMapping("addStudentBasicDetails")
	public ResponseEntity<Response> addStudentBasicDetails(@RequestBody StudentBasicDetailsRequest basicDetailsRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(userService.addStudentBasicDetails(basicDetailsRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("updateAcademicDetails")
	public ResponseEntity<Response> updateAcademicDetails(@RequestBody AcademicDetailsRequest academicDetailsRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(userService.updateAcademicDetails(academicDetailsRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("updateOfficeDetails")
	public ResponseEntity<Response> updateOfficeDetails(@RequestBody OfficeDetailsRequest officeDetailsRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(userService.updateOfficeDetails(officeDetailsRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("updateTransportDetails")
	public ResponseEntity<Response> updateTransportDetails(@RequestBody TransportDetailsRequest transportDetailsRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(userService.updateTransportDetails(transportDetailsRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("updateHostelDetails")
	public ResponseEntity<Response> updateHostelDetails(@RequestBody HostelDetailsRequest hostelDetailsRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(userService.updateHostelDetails(hostelDetailsRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("updatePreSchoolDetails")
	public ResponseEntity<Response> updatePreSchoolDetails(@RequestBody PreviousSchoolDetailsRequest previousSchoolDetailsRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(userService.updatePreSchoolDetails(previousSchoolDetailsRequest));
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getStudentDetails/{userId}")
	public ResponseEntity<Response> getStudentDetails(@PathVariable String userId) {
		Response response = new Response();
		response.succeed();
		response.setData(userService.getStudentDetails(userId));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("studentPromotion")
	public ResponseEntity<Response> updateStudentPromotion(@RequestBody StudentPromotionRequest studentPromotionRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(userService.updateStudentPromotion(studentPromotionRequest));
		return ResponseEntity.ok().body(response);
	}
}
