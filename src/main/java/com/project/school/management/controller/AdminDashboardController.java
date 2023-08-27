package com.project.school.management.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.entity.RoleEntity;
import com.project.school.management.service.AdminDashService;

@RestController
@RequestMapping("/admin")
public class AdminDashboardController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminDashboardController.class);
	
	@Autowired
	private AdminDashService adminDashService;
	
	@GetMapping("/getStudentToAdmin")
	public ResponseEntity<Object> getStudent(String role) throws IOException{
		log.info("******API Start For get student for admin******");
				return adminDashService.getStudent(role);	
	}
	
	@GetMapping("/getBoysAndGirlsToAdmin")
	public ResponseEntity<Object> getBoysAndGirls(String role) throws IOException{
		log.info("******API Start For get student for admin******");
				return adminDashService.getBoysAndGirls(role);	
	}

}
