package com.project.school.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.request.ExamScheduleRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.ExamService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("exam")
public class ExamController {
	
	@Autowired
	private ExamService examService;
	
	@Valid
	@PostMapping("saveExam")
	public ResponseEntity<Response> saveExam(@RequestBody ExamScheduleRequest examScheduleRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(examService.saveExam(examScheduleRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getExam")
	public ResponseEntity<Response> getExam() {
		Response response = new Response();
		response.succeed();
		response.setData(examService.getExam());
		return ResponseEntity.ok().body(response);
	}

}
