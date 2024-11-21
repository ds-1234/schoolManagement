package com.project.school.management.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.response.Response;
import com.project.school.management.service.AdminDashboardService;

@CrossOrigin
@RestController
@RequestMapping("adminDashboard")
public class AdminDashboardController {
	
	@Autowired
	private AdminDashboardService adminDashboardService;
	
	@GetMapping("getCount")
	public ResponseEntity<Object> getCount() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(adminDashboardService.getCount());
		return ResponseEntity.ok().body(response);
	}
	

}
