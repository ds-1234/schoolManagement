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

import com.project.school.management.entity.School;
import com.project.school.management.response.Response;
import com.project.school.management.service.SchoolService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("school")
@Slf4j
public class SchoolController {

	@Autowired
	private SchoolService schoolService;

	@PostMapping("createSchool")
	public ResponseEntity<Response> createSchool(@RequestBody School dto) {
		log.info("******  API Start For save school******");
		Response response = new Response();
		response.succeed();
		response.setData(schoolService.save(dto));
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getSchoolList")
	public ResponseEntity<Object> getSchoolList() throws IOException {
		log.info("******  API Start For get school******");
		Response response = new Response();
		response.succeed();
		response.setData(schoolService.getList());
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getSchool/{id}")
	public ResponseEntity<Object> getSchool(@PathVariable Long id) {
		log.info("******  API Start For get school by id******");
		Response response = new Response();
		response.succeed();
		response.setData(schoolService.getAddress(id));
		return ResponseEntity.ok().body(response);

	}

}
