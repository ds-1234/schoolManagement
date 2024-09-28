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

import com.project.school.management.request.SportsRequest;
import com.project.school.management.response.Response;
import com.project.school.management.service.SportsService;

@CrossOrigin
@RestController
@RequestMapping("sports")
public class SportsController {
	
	@Autowired
	private SportsService sportsService;
	
	@PostMapping("saveSports")
	public ResponseEntity<Response> saveSports(@RequestBody SportsRequest sportsRequest) {
		Response response = new Response();
		response.succeed();
		response.setData(sportsService.saveSports(sportsRequest));
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getSportsList")
	public ResponseEntity<Object> getSportsList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(sportsService.getSportsList());
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("getSportsById/{id}")
	public ResponseEntity<Object> getSportsById(@PathVariable Long id) throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(sportsService.getSportsById(id));
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping("deleteSport/{id}")
	public ResponseEntity<Response> deleteSports(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(sportsService.deleteSports(id));
		return ResponseEntity.ok().body(response);
	}

}
